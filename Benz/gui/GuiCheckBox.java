// 
// Decompiled by Procyon v0.5.36
// 

package Benz.gui;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.Minecraft;
import java.awt.Color;
import net.minecraft.client.gui.GuiButton;

public class GuiCheckBox extends GuiButton
{
    public boolean checked;
    private static final String X = "OFF";
    private static final String CHECK = "ON";
    private static final Color X_COLOR;
    private static final Color CHECK_COLOR;
    
    static {
        X_COLOR = Color.RED;
        CHECK_COLOR = Color.GREEN;
    }
    
    public GuiCheckBox(final int buttonId, final int x, final int y) {
        this(buttonId, x, y, false);
    }
    
    public GuiCheckBox(final int buttonId, final int x, final int y, final boolean checked) {
        this(buttonId, x, y, 22, 20, checked);
    }
    
    public GuiCheckBox(final int buttonId, final int x, final int y, final int width, final int height) {
        this(buttonId, x, y, width, height, false);
    }
    
    public GuiCheckBox(final int buttonId, final int x, final int y, final int width, final int height, final boolean checked) {
        super(buttonId, x, y, width, height, "");
        this.checked = checked;
    }
    
    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            final FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(GuiCheckBox.buttonTextures);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            this.hovered = (mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height);
            final int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.blendFunc(770, 771);
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 46 + i * 20, this.width / 2, this.height);
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
            this.mouseDragged(mc, mouseX, mouseY);
            this.displayString = "OFF";
            int color = GuiCheckBox.X_COLOR.getRGB();
            if (this.checked) {
                this.displayString = "ON";
                color = GuiCheckBox.CHECK_COLOR.getRGB();
            }
            this.drawCenteredString(fontrenderer, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, color);
        }
    }
    
    @Override
    public boolean mousePressed(final Minecraft mc, final int mouseX, final int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
            this.checked = !this.checked;
            return true;
        }
        System.out.println();
        return false;
    }
    
    public boolean isChecked() {
        return this.checked;
    }
    
    public void setChecked(final boolean checked) {
        this.checked = checked;
    }
}
