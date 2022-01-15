package net.mcreator.sao;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.storage.WorldSavedData;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.IServerWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class SaoModVariables {
	public SaoModVariables(SaoModElements elements) {
		elements.addNetworkMessage(WorldSavedDataSyncMessage.class, WorldSavedDataSyncMessage::buffer, WorldSavedDataSyncMessage::new,
				WorldSavedDataSyncMessage::handler);
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData mapdata = MapVariables.get(event.getPlayer().world);
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (mapdata != null)
				SaoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				SaoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote()) {
			WorldSavedData worlddata = WorldVariables.get(event.getPlayer().world);
			if (worlddata != null)
				SaoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
						new WorldSavedDataSyncMessage(1, worlddata));
		}
	}

	public static class WorldVariables extends WorldSavedData {
		public static final String DATA_NAME = "sao_worldvars";

		public WorldVariables() {
			super(DATA_NAME);
		}

		public WorldVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				SaoMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(((World) world)::getDimensionKey),
						new WorldSavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(IWorld world) {
			if (world instanceof ServerWorld) {
				return ((ServerWorld) world).getSavedData().getOrCreate(WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends WorldSavedData {
		public static final String DATA_NAME = "sao_mapvars";
		public boolean generate = false;
		public boolean two = false;
		public double grave = 0;
		public double row = 0;
		public double xxGrass = 0;
		public double zzGrasss = 0;
		public double timeeee = 0;
		public boolean NicholasEvent = false;

		public MapVariables() {
			super(DATA_NAME);
		}

		public MapVariables(String s) {
			super(s);
		}

		@Override
		public void read(CompoundNBT nbt) {
			generate = nbt.getBoolean("generate");
			two = nbt.getBoolean("two");
			grave = nbt.getDouble("grave");
			row = nbt.getDouble("row");
			xxGrass = nbt.getDouble("xxGrass");
			zzGrasss = nbt.getDouble("zzGrasss");
			timeeee = nbt.getDouble("timeeee");
			NicholasEvent = nbt.getBoolean("NicholasEvent");
		}

		@Override
		public CompoundNBT write(CompoundNBT nbt) {
			nbt.putBoolean("generate", generate);
			nbt.putBoolean("two", two);
			nbt.putDouble("grave", grave);
			nbt.putDouble("row", row);
			nbt.putDouble("xxGrass", xxGrass);
			nbt.putDouble("zzGrasss", zzGrasss);
			nbt.putDouble("timeeee", timeeee);
			nbt.putBoolean("NicholasEvent", NicholasEvent);
			return nbt;
		}

		public void syncData(IWorld world) {
			this.markDirty();
			if (world instanceof World && !world.isRemote())
				SaoMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new WorldSavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(IWorld world) {
			if (world instanceof IServerWorld) {
				return ((IServerWorld) world).getWorld().getServer().getWorld(World.OVERWORLD).getSavedData().getOrCreate(MapVariables::new,
						DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class WorldSavedDataSyncMessage {
		public int type;
		public WorldSavedData data;

		public WorldSavedDataSyncMessage(PacketBuffer buffer) {
			this.type = buffer.readInt();
			this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
			this.data.read(buffer.readCompoundTag());
		}

		public WorldSavedDataSyncMessage(int type, WorldSavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(WorldSavedDataSyncMessage message, PacketBuffer buffer) {
			buffer.writeInt(message.type);
			buffer.writeCompoundTag(message.data.write(new CompoundNBT()));
		}

		public static void handler(WorldSavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;

	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("sao", "player_variables"), new PlayerVariablesProvider());
	}

	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("str", instance.str);
			nbt.putDouble("lvl", instance.lvl);
			nbt.putDouble("xp", instance.xp);
			nbt.putDouble("def", instance.def);
			nbt.putDouble("speed", instance.speed);
			nbt.putString("classs", instance.classs);
			nbt.putDouble("hp", instance.hp);
			nbt.putDouble("hp_max", instance.hp_max);
			nbt.putDouble("regen", instance.regen);
			nbt.putDouble("hp_show", instance.hp_show);
			nbt.putDouble("points", instance.points);
			nbt.putDouble("DefProcent", instance.DefProcent);
			nbt.putString("party", instance.party);
			nbt.putString("skill", instance.skill);
			nbt.putBoolean("energy", instance.energy);
			nbt.putDouble("ShieldTimer", instance.ShieldTimer);
			nbt.putString("Dialog", instance.Dialog);
			nbt.putString("finished_quests", instance.finished_quests);
			nbt.putString("id_quest", instance.id_quest);
			nbt.putDouble("needQuest", instance.needQuest);
			nbt.putString("TakingQuest", instance.TakingQuest);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.str = nbt.getDouble("str");
			instance.lvl = nbt.getDouble("lvl");
			instance.xp = nbt.getDouble("xp");
			instance.def = nbt.getDouble("def");
			instance.speed = nbt.getDouble("speed");
			instance.classs = nbt.getString("classs");
			instance.hp = nbt.getDouble("hp");
			instance.hp_max = nbt.getDouble("hp_max");
			instance.regen = nbt.getDouble("regen");
			instance.hp_show = nbt.getDouble("hp_show");
			instance.points = nbt.getDouble("points");
			instance.DefProcent = nbt.getDouble("DefProcent");
			instance.party = nbt.getString("party");
			instance.skill = nbt.getString("skill");
			instance.energy = nbt.getBoolean("energy");
			instance.ShieldTimer = nbt.getDouble("ShieldTimer");
			instance.Dialog = nbt.getString("Dialog");
			instance.finished_quests = nbt.getString("finished_quests");
			instance.id_quest = nbt.getString("id_quest");
			instance.needQuest = nbt.getDouble("needQuest");
			instance.TakingQuest = nbt.getString("TakingQuest");
		}
	}

	public static class PlayerVariables {
		public double str = 0;
		public double lvl = 1.0;
		public double xp = 0;
		public double def = 1.0;
		public double speed = 1.0;
		public String classs = "\"\"";
		public double hp = 20.0;
		public double hp_max = 20.0;
		public double regen = 1.0;
		public double hp_show = 0;
		public double points = 0;
		public double DefProcent = 0;
		public String party = "";
		public String skill = "vertical slash";
		public boolean energy = true;
		public double ShieldTimer = 0;
		public String Dialog = "\"\"";
		public String finished_quests = "\"\"";
		public String id_quest = "\"\"";
		public double needQuest = 0;
		public String TakingQuest = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				SaoMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity), new PlayerVariablesSyncMessage(this));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PlayerVariables()));
		PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
		clone.str = original.str;
		clone.lvl = original.lvl;
		clone.xp = original.xp;
		clone.def = original.def;
		clone.speed = original.speed;
		clone.classs = original.classs;
		clone.hp = original.hp;
		clone.hp_max = original.hp_max;
		clone.regen = original.regen;
		clone.points = original.points;
		clone.party = original.party;
		clone.skill = original.skill;
		clone.finished_quests = original.finished_quests;
		clone.id_quest = original.id_quest;
		clone.needQuest = original.needQuest;
		clone.TakingQuest = original.TakingQuest;
		if (!event.isWasDeath()) {
			clone.hp_show = original.hp_show;
			clone.DefProcent = original.DefProcent;
			clone.energy = original.energy;
			clone.ShieldTimer = original.ShieldTimer;
			clone.Dialog = original.Dialog;
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.str = message.data.str;
					variables.lvl = message.data.lvl;
					variables.xp = message.data.xp;
					variables.def = message.data.def;
					variables.speed = message.data.speed;
					variables.classs = message.data.classs;
					variables.hp = message.data.hp;
					variables.hp_max = message.data.hp_max;
					variables.regen = message.data.regen;
					variables.hp_show = message.data.hp_show;
					variables.points = message.data.points;
					variables.DefProcent = message.data.DefProcent;
					variables.party = message.data.party;
					variables.skill = message.data.skill;
					variables.energy = message.data.energy;
					variables.ShieldTimer = message.data.ShieldTimer;
					variables.Dialog = message.data.Dialog;
					variables.finished_quests = message.data.finished_quests;
					variables.id_quest = message.data.id_quest;
					variables.needQuest = message.data.needQuest;
					variables.TakingQuest = message.data.TakingQuest;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
