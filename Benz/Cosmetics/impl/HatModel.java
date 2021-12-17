// 
// Decompiled by Procyon v0.5.36
// 

package Benz.Cosmetics.impl;

import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class HatModel extends ModelBiped
{
    public static ModelRenderer model;
    
    public HatModel(final RenderPlayer renderPlayer) {
        (HatModel.model = new ModelRenderer(this).setTextureSize(64, 128)).setRotationPoint(-5.0f, -10.03125f, -5.0f);
        HatModel.model.setTextureOffset(0, 64).addBox(-5.0f, -10.0f, -5.0f, 10, 2, 10);
        final ModelRenderer modelrenderer = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer.setTextureOffset(0, 76).addBox(-5.0f, -9.0f, -5.0f, 7, 4, 7);
        modelrenderer.rotateAngleX = -0.05235988f;
        modelrenderer.rotateAngleZ = 0.02617994f;
        HatModel.model.addChild(modelrenderer);
        final ModelRenderer modelrenderer2 = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer2.setRotationPoint(1.75f, -4.0f, 2.0f);
        modelrenderer2.setTextureOffset(0, 87).addBox(-5.0f, -8.0f, -5.0f, 4, 4, 4);
        modelrenderer2.rotateAngleX = -0.10471976f;
        modelrenderer2.rotateAngleZ = 0.05235988f;
        modelrenderer.addChild(modelrenderer2);
        final ModelRenderer modelrenderer3 = new ModelRenderer(this).setTextureSize(64, 128);
        modelrenderer3.setRotationPoint(1.75f, -2.0f, 2.0f);
        modelrenderer3.setTextureOffset(0, 95).addBox(-6.0f, -7.0f, -5.0f, 1, 2, 1, 0.25f);
        modelrenderer3.rotateAngleX = -0.20943952f;
        modelrenderer3.rotateAngleZ = 0.10471976f;
        modelrenderer2.addChild(modelrenderer3);
    }
    
    public void render(final Entity entityIn, final ModelRenderer source, final float scale) {
        if (entityIn.isSneaking()) {
            GlStateManager.translate(0.0, 0.2, 0.0);
        }
        ModelBase.copyModelAngles(source, HatModel.model);
        GlStateManager.pushMatrix();
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Benz/christmas.png"));
        HatModel.model.render(scale);
        GlStateManager.popMatrix();
    }
}
