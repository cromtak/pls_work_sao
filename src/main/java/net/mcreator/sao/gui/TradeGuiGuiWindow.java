
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
public class TradeGuiGuiWindow extends ContainerScreen<TradeGuiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = TradeGuiGui.guistate;

	public TradeGuiGuiWindow(TradeGuiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		this.blit(ms, this.guiLeft + 6, this.guiTop + -2, 0, 0, 160, 160, 160, 160);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 33, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 69, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 87, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 123, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 141, this.guiTop + 25, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 15, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 33, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 51, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 69, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 87, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 105, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 123, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

		Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/slot2.png"));
		this.blit(ms, this.guiLeft + 141, this.guiTop + 52, 0, 0, 18, 18, 18, 18);

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
		this.addButton(new Button(this.guiLeft + 60, this.guiTop + -2, 50, 20, new StringTextComponent("trade"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new TradeGuiGui.ButtonPressedMessage(0, x, y, z));
				TradeGuiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
