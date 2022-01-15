package net.mcreator.sao.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class SetMeteorBreakProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure SetMeteorBreak!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			String _setval = "meteor break";
			entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.skill = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
