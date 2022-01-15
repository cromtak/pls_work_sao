package net.mcreator.sao.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class SkillUseProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure SkillUse!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure SkillUse!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).energy) {
			if (((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).skill)
					.equals("vertical slash")) {
				VerticalSlashProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				{
					boolean _setval = (false);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						{
							boolean _setval = (true);
							entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.energy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) (40 / (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).speed + 20));
			} else if (((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).skill)
					.equals("meteor break")) {
				MeteorBreakProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				{
					boolean _setval = (false);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						{
							boolean _setval = (true);
							entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.energy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) (80 / (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).speed + 20));
			} else if (((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).skill)
					.equals("dash")) {
				DashProcedure
						.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				{
					boolean _setval = (false);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.energy = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				new Object() {
					private int ticks = 0;
					private float waitTicks;
					private IWorld world;

					public void start(IWorld world, int waitTicks) {
						this.waitTicks = waitTicks;
						MinecraftForge.EVENT_BUS.register(this);
						this.world = world;
					}

					@SubscribeEvent
					public void tick(TickEvent.ServerTickEvent event) {
						if (event.phase == TickEvent.Phase.END) {
							this.ticks += 1;
							if (this.ticks >= this.waitTicks)
								run();
						}
					}

					private void run() {
						{
							boolean _setval = (true);
							entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.energy = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) (80 / (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).speed + 20));
			}
		} else {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("skill on cooldown"), (false));
			}
		}
	}
}
