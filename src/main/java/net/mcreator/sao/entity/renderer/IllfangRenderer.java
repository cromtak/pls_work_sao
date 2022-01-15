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

import net.mcreator.sao.entity.IllfangEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class IllfangRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(IllfangEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelkobalt_daddy(), 0.9f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("sao:textures/kobalt_daddy.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.0.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelkobalt_daddy extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer arm2;
		private final ModelRenderer bone5;
		private final ModelRenderer arm;
		private final ModelRenderer leg;
		private final ModelRenderer leg2;

		public Modelkobalt_daddy() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -12.0F, 0.0F);
			setRotationAngle(bone, -3.1416F, 0.0F, 3.1416F);
			bone.setTextureOffset(0, 0).addBox(-7.5F, 5.0F, -4.5F, 15.0F, 16.0F, 11.0F, 0.0F, false);
			bone.setTextureOffset(0, 27).addBox(-8.5F, -3.0F, -3.5F, 17.0F, 8.0F, 9.0F, 0.0F, false);
			bone.setTextureOffset(70, 19).addBox(-6.5F, 6.0F, 6.5F, 13.0F, 14.0F, 2.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 36.0F, 0.0F);
			bone.addChild(head);
			head.setTextureOffset(40, 32).addBox(-4.5F, -48.0F, -3.5F, 9.0F, 9.0F, 12.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.0436F);
			cube_r1.setTextureOffset(41, 0).addBox(4.5F, -48.0F, -1.5F, 9.0F, 4.0F, 2.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.0436F);
			cube_r2.setTextureOffset(70, 35).addBox(-13.5F, -48.0F, -1.5F, 9.0F, 4.0F, 2.0F, 0.0F, false);
			arm2 = new ModelRenderer(this);
			arm2.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(arm2);
			arm2.setTextureOffset(42, 71).addBox(9.0F, -2.5F, 18.5F, 7.0F, 7.0F, 6.0F, 0.0F, false);
			arm2.setTextureOffset(52, 0).addBox(9.5F, -2.0F, 5.5F, 6.0F, 6.0F, 13.0F, 0.0F, false);
			arm2.setTextureOffset(0, 63).addBox(8.5F, -3.0F, -3.5F, 8.0F, 8.0F, 9.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(0.0F, 36.0F, 0.0F);
			arm2.addChild(bone5);
			bone5.setTextureOffset(43, 27).addBox(12.0F, -51.25F, 29.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(0, 27).addBox(12.0F, -52.25F, 28.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(0, 44).addBox(12.0F, -54.25F, 26.5F, 1.0F, 11.0F, 2.0F, 0.0F, false);
			bone5.setTextureOffset(0, 0).addBox(12.0F, -53.25F, 25.5F, 1.0F, 9.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(4, 27).addBox(12.0F, -52.25F, 24.5F, 1.0F, 7.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(4, 0).addBox(12.0F, -51.25F, 22.5F, 1.0F, 5.0F, 2.0F, 0.0F, false);
			bone5.setTextureOffset(34, 70).addBox(11.5F, -52.25F, 20.5F, 2.0F, 35.0F, 2.0F, 0.0F, false);
			arm = new ModelRenderer(this);
			arm.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(arm);
			arm.setTextureOffset(66, 64).addBox(-16.0F, -2.5F, 18.5F, 7.0F, 7.0F, 6.0F, 0.0F, false);
			arm.setTextureOffset(0, 44).addBox(-15.5F, -2.0F, 5.5F, 6.0F, 6.0F, 13.0F, 0.0F, false);
			arm.setTextureOffset(38, 53).addBox(-16.5F, -3.0F, -3.5F, 8.0F, 8.0F, 9.0F, 0.0F, false);
			leg = new ModelRenderer(this);
			leg.setRotationPoint(0.0F, 16.0F, 0.0F);
			bone.addChild(leg);
			leg.setTextureOffset(76, 47).addBox(-11.5F, -2.0F, -2.5F, 6.0F, 9.0F, 6.0F, 0.0F, false);
			leg.setTextureOffset(87, 87).addBox(-11.0F, 7.0F, -2.0F, 5.0F, 9.0F, 5.0F, 0.0F, false);
			leg.setTextureOffset(0, 80).addBox(-12.0F, 16.0F, -3.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);
			leg2 = new ModelRenderer(this);
			leg2.setRotationPoint(0.0F, 16.0F, 0.0F);
			bone.addChild(leg2);
			leg2.setTextureOffset(68, 77).addBox(5.5F, -2.0F, -2.5F, 6.0F, 9.0F, 6.0F, 0.0F, false);
			leg2.setTextureOffset(42, 84).addBox(6.0F, 7.0F, -2.0F, 5.0F, 9.0F, 5.0F, 0.0F, false);
			leg2.setTextureOffset(77, 0).addBox(5.0F, 16.0F, -3.0F, 7.0F, 4.0F, 7.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {

			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.arm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			this.leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
