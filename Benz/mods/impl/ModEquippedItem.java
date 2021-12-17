// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModEquippedItem extends ModDraggable
{
    @Override
    public int getWidth() {
        return 40;
    }
    
    @Override
    public int getHeight() {
        return 17;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        this.renderItemStack(pos, 3, this.mc.thePlayer.getCurrentEquippedItem());
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        this.renderItemStack(pos, 3, new ItemStack(Items.diamond_axe));
    }
    
    private void renderItemStack(final ScreenPosition pos, final int i, final ItemStack is) {
        if (is == null) {
            return;
        }
        GL11.glPushMatrix();
        final int yAdd = -16 * i + 48;
        if (is.getItem().isDamageable()) {
            final double damage = (is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0;
            this.font.drawString(String.format("%.0f", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, 65280);
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
}
