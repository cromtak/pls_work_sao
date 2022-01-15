package net.mcreator.sao.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.sao.entity.ToadEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class ToadRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(ToadEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modeltoad(), 0.2f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("sao:textures/toad.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modeltoad extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer cube_r1;
		private final ModelRenderer bone2;
		private final ModelRenderer cube_r2;
		private final ModelRenderer bone3;
		private final ModelRenderer cube_r3;
		private final ModelRenderer bone4;
		private final ModelRenderer cube_r4;
		private final ModelRenderer bb_main;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;

		public Modeltoad() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-1.75F, 22.0F, 3.0F);
			bone.setTextureOffset(10, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -1.0F, 0.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, -2.2253F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(10, 6).addBox(-1.0F, -1.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(1.75F, 22.0F, 3.0F);
			bone2.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, -1.0F, 0.0F);
			bone2.addChild(cube_r2);
			setRotationAngle(cube_r2, -2.2253F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(4, 10).addBox(-1.0F, -1.0F, 0.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-2.75F, 20.5F, 0.25F);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.3927F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 10).addBox(-0.25F, -0.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(1.25F, 20.5F, 0.25F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone4.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.3927F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(9, 9).addBox(-0.25F, -0.5F, -0.5F, 1.0F, 4.0F, 1.0F, 0.0F, false);
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.5F, -3.25F, -0.75F);
			bb_main.addChild(cube_r5);
			setRotationAngle(cube_r5, -0.0873F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 6).addBox(-1.5F, -1.9887F, -1.3141F, 3.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 3.0F);
			bb_main.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.6109F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 0).addBox(-2.0F, -2.5F, -4.75F, 3.0F, 2.0F, 4.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone4.render(matrixStack, buffer, packedLight, packedOverlay);
			bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.bone3.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.bone2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.bone4.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.bone.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
