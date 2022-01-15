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
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BoneMealItem;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.sao.entity.Trader1stFloorEntity;
import net.mcreator.sao.entity.QuestGiverDirewolfsEntity;
import net.mcreator.sao.entity.HunterEntity;
import net.mcreator.sao.entity.BlacksmithEntity;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;

public class Gen2Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure Gen2!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double xx = 0;
		double zz = 0;
		if (world instanceof ServerWorld) {
			IWorld _worldorig = world;
			world = ((ServerWorld) world).getServer().getWorld(RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")));
			if (world != null) {
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new Trader1stFloorEntity.CustomEntity(Trader1stFloorEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(59, 63, (-7), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new HunterEntity.CustomEntity(HunterEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(59, 63, (-16), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "stanek_white"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 58, (int) 63, (int) (-17)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new BlacksmithEntity.CustomEntity(BlacksmithEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(68, 64, 2, world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "stanek_white"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 58, (int) 63, (int) (-8)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "nep_spawner"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 86, (int) 63, (int) 171),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "kostel"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 58, (int) 63, (int) 29),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "kovarna"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 63, (int) 63, (int) (-1)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "direwolf_spawner"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 147, (int) 63, (int) 116),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "direwolf_spawner"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 147, (int) 63, (int) 140),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "mini_dungeon_1"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 65, (int) 63, (int) 149),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "kopec_1"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 171, (int) 63, (int) 130),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "kopec_2"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 180, (int) 63, (int) 135),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "nep_spawner"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 188, (int) 63, (int) 184),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Template template = ((ServerWorld) world).getStructureTemplateManager()
							.getTemplateDefaulted(new ResourceLocation("sao", "mini_castle"));
					if (template != null) {
						template.func_237144_a_((ServerWorld) world, new BlockPos((int) 40, (int) 62, (int) (-27)),
								new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
								((World) world).rand);
					}
				}
				if (world instanceof ServerWorld) {
					Entity entityToSpawn = new QuestGiverDirewolfsEntity.CustomEntity(QuestGiverDirewolfsEntity.entity, (World) world);
					entityToSpawn.setLocationAndAngles(11, 63, (-64), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof MobEntity)
						((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
								SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
					world.addEntity(entityToSpawn);
				}
				SaoModVariables.MapVariables.get(world).xxGrass = 0;
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
						for (int index0 = 0; index0 < (int) (100); index0++) {
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
									SaoModVariables.MapVariables.get(world).zzGrasss = 0;
									SaoModVariables.MapVariables.get(world).syncData(world);
									for (int index1 = 0; index1 < (int) (153); index1++) {
										if (world instanceof World) {
											if (BoneMealItem.applyBonemeal(new ItemStack(Items.BONE_MEAL), (World) world,
													new BlockPos((int) (-50 + SaoModVariables.MapVariables.get(world).xxGrass), (int) 62,
															(int) (-200 + SaoModVariables.MapVariables.get(world).zzGrasss)))
													|| BoneMealItem.growSeagrass(new ItemStack(Items.BONE_MEAL), (World) world,
															new BlockPos((int) (-50 + SaoModVariables.MapVariables.get(world).xxGrass), (int) 62,
																	(int) (-200 + SaoModVariables.MapVariables.get(world).zzGrasss)),
															(Direction) null)) {
												if (!world.isRemote())
													((World) world).playEvent(2005,
															new BlockPos((int) (-50 + SaoModVariables.MapVariables.get(world).xxGrass), (int) 62,
																	(int) (-200 + SaoModVariables.MapVariables.get(world).zzGrasss)),
															0);
											}
										}
										SaoModVariables.MapVariables.get(world).zzGrasss = (SaoModVariables.MapVariables.get(world).zzGrasss + 3);
										SaoModVariables.MapVariables.get(world).syncData(world);
									}
									SaoModVariables.MapVariables.get(world).xxGrass = (SaoModVariables.MapVariables.get(world).xxGrass + 3);
									SaoModVariables.MapVariables.get(world).syncData(world);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) SaoModVariables.MapVariables.get(world).timeeee);
							SaoModVariables.MapVariables.get(world).timeeee = (SaoModVariables.MapVariables.get(world).timeeee + 1);
							SaoModVariables.MapVariables.get(world).syncData(world);
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 40);
			}
			world = _worldorig;
		}
	}
}
