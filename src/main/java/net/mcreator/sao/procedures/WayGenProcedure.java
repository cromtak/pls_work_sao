package net.mcreator.sao.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Mirror;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.sao.entity.KobaltEntity;
import net.mcreator.sao.SaoMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class WayGenProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure WayGen!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double zz = 0;
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

				Gen2Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 40);
		if (world instanceof ServerWorld) {
			IWorld _worldorig = world;
			world = ((ServerWorld) world).getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")));
			if (world != null) {
				xx = 0;
				for (int index0 = 0; index0 < (int) (13); index0++) {
					zz = 0;
					for (int index1 = 0; index1 < (int) (1); index1++) {
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "street_lamp"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-30 + xx), (int) 63, (int) (-46)), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						zz = (zz + 0);
					}
					xx = (xx + 10);
				}
				xx = 0;
				for (int index2 = 0; index2 < (int) (13); index2++) {
					zz = 0;
					for (int index3 = 0; index3 < (int) (1); index3++) {
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "street_lamp"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-30 + xx), (int) 63, (int) (-68)), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						zz = (zz + 0);
					}
					xx = (xx + 10);
				}
				xx = 0;
				for (int index4 = 0; index4 < (int) (13); index4++) {
					zz = 0;
					for (int index5 = 0; index5 < (int) (1); index5++) {
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "street_lamp"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-30 + xx), (int) 63, (int) (-90)), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						zz = (zz + 0);
					}
					xx = (xx + 10);
				}
				xx = 0;
				for (int index6 = 0; index6 < (int) (13); index6++) {
					zz = 0;
					for (int index7 = 0; index7 < (int) (1); index7++) {
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "street_lamp"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-30 + xx), (int) 63, (int) (-112)), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						zz = (zz + 0);
					}
					xx = (xx + 10);
				}
				xx = 0;
				for (int index8 = 0; index8 < (int) (13); index8++) {
					zz = 0;
					for (int index9 = 0; index9 < (int) (1); index9++) {
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "street_lamp"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-30 + xx), (int) 63, (int) (-134)), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						zz = (zz + 0);
					}
					xx = (xx + 10);
				}
				for (int index10 = 0; index10 < (int) (20); index10++) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new KobaltEntity.CustomEntity(KobaltEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(18, 70, 219, world.getRandom().nextFloat() * 360F, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
									world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
									(CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
				}
				xx = 0;
				for (int index11 = 0; index11 < (int) (3); index11++) {
					zz = 0;
					for (int index12 = 0; index12 < (int) (200); index12++) {
						world.setBlockState(new BlockPos((int) (54 + xx), (int) 62, (int) (71 - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
				xx = 0;
				for (int index13 = 0; index13 < (int) (138); index13++) {
					zz = 0;
					for (int index14 = 0; index14 < (int) (4); index14++) {
						world.setBlockState(new BlockPos((int) (-30 + xx), (int) 62, (int) ((-41) - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
				xx = 0;
				for (int index15 = 0; index15 < (int) (138); index15++) {
					zz = 0;
					for (int index16 = 0; index16 < (int) (4); index16++) {
						world.setBlockState(new BlockPos((int) (-30 + xx), (int) 62, (int) ((-63) - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
				xx = 0;
				for (int index17 = 0; index17 < (int) (138); index17++) {
					zz = 0;
					for (int index18 = 0; index18 < (int) (4); index18++) {
						world.setBlockState(new BlockPos((int) (-30 + xx), (int) 62, (int) ((-85) - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
				xx = 0;
				for (int index19 = 0; index19 < (int) (138); index19++) {
					zz = 0;
					for (int index20 = 0; index20 < (int) (4); index20++) {
						world.setBlockState(new BlockPos((int) (-30 + xx), (int) 62, (int) ((-107) - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
				xx = 0;
				for (int index21 = 0; index21 < (int) (138); index21++) {
					zz = 0;
					for (int index22 = 0; index22 < (int) (4); index22++) {
						world.setBlockState(new BlockPos((int) (-30 + xx), (int) 62, (int) ((-129) - zz)), Blocks.GRAVEL.getDefaultState(), 3);
						zz = (zz + 1);
					}
					xx = (xx + 1);
				}
			}
			world = _worldorig;
		}
	}
}
