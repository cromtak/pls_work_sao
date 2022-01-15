
package net.mcreator.sao.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.sao.block.NervegearBlock;
import net.mcreator.sao.SaoModElements;

@SaoModElements.ModElement.Tag
public class SAOItemsItemGroup extends SaoModElements.ModElement {
	public SAOItemsItemGroup(SaoModElements instance) {
		super(instance, 34);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabsao_items") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(NervegearBlock.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}

	public static ItemGroup tab;
}
