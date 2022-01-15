
package net.mcreator.sao.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.sao.SaoModElements;

import java.util.List;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@SaoModElements.ModElement.Tag
public class HeathcliffArmorItem extends SaoModElements.ModElement {
	@ObjectHolder("sao:heathcliff_armor_helmet")
	public static final Item helmet = null;
	@ObjectHolder("sao:heathcliff_armor_chestplate")
	public static final Item body = null;
	@ObjectHolder("sao:heathcliff_armor_leggings")
	public static final Item legs = null;
	@ObjectHolder("sao:heathcliff_armor_boots")
	public static final Item boots = null;

	public HeathcliffArmorItem(SaoModElements instance) {
		super(instance, 202);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 500;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{16, 16, 16, 16}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 25;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "heathcliff_armor";
			}

			@Override
			public float getToughness() {
				return 5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.25f;
			}
		};
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedBody = new ModelKnights_of_the_Blood_Chestplate4().Armor_body;
						armorModel.bipedLeftArm = new ModelKnights_of_the_Blood_Chestplate4().Left_arm;
						armorModel.bipedRightArm = new ModelKnights_of_the_Blood_Chestplate4().Right_arm;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
						super.addInformation(itemstack, world, list, flag);
						list.add(new StringTextComponent("High quality great armor belonging to Heathcliff"));
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "sao:textures/knights_of_the_blood_chestplate2.png";
					}
				}.setRegistryName("heathcliff_armor_chestplate"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new ModelKnights_of_the_Blood_Leggins2().Left_leg;
						armorModel.bipedRightLeg = new ModelKnights_of_the_Blood_Leggins2().Right_leg;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "sao:textures/knights_of_the_blood_leggins2.png";
					}
				}.setRegistryName("heathcliff_armor_leggings"));
		elements.items
				.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.FEET, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
					@Override
					@OnlyIn(Dist.CLIENT)
					public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
						BipedModel armorModel = new BipedModel(1);
						armorModel.bipedLeftLeg = new ModelKnights_of_the_Blood_Boots().Left_boots;
						armorModel.bipedRightLeg = new ModelKnights_of_the_Blood_Boots().Right_boots;
						armorModel.isSneak = living.isSneaking();
						armorModel.isSitting = defaultModel.isSitting;
						armorModel.isChild = living.isChild();
						return armorModel;
					}

					@Override
					public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
						return "sao:textures/knights_of_the_blood_boots.png";
					}
				}.setRegistryName("heathcliff_armor_boots"));
	}

	// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelKnights_of_the_Blood_Chestplate4 extends EntityModel<Entity> {
		private final ModelRenderer Armor_body;
		private final ModelRenderer Armor_body_r1;
		private final ModelRenderer Armor_body_r2;
		private final ModelRenderer Armor_body_r3;
		private final ModelRenderer Armor_body_r4;
		private final ModelRenderer Armor_body_r5;
		private final ModelRenderer Armor_body_r6;
		private final ModelRenderer Armor_body_r7;
		private final ModelRenderer Armor_body_r8;
		private final ModelRenderer Armor_body_r9;
		private final ModelRenderer Armor_body_r10;
		private final ModelRenderer Armor_body_r11;
		private final ModelRenderer Armor_body_r12;
		private final ModelRenderer Armor_body_r13;
		private final ModelRenderer Armor_body_r14;
		private final ModelRenderer Armor_body_r15;
		private final ModelRenderer Armor_body_r16;
		private final ModelRenderer Armor_body_r17;
		private final ModelRenderer Right_arm;
		private final ModelRenderer Right_arm_r1;
		private final ModelRenderer Left_arm;
		private final ModelRenderer Left_arm_r1;

		public ModelKnights_of_the_Blood_Chestplate4() {
			textureWidth = 128;
			textureHeight = 128;
			Armor_body = new ModelRenderer(this);
			Armor_body.setRotationPoint(0.0F, 12.0F, 0.0F);
			Armor_body.setTextureOffset(52, 3).addBox(-3.0F, 0.0F, -2.6F, 6.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(27, 0).addBox(-5.0F, -1.7857F, -5.0F, 2.0F, 4.0F, 10.0F, 0.0F, false);
			Armor_body.setTextureOffset(27, 0).addBox(3.0F, -1.7857F, -5.0F, 2.0F, 4.0F, 10.0F, 0.0F, false);
			Armor_body.setTextureOffset(19, 16).addBox(-5.0F, 0.2143F, -3.0F, 10.0F, 2.0F, 8.0F, 0.0F, false);
			Armor_body.setTextureOffset(41, 34).addBox(-5.0F, -1.7857F, 3.0F, 10.0F, 4.0F, 2.0F, 0.0F, false);
			Armor_body.setTextureOffset(11, 59).addBox(-2.875F, 1.3143F, -4.625F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 14).addBox(-5.125F, -2.0607F, -5.125F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 49).addBox(-2.875F, -2.0607F, -5.125F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(70, 49).addBox(1.8677F, -1.6857F, -5.125F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(18, 70).addBox(1.8677F, -2.0607F, -5.125F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(18, 70).addBox(-2.875F, -1.6857F, -5.125F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(71, 6).addBox(-5.125F, -2.0607F, 4.125F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(60, 6).addBox(-2.0F, 0.0143F, -3.1F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(68, 45).addBox(-1.5037F, 0.5681F, -3.2756F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(44, 68).addBox(-5.6F, 2.0F, 1.9816F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			Armor_body.setTextureOffset(44, 68).addBox(3.6F, 2.0F, 1.9816F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 71).addBox(2.9927F, 2.5397F, 3.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(58, 56).addBox(-0.5F, 4.7897F, 3.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 70).addBox(-1.0F, 18.7897F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 70).addBox(-1.0F, 4.5897F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 71).addBox(-4.0F, 2.5397F, 3.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 71).addBox(2.9927F, 20.9397F, 3.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(70, 70).addBox(2.9927F, 19.9397F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(70, 70).addBox(-5.0F, 19.9397F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 71).addBox(-4.0F, 20.9397F, 3.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 70).addBox(-5.0F, 3.5397F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(70, 70).addBox(2.9927F, 3.5397F, 3.6F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(45, 56).addBox(-3.8073F, 8.1897F, 3.6F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 24).addBox(-3.5F, 8.6897F, 3.6F, 7.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(45, 56).addBox(2.8F, 8.1897F, 3.6F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(66, 34).addBox(-3.5F, 1.9F, -2.6625F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 27).addBox(-1.75F, 5.8335F, -2.6625F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 27).addBox(1.2427F, 5.8335F, -2.6625F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(66, 34).addBox(0.4927F, 1.9F, -2.6625F, 3.0F, 3.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(0, 27).addBox(0.7427F, 5.8335F, -2.6625F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(0, 27).addBox(-2.25F, 5.8335F, -2.6625F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 59).addBox(-2.0F, 12.9F, -3.3F, 4.0F, 5.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(35, 68).addBox(-1.2F, 13.0F, -3.4F, 3.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(35, 68).addBox(-1.8F, 13.0F, -3.4F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(63, 55).addBox(-1.2F, 13.7F, -3.4F, 3.0F, 4.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(63, 55).addBox(-1.8F, 13.7F, -3.4F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(5, 71).addBox(1.1F, 12.9F, -3.1F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(53, 68).addBox(1.1F, 13.7F, -3.1F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(5, 71).addBox(-2.1F, 12.9F, -3.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(53, 68).addBox(-2.1F, 13.7F, -3.1F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(9, 68).addBox(-1.2F, 16.0F, -3.1F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(55, 41).addBox(-1.8F, 16.0F, -3.1F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(48, 6).addBox(4.125F, -2.0607F, -4.625F, 1.0F, 1.0F, 9.0F, 0.0F, false);
			Armor_body.setTextureOffset(48, 6).addBox(-5.125F, -2.0607F, -4.625F, 1.0F, 1.0F, 9.0F, 0.0F, true);
			Armor_body.setTextureOffset(42, 0).addBox(-4.875F, -2.0607F, 4.125F, 10.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(19, 45).addBox(2.9F, 0.1F, -3.4F, 2.0F, 23.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(26, 67).addBox(1.9F, 0.0F, -2.9F, 3.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(0, 0).addBox(-6.0F, 2.0F, 3.4816F, 12.0F, 22.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(58, 31).addBox(-2.5F, 9.1F, -2.6F, 5.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(63, 41).addBox(-2.0F, 10.4F, -2.6F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 45).addBox(-4.0F, 0.0F, 1.6F, 8.0F, 12.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(29, 27).addBox(-4.5F, -0.3F, -2.5F, 9.0F, 1.0F, 5.0F, 0.0F, false);
			Armor_body.setTextureOffset(56, 17).addBox(-4.5F, 1.7F, -2.6F, 9.0F, 8.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(0, 27).addBox(-4.5F, 0.0F, -2.5F, 9.0F, 12.0F, 5.0F, 0.0F, false);
			Armor_body.setTextureOffset(53, 27).addBox(-4.5F, 1.0F, -2.6F, 9.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(26, 62).addBox(-2.0F, 10.0506F, -2.7F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(19, 45).addBox(-4.9F, 0.1F, -3.4F, 2.0F, 23.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(26, 67).addBox(-4.9F, 0.0F, -2.9F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(11, 59).addBox(1.875F, 1.3143F, -4.625F, 1.0F, 1.0F, 2.0F, 0.0F, true);
			Armor_body.setTextureOffset(61, 49).addBox(-5.0F, -1.7857F, -5.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body.setTextureOffset(61, 49).addBox(2.0F, -1.7857F, -5.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);
			Armor_body.setTextureOffset(70, 14).addBox(2.125F, -2.0607F, -5.125F, 3.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body_r1 = new ModelRenderer(this);
			Armor_body_r1.setRotationPoint(-3.8245F, 4.3293F, -3.75F);
			Armor_body.addChild(Armor_body_r1);
			setRotationAngle(Armor_body_r1, 0.0F, 0.0F, 0.3927F);
			Armor_body_r1.setTextureOffset(69, 61).addBox(-1.505F, -0.5293F, -0.3256F, 3.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body_r1.setTextureOffset(60, 11).addBox(-2.0F, -1.0F, -0.15F, 4.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body_r2 = new ModelRenderer(this);
			Armor_body_r2.setRotationPoint(0.0201F, 11.5515F, -2.35F);
			Armor_body.addChild(Armor_body_r2);
			setRotationAngle(Armor_body_r2, 0.0F, 0.0F, -0.7854F);
			Armor_body_r2.setTextureOffset(52, 10).addBox(0.8F, 0.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body_r3 = new ModelRenderer(this);
			Armor_body_r3.setRotationPoint(0.4444F, 11.1272F, -2.35F);
			Armor_body.addChild(Armor_body_r3);
			setRotationAngle(Armor_body_r3, 0.0F, 0.0F, -0.7854F);
			Armor_body_r3.setTextureOffset(0, 67).addBox(0.8F, 0.0F, -0.25F, 3.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body_r4 = new ModelRenderer(this);
			Armor_body_r4.setRotationPoint(-0.0274F, 11.5515F, -2.35F);
			Armor_body.addChild(Armor_body_r4);
			setRotationAngle(Armor_body_r4, 0.0F, 0.0F, 0.7854F);
			Armor_body_r4.setTextureOffset(52, 10).addBox(-1.8F, 0.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body_r5 = new ModelRenderer(this);
			Armor_body_r5.setRotationPoint(-0.4517F, 11.1272F, -2.35F);
			Armor_body.addChild(Armor_body_r5);
			setRotationAngle(Armor_body_r5, 0.0F, 0.0F, 0.7854F);
			Armor_body_r5.setTextureOffset(0, 67).addBox(-3.8F, 0.0F, -0.25F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body_r6 = new ModelRenderer(this);
			Armor_body_r6.setRotationPoint(-0.4011F, 10.7778F, -2.45F);
			Armor_body.addChild(Armor_body_r6);
			setRotationAngle(Armor_body_r6, 0.0F, 0.0F, 0.7854F);
			Armor_body_r6.setTextureOffset(42, 3).addBox(-3.8F, 0.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body_r7 = new ModelRenderer(this);
			Armor_body_r7.setRotationPoint(0.0232F, 11.2021F, -2.45F);
			Armor_body.addChild(Armor_body_r7);
			setRotationAngle(Armor_body_r7, 0.0F, 0.0F, 0.7854F);
			Armor_body_r7.setTextureOffset(63, 66).addBox(-3.8F, 0.0F, -0.25F, 3.0F, 2.0F, 1.0F, 0.0F, false);
			Armor_body_r8 = new ModelRenderer(this);
			Armor_body_r8.setRotationPoint(-0.0305F, 11.2021F, -2.45F);
			Armor_body.addChild(Armor_body_r8);
			setRotationAngle(Armor_body_r8, 0.0F, 0.0F, -0.7854F);
			Armor_body_r8.setTextureOffset(63, 66).addBox(0.8F, 0.0F, -0.25F, 3.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body_r9 = new ModelRenderer(this);
			Armor_body_r9.setRotationPoint(0.3938F, 10.7778F, -2.45F);
			Armor_body.addChild(Armor_body_r9);
			setRotationAngle(Armor_body_r9, 0.0F, 0.0F, -0.7854F);
			Armor_body_r9.setTextureOffset(42, 3).addBox(2.8F, 0.0F, -0.25F, 1.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body_r10 = new ModelRenderer(this);
			Armor_body_r10.setRotationPoint(3.8245F, 4.3293F, -3.75F);
			Armor_body.addChild(Armor_body_r10);
			setRotationAngle(Armor_body_r10, 0.0F, 0.0F, -0.3927F);
			Armor_body_r10.setTextureOffset(69, 61).addBox(-1.495F, -0.5293F, -0.3256F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r10.setTextureOffset(60, 11).addBox(-2.0F, -1.0F, -0.15F, 4.0F, 2.0F, 1.0F, 0.0F, true);
			Armor_body_r11 = new ModelRenderer(this);
			Armor_body_r11.setRotationPoint(-1.1F, 12.9F, -2.3929F);
			Armor_body.addChild(Armor_body_r11);
			setRotationAngle(Armor_body_r11, -0.7854F, 0.0F, 0.0F);
			Armor_body_r11.setTextureOffset(0, 71).addBox(-1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r11.setTextureOffset(0, 71).addBox(2.2F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body_r12 = new ModelRenderer(this);
			Armor_body_r12.setRotationPoint(1.0F, 12.9F, -2.5929F);
			Armor_body.addChild(Armor_body_r12);
			setRotationAngle(Armor_body_r12, -0.7854F, 0.0F, 0.0F);
			Armor_body_r12.setTextureOffset(67, 3).addBox(-2.2F, -0.6F, -0.6F, 3.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r12.setTextureOffset(0, 71).addBox(-2.8F, -0.6F, -0.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r12.setTextureOffset(65, 0).addBox(-3.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r13 = new ModelRenderer(this);
			Armor_body_r13.setRotationPoint(0.0F, 0.2213F, 0.0F);
			Armor_body.addChild(Armor_body_r13);
			setRotationAngle(Armor_body_r13, 0.0F, 1.5708F, 0.0F);
			Armor_body_r13.setTextureOffset(63, 61).addBox(2.5F, 14.125F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Armor_body_r13.setTextureOffset(26, 49).addBox(2.5F, 13.125F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Armor_body_r14 = new ModelRenderer(this);
			Armor_body_r14.setRotationPoint(-1.5782F, 9.1517F, -1.85F);
			Armor_body.addChild(Armor_body_r14);
			setRotationAngle(Armor_body_r14, 0.0F, 0.0F, -0.7854F);
			Armor_body_r14.setTextureOffset(14, 63).addBox(-0.25F, -0.7F, -0.8125F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Armor_body_r15 = new ModelRenderer(this);
			Armor_body_r15.setRotationPoint(1.5709F, 6.1517F, -1.85F);
			Armor_body.addChild(Armor_body_r15);
			setRotationAngle(Armor_body_r15, 0.0F, 0.0F, 0.7854F);
			Armor_body_r15.setTextureOffset(14, 63).addBox(-0.75F, -0.7F, -0.8125F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body_r16 = new ModelRenderer(this);
			Armor_body_r16.setRotationPoint(1.5709F, 9.1517F, -1.85F);
			Armor_body.addChild(Armor_body_r16);
			setRotationAngle(Armor_body_r16, 0.0F, 0.0F, 0.7854F);
			Armor_body_r16.setTextureOffset(14, 63).addBox(-0.75F, -0.7F, -0.8125F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Armor_body_r17 = new ModelRenderer(this);
			Armor_body_r17.setRotationPoint(-1.5782F, 6.1517F, -1.85F);
			Armor_body.addChild(Armor_body_r17);
			setRotationAngle(Armor_body_r17, 0.0F, 0.0F, -0.7854F);
			Armor_body_r17.setTextureOffset(14, 63).addBox(-0.25F, -0.7F, -0.8125F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm = new ModelRenderer(this);
			Right_arm.setRotationPoint(-5.0F, 14.0F, 0.0F);
			Right_arm.setTextureOffset(26, 51).addBox(-3.5F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, 0.0F, false);
			Right_arm.setTextureOffset(27, 0).addBox(-2.5F, 3.5F, -2.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(27, 0).addBox(-2.5F, 3.5F, 1.5F, 2.0F, 6.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(45, 56).addBox(-3.5F, 3.5F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, false);
			Right_arm.setTextureOffset(48, 17).addBox(-3.6F, 4.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(34, 63).addBox(-3.6F, 5.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Right_arm.setTextureOffset(40, 62).addBox(-3.6F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(40, 62).addBox(-3.6F, 8.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(40, 62).addBox(-3.6F, 8.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(40, 62).addBox(-3.6F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(63, 70).addBox(-0.75F, 4.7F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(8, 63).addBox(0.25F, 4.7F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Right_arm.setTextureOffset(63, 70).addBox(-0.75F, 4.7F, 1.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(63, 70).addBox(-0.75F, 7.2F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm.setTextureOffset(8, 63).addBox(0.25F, 7.2F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Right_arm.setTextureOffset(63, 70).addBox(-0.75F, 7.2F, 1.25F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm_r1 = new ModelRenderer(this);
			Right_arm_r1.setRotationPoint(-7.0F, -2.5355F, 0.0F);
			Right_arm.addChild(Right_arm_r1);
			setRotationAngle(Right_arm_r1, 0.0F, 0.0F, 0.7854F);
			Right_arm_r1.setTextureOffset(29, 34).addBox(4.7184F, -4.6645F, -3.5F, 2.0F, 7.0F, 7.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(53, 56).addBox(2.2184F, -0.0645F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(53, 56).addBox(2.2184F, -4.0645F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(53, 56).addBox(2.2184F, -4.0645F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(53, 56).addBox(2.2184F, -0.0645F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(24, 27).addBox(2.2184F, -2.5645F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(29, 34).addBox(2.2184F, -3.5645F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(42, 43).addBox(2.3184F, -4.6645F, -3.0F, 3.0F, 6.0F, 6.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(55, 41).addBox(3.7184F, 0.3355F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, false);
			Right_arm_r1.setTextureOffset(42, 3).addBox(4.7184F, 2.3355F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, false);
			Left_arm = new ModelRenderer(this);
			Left_arm.setRotationPoint(5.0F, 14.0F, 0.0F);
			Left_arm.setTextureOffset(26, 51).addBox(-0.5F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, 0.0F, true);
			Left_arm.setTextureOffset(27, 0).addBox(0.5F, 3.5F, 1.5F, 2.0F, 6.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(27, 0).addBox(0.5F, 3.5F, -2.5F, 2.0F, 6.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(45, 56).addBox(2.5F, 3.5F, -2.5F, 1.0F, 6.0F, 5.0F, 0.0F, true);
			Left_arm.setTextureOffset(48, 17).addBox(2.6F, 4.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(34, 63).addBox(2.6F, 5.5F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			Left_arm.setTextureOffset(40, 62).addBox(2.6F, 4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(40, 62).addBox(2.6F, 8.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(40, 62).addBox(2.6F, 8.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(40, 62).addBox(2.6F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(63, 70).addBox(-1.25F, 7.2F, 1.25F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(8, 63).addBox(-1.25F, 7.2F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			Left_arm.setTextureOffset(63, 70).addBox(-1.25F, 7.2F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(63, 70).addBox(-1.25F, 4.7F, -2.25F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm.setTextureOffset(8, 63).addBox(-1.25F, 4.7F, -1.25F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			Left_arm.setTextureOffset(63, 70).addBox(-1.25F, 4.7F, 1.25F, 2.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm_r1 = new ModelRenderer(this);
			Left_arm_r1.setRotationPoint(7.0F, -2.5355F, 0.0F);
			Left_arm.addChild(Left_arm_r1);
			setRotationAngle(Left_arm_r1, 0.0F, 0.0F, -0.7854F);
			Left_arm_r1.setTextureOffset(29, 34).addBox(-6.7184F, -4.6645F, -3.5F, 2.0F, 7.0F, 7.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(42, 3).addBox(-6.7184F, 2.3355F, -2.5F, 2.0F, 1.0F, 5.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(53, 56).addBox(-3.2184F, -4.0645F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(53, 56).addBox(-3.2184F, -0.0645F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(53, 56).addBox(-3.2184F, -4.0645F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(53, 56).addBox(-3.2184F, -0.0645F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(24, 27).addBox(-3.2184F, -2.5645F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(29, 34).addBox(-3.2184F, -3.5645F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(55, 41).addBox(-4.7184F, 0.3355F, -2.5F, 1.0F, 2.0F, 5.0F, 0.0F, true);
			Left_arm_r1.setTextureOffset(42, 43).addBox(-5.3184F, -4.6645F, -3.0F, 3.0F, 6.0F, 6.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Armor_body.render(matrixStack, buffer, packedLight, packedOverlay);
			Right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
			Left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.Right_arm_r1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.Left_arm_r1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.Right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

	// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelKnights_of_the_Blood_Leggins2 extends EntityModel<Entity> {
		private final ModelRenderer Right_leg;
		private final ModelRenderer Right_leg_r1;
		private final ModelRenderer Right_leg_r2;
		private final ModelRenderer Right_leg_r3;
		private final ModelRenderer Right_leg_r4;
		private final ModelRenderer Right_leg_r5;
		private final ModelRenderer Right_leg_r6;
		private final ModelRenderer Right_leg_r7;
		private final ModelRenderer Right_leg_r8;
		private final ModelRenderer Right_leg_r9;
		private final ModelRenderer Right_leg_r10;
		private final ModelRenderer Right_leg_r11;
		private final ModelRenderer Right_leg_r12;
		private final ModelRenderer Left_leg;
		private final ModelRenderer Left_leg_r1;
		private final ModelRenderer Left_leg_r2;
		private final ModelRenderer Left_leg_r3;
		private final ModelRenderer Left_leg_r4;
		private final ModelRenderer Left_leg_r5;
		private final ModelRenderer Left_leg_r6;
		private final ModelRenderer Left_leg_r7;
		private final ModelRenderer Left_leg_r8;
		private final ModelRenderer Left_leg_r9;
		private final ModelRenderer Left_leg_r10;
		private final ModelRenderer Left_leg_r11;
		private final ModelRenderer Left_leg_r12;

		public ModelKnights_of_the_Blood_Leggins2() {
			textureWidth = 64;
			textureHeight = 64;
			Right_leg = new ModelRenderer(this);
			Right_leg.setRotationPoint(-2.0F, 12.0F, 0.0F);
			Right_leg.setTextureOffset(0, 0).addBox(-2.3F, 0.5F, -2.5F, 4.0F, 9.0F, 5.0F, 0.0F, false);
			Right_leg.setTextureOffset(0, 15).addBox(1.025F, 0.5F, -2.5F, 1.0F, 9.0F, 5.0F, 0.0F, false);
			Right_leg.setTextureOffset(19, 0).addBox(-2.3F, 0.0F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, false);
			Right_leg.setTextureOffset(28, 7).addBox(1.025F, 0.0F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			Right_leg_r1 = new ModelRenderer(this);
			Right_leg_r1.setRotationPoint(0.0908F, 10.7617F, 1.3544F);
			Right_leg.addChild(Right_leg_r1);
			setRotationAngle(Right_leg_r1, 1.5708F, 1.309F, 1.5708F);
			Right_leg_r1.setTextureOffset(32, 18).addBox(-2.4388F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r1.setTextureOffset(26, 23).addBox(-2.4388F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r2 = new ModelRenderer(this);
			Right_leg_r2.setRotationPoint(0.0908F, 8.7617F, 1.3544F);
			Right_leg.addChild(Right_leg_r2);
			setRotationAngle(Right_leg_r2, 1.5708F, 1.309F, 1.5708F);
			Right_leg_r2.setTextureOffset(32, 18).addBox(-2.4388F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r2.setTextureOffset(26, 23).addBox(-2.4388F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r3 = new ModelRenderer(this);
			Right_leg_r3.setRotationPoint(0.0908F, 6.7617F, 1.3544F);
			Right_leg.addChild(Right_leg_r3);
			setRotationAngle(Right_leg_r3, 1.5708F, 1.309F, 1.5708F);
			Right_leg_r3.setTextureOffset(32, 18).addBox(-2.4388F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r3.setTextureOffset(26, 23).addBox(-2.4388F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r4 = new ModelRenderer(this);
			Right_leg_r4.setRotationPoint(0.0908F, 10.7617F, -1.3544F);
			Right_leg.addChild(Right_leg_r4);
			setRotationAngle(Right_leg_r4, -1.5708F, -1.309F, 1.5708F);
			Right_leg_r4.setTextureOffset(13, 19).addBox(-2.4388F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r4.setTextureOffset(21, 31).addBox(-2.4388F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r5 = new ModelRenderer(this);
			Right_leg_r5.setRotationPoint(0.0908F, 8.7617F, -1.3544F);
			Right_leg.addChild(Right_leg_r5);
			setRotationAngle(Right_leg_r5, -1.5708F, -1.309F, 1.5708F);
			Right_leg_r5.setTextureOffset(13, 19).addBox(-2.4388F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r5.setTextureOffset(21, 31).addBox(-2.4388F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r6 = new ModelRenderer(this);
			Right_leg_r6.setRotationPoint(0.0908F, 6.7617F, -1.3544F);
			Right_leg.addChild(Right_leg_r6);
			setRotationAngle(Right_leg_r6, -1.5708F, -1.309F, 1.5708F);
			Right_leg_r6.setTextureOffset(13, 19).addBox(-2.4388F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r6.setTextureOffset(21, 31).addBox(-2.4388F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r7 = new ModelRenderer(this);
			Right_leg_r7.setRotationPoint(-1.6563F, 7.6296F, 0.0F);
			Right_leg.addChild(Right_leg_r7);
			setRotationAngle(Right_leg_r7, 0.0F, 0.0F, 0.2618F);
			Right_leg_r7.setTextureOffset(8, 27).addBox(-1.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r7.setTextureOffset(14, 10).addBox(-0.6522F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r8 = new ModelRenderer(this);
			Right_leg_r8.setRotationPoint(-1.6563F, 5.6296F, 0.0F);
			Right_leg.addChild(Right_leg_r8);
			setRotationAngle(Right_leg_r8, 0.0F, 0.0F, 0.2618F);
			Right_leg_r8.setTextureOffset(8, 27).addBox(-1.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r8.setTextureOffset(14, 10).addBox(-0.6522F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r9 = new ModelRenderer(this);
			Right_leg_r9.setRotationPoint(-1.6563F, 3.6296F, 0.0F);
			Right_leg.addChild(Right_leg_r9);
			setRotationAngle(Right_leg_r9, 0.0F, 0.0F, 0.2618F);
			Right_leg_r9.setTextureOffset(8, 27).addBox(-1.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r9.setTextureOffset(14, 10).addBox(-0.6522F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r10 = new ModelRenderer(this);
			Right_leg_r10.setRotationPoint(0.0908F, 4.7617F, 1.3544F);
			Right_leg.addChild(Right_leg_r10);
			setRotationAngle(Right_leg_r10, 1.5708F, 1.309F, 1.5708F);
			Right_leg_r10.setTextureOffset(32, 18).addBox(-2.4388F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r10.setTextureOffset(26, 23).addBox(-2.4388F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r11 = new ModelRenderer(this);
			Right_leg_r11.setRotationPoint(0.0908F, 4.7617F, -1.3544F);
			Right_leg.addChild(Right_leg_r11);
			setRotationAngle(Right_leg_r11, -1.5708F, -1.309F, 1.5708F);
			Right_leg_r11.setTextureOffset(13, 19).addBox(-2.4388F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Right_leg_r11.setTextureOffset(21, 31).addBox(-2.4388F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			Right_leg_r12 = new ModelRenderer(this);
			Right_leg_r12.setRotationPoint(-1.6563F, 1.6296F, 0.0F);
			Right_leg.addChild(Right_leg_r12);
			setRotationAngle(Right_leg_r12, 0.0F, 0.0F, 0.2618F);
			Right_leg_r12.setTextureOffset(8, 27).addBox(-1.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			Right_leg_r12.setTextureOffset(14, 10).addBox(-0.6522F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			Left_leg = new ModelRenderer(this);
			Left_leg.setRotationPoint(2.0F, 12.0F, 0.0F);
			Left_leg.setTextureOffset(0, 15).addBox(-2.025F, 0.5F, -2.5F, 1.0F, 9.0F, 5.0F, 0.0F, true);
			Left_leg.setTextureOffset(0, 0).addBox(-1.7F, 0.5F, -2.5F, 4.0F, 9.0F, 5.0F, 0.0F, true);
			Left_leg.setTextureOffset(19, 0).addBox(-1.7F, 0.0F, -2.5F, 4.0F, 1.0F, 5.0F, 0.0F, true);
			Left_leg.setTextureOffset(28, 7).addBox(-2.025F, 0.0F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, true);
			Left_leg_r1 = new ModelRenderer(this);
			Left_leg_r1.setRotationPoint(-0.0908F, 10.7617F, 1.3544F);
			Left_leg.addChild(Left_leg_r1);
			setRotationAngle(Left_leg_r1, 1.5708F, -1.309F, -1.5708F);
			Left_leg_r1.setTextureOffset(32, 18).addBox(-1.5612F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r1.setTextureOffset(26, 23).addBox(-1.5612F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r2 = new ModelRenderer(this);
			Left_leg_r2.setRotationPoint(-0.0908F, 8.7617F, 1.3544F);
			Left_leg.addChild(Left_leg_r2);
			setRotationAngle(Left_leg_r2, 1.5708F, -1.309F, -1.5708F);
			Left_leg_r2.setTextureOffset(32, 18).addBox(-1.5612F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r2.setTextureOffset(26, 23).addBox(-1.5612F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r3 = new ModelRenderer(this);
			Left_leg_r3.setRotationPoint(-0.0908F, 6.7617F, 1.3544F);
			Left_leg.addChild(Left_leg_r3);
			setRotationAngle(Left_leg_r3, 1.5708F, -1.309F, -1.5708F);
			Left_leg_r3.setTextureOffset(32, 18).addBox(-1.5612F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r3.setTextureOffset(26, 23).addBox(-1.5612F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r4 = new ModelRenderer(this);
			Left_leg_r4.setRotationPoint(-0.0908F, 4.7617F, 1.3544F);
			Left_leg.addChild(Left_leg_r4);
			setRotationAngle(Left_leg_r4, 1.5708F, -1.309F, -1.5708F);
			Left_leg_r4.setTextureOffset(32, 18).addBox(-1.5612F, -4.2891F, -2.4F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r4.setTextureOffset(26, 23).addBox(-1.5612F, -4.2891F, -2.07F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r5 = new ModelRenderer(this);
			Left_leg_r5.setRotationPoint(-0.0908F, 10.7617F, -1.3544F);
			Left_leg.addChild(Left_leg_r5);
			setRotationAngle(Left_leg_r5, -1.5708F, 1.309F, -1.5708F);
			Left_leg_r5.setTextureOffset(13, 19).addBox(-1.5612F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r5.setTextureOffset(21, 31).addBox(-1.5612F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r6 = new ModelRenderer(this);
			Left_leg_r6.setRotationPoint(-0.0908F, 8.7617F, -1.3544F);
			Left_leg.addChild(Left_leg_r6);
			setRotationAngle(Left_leg_r6, -1.5708F, 1.309F, -1.5708F);
			Left_leg_r6.setTextureOffset(13, 19).addBox(-1.5612F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r6.setTextureOffset(21, 31).addBox(-1.5612F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r7 = new ModelRenderer(this);
			Left_leg_r7.setRotationPoint(-0.0908F, 6.7617F, -1.3544F);
			Left_leg.addChild(Left_leg_r7);
			setRotationAngle(Left_leg_r7, -1.5708F, 1.309F, -1.5708F);
			Left_leg_r7.setTextureOffset(13, 19).addBox(-1.5612F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r7.setTextureOffset(21, 31).addBox(-1.5612F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r8 = new ModelRenderer(this);
			Left_leg_r8.setRotationPoint(-0.0908F, 4.7617F, -1.3544F);
			Left_leg.addChild(Left_leg_r8);
			setRotationAngle(Left_leg_r8, -1.5708F, 1.309F, -1.5708F);
			Left_leg_r8.setTextureOffset(13, 19).addBox(-1.5612F, -4.2891F, -1.6F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Left_leg_r8.setTextureOffset(21, 31).addBox(-1.5612F, -4.2891F, -1.93F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_leg_r9 = new ModelRenderer(this);
			Left_leg_r9.setRotationPoint(1.6563F, 7.6296F, 0.0F);
			Left_leg.addChild(Left_leg_r9);
			setRotationAngle(Left_leg_r9, 0.0F, 0.0F, -0.2618F);
			Left_leg_r9.setTextureOffset(8, 27).addBox(0.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r9.setTextureOffset(14, 10).addBox(-3.3478F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r10 = new ModelRenderer(this);
			Left_leg_r10.setRotationPoint(1.6563F, 5.6296F, 0.0F);
			Left_leg.addChild(Left_leg_r10);
			setRotationAngle(Left_leg_r10, 0.0F, 0.0F, -0.2618F);
			Left_leg_r10.setTextureOffset(8, 27).addBox(0.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r10.setTextureOffset(14, 10).addBox(-3.3478F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r11 = new ModelRenderer(this);
			Left_leg_r11.setRotationPoint(1.6563F, 3.6296F, 0.0F);
			Left_leg.addChild(Left_leg_r11);
			setRotationAngle(Left_leg_r11, 0.0F, 0.0F, -0.2618F);
			Left_leg_r11.setTextureOffset(8, 27).addBox(0.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r11.setTextureOffset(14, 10).addBox(-3.3478F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r12 = new ModelRenderer(this);
			Left_leg_r12.setRotationPoint(1.6563F, 1.6296F, 0.0F);
			Left_leg.addChild(Left_leg_r12);
			setRotationAngle(Left_leg_r12, 0.0F, 0.0F, -0.2618F);
			Left_leg_r12.setTextureOffset(8, 27).addBox(0.1522F, -1.3913F, -2.5F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			Left_leg_r12.setTextureOffset(14, 10).addBox(-3.3478F, -1.3913F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
			Left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.Left_leg_r7.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r8.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r5.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r6.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_leg_r12.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Left_leg_r3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_leg_r11.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Left_leg_r4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_leg_r10.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Left_leg_r1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r12.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r9.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r11.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Left_leg_r10.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_leg_r1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r5.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r7.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r6.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r9.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Right_leg_r8.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

	// Made with Blockbench 4.0.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelKnights_of_the_Blood_Boots extends EntityModel<Entity> {
		private final ModelRenderer Right_boots;
		private final ModelRenderer Left_boots;

		public ModelKnights_of_the_Blood_Boots() {
			textureWidth = 32;
			textureHeight = 32;
			Right_boots = new ModelRenderer(this);
			Right_boots.setRotationPoint(-2.0F, 12.0F, 0.0F);
			Right_boots.setTextureOffset(0, 8).addBox(1.025F, 9.5F, -2.325F, 1.0F, 3.0F, 4.0F, 0.0F, true);
			Right_boots.setTextureOffset(11, 13).addBox(1.025F, 9.5F, 1.325F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			Right_boots.setTextureOffset(0, 0).addBox(-2.225F, 9.5F, -2.325F, 4.0F, 3.0F, 4.0F, 0.0F, true);
			Right_boots.setTextureOffset(11, 8).addBox(-2.225F, 9.5F, 1.325F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			Left_boots = new ModelRenderer(this);
			Left_boots.setRotationPoint(2.0F, 12.0F, 0.0F);
			Left_boots.setTextureOffset(0, 8).addBox(-2.025F, 9.5F, -2.325F, 1.0F, 3.0F, 4.0F, 0.0F, false);
			Left_boots.setTextureOffset(11, 13).addBox(-2.025F, 9.5F, 1.325F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Left_boots.setTextureOffset(0, 0).addBox(-1.775F, 9.5F, -2.325F, 4.0F, 3.0F, 4.0F, 0.0F, false);
			Left_boots.setTextureOffset(11, 8).addBox(-1.775F, 9.5F, 1.325F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Right_boots.render(matrixStack, buffer, packedLight, packedOverlay);
			Left_boots.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.Left_boots.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.Right_boots.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		}
	}

}
