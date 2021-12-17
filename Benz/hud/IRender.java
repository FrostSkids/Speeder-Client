// 
// Decompiled by Procyon v0.5.36
// 

package Benz.hud;

public interface IRender extends IrenderConfig
{
    int getWidth();
    
    int getHeight();
    
    void render(final ScreenPosition p0);
    
    default void renderDummy(final ScreenPosition pos) {
        this.render(pos);
    }
    
    default boolean isEnabled() {
        return true;
    }
}
