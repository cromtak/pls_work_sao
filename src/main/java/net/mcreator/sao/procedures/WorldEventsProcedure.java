package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameRules;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.sao.world.RealTimeGameRule;
import net.mcreator.sao.entity.NicholasEntity;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

public class WorldEventsProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onWorldTick(TickEvent.WorldTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				IWorld world = event.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("world", world);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure WorldEvents!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (Calendar.getInstance().get(Calendar.DAY_OF_MONTH) > 18 && Calendar.getInstance().get(Calendar.DAY_OF_MONTH) < 25
				&& Calendar.getInstance().get(Calendar.MONTH) + 1 == 12) {
			if (SaoModVariables.MapVariables.get(world).NicholasEvent == false) {
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")));
					if (world != null) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new NicholasEntity.CustomEntity(NicholasEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(0, 63, 0, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
					world = _worldorig;
				}
				SaoModVariables.MapVariables.get(world).NicholasEvent = (true);
				SaoModVariables.MapVariables.get(world).syncData(world);
			}
		} else {
			SaoModVariables.MapVariables.get(world).NicholasEvent = (false);
			SaoModVariables.MapVariables.get(world).syncData(world);
		}
		if (world.getWorldInfo().getGameRulesInstance().getBoolean(RealTimeGameRule.gamerule)) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).setDayTime((int) (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) * 1000
						+ Calendar.getInstance().get(Calendar.MINUTE) * 16 + Calendar.getInstance().get(Calendar.SECOND) / 4 + 18000));
		}
		if (world instanceof World) {
			((World) world).getGameRules().get(GameRules.DO_DAYLIGHT_CYCLE)
					.set((!world.getWorldInfo().getGameRulesInstance().getBoolean(RealTimeGameRule.gamerule)), ((World) world).getServer());
		}
	}
}
