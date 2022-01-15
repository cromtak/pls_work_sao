package net.mcreator.sao.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.sao.item.Spear2Item;
import net.mcreator.sao.item.LongSwordItem;
import net.mcreator.sao.item.KaraKurenaiItem;
import net.mcreator.sao.item.GreatHammerItem;
import net.mcreator.sao.item.GreatAxeItem;
import net.mcreator.sao.item.DoubleAxeItem;
import net.mcreator.sao.item.DaggerItem;
import net.mcreator.sao.item.ClasicSwordItem;
import net.mcreator.sao.gui.TradeGuiGui;
import net.mcreator.sao.SaoMod;

import java.util.function.Supplier;
import java.util.Map;

import io.netty.buffer.Unpooled;

public class BlacmsmithRightClickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SaoMod.LOGGER.warn("Failed to load dependency world for procedure BlacmsmithRightClick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SaoMod.LOGGER.warn("Failed to load dependency x for procedure BlacmsmithRightClick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SaoMod.LOGGER.warn("Failed to load dependency y for procedure BlacmsmithRightClick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SaoMod.LOGGER.warn("Failed to load dependency z for procedure BlacmsmithRightClick!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				SaoMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BlacmsmithRightClick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		{
			Entity _ent = sourceentity;
			if (_ent instanceof ServerPlayerEntity) {
				BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
				NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
					@Override
					public ITextComponent getDisplayName() {
						return new StringTextComponent("TradeGui");
					}

					@Override
					public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
						return new TradeGuiGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(GreatAxeItem.block);
					_setstack.setCount((int) 45);
					((Slot) ((Map) invobj).get((int) (0))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(DoubleAxeItem.block);
					_setstack.setCount((int) 30);
					((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(LongSwordItem.block);
					_setstack.setCount((int) 45);
					((Slot) ((Map) invobj).get((int) (2))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(ClasicSwordItem.block);
					_setstack.setCount((int) 33);
					((Slot) ((Map) invobj).get((int) (3))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(GreatHammerItem.block);
					_setstack.setCount((int) 45);
					((Slot) ((Map) invobj).get((int) (4))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(DaggerItem.block);
					_setstack.setCount((int) 30);
					((Slot) ((Map) invobj).get((int) (5))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(KaraKurenaiItem.block);
					_setstack.setCount((int) 64);
					((Slot) ((Map) invobj).get((int) (6))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
		if (sourceentity instanceof PlayerEntity) {
			Container _current = ((PlayerEntity) sourceentity).openContainer;
			if (_current instanceof Supplier) {
				Object invobj = ((Supplier) _current).get();
				if (invobj instanceof Map) {
					ItemStack _setstack = new ItemStack(Spear2Item.block);
					_setstack.setCount((int) 30);
					((Slot) ((Map) invobj).get((int) (7))).putStack(_setstack);
					_current.detectAndSendChanges();
				}
			}
		}
	}
}
