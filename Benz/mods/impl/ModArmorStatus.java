// 
// Decompiled by Procyon v0.5.36
// 

package Benz.mods.impl;

import java.awt.Color;
import net.minecraft.client.renderer.RenderHelper;
import org.lwjgl.opengl.GL11;
import net.minecraft.item.Item;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.client.gui.Gui;
import Benz.hud.ScreenPosition;
import Benz.mods.ModDraggable;

public class ModArmorStatus extends ModDraggable
{
    @Override
    public int getWidth() {
        return 50;
    }
    
    @Override
    public int getHeight() {
        return 64;
    }
    
    @Override
    public void render(final ScreenPosition pos) {
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        for (int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
            final ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
            this.renderItemStack(pos, i, itemStack);
        }
    }
    
    @Override
    public void renderDummy(final ScreenPosition pos) {
        Gui.drawRect(pos.getAbsoluteX(), pos.getAbsoluteY(), pos.getAbsoluteX() + this.getWidth() + 1, pos.getAbsoluteY() + this.getHeight(), -1879048192);
        this.renderItemStack(pos, 3, new ItemStack(Items.diamond_helmet));
        this.renderItemStack(pos, 2, new ItemStack(Items.diamond_chestplate));
        this.renderItemStack(pos, 1, new ItemStack(Items.diamond_leggings));
        this.renderItemStack(pos, 0, new ItemStack(Items.diamond_boots));
    }
    
    private void renderItemStack(final ScreenPosition pos, final int i, final ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }
        GL11.glPushMatrix();
        final int yAdd = -16 * i + 50;
        if (itemStack.getItem().isDamageable()) {
            final double damage = (itemStack.getMaxDamage() - itemStack.getItemDamage()) / (double)itemStack.getMaxDamage() * 100.0;
            this.font.drawString(String.format("%.0f%%", damage), pos.getAbsoluteX() + 20, pos.getAbsoluteY() + yAdd + 5, DamageToColor(damage / 100.0));
        }
        RenderHelper.enableGUIStandardItemLighting();
        this.mc.getRenderItem().renderItemAndEffectIntoGUI(itemStack, pos.getAbsoluteX(), pos.getAbsoluteY() + yAdd);
        GL11.glPopMatrix();
    }
    
    static int DamageToColor(double percentage) {
        if (percentage > 1.0) {
            percentage = 1.0;
        }
        else if (percentage < 0.0) {
            percentage = 0.0;
        }
        final int red = (int)(255.0 * (1.0 - percentage));
        final int green = (int)(255.0 * percentage);
        final int blue = 0;
        return new Color(red, green, blue).getRGB();
    }
}
