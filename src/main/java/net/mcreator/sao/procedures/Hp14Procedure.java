package net.mcreator.sao.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class Hp14Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure Hp14!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp > 0;
	}
}
