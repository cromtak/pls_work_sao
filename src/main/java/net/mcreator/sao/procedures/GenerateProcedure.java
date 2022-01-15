package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
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

import net.mcreator.sao.entity.IllfangEntity;
import net.mcreator.sao.block.TeleportStoneBlock;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class GenerateProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
			Entity entity = event.getEntity();
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("dimension", event.getDimension());
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure Generate!");
			return;
		}
		if (dependencies.get("dimension") == null) {
			if (!dependencies.containsKey("dimension"))
				SaoMod.LOGGER.warn("Failed to load dependency dimension for procedure Generate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		RegistryKey<World> dimension = (RegistryKey<World>) dependencies.get("dimension");
		double hey = 0;
		double offset = 0;
		double offset2 = 0;
		double yyyy = 0;
		double forrest = 0;
		double forrest_size = 0;
		if ((dimension) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")))) {
			if (!SaoModVariables.MapVariables.get(world).generate) {
				SaoModVariables.MapVariables.get(world).generate = (true);
				SaoModVariables.MapVariables.get(world).syncData(world);
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

						WayGenProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world)).collect(HashMap::new,
								(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 40);
				if (world instanceof ServerWorld) {
					IWorld _worldorig = world;
					world = ((ServerWorld) world).getServer()
							.getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")));
					if (world != null) {
						forrest_size = 0;
						for (int index0 = 0; index0 < (int) (30); index0++) {
							forrest = 1;
							for (int index1 = 0; index1 < (int) (30); index1++) {
								if (Math.random() < 0.2) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "rock1"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else if (Math.random() < 0.2) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "rock5"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else if (Math.random() < 0.2) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "rock4"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else if (Math.random() < 0.2) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "rock2"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else if (Math.random() < 0.05) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "boar_spawn"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "tree"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (-55 + forrest), (int) 63,
															(int) (240 - forrest_size + (Math.random() * 10) / 1.3)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								}
								forrest = (forrest + Math.random() * 10);
							}
							forrest_size = (forrest_size + 5);
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "iron_palace"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 0, (int) 62, (int) 3), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "lake"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 66, (int) 60, (int) 8), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "momument_of_life"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 8, (int) 62, (int) 32), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "namesti"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) (-32), (int) 62, (int) 0), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "dungeon_part1"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 0, (int) 62, (int) 200), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "dungeon_part2"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 0, (int) 94, (int) 200), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IllfangEntity.CustomEntity(IllfangEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(16, 90, 227, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
										(ILivingEntityData) null, (CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						world.setBlockState(new BlockPos((int) 0, (int) 63, (int) 2), TeleportStoneBlock.block.getDefaultState(), 3);
						offset = 0;
						for (int index2 = 0; index2 < (int) (5); index2++) {
							hey = 1;
							for (int index3 = 0; index3 < (int) (10); index3++) {
								if (Math.random() < 0.5) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "house_1"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (hey * 14 - 40), (int) 62, (int) ((-40) - offset)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else if (Math.random() < 0.5) {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "house_2"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (hey * 14 - 40), (int) 62, (int) ((-40) - offset)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								} else {
									if (world instanceof ServerWorld) {
										Template template = ((ServerWorld) world).getStructureTemplateManager()
												.getTemplateDefaulted(new ResourceLocation("sao", "house_3"));
										if (template != null) {
											template.func_237144_a_((ServerWorld) world,
													new BlockPos((int) (hey * 14 - 40), (int) 62, (int) ((-40) - offset)),
													new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null)
															.setIgnoreEntities(false),
													((World) world).rand);
										}
									}
								}
								hey = (hey + 1);
							}
							offset = (offset + 22);
						}
						for (int index4 = 0; index4 < (int) (160); index4++) {
							for (int index5 = 0; index5 < (int) (8); index5++) {
								world.setBlockState(new BlockPos((int) (-38 + offset2), (int) (63 + yyyy), (int) 70),
										Blocks.STONE_BRICKS.getDefaultState(), 3);
								world.setBlockState(new BlockPos((int) (-38 + offset2), (int) (63 + yyyy), (int) (-140)),
										Blocks.STONE_BRICKS.getDefaultState(), 3);
								yyyy = (yyyy + 1);
							}
							yyyy = 0;
							offset2 = (offset2 + 1);
						}
						offset2 = 0;
						for (int index6 = 0; index6 < (int) (210); index6++) {
							for (int index7 = 0; index7 < (int) (8); index7++) {
								world.setBlockState(new BlockPos((int) (-38), (int) (63 + yyyy), (int) (70 - offset2)),
										Blocks.STONE_BRICKS.getDefaultState(), 3);
								world.setBlockState(new BlockPos((int) 122, (int) (63 + yyyy), (int) (70 - offset2)),
										Blocks.STONE_BRICKS.getDefaultState(), 3);
								yyyy = (yyyy + 1);
							}
							yyyy = 0;
							offset2 = (offset2 + 1);
						}
						if (world instanceof ServerWorld) {
							Template template = ((ServerWorld) world).getStructureTemplateManager()
									.getTemplateDefaulted(new ResourceLocation("sao", "gateee"));
							if (template != null) {
								template.func_237144_a_(
										(ServerWorld) world, new BlockPos((int) 53, (int) 63, (int) 69), new PlacementSettings()
												.setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
										((World) world).rand);
							}
						}
					}
					world = _worldorig;
				}
			}
		}
	}
}
