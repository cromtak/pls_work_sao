
package net.mcreator.sao.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.sao.itemgroup.SAOItemsItemGroup;
import net.mcreator.sao.SaoModElements;

@SaoModElements.ModElement.Tag
public class BronzeCoinItem extends SaoModElements.ModElement {
	@ObjectHolder("sao:bronze_coin")
	public static final Item block = null;

	public BronzeCoinItem(SaoModElements instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SAOItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("bronze_coin");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
