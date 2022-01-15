// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelTremblingOx extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer leftArm;
	private final ModelRenderer rightArm;
	private final ModelRenderer leftLeg;
	private final ModelRenderer rightLeg;

	public ModelTremblingOx() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -5.0F, 0.0F);
		head.setTextureOffset(0, 23).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(24, 24).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(16, 39).addBox(-7.0F, -8.0F, 1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		head.setTextureOffset(0, 2).addBox(-9.0F, -7.5F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 0).addBox(7.0F, -7.5F, 1.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(26, 0).addBox(4.0F, -8.0F, 1.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 17.0F, 6.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 11.0F, 3.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, -0.829F, 0.0F, 0.0F);
		body_r1.setTextureOffset(48, 44).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		leftArm = new ModelRenderer(this);
		leftArm.setRotationPoint(-6.0F, -3.0F, 0.0F);
		leftArm.setTextureOffset(22, 42).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);
		leftArm.setTextureOffset(24, 10).addBox(-1.5F, 9.5F, -8.0F, 1.0F, 1.0F, 13.0F, 0.0F, false);
		leftArm.setTextureOffset(38, 42).addBox(-2.5F, 8.5F, -13.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		leftArm.setTextureOffset(0, 23).addBox(-1.5F, 7.5F, -12.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		leftArm.setTextureOffset(49, 37).addBox(-2.5F, 5.5F, -13.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		leftArm.setTextureOffset(48, 19).addBox(-2.5F, 12.5F, -13.0F, 3.0F, 2.0F, 5.0F, 0.0F, false);

		rightArm = new ModelRenderer(this);
		rightArm.setRotationPoint(6.0F, -3.0F, 0.0F);
		rightArm.setTextureOffset(39, 0).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 14.0F, 4.0F, 0.0F, false);

		leftLeg = new ModelRenderer(this);
		leftLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
		leftLeg.setTextureOffset(0, 39).addBox(-3.0F, 0.0F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);

		rightLeg = new ModelRenderer(this);
		rightLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
		rightLeg.setTextureOffset(32, 24).addBox(-2.0F, 0.0F, -3.0F, 5.0F, 12.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
		rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
		leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.rightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.leftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}