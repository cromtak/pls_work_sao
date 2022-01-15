package net.mcreator.sao.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class IllfangEntityDiesProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure IllfangEntityDies!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		SaoModVariables.MapVariables.get(world).two = (true);
		SaoModVariables.MapVariables.get(world).syncData(world);
		{
			List<? extends PlayerEntity> _players = new ArrayList<>(world.getPlayers());
			for (Entity entityiterator : _players) {
				if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
					((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent("Second floor was unlocked."), (true));
				}
			}
		}
	}
}
