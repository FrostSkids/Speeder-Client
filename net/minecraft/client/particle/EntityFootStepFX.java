// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.BlockPos;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.world.World;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class EntityFootStepFX extends EntityFX
{
    private static final ResourceLocation FOOTPRINT_TEXTURE;
    private int footstepAge;
    private int footstepMaxAge;
    private TextureManager currentFootSteps;
    
    static {
        FOOTPRINT_TEXTURE = new ResourceLocation("textures/particle/footprint.png");
    }
    
    protected EntityFootStepFX(final TextureManager currentFootStepsIn, final World worldIn, final double xCoordIn, final double yCoordIn, final double zCoordIn) {
        super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0.0, 0.0, 0.0);
        this.currentFootSteps = currentFootStepsIn;
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        this.footstepMaxAge = 200;
    }
    
    @Override
    public void renderParticle(final WorldRenderer worldRendererIn, final Entity entityIn, final float partialTicks, final float p_180434_4_, final float p_180434_5_, final float p_180434_6_, final float p_180434_7_, final float p_180434_8_) {
        float f = (this.footstepAge + partialTicks) / this.footstepMaxAge;
        f *= f;
        float f2 = 2.0f - f * 2.0f;
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        f2 *= 0.2f;
        GlStateManager.disableLighting();
        final float f3 = 0.125f;
        final float f4 = (float)(this.posX - EntityFootStepFX.interpPosX);
        final float f5 = (float)(this.posY - EntityFootStepFX.interpPosY);
        final float f6 = (float)(this.posZ - EntityFootStepFX.interpPosZ);
        final float f7 = this.worldObj.getLightBrightness(new BlockPos(this));
        this.currentFootSteps.bindTexture(EntityFootStepFX.FOOTPRINT_TEXTURE);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(770, 771);
        worldRendererIn.func_181668_a(7, DefaultVertexFormats.field_181709_i);
        worldRendererIn.func_181662_b(f4 - 0.125f, f5, f6 + 0.125f).func_181673_a(0.0, 1.0).func_181666_a(f7, f7, f7, f2).func_181675_d();
        worldRendererIn.func_181662_b(f4 + 0.125f, f5, f6 + 0.125f).func_181673_a(1.0, 1.0).func_181666_a(f7, f7, f7, f2).func_181675_d();
        worldRendererIn.func_181662_b(f4 + 0.125f, f5, f6 - 0.125f).func_181673_a(1.0, 0.0).func_181666_a(f7, f7, f7, f2).func_181675_d();
        worldRendererIn.func_181662_b(f4 - 0.125f, f5, f6 - 0.125f).func_181673_a(0.0, 0.0).func_181666_a(f7, f7, f7, f2).func_181675_d();
        Tessellator.getInstance().draw();
        GlStateManager.disableBlend();
        GlStateManager.enableLighting();
    }
    
    @Override
    public void onUpdate() {
        ++this.footstepAge;
        if (this.footstepAge == this.footstepMaxAge) {
            this.setDead();
        }
    }
    
    @Override
    public int getFXLayer() {
        return 3;
    }
    
    public static class Factory implements IParticleFactory
    {
        @Override
        public EntityFX getEntityFX(final int particleID, final World worldIn, final double xCoordIn, final double yCoordIn, final double zCoordIn, final double xSpeedIn, final double ySpeedIn, final double zSpeedIn, final int... p_178902_15_) {
            return new EntityFootStepFX(Minecraft.getMinecraft().getTextureManager(), worldIn, xCoordIn, yCoordIn, zCoordIn);
        }
    }
}
