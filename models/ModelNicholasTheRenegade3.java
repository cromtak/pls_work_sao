// Made with Blockbench 4.0.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelNicholasTheRenegade3 extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer head_r3;
	private final ModelRenderer head_r4;
	private final ModelRenderer head_r5;
	private final ModelRenderer head_r6;
	private final ModelRenderer Right_arm;
	private final ModelRenderer Right_arm_r1;
	private final ModelRenderer Right_arm_r2;
	private final ModelRenderer Right_arm_r3;
	private final ModelRenderer Right_arm_r4;
	private final ModelRenderer Left_arm;
	private final ModelRenderer Left_arm_r1;
	private final ModelRenderer Left_arm_r2;
	private final ModelRenderer Left_arm_r3;
	private final ModelRenderer Left_arm_r4;
	private final ModelRenderer Body;
	private final ModelRenderer Legs;

	public ModelNicholasTheRenegade3() {
		textureWidth = 256;
		textureHeight = 256;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -33.5F, 0.0F);
		Head.setTextureOffset(106, 111).addBox(-6.5F, 15.4169F, -6.6F, 13.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(106, 98).addBox(-7.5F, 16.6669F, -6.6F, 15.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(106, 86).addBox(-9.0F, 17.9169F, -6.6F, 18.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(121, 32).addBox(-4.0F, -0.5831F, -7.1F, 8.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(21, 23).addBox(-2.5F, 1.9169F, -7.1F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 113).addBox(-5.0F, -3.0831F, -7.1F, 10.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(106, 104).addBox(-6.5F, -5.5831F, -7.1F, 13.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(25, 44).addBox(-1.5F, 4.4169F, -7.1F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 125).addBox(-4.0F, 22.9169F, -6.6F, 8.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(121, 22).addBox(-5.0F, 21.6669F, -6.6F, 10.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 14).addBox(-4.0F, -5.5831F, -6.6F, 8.0F, 21.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(0, 107).addBox(-6.5F, 20.4169F, -6.6F, 13.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(106, 92).addBox(-7.5F, 19.1669F, -6.6F, 15.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(25, 0).addBox(-2.5F, 24.1669F, -6.6F, 5.0F, 3.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(76, 125).addBox(-5.0F, -10.0831F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
		Head.setTextureOffset(61, 178).addBox(-6.5F, -13.0831F, -6.5F, 13.0F, 3.0F, 13.0F, 0.0F, false);
		Head.setTextureOffset(23, 70).addBox(-1.0F, -25.8831F, 13.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		Head.setTextureOffset(21, 14).addBox(-1.5F, -6.5831F, -8.25F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		Head.setTextureOffset(61, 178).addBox(-6.5F, -12.8331F, -6.5F, 13.0F, 3.0F, 13.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(-0.75F, -28.0831F, 4.0F);
		Head.addChild(head_r1);
		setRotationAngle(head_r1, -1.5708F, 0.0F, 0.0F);
		head_r1.setTextureOffset(0, 0).addBox(0.25F, -9.65F, 2.7F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(-0.25F, -28.0831F, 4.0F);
		Head.addChild(head_r2);
		setRotationAngle(head_r2, -1.309F, 0.0F, 0.0F);
		head_r2.setTextureOffset(25, 58).addBox(-0.75F, -5.75F, 3.85F, 2.0F, 3.0F, 2.0F, 0.0F, false);

		head_r3 = new ModelRenderer(this);
		head_r3.setRotationPoint(0.25F, -28.0831F, 4.0F);
		Head.addChild(head_r3);
		setRotationAngle(head_r3, -1.0472F, 0.0F, 0.0F);
		head_r3.setTextureOffset(21, 30).addBox(-1.75F, -1.75F, 4.05F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		head_r4 = new ModelRenderer(this);
		head_r4.setRotationPoint(0.0F, -26.3331F, 2.5F);
		Head.addChild(head_r4);
		setRotationAngle(head_r4, -0.7854F, 0.0F, 0.0F);
		head_r4.setTextureOffset(115, 63).addBox(-2.5F, -0.075F, 2.475F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		head_r5 = new ModelRenderer(this);
		head_r5.setRotationPoint(0.25F, -22.5831F, 0.75F);
		Head.addChild(head_r5);
		setRotationAngle(head_r5, -0.5236F, 0.0F, 0.0F);
		head_r5.setTextureOffset(0, 0).addBox(-4.25F, 1.2F, -0.825F, 8.0F, 5.0F, 8.0F, 0.0F, false);

		head_r6 = new ModelRenderer(this);
		head_r6.setRotationPoint(0.0F, -18.8331F, -0.4286F);
		Head.addChild(head_r6);
		setRotationAngle(head_r6, -0.2618F, 0.0F, 0.0F);
		head_r6.setTextureOffset(157, 190).addBox(-5.0F, 1.875F, -3.15F, 10.0F, 5.0F, 10.0F, 0.0F, false);

		Right_arm = new ModelRenderer(this);
		Right_arm.setRotationPoint(-7.5F, -29.75F, 0.0F);
		Right_arm.setTextureOffset(121, 11).addBox(-7.6033F, -2.8653F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		Right_arm.setTextureOffset(121, 0).addBox(-15.096F, 29.5483F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, true);
		Right_arm.setTextureOffset(0, 44).addBox(-16.6212F, 25.1844F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, true);

		Right_arm_r1 = new ModelRenderer(this);
		Right_arm_r1.setRotationPoint(-2.5F, -1.1609F, -0.125F);
		Right_arm.addChild(Right_arm_r1);
		setRotationAngle(Right_arm_r1, 0.0F, 0.0F, 1.5708F);
		Right_arm_r1.setTextureOffset(0, 58).addBox(-3.25F, -2.5F, -3.75F, 8.0F, 3.0F, 8.0F, 0.0F, true);

		Right_arm_r2 = new ModelRenderer(this);
		Right_arm_r2.setRotationPoint(-10.986F, 13.8702F, -0.25F);
		Right_arm.addChild(Right_arm_r2);
		setRotationAngle(Right_arm_r2, 0.0F, 0.0F, 0.3054F);
		Right_arm_r2.setTextureOffset(0, 70).addBox(-3.45F, -4.05F, -3.75F, 7.0F, 2.0F, 8.0F, 0.0F, true);

		Right_arm_r3 = new ModelRenderer(this);
		Right_arm_r3.setRotationPoint(-12.6604F, 22.005F, 0.0F);
		Right_arm.addChild(Right_arm_r3);
		setRotationAngle(Right_arm_r3, 0.0F, 0.0F, 0.1745F);
		Right_arm_r3.setTextureOffset(0, 86).addBox(-1.9108F, -10.75F, -2.5F, 5.0F, 18.0F, 5.0F, 0.0F, true);

		Right_arm_r4 = new ModelRenderer(this);
		Right_arm_r4.setRotationPoint(-9.2495F, 2.3885F, 0.0F);
		Right_arm.addChild(Right_arm_r4);
		setRotationAngle(Right_arm_r4, 0.0F, 0.0F, 0.3491F);
		Right_arm_r4.setTextureOffset(115, 44).addBox(-0.25F, -5.5F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, true);

		Left_arm = new ModelRenderer(this);
		Left_arm.setRotationPoint(7.5F, -29.75F, 0.0F);
		Left_arm.setTextureOffset(121, 11).addBox(2.6033F, -2.8653F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		Left_arm.setTextureOffset(121, 0).addBox(10.096F, 29.5483F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		Left_arm.setTextureOffset(0, 44).addBox(8.6212F, 25.1844F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, false);

		Left_arm_r1 = new ModelRenderer(this);
		Left_arm_r1.setRotationPoint(2.5F, -1.1609F, -0.125F);
		Left_arm.addChild(Left_arm_r1);
		setRotationAngle(Left_arm_r1, 0.0F, 0.0F, -1.5708F);
		Left_arm_r1.setTextureOffset(0, 58).addBox(-4.75F, -2.5F, -3.75F, 8.0F, 3.0F, 8.0F, 0.0F, false);

		Left_arm_r2 = new ModelRenderer(this);
		Left_arm_r2.setRotationPoint(10.986F, 13.8702F, -0.25F);
		Left_arm.addChild(Left_arm_r2);
		setRotationAngle(Left_arm_r2, 0.0F, 0.0F, -0.3054F);
		Left_arm_r2.setTextureOffset(0, 70).addBox(-3.55F, -4.05F, -3.75F, 7.0F, 2.0F, 8.0F, 0.0F, false);

		Left_arm_r3 = new ModelRenderer(this);
		Left_arm_r3.setRotationPoint(12.6604F, 22.005F, 0.0F);
		Left_arm.addChild(Left_arm_r3);
		setRotationAngle(Left_arm_r3, 0.0F, 0.0F, -0.1745F);
		Left_arm_r3.setTextureOffset(0, 86).addBox(-3.0892F, -10.75F, -2.5F, 5.0F, 18.0F, 5.0F, 0.0F, false);

		Left_arm_r4 = new ModelRenderer(this);
		Left_arm_r4.setRotationPoint(9.2495F, 2.3885F, 0.0F);
		Left_arm.addChild(Left_arm_r4);
		setRotationAngle(Left_arm_r4, 0.0F, 0.0F, -0.3491F);
		Left_arm_r4.setTextureOffset(115, 44).addBox(-4.75F, -5.5F, -2.5F, 5.0F, 13.0F, 5.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, -13.9275F, 0.0F);
		Body.setTextureOffset(154, 156).addBox(-6.5F, -15.5556F, -5.0F, 13.0F, 23.0F, 10.0F, 0.0F, false);
		Body.setTextureOffset(114, 178).addBox(-6.5F, 7.4444F, -6.5F, 13.0F, 3.0F, 13.0F, 0.0F, false);
		Body.setTextureOffset(0, 178).addBox(-7.5F, 10.3444F, -7.5F, 15.0F, 2.0F, 15.0F, 0.0F, false);
		Body.setTextureOffset(171, 129).addBox(-7.5F, -20.2334F, -6.5F, 15.0F, 8.0F, 13.0F, 0.0F, false);

		Legs = new ModelRenderer(this);
		Legs.setRotationPoint(0.0F, -1.6F, 0.0F);
		Legs.setTextureOffset(81, 156).addBox(-9.0F, 0.0169F, -9.0F, 18.0F, 3.0F, 18.0F, 0.0F, false);
		Legs.setTextureOffset(0, 154).addBox(-10.0F, 2.5169F, -10.0F, 20.0F, 3.0F, 20.0F, 0.0F, false);
		Legs.setTextureOffset(101, 129).addBox(-11.5F, 5.0169F, -11.5F, 23.0F, 3.0F, 23.0F, 0.0F, false);
		Legs.setTextureOffset(0, 125).addBox(-12.5F, 7.5169F, -12.5F, 25.0F, 3.0F, 25.0F, 0.0F, false);
		Legs.setTextureOffset(121, 0).addBox(-14.0F, 10.0169F, -14.0F, 28.0F, 3.0F, 28.0F, 0.0F, false);
		Legs.setTextureOffset(115, 44).addBox(-15.0F, 12.5169F, -15.0F, 30.0F, 3.0F, 30.0F, 0.0F, false);
		Legs.setTextureOffset(108, 92).addBox(-16.5F, 15.0169F, -16.5F, 33.0F, 3.0F, 33.0F, 0.0F, false);
		Legs.setTextureOffset(0, 86).addBox(-17.5F, 17.5169F, -17.5F, 35.0F, 3.0F, 35.0F, 0.0F, false);
		Legs.setTextureOffset(0, 44).addBox(-19.0F, 20.0169F, -19.0F, 38.0F, 3.0F, 38.0F, 0.0F, false);
		Legs.setTextureOffset(0, 0).addBox(-20.0F, 22.5169F, -20.0F, 40.0F, 3.0F, 40.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		Left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Legs.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.Right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}