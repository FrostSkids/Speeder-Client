// 
// Decompiled by Procyon v0.5.36
// 

package Benz.hud;

public interface IRenderer extends IrenderConfig
{
    int getHeight();
    
    int getWidth();
    
    void render(final ScreenPosition p0);
    
    default void renderDummy(final ScreenPosition pos) {
        this.render(pos);
    }
    
    default int borderColor() {
        return 1;
    }
    
    default int borderBackgroundColor() {
        return 1;
    }
    
    default boolean renderBorder() {
        return true;
    }
    
    default boolean IsEnabled() {
        return true;
    }
    
    default boolean IsDisabled() {
        return true;
    }
}
