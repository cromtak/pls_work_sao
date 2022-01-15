package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

public class DmgProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingHurtEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				double amount = event.getAmount();
				World world = entity.world;
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("amount", amount);
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
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure Dmg!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SaoMod.LOGGER.warn("Failed to load dependency sourceentity for procedure Dmg!");
			return;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				SaoMod.LOGGER.warn("Failed to load dependency amount for procedure Dmg!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")))) {
			if (((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).party)
					.contains(entity.getDisplayName().getString())) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			} else {
				if (entity instanceof PlayerEntity) {
					{
						double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).hp
								- Math.sqrt(
										Math.pow(amount, 2) + Math.pow((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SaoModVariables.PlayerVariables())).str + 1, 2))
										* (100 / (100
												+ (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new SaoModVariables.PlayerVariables())).def
												+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0) * 3)));
						entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp <= 0) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) 0);
					} else {
						if (dependencies.get("event") != null) {
							Object _obj = dependencies.get("event");
							if (_obj instanceof Event) {
								Event _evt = (Event) _obj;
								if (_evt.isCancelable())
									_evt.setCanceled(true);
							}
						}
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.LEGS)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.CHEST)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
					{
						ItemStack _ist = ((entity instanceof LivingEntity)
								? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.HEAD)
								: ItemStack.EMPTY);
						if (_ist.attemptDamageItem((int) 1, new Random(), null)) {
							_ist.shrink(1);
							_ist.setDamage(0);
						}
					}
				} else {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth(
								(float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) - Math
										.sqrt(Math.pow(amount, 2) + Math
												.pow((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new SaoModVariables.PlayerVariables())).str + 1, 2))
										* (100 / (100 + ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0)))));
				}
			}
		}
	}
}
