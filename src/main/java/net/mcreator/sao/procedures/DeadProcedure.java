package net.mcreator.sao.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.block.BlockState;

import net.mcreator.sao.block.GraveBlock;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class DeadProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure Dead!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (SaoModVariables.MapVariables.get(world).grave > 4) {
			SaoModVariables.MapVariables.get(world).grave = 2;
			SaoModVariables.MapVariables.get(world).syncData(world);
			SaoModVariables.MapVariables.get(world).row = (SaoModVariables.MapVariables.get(world).row + 2);
			SaoModVariables.MapVariables.get(world).syncData(world);
		}
		world.setBlockState(new BlockPos((int) (83 - SaoModVariables.MapVariables.get(world).row), (int) 63,
				(int) (46 + SaoModVariables.MapVariables.get(world).grave)), GraveBlock.block.getDefaultState(), 3);
		try {
			BlockState _bs = world.getBlockState(new BlockPos((int) (83 - SaoModVariables.MapVariables.get(world).row), (int) 63,
					(int) (46 + SaoModVariables.MapVariables.get(world).grave)));
			DirectionProperty _property = (DirectionProperty) _bs.getBlock().getStateContainer().getProperty("facing");
			if (_property != null) {
				world.setBlockState(new BlockPos((int) (83 - SaoModVariables.MapVariables.get(world).row), (int) 63,
						(int) (46 + SaoModVariables.MapVariables.get(world).grave)), _bs.with(_property, Direction.WEST), 3);
			} else {
				world.setBlockState(
						new BlockPos((int) (83 - SaoModVariables.MapVariables.get(world).row), (int) 63,
								(int) (46 + SaoModVariables.MapVariables.get(world).grave)),
						_bs.with((EnumProperty<Direction.Axis>) _bs.getBlock().getStateContainer().getProperty("axis"), Direction.WEST.getAxis()), 3);
			}
		} catch (Exception e) {
		}
	}
}
