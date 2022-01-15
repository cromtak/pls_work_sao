
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
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.sao.SaoModVariables;
import net.mcreator.sao.SaoMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MenuGuiWindow extends ContainerScreen<MenuGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MenuGui.guistate;
	TextFieldWidget nick;

	public MenuGuiWindow(MenuGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
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
		nick.render(ms, mouseX, mouseY, partialTicks);
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
		if (nick.isFocused())
			return nick.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
		nick.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Menu", 78, -2, -13421773);
		this.font.drawString(ms,
				"" + ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).party)
						+ "",
				77, 55, -1);
		this.font.drawString(ms, "Party Members:", 7, 55, -13421773);
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
		this.addButton(new Button(this.guiLeft + 6, this.guiTop + 16, 50, 20, new StringTextComponent("Stats"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(0, x, y, z));
				MenuGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 51, this.guiTop + 34, 50, 20, new StringTextComponent("remove"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(1, x, y, z));
				MenuGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 105, this.guiTop + 34, 40, 20, new StringTextComponent("add"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(2, x, y, z));
				MenuGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		nick = new TextFieldWidget(this.font, this.guiLeft + 7, this.guiTop + 34, 45, 20, new StringTextComponent("nick")) {
			{
				setSuggestion("nick");
			}

			@Override
			public void writeText(String text) {
				super.writeText(text);
				if (getText().isEmpty())
					setSuggestion("nick");
				else
					setSuggestion(null);
			}

			@Override
			public void setCursorPosition(int pos) {
				super.setCursorPosition(pos);
				if (getText().isEmpty())
					setSuggestion("nick");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:nick", nick);
		nick.setMaxStringLength(32767);
		this.children.add(this.nick);
		this.addButton(new Button(this.guiLeft + 7, this.guiTop + 68, 55, 20, new StringTextComponent("Skills"), e -> {
			if (true) {
				SaoMod.PACKET_HANDLER.sendToServer(new MenuGui.ButtonPressedMessage(3, x, y, z));
				MenuGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
