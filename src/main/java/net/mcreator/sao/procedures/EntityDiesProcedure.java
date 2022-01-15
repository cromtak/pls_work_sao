package net.mcreator.sao.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sao.item.BronzeCoinItem;
import net.mcreator.sao.entity.DirewolfEntity;
import net.mcreator.sao.entity.BoarEntity;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;
import java.util.HashMap;

public class EntityDiesProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityDeath(LivingDeathEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("sourceentity", sourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure EntityDies!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SaoMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EntityDies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		if (((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).id_quest)
				.equals("a1")) {
			if (entity instanceof BoarEntity.CustomEntity) {
				{
					double _setval = ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).needQuest + 1);
					sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.needQuest = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).needQuest == 5) {
					{
						String _setval = ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).id_quest + ""
								+ (sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SaoModVariables.PlayerVariables())).finished_quests);
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.finished_quests = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						String _setval = "";
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.id_quest = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = 0;
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.needQuest = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(BronzeCoinItem.block);
						_setstack.setCount((int) 20);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 20);
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Finished Quest"), (false));
					}
				}
			}
		}
		if (((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).id_quest)
				.equals("a2")) {
			if (entity instanceof DirewolfEntity.CustomEntity) {
				{
					double _setval = ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).needQuest + 1);
					sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.needQuest = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				if ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).needQuest == 5) {
					{
						String _setval = ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).id_quest + ""
								+ (sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SaoModVariables.PlayerVariables())).finished_quests);
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.finished_quests = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						String _setval = "";
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.id_quest = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					{
						double _setval = 0;
						sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.needQuest = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(BronzeCoinItem.block);
						_setstack.setCount((int) 30);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).giveExperiencePoints((int) 30);
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Finished Quest"), (false));
					}
				}
			}
		}
	}
}
