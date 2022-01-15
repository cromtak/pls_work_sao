
package net.mcreator.sao.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.sao.itemgroup.SAOItemsItemGroup;
import net.mcreator.sao.SaoModElements;

@SaoModElements.ModElement.Tag
public class BloodGemItem extends SaoModElements.ModElement {
	@ObjectHolder("sao:blood_gem")
	public static final Item block = null;

	public BloodGemItem(SaoModElements instance) {
		super(instance, 193);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SAOItemsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("blood_gem");
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
