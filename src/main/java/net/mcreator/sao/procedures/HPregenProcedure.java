package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.sao.enchantment.LightWeightEnchantment;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class HPregenProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure HPregen!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("sao:sao")))) {
			{
				double _setval = Math.ceil(
						(entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hp_show = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = Math.round(100 - (100 / (100 + (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).def)) * 100);
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DefProcent = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				String _setval = (entity.getDisplayName().getString());
				entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.classs = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp < (entity
					.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp_max) {
				if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0) > 0) {
					{
						double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).hp
								+ (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new SaoModVariables.PlayerVariables())).regen / 100);
						entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new SaoModVariables.PlayerVariables())).hp > (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp_max) {
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp_max);
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp > 0) {
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < ((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getMaxHealth()
					: -1)) {
				{
					double _setval = ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new SaoModVariables.PlayerVariables())).hp
							- (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))
									* (100 / (100 + ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0)
											+ (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new SaoModVariables.PlayerVariables())).def)));
					entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
			}
		}
		if ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).hp <= 0
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) > 0) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).setHealth((float) 0);
		}
		if ((EnchantmentHelper.getEnchantmentLevel(LightWeightEnchantment.enchantment,
				((entity instanceof LivingEntity) ? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET) : ItemStack.EMPTY)) != 0)) {
			if (!(new Object() {
				boolean check(Entity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.SPEED)
								return true;
						}
					}
					return false;
				}
			}.check(entity)) && entity.isSprinting()) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60,
							(int) (EnchantmentHelper.getEnchantmentLevel(LightWeightEnchantment.enchantment,
									((entity instanceof LivingEntity)
											? ((LivingEntity) entity).getItemStackFromSlot(EquipmentSlotType.FEET)
											: ItemStack.EMPTY))),
							(false), (false)));
			}
		}
	}
}
