// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import java.awt.Color;
import Benz.utils.DraggableRectangle;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;

public class GuiChangeLog extends GuiScreen
{
    ScaledResolution sr;
    
    public GuiChangeLog(final GuiMainMenu guiMainMenu) {
        this.sr = new ScaledResolution(Minecraft.getMinecraft());
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        if (this.sr.getScaleFactor() == 2) {
            GlStateManager.scale(0.5, 0.5, 0.5);
        }
        else if (this.sr.getScaleFactor() == 3) {
            GlStateManager.scale(0.3325, 0.3325, 0.3325);
        }
        else if (this.sr.getScaleFactor() == 4) {
            GlStateManager.scale(0.25, 0.25, 0.25);
        }
        final DraggableRectangle guiMain = new DraggableRectangle(0, 0, 120, 550, 100663296);
        final DraggableRectangle guiTop = new DraggableRectangle(0, 0, 120, 15, 1610612736);
        guiMain.draw(mouseX, mouseY);
        guiTop.draw(mouseX, mouseY);
        GlStateManager.scale(1.0f, 1.0f, 1.0f);
        this.drawCenteredString(this.fontRendererObj, "Sin Client Change Log", this.width / 16, 2, Color.WHITE.getRGB());
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.popMatrix();
    }
}
