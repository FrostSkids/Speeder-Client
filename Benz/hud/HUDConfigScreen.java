// 
// Decompiled by Procyon v0.5.36
// 

package Benz.hud;

import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.Gui;
import java.util.Iterator;
import java.util.Collection;
import java.io.IOException;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import java.util.Optional;
import java.util.HashMap;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen
{
    int i;
    private int smX;
    private int smY;
    private boolean dragged;
    protected boolean hovered;
    private final HashMap<IRender, ScreenPosition> renderers;
    private Optional<IRender> selectedRenderer;
    private int prevX;
    private int prevY;
    
    @Override
    public void initGui() {
        Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
        super.initGui();
    }
    
    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        super.actionPerformed(button);
    }
    
    public HUDConfigScreen(final HUDManager api) {
        this.i = 0;
        this.dragged = false;
        this.renderers = new HashMap<IRender, ScreenPosition>();
        this.selectedRenderer = Optional.empty();
        final Collection<IRender> registeredRenderers = api.getRegisteredRenderers();
        for (final IRender ren : registeredRenderers) {
            if (!ren.isEnabled()) {
                continue;
            }
            ScreenPosition pos = ren.load();
            if (pos == null) {
                pos = ScreenPosition.fromRelativePosition(30.0, 25.0);
            }
            this.adjustBounds(ren, pos);
            this.renderers.put(ren, pos);
        }
    }
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        final float zBackup = this.zLevel;
        this.zLevel = 200.0f;
        this.drawHorizontalLine(mouseY, mouseX, mouseY, mouseY);
        for (final IRender renderer : this.renderers.keySet()) {
            final ScreenPosition pos = this.renderers.get(renderer);
            Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + renderer.getWidth(), pos.getAbsoluteY() + renderer.getHeight(), 872415231);
            this.drawHollowRect(pos.getAbsoluteX(), pos.getAbsoluteY(), renderer.getWidth(), renderer.getHeight(), 0);
            renderer.renderDummy(pos);
            final int absoluteX = pos.getAbsoluteX();
            final int absoluteY = pos.getAbsoluteY();
            this.hovered = (mouseX >= absoluteX && mouseX <= absoluteX + renderer.getWidth() && mouseY >= absoluteY && mouseY <= absoluteY + renderer.getHeight());
            if (this.hovered && this.dragged) {
                pos.setAbsolute(pos.getAbsoluteX() + mouseX - this.prevX, pos.getAbsoluteY() + mouseY - this.prevY);
                this.adjustBounds(renderer, pos);
                this.prevX = mouseX;
                this.prevY = mouseY;
            }
        }
        this.smX = mouseX;
        this.smY = mouseY;
        this.zLevel = zBackup;
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    private void drawHollowRect(final int x, final int y, final int w, final int h, final int color) {
        this.drawHorizontalLine(x, x + w, y, 4093);
        this.drawHorizontalLine(x, x + w, y + h, 4093);
        this.drawVerticalLine(x, y + h, y, 4093);
        this.drawVerticalLine(x + w, y + h, y, 4093);
    }
    
    @Override
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
        if (keyCode == 1) {
            this.renderers.entrySet().forEach(entry -> entry.getKey().save((ScreenPosition)entry.getValue()));
            this.mc.displayGuiScreen(null);
        }
    }
    
    @Override
    protected void mouseClickMove(final int x, final int y, final int button, final long time) {
        if (this.selectedRenderer.isPresent()) {
            this.moveSelectedRenderBy(x - this.prevX, y - this.prevY);
        }
        this.prevX = x;
        this.prevY = y;
    }
    
    private void moveSelectedRenderBy(final int offsetX, final int offsetY) {
        final IRender renderer = this.selectedRenderer.get();
        final ScreenPosition pos = this.renderers.get(renderer);
        pos.setAbsolute(pos.getAbsoluteX() + offsetX, pos.getAbsoluteY() + offsetY);
        if (pos.getAbsoluteX() == 0) {
            pos.setAbsolute(1, pos.getAbsoluteY());
        }
        if (pos.getAbsoluteY() == 0) {
            pos.setAbsolute(pos.getAbsoluteX(), 1);
        }
        this.adjustBounds(renderer, pos);
    }
    
    @Override
    public void onGuiClosed() {
        Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
        super.onGuiClosed();
        for (final IRender renderer : this.renderers.keySet()) {
            renderer.save(this.renderers.get(renderer));
        }
    }
    
    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }
    
    private void adjustBounds(final IRender renderer, final ScreenPosition pos) {
        final ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
        final int screenWidth = res.getScaledWidth();
        final int screenHeight = res.getScaledHeight();
        final int absoluteX = Math.max(0, Math.min(pos.getAbsoluteX(), Math.max(screenWidth - renderer.getWidth(), 0)));
        final int absoluteY = Math.max(0, Math.min(pos.getAbsoluteY(), Math.max(screenHeight - renderer.getHeight(), 0)));
        pos.setAbsolute(absoluteX, absoluteY);
    }
    
    @Override
    protected void mouseClicked(final int x, final int y, final int button) throws IOException {
        this.prevX = x;
        this.prevY = y;
        this.dragged = true;
        this.loadMouseOver(x, y);
        super.mouseClicked(x, y, button);
    }
    
    @Override
    protected void mouseReleased(final int mouseX, final int mouseY, final int state) {
        this.dragged = false;
        super.mouseReleased(mouseX, mouseY, state);
    }
    
    private void loadMouseOver(final int x, final int y) {
        this.selectedRenderer = this.renderers.keySet().stream().filter(new MouseOverFinder(x, y)).findFirst();
    }
    
    private class MouseOverFinder implements Predicate<IRender>
    {
        private int mouseX;
        private int mouseY;
        
        public MouseOverFinder(final int x, final int y) {
            this.mouseX = x;
            this.mouseY = y;
        }
        
        @Override
        public boolean test(final IRender renderer) {
            final ScreenPosition pos = HUDConfigScreen.this.renderers.get(renderer);
            final int absoluteX = pos.getAbsoluteX();
            final int absoluteY = pos.getAbsoluteY();
            return this.mouseX >= absoluteX && this.mouseX <= absoluteX + renderer.getWidth() && this.mouseY >= absoluteY && this.mouseY <= absoluteY + renderer.getHeight();
        }
    }
}
