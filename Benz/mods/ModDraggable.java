// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods;

import java.awt.Color;
import Benz.FileManager;
import java.io.File;
import Benz.hud.ScreenPosition;
import Benz.hud.IRender;

public abstract class ModDraggable extends Mod implements IRender
{
    protected ScreenPosition pos;
    
    public ModDraggable() {
        this.pos = this.loadPositionFromFile();
    }
    
    @Override
    public ScreenPosition load() {
        return this.pos;
    }
    
    @Override
    public void save(final ScreenPosition pos) {
        this.pos = pos;
        this.savePositionToFile();
    }
    
    private File getFolder() {
        final File folder = new File(FileManager.getModsDirectory(), this.getClass().getSimpleName());
        folder.mkdirs();
        return folder;
    }
    
    public int borderColor() {
        return new Color(199, 199, 0, 80).getRGB();
    }
    
    public int borderBackgroundColor() {
        return new Color(199, 199, 0, 160).getRGB();
    }
    
    public boolean renderBorder() {
        return false;
    }
    
    private void savePositionToFile() {
        FileManager.writeJsonToFile(new File(this.getFolder(), "pos.json"), this.pos);
    }
    
    private ScreenPosition loadPositionFromFile() {
        ScreenPosition loaded = FileManager.readFromJson(new File(this.getFolder(), "pos.json"), ScreenPosition.class);
        if (loaded == null) {
            loaded = ScreenPosition.fromRelativePosition(0.5, 0.5);
            this.pos = loaded;
            this.savePositionToFile();
        }
        return loaded;
    }
    
    public final int getLineOffset(final ScreenPosition pos, final int lineNum) {
        return pos.getAbsoluteY() + this.getLineOffset(lineNum);
    }
    
    private int getLineOffset(final int lineNum) {
        return (this.font.FONT_HEIGHT + 3) * lineNum;
    }
}
