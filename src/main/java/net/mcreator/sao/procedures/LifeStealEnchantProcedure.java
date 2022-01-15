package net.mcreator.sao.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.sao.enchantment.LifeStealEnchantment;
import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.Map;
import java.util.HashMap;

public class LifeStealEnchantProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onEntityAttacked(LivingAttackEvent event) {
			if (event != null && event.getEntity() != null) {
				Entity entity = event.getEntity();
				Entity sourceentity = event.getSource().getTrueSource();
				Entity imediatesourceentity = event.getSource().getImmediateSource();
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
				dependencies.put("imediatesourceentity", imediatesourceentity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				SaoMod.LOGGER.warn("Failed to load dependency entity for procedure LifeStealEnchant!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SaoMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LifeStealEnchant!");
			return;
		}
		if (dependencies.get("amount") == null) {
			if (!dependencies.containsKey("amount"))
				SaoMod.LOGGER.warn("Failed to load dependency amount for procedure LifeStealEnchant!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double amount = dependencies.get("amount") instanceof Integer ? (int) dependencies.get("amount") : (double) dependencies.get("amount");
		if ((EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment,
				((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)) != 0)) {
			{
				double _setval = ((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new SaoModVariables.PlayerVariables())).hp
						+ Math.sqrt(Math.pow(amount, 2) + Math.pow((sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).str, 2))
								* (100 / (100
										+ (entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new SaoModVariables.PlayerVariables())).def
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getTotalArmorValue() : 0)))
								* EnchantmentHelper.getEnchantmentLevel(LifeStealEnchantment.enchantment,
										((sourceentity instanceof LivingEntity)
												? ((LivingEntity) sourceentity).getHeldItemMainhand()
												: ItemStack.EMPTY))
								* 0.1);
				sourceentity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hp = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
