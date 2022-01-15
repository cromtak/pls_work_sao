package net.mcreator.sao.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.sao.entity.NepenthesEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NepenthesRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(NepenthesEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelnepenthes2(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("sao:textures/nepenthes.png");
					}
				};
			});
			RenderingRegistry.registerEntityRenderingHandler(NepenthesEntity.arrow,
					renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
		}
	}

	// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelnepenthes2 extends EntityModel<Entity> {
		private final ModelRenderer bone3;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer bone2;
		private final ModelRenderer bone;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;

		public Modelnepenthes2() {
			textureWidth = 64;
			textureHeight = 64;
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone3, 3.1416F, 0.0F, 3.1416F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.3927F, 0.0F);
			cube_r1.setTextureOffset(18, 12).addBox(1.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.035F, -0.2595F, -0.1355F);
			cube_r2.setTextureOffset(22, 22).addBox(-5.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.0873F, -0.1745F, 0.0F);
			cube_r3.setTextureOffset(15, 22).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(bone2);
			bone2.setTextureOffset(22, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			bone2.setTextureOffset(20, 14).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
			bone2.setTextureOffset(0, 0).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
			bone2.setTextureOffset(0, 18).addBox(-2.5F, -13.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
			bone2.setTextureOffset(0, 10).addBox(-3.0F, -15.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
			bone2.setTextureOffset(19, 5).addBox(-2.5F, -17.0F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
			bone2.setTextureOffset(18, 0).addBox(-2.0F, -18.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -18.0F, 0.0F);
			bone3.addChild(bone);
			setRotationAngle(bone, -0.3491F, 0.0F, 0.0F);
			bone.setTextureOffset(0, 18).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-0.5F, -3.0F, 0.0F);
			bone.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, 0.2182F);
			cube_r4.setTextureOffset(0, 10).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, -3.0F, 0.5F);
			bone.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.2182F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.5F, -3.0F, 0.0F);
			bone.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.2182F);
			cube_r6.setTextureOffset(0, 12).addBox(0.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, -3.0F, -0.5F);
			bone.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.2182F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(0, 3).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

		}
	}

}
