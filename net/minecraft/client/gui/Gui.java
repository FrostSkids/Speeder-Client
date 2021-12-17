// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.gui;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;

public class Gui
{
    public static final ResourceLocation optionsBackground;
    public static final ResourceLocation statIcons;
    public static final ResourceLocation icons;
    protected float zLevel;
    
    static {
        optionsBackground = new ResourceLocation("textures/gui/options_background.png");
        statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");
        icons = new ResourceLocation("textures/gui/icons.png");
    }
    
    public void drawHorizontalLine(int startX, int endX, final int y, final int color) {
        if (endX < startX) {
            final int i = startX;
            startX = endX;
            endX = i;
        }
        drawRect(startX, y, endX + 1, y + 1, color);
    }
    
    public void drawVerticalLine(final int x, int startY, int endY, final int color) {
        if (endY < startY) {
            final int i = startY;
            startY = endY;
            endY = i;
        }
        drawRect(x, startY + 1, x + 1, endY, color);
    }
    
    public static void drawRect(int left, int top, int right, int bottom, final int color) {
        if (left < right) {
            final int i = left;
            left = right;
            right = i;
        }
        if (top < bottom) {
            final int j = top;
            top = bottom;
            bottom = j;
        }
        final float f3 = (color >> 24 & 0xFF) / 255.0f;
        final float f4 = (color >> 16 & 0xFF) / 255.0f;
        final float f5 = (color >> 8 & 0xFF) / 255.0f;
        final float f6 = (color & 0xFF) / 255.0f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.color(f4, f5, f6, f3);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        worldrenderer.func_181662_b(left, bottom, 0.0).func_181675_d();
        worldrenderer.func_181662_b(right, bottom, 0.0).func_181675_d();
        worldrenderer.func_181662_b(right, top, 0.0).func_181675_d();
        worldrenderer.func_181662_b(left, top, 0.0).func_181675_d();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }
    
    protected void drawGradientRect(final int left, final int top, final int right, final int bottom, final int startColor, final int endColor) {
        final float f = (startColor >> 24 & 0xFF) / 255.0f;
        final float f2 = (startColor >> 16 & 0xFF) / 255.0f;
        final float f3 = (startColor >> 8 & 0xFF) / 255.0f;
        final float f4 = (startColor & 0xFF) / 255.0f;
        final float f5 = (endColor >> 24 & 0xFF) / 255.0f;
        final float f6 = (endColor >> 16 & 0xFF) / 255.0f;
        final float f7 = (endColor >> 8 & 0xFF) / 255.0f;
        final float f8 = (endColor & 0xFF) / 255.0f;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(7425);
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181706_f);
        worldrenderer.func_181662_b(right, top, this.zLevel).func_181666_a(f2, f3, f4, f).func_181675_d();
        worldrenderer.func_181662_b(left, top, this.zLevel).func_181666_a(f2, f3, f4, f).func_181675_d();
        worldrenderer.func_181662_b(left, bottom, this.zLevel).func_181666_a(f6, f7, f8, f5).func_181675_d();
        worldrenderer.func_181662_b(right, bottom, this.zLevel).func_181666_a(f6, f7, f8, f5).func_181675_d();
        tessellator.draw();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }
    
    public void drawCenteredString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color) {
        fontRendererIn.drawStringWithShadow(text, (float)(x - fontRendererIn.getStringWidth(text) / 2), (float)y, color);
    }
    
    public void drawString(final FontRenderer fontRendererIn, final String text, final int x, final int y, final int color) {
        fontRendererIn.drawStringWithShadow(text, (float)x, (float)y, color);
    }
    
    public void drawTexturedModalRect(final int x, final int y, final int textureX, final int textureY, final int width, final int height) {
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(x + 0, y + height, this.zLevel).func_181673_a((textureX + 0) * f, (textureY + height) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y + height, this.zLevel).func_181673_a((textureX + width) * f, (textureY + height) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y + 0, this.zLevel).func_181673_a((textureX + width) * f, (textureY + 0) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + 0, y + 0, this.zLevel).func_181673_a((textureX + 0) * f, (textureY + 0) * f2).func_181675_d();
        tessellator.draw();
    }
    
    public void drawTexturedModalRect(final float xCoord, final float yCoord, final int minU, final int minV, final int maxU, final int maxV) {
        final float f = 0.00390625f;
        final float f2 = 0.00390625f;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(xCoord + 0.0f, yCoord + maxV, this.zLevel).func_181673_a((minU + 0) * f, (minV + maxV) * f2).func_181675_d();
        worldrenderer.func_181662_b(xCoord + maxU, yCoord + maxV, this.zLevel).func_181673_a((minU + maxU) * f, (minV + maxV) * f2).func_181675_d();
        worldrenderer.func_181662_b(xCoord + maxU, yCoord + 0.0f, this.zLevel).func_181673_a((minU + maxU) * f, (minV + 0) * f2).func_181675_d();
        worldrenderer.func_181662_b(xCoord + 0.0f, yCoord + 0.0f, this.zLevel).func_181673_a((minU + 0) * f, (minV + 0) * f2).func_181675_d();
        tessellator.draw();
    }
    
    public void drawTexturedModalRect(final int xCoord, final int yCoord, final TextureAtlasSprite textureSprite, final int widthIn, final int heightIn) {
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(xCoord + 0, yCoord + heightIn, this.zLevel).func_181673_a(textureSprite.getMinU(), textureSprite.getMaxV()).func_181675_d();
        worldrenderer.func_181662_b(xCoord + widthIn, yCoord + heightIn, this.zLevel).func_181673_a(textureSprite.getMaxU(), textureSprite.getMaxV()).func_181675_d();
        worldrenderer.func_181662_b(xCoord + widthIn, yCoord + 0, this.zLevel).func_181673_a(textureSprite.getMaxU(), textureSprite.getMinV()).func_181675_d();
        worldrenderer.func_181662_b(xCoord + 0, yCoord + 0, this.zLevel).func_181673_a(textureSprite.getMinU(), textureSprite.getMinV()).func_181675_d();
        tessellator.draw();
    }
    
    public static void drawModalRectWithCustomSizedTexture(final int x, final int y, final float u, final float v, final int width, final int height, final float textureWidth, final float textureHeight) {
        final float f = 1.0f / textureWidth;
        final float f2 = 1.0f / textureHeight;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(x, y + height, 0.0).func_181673_a(u * f, (v + height) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y + height, 0.0).func_181673_a((u + width) * f, (v + height) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y, 0.0).func_181673_a((u + width) * f, v * f2).func_181675_d();
        worldrenderer.func_181662_b(x, y, 0.0).func_181673_a(u * f, v * f2).func_181675_d();
        tessellator.draw();
    }
    
    public static void drawScaledCustomSizeModalRect(final int x, final int y, final float u, final float v, final int uWidth, final int vHeight, final int width, final int height, final float tileWidth, final float tileHeight) {
        final float f = 1.0f / tileWidth;
        final float f2 = 1.0f / tileHeight;
        final Tessellator tessellator = Tessellator.getInstance();
        final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(x, y + height, 0.0).func_181673_a(u * f, (v + vHeight) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y + height, 0.0).func_181673_a((u + uWidth) * f, (v + vHeight) * f2).func_181675_d();
        worldrenderer.func_181662_b(x + width, y, 0.0).func_181673_a((u + uWidth) * f, v * f2).func_181675_d();
        worldrenderer.func_181662_b(x, y, 0.0).func_181673_a(u * f, v * f2).func_181675_d();
        tessellator.draw();
    }
}
