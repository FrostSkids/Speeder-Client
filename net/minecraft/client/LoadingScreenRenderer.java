// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client;

import net.optifine.CustomLoadingScreen;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.gui.Gui;
import net.optifine.CustomLoadingScreens;
import net.minecraft.client.renderer.Tessellator;
import net.optifine.reflect.Reflector;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MinecraftError;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.IProgressUpdate;

public class LoadingScreenRenderer implements IProgressUpdate
{
    private String message;
    private Minecraft mc;
    private String currentlyDisplayedText;
    private long systemTime;
    private boolean field_73724_e;
    private ScaledResolution scaledResolution;
    private Framebuffer framebuffer;
    
    public LoadingScreenRenderer(final Minecraft mcIn) {
        this.message = "";
        this.currentlyDisplayedText = "";
        this.systemTime = Minecraft.getSystemTime();
        this.mc = mcIn;
        this.scaledResolution = new ScaledResolution(mcIn);
        (this.framebuffer = new Framebuffer(mcIn.displayWidth, mcIn.displayHeight, false)).setFramebufferFilter(9728);
    }
    
    @Override
    public void resetProgressAndMessage(final String message) {
        this.field_73724_e = false;
        this.displayString(message);
    }
    
    @Override
    public void displaySavingString(final String message) {
        this.field_73724_e = true;
        this.displayString(message);
    }
    
    private void displayString(final String message) {
        this.currentlyDisplayedText = message;
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            GlStateManager.clear(256);
            GlStateManager.matrixMode(5889);
            GlStateManager.loadIdentity();
            if (OpenGlHelper.isFramebufferEnabled()) {
                final int i = this.scaledResolution.getScaleFactor();
                GlStateManager.ortho(0.0, this.scaledResolution.getScaledWidth() * i, this.scaledResolution.getScaledHeight() * i, 0.0, 100.0, 300.0);
            }
            else {
                final ScaledResolution scaledresolution = new ScaledResolution(this.mc);
                GlStateManager.ortho(0.0, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0, 100.0, 300.0);
            }
            GlStateManager.matrixMode(5888);
            GlStateManager.loadIdentity();
            GlStateManager.translate(0.0f, 0.0f, -200.0f);
        }
    }
    
    @Override
    public void displayLoadingString(final String message) {
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            this.systemTime = 0L;
            this.message = message;
            this.setLoadingProgress(-1);
            this.systemTime = 0L;
        }
    }
    
    @Override
    public void setLoadingProgress(final int progress) {
        if (!this.mc.running) {
            if (!this.field_73724_e) {
                throw new MinecraftError();
            }
        }
        else {
            final long i = Minecraft.getSystemTime();
            if (i - this.systemTime >= 100L) {
                this.systemTime = i;
                final ScaledResolution scaledresolution = new ScaledResolution(this.mc);
                final int j = scaledresolution.getScaleFactor();
                final int k = scaledresolution.getScaledWidth();
                final int l = scaledresolution.getScaledHeight();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferClear();
                }
                else {
                    GlStateManager.clear(256);
                }
                this.framebuffer.bindFramebuffer(false);
                GlStateManager.matrixMode(5889);
                GlStateManager.loadIdentity();
                GlStateManager.ortho(0.0, scaledresolution.getScaledWidth_double(), scaledresolution.getScaledHeight_double(), 0.0, 100.0, 300.0);
                GlStateManager.matrixMode(5888);
                GlStateManager.loadIdentity();
                GlStateManager.translate(0.0f, 0.0f, -200.0f);
                if (!OpenGlHelper.isFramebufferEnabled()) {
                    GlStateManager.clear(16640);
                }
                boolean flag = true;
                if (Reflector.FMLClientHandler_handleLoadingScreen.exists()) {
                    final Object object = Reflector.call(Reflector.FMLClientHandler_instance, new Object[0]);
                    if (object != null) {
                        flag = !Reflector.callBoolean(object, Reflector.FMLClientHandler_handleLoadingScreen, scaledresolution);
                    }
                }
                if (flag) {
                    final Tessellator tessellator = Tessellator.getInstance();
                    final WorldRenderer worldrenderer = tessellator.getWorldRenderer();
                    final CustomLoadingScreen customloadingscreen = CustomLoadingScreens.getCustomLoadingScreen();
                    if (customloadingscreen != null) {
                        customloadingscreen.drawBackground(scaledresolution.getScaledWidth(), scaledresolution.getScaledHeight());
                    }
                    else {
                        this.mc.getTextureManager().bindTexture(Gui.optionsBackground);
                        final float f = 32.0f;
                        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
                        worldrenderer.func_181662_b(0.0, l, 0.0).func_181673_a(0.0, l / f).func_181669_b(64, 64, 64, 255).func_181675_d();
                        worldrenderer.func_181662_b(k, l, 0.0).func_181673_a(k / f, l / f).func_181669_b(64, 64, 64, 255).func_181675_d();
                        worldrenderer.func_181662_b(k, 0.0, 0.0).func_181673_a(k / f, 0.0).func_181669_b(64, 64, 64, 255).func_181675_d();
                        worldrenderer.func_181662_b(0.0, 0.0, 0.0).func_181673_a(0.0, 0.0).func_181669_b(64, 64, 64, 255).func_181675_d();
                        tessellator.draw();
                    }
                    if (progress >= 0) {
                        final int l2 = 100;
                        final int i2 = 2;
                        final int j2 = k / 2 - l2 / 2;
                        final int k2 = l / 2 + 16;
                        GlStateManager.disableTexture2D();
                        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181706_f);
                        worldrenderer.func_181662_b(j2, k2, 0.0).func_181669_b(128, 128, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2, k2 + i2, 0.0).func_181669_b(128, 128, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2 + l2, k2 + i2, 0.0).func_181669_b(128, 128, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2 + l2, k2, 0.0).func_181669_b(128, 128, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2, k2, 0.0).func_181669_b(128, 255, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2, k2 + i2, 0.0).func_181669_b(128, 255, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2 + progress, k2 + i2, 0.0).func_181669_b(128, 255, 128, 255).func_181675_d();
                        worldrenderer.func_181662_b(j2 + progress, k2, 0.0).func_181669_b(128, 255, 128, 255).func_181675_d();
                        tessellator.draw();
                        GlStateManager.enableTexture2D();
                    }
                    GlStateManager.enableBlend();
                    GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                    this.mc.fontRendererObj.drawStringWithShadow(this.currentlyDisplayedText, (float)((k - this.mc.fontRendererObj.getStringWidth(this.currentlyDisplayedText)) / 2), (float)(l / 2 - 4 - 16), 16777215);
                    this.mc.fontRendererObj.drawStringWithShadow(this.message, (float)((k - this.mc.fontRendererObj.getStringWidth(this.message)) / 2), (float)(l / 2 - 4 + 8), 16777215);
                }
                this.framebuffer.unbindFramebuffer();
                if (OpenGlHelper.isFramebufferEnabled()) {
                    this.framebuffer.framebufferRender(k * j, l * j);
                }
                this.mc.updateDisplay();
                try {
                    Thread.yield();
                }
                catch (Exception ex) {}
            }
        }
    }
    
    @Override
    public void setDoneWorking() {
    }
}