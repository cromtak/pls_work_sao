
package net.mcreator.sao.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.sao.itemgroup.WeaponsItemGroup;
import net.mcreator.sao.SaoModElements;

@SaoModElements.ModElement.Tag
public class DaggerItem extends SaoModElements.ModElement {
	@ObjectHolder("sao:dagger")
	public static final Item block = null;

	public DaggerItem(SaoModElements instance) {
		super(instance, 30);
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
				return 1.1999999999999997f;
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
		}, 3, 0f, new Item.Properties().group(WeaponsItemGroup.tab)) {
		}.setRegistryName("dagger"));
	}
}
