
package net.mcreator.sao.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.sao.itemgroup.WeaponsItemGroup;
import net.mcreator.sao.SaoModElements;

@SaoModElements.ModElement.Tag
public class AxeOneSideItem extends SaoModElements.ModElement {
	@ObjectHolder("sao:axe_one_side")
	public static final Item block = null;

	public AxeOneSideItem(SaoModElements instance) {
		super(instance, 31);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 300;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3.4f, new Item.Properties().group(WeaponsItemGroup.tab)) {
		}.setRegistryName("axe_one_side"));
	}
}
