// Made with Blockbench 4.0.3
// Exported for Minecraft version 1.15 - 1.16 with Mojang mappings
// Paste this class into your mod and generate all required imports

public static class ModelNepenthes extends EntityModel<Entity> {
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

	public ModelNepenthes() {
		texWidth = 64;
		texHeight = 64;

		bone3 = new ModelRenderer(this);
		bone3.setPos(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone3, 3.1416F, 0.0F, 3.1416F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.3927F, 0.0F);
		cube_r1.texOffs(18, 12).addBox(1.0F, -1.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.035F, -0.2595F, -0.1355F);
		cube_r2.texOffs(22, 22).addBox(-5.0F, -1.0F, 0.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0873F, -0.1745F, 0.0F);
		cube_r3.texOffs(15, 22).addBox(-1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setPos(0.0F, 0.0F, 0.0F);
		bone3.addChild(bone2);
		bone2.texOffs(22, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
		bone2.texOffs(20, 14).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		bone2.texOffs(0, 0).addBox(-3.0F, -9.0F, -3.0F, 6.0F, 4.0F, 6.0F, 0.0F, false);
		bone2.texOffs(0, 18).addBox(-2.5F, -13.0F, -2.5F, 5.0F, 4.0F, 5.0F, 0.0F, false);
		bone2.texOffs(0, 10).addBox(-3.0F, -15.0F, -3.0F, 6.0F, 2.0F, 6.0F, 0.0F, false);
		bone2.texOffs(19, 5).addBox(-2.5F, -17.0F, -2.5F, 5.0F, 2.0F, 5.0F, 0.0F, false);
		bone2.texOffs(18, 0).addBox(-2.0F, -18.0F, -2.0F, 4.0F, 1.0F, 4.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setPos(0.0F, -18.0F, 0.0F);
		bone3.addChild(bone);
		setRotationAngle(bone, -0.3491F, 0.0F, 0.0F);
		bone.texOffs(0, 18).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setPos(-0.5F, -3.0F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.2182F);
		cube_r4.texOffs(0, 10).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setPos(0.0F, -3.0F, 0.5F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.2182F, 0.0F, 0.0F);
		cube_r5.texOffs(0, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setPos(0.5F, -3.0F, 0.0F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.2182F);
		cube_r6.texOffs(0, 12).addBox(0.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setPos(0.0F, -3.0F, -0.5F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, -0.2182F, 0.0F, 0.0F);
		cube_r7.texOffs(0, 3).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void renderToBuffer(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		bone3.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.xRot = x;
		modelRenderer.yRot = y;
		modelRenderer.zRot = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}