// 
// Decompiled by Procyon v0.5.36
// 

package Benz.gui;

import java.util.Iterator;
import java.util.Collections;
import Benz.mods.Mod;
import Benz.hud.IRender;
import Benz.hud.HUDManager;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import java.util.List;
import net.minecraft.client.gui.GuiListExtended;

public class ScrollListModToggle extends GuiListExtended
{
    private final List<ModEntry> entrys;
    
    public ScrollListModToggle(final Minecraft mcIn, final GuiModToggle inGui) {
        super(mcIn, inGui.width, inGui.height, 63, inGui.height - 32, 20);
        this.entrys = new ArrayList<ModEntry>();
        for (final IRender r : HUDManager.getInstance().getRegisteredRenderers()) {
            if (r instanceof Mod) {
                final Mod m = (Mod)r;
                this.entrys.add(new ModEntry(inGui, m));
            }
        }
        Collections.sort(this.entrys);
    }
    
    @Override
    public IGuiListEntry getListEntry(final int index) {
        return this.entrys.get(index);
    }
    
    @Override
    protected int getSize() {
        return this.entrys.size();
    }
}
