
package net.mcreator.sao.gui;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.sao.SaoMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CookingGuiWindow extends ContainerScreen<CookingGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = CookingGui.guistate;

	public CookingGuiWindow(CookingGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/stats_b.png"));
		this.blit(ms, this.guiLeft + 6, this.guiTop + 7, 0, 0, 160, 160, 160, 160);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 34, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 42, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 34, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 114, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 78, this.guiTop + 97, 0, 0, 18, 18, 18, 18);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 65, this.guiTop + 70, 45, 20, new StringTextComponent("cook"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new CookingGui.ButtonPressedMessage(0, x, y, z));
				CookingGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
