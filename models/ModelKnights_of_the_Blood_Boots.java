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
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Right_boots.render(matrixStack, buffer, packedLight, packedOverlay);
		Left_boots.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Left_boots.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Right_boots.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}