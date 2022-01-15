
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

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SkillsGuiWindow extends ContainerScreen<SkillsGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = SkillsGui.guistate;

	public SkillsGuiWindow(SkillsGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		this.blit(ms, this.guiLeft + 7, this.guiTop + 0, 0, 0, 160, 160, 160, 160);

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
		this.font.drawString(ms, "Skills", 71, 2, -13421773);
		this.font.drawString(ms, "Skill:_________________", 9, 26, -1);
		this.font.drawString(ms,
				"" + ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).skill)
						+ "",
				39, 26, -16711681);
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
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + 37, 95, 20, new StringTextComponent("Vertical Slash"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(0, x, y, z));
				SkillsGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 159, 70, 20, new StringTextComponent("Main Menu"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(1, x, y, z));
				SkillsGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + 57, 85, 20, new StringTextComponent("Meteor Break"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(2, x, y, z));
				SkillsGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 8, this.guiTop + 77, 45, 20, new StringTextComponent("Dash"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new SkillsGui.ButtonPressedMessage(3, x, y, z));
				SkillsGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
