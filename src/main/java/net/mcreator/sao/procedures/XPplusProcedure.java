package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerXpEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class XPplusProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerXPChange(PlayerXpEvent.XpChange event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				int amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("amount", amount);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure XPplus!");
			return;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				SaoMod.LOGGER.warn("Failed to load dependency amount for procedure XPplus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")))) {
			{
				double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).xp + amount);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.xp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).xp >= (entity
					.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).lvl * 12) {
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).xp
							- (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SaoModVariables.PlayerVariables())).lvl * 12);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.xp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).lvl + 1);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lvl = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).points
							+ Math.ceil((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SaoModVariables.PlayerVariables())).lvl / 10));
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.points = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp_max + 3);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hp_max = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).str + 0.5);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.str = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp + 3);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).xp >= (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).lvl * 12) {
					XPplusProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("amount", amount))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
		}
	}
}
