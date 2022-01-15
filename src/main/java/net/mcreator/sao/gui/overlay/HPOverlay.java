
package net.mcreator.sao.gui.overlay;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.sao.procedures.Hp44Procedure;
import net.mcreator.sao.procedures.Hp34Procedure;
import net.mcreator.sao.procedures.Hp24Procedure;
import net.mcreator.sao.procedures.Hp14Procedure;
import net.mcreator.sao.procedures.HearthcanProcedure;
import net.mcreator.sao.SaoModVariables;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber
public class HPOverlay {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGameOverlayEvent.Post event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int w = event.getWindow().getScaledWidth();
			int h = event.getWindow().getScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			World _world = null;
			double _x = 0;
			double _y = 0;
			double _z = 0;
			PlayerEntity entity = Minecraft.getInstance().player;
			if (entity != null) {
				_world = entity.world;
				_x = entity.getPosX();
				_y = entity.getPosY();
				_z = entity.getPosZ();
			}
			World world = _world;
			double x = _x;
			double y = _y;
			double z = _z;
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
					GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			RenderSystem.disableAlphaTest();
			if (HearthcanProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/b1.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -103, 0, 0, 64, 16, 64, 16);

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "" + ((entity
						.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).classs) + "",
						posX + -207, posY + -113, -1);
				if (Hp14Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/b3.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -103, 0, 0, 64, 16, 64, 16);
				}
				if (Hp24Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/b4.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -103, 0, 0, 64, 16, 64, 16);
				}
				if (Hp34Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/b5.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -103, 0, 0, 64, 16, 64, 16);
				}
				if (Hp44Procedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
						(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll))) {
					Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/b6.png"));
					Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -103, 0, 0, 64, 16, 64, 16);
				}
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(),
						"" + ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new SaoModVariables.PlayerVariables())).hp_show) + "",
						posX + -206, posY + -103, -65281);
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/other_bar.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -87, 0, 0, 50, 9, 50, 9);

				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("sao:textures/other_bar.png"));
				Minecraft.getInstance().ingameGUI.blit(event.getMatrixStack(), posX + -207, posY + -78, 0, 0, 50, 9, 50, 9);

				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), ""
						+ ((entity.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).xp)
						+ "", posX + -206, posY + -78, -16737793);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "" + ((entity
						.getCapability(SaoModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new SaoModVariables.PlayerVariables())).lvl) + "",
						posX + -206, posY + -87, -16711681);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "LVL", posX + -156, posY + -87, -16777216);
				Minecraft.getInstance().fontRenderer.drawString(event.getMatrixStack(), "XP", posX + -156, posY + -78, -12829636);
			}
			RenderSystem.depthMask(true);
			RenderSystem.enableDepthTest();
			RenderSystem.enableAlphaTest();
			RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
		}
	}
}
