package net.mcreator.sao.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class PowerPlusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure PowerPlus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).points >= 1) {
			{
				double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).str + 1);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.str = _setval;
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
