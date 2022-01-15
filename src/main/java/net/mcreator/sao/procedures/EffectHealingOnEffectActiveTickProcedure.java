package net.mcreator.sao.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class EffectHealingOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure EffectHealingOnEffectActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SaoModVariables.PlayerVariables())).hp
					+ ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp_max
							- (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new SaoModVariables.PlayerVariables())).hp)
							* 0.75);
			entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.hp = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
