package net.mcreator.sao.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class HPplusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure HPplus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).points >= 1) {
			{
				double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).hp_max + 1);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hp_max = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).points - 1);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.points = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
