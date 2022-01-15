// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelBoar extends EntityModel<Entity> {
	private final ModelRenderer leg4;
	private final ModelRenderer cube_r1;
	private final ModelRenderer leg3;
	private final ModelRenderer cube_r2;
	private final ModelRenderer leg2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer leg;
	private final ModelRenderer cube_r4;
	private final ModelRenderer head;
	private final ModelRenderer cube_r5;
	private final ModelRenderer bb_main;

	public ModelBoar() {
		textureWidth = 64;
		textureHeight = 64;

		leg4 = new ModelRenderer(this);
		leg4.setRotationPoint(4.0F, 17.0F, -5.5F);
		leg4.setTextureOffset(32, 0).addBox(-0.5F, -1.0F, -1.5F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(1.0F, 3.0F, -1.5F);
		leg4.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3054F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(16, 34).addBox(-1.0F, -0.25F, 0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leg3 = new ModelRenderer(this);
		leg3.setRotationPoint(-3.0F, 17.0F, -5.75F);
		leg3.setTextureOffset(26, 28).addBox(-3.5F, -1.0F, -1.25F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.0F, 3.0F, -1.25F);
		leg3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3054F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(8, 34).addBox(-1.0F, -0.25F, 0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leg2 = new ModelRenderer(this);
		leg2.setRotationPoint(-4.0F, 17.0F, 5.25F);
		leg2.setTextureOffset(0, 7).addBox(-2.5F, -1.0F, -1.25F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-1.0F, 3.0F, -1.25F);
		leg2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.3054F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(0, 34).addBox(-1.0F, -0.25F, 0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		leg = new ModelRenderer(this);
		leg.setRotationPoint(4.0F, 17.0F, 5.75F);
		leg.setTextureOffset(0, 0).addBox(-0.5F, -1.0F, -1.75F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(1.0F, 3.0F, -1.75F);
		leg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.3054F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(32, 7).addBox(-1.0F, -0.25F, 0.5F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 19.0F, -8.0F);
		head.setTextureOffset(21, 23).addBox(-3.0F, -7.0F, -4.0F, 6.0F, 1.0F, 4.0F, 0.0F, false);
		head.setTextureOffset(24, 35).addBox(-1.5F, -3.0F, -6.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 23).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 5.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(2.0F, -2.0F, -5.0F);
		head.addChild(cube_r5);
		setRotationAngle(cube_r5, 1.0908F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(12, 6).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		cube_r5.setTextureOffset(12, 0).addBox(-4.5F, -3.0F, -0.5F, 1.0F, 5.0F, 1.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -12.0F, -8.0F, 8.0F, 7.0F, 16.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leg4.render(matrixStack, buffer, packedLight, packedOverlay);
		leg3.render(matrixStack, buffer, packedLight, packedOverlay);
		leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		leg.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
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
		this.leg4.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}