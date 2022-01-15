// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelSteve extends EntityModel<Entity> {
	private final ModelRenderer Head2;
	private final ModelRenderer Body2;
	private final ModelRenderer RightArm2;
	private final ModelRenderer LeftArm2;
	private final ModelRenderer RightLeg2;
	private final ModelRenderer LeftLeg2;

	public ModelSteve() {
		textureWidth = 16;
		textureHeight = 16;

		Head2 = new ModelRenderer(this);
		Head2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head2.setTextureOffset(0, 0).addBox(-4.0F, 4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body2.setTextureOffset(16, 16).addBox(-4.0F, 12.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);

		RightArm2 = new ModelRenderer(this);
		RightArm2.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm2.setTextureOffset(40, 16).addBox(-3.0F, 10.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftArm2 = new ModelRenderer(this);
		LeftArm2.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm2.setTextureOffset(32, 48).addBox(-1.0F, 10.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		RightLeg2 = new ModelRenderer(this);
		RightLeg2.setRotationPoint(-1.9F, 12.0F, 0.0F);
		RightLeg2.setTextureOffset(0, 16).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		LeftLeg2 = new ModelRenderer(this);
		LeftLeg2.setRotationPoint(1.9F, 12.0F, 0.0F);
		LeftLeg2.setTextureOffset(16, 48).addBox(-2.0F, 12.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head2.render(matrixStack, buffer, packedLight, packedOverlay);
		Body2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightArm2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftArm2.render(matrixStack, buffer, packedLight, packedOverlay);
		RightLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
		LeftLeg2.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.RightArm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Head2.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head2.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.RightLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.LeftLeg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}