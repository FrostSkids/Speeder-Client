// 
// Decompiled by Procyon v0.5.36
// 

package Benz.hud;

import Benz.event.EventTarget;
import java.util.Iterator;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.inventory.GuiContainer;
import Benz.event.impl.RenderEvent;
import net.minecraft.client.gui.GuiScreen;
import java.util.HashSet;
import Benz.event.EventManager;
import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import java.util.Set;

public class HUDManager
{
    private static HUDManager instance;
    private static Set<IRender> registeredRenderers;
    private Minecraft mc;
    
    static {
        HUDManager.instance = null;
        HUDManager.registeredRenderers = (Set<IRender>)Sets.newHashSet();
    }
    
    private HUDManager() {
        this.mc = Minecraft.getMinecraft();
    }
    
    public static HUDManager getInstance() {
        if (HUDManager.instance != null) {
            return HUDManager.instance;
        }
        EventManager.register(HUDManager.instance = new HUDManager());
        return HUDManager.instance;
    }
    
    public void register(final IRender... renderers) {
        for (final IRender render : renderers) {
            HUDManager.registeredRenderers.add(render);
        }
    }
    
    public void unregister(final IRender... renderers) {
        for (final IRender render : renderers) {
            HUDManager.registeredRenderers.remove(render);
        }
    }
    
    public HashSet<IRender> getRegisteredRenderers() {
        return (HashSet<IRender>)Sets.newHashSet((Iterable)HUDManager.registeredRenderers);
    }
    
    public void openConfigScreen() {
        this.mc.displayGuiScreen(new HUDConfigScreen(this));
    }
    
    @EventTarget
    public void onRender(final RenderEvent event) {
        if (this.mc.currentScreen == null || this.mc.currentScreen instanceof GuiContainer || this.mc.currentScreen instanceof GuiChat) {
            for (final IRender render : HUDManager.registeredRenderers) {
                this.callRenderer(render);
            }
        }
    }
    
    private void callRenderer(final IRender renderer) {
        if (!renderer.isEnabled()) {
            return;
        }
        ScreenPosition pos = renderer.load();
        if (pos == null) {
            pos = ScreenPosition.fromRelativePosition(0.5, 0.5);
        }
        renderer.render(pos);
    }
}
