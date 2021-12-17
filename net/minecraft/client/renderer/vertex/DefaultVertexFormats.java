// 
// Decompiled by Procyon v0.5.36
// 

package net.minecraft.client.renderer.vertex;

import java.lang.reflect.Field;
import net.minecraft.src.Config;
import net.optifine.shaders.SVertexFormat;
import net.optifine.reflect.ReflectorField;
import net.optifine.reflect.ReflectorClass;

public class DefaultVertexFormats
{
    public static VertexFormat BLOCK;
    public static VertexFormat ITEM;
    private static final VertexFormat BLOCK_VANILLA;
    private static final VertexFormat ITEM_VANILLA;
    public static ReflectorClass Attributes;
    public static ReflectorField Attributes_DEFAULT_BAKED_FORMAT;
    private static final VertexFormat FORGE_BAKED;
    public static final VertexFormat field_181703_c;
    public static final VertexFormat field_181704_d;
    public static final VertexFormat field_181705_e;
    public static final VertexFormat field_181706_f;
    public static final VertexFormat field_181707_g;
    public static final VertexFormat field_181708_h;
    public static final VertexFormat field_181709_i;
    public static final VertexFormat field_181710_j;
    public static final VertexFormat field_181711_k;
    public static final VertexFormat field_181712_l;
    public static final VertexFormatElement field_181713_m;
    public static final VertexFormatElement field_181714_n;
    public static final VertexFormatElement field_181715_o;
    public static final VertexFormatElement field_181716_p;
    public static final VertexFormatElement field_181717_q;
    public static final VertexFormatElement field_181718_r;
    public static final String POSITION_COLOR;
    
    static {
        DefaultVertexFormats.BLOCK = new VertexFormat();
        DefaultVertexFormats.ITEM = new VertexFormat();
        BLOCK_VANILLA = DefaultVertexFormats.BLOCK;
        ITEM_VANILLA = DefaultVertexFormats.ITEM;
        DefaultVertexFormats.Attributes = new ReflectorClass("net.minecraftforge.client.model.Attributes");
        DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT = new ReflectorField(DefaultVertexFormats.Attributes, "DEFAULT_BAKED_FORMAT");
        FORGE_BAKED = SVertexFormat.duplicate((VertexFormat)getFieldValue(DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT));
        field_181703_c = new VertexFormat();
        field_181704_d = new VertexFormat();
        field_181705_e = new VertexFormat();
        field_181706_f = new VertexFormat();
        field_181707_g = new VertexFormat();
        field_181708_h = new VertexFormat();
        field_181709_i = new VertexFormat();
        field_181710_j = new VertexFormat();
        field_181711_k = new VertexFormat();
        field_181712_l = new VertexFormat();
        field_181713_m = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.POSITION, 3);
        field_181714_n = new VertexFormatElement(0, VertexFormatElement.EnumType.UBYTE, VertexFormatElement.EnumUsage.COLOR, 4);
        field_181715_o = new VertexFormatElement(0, VertexFormatElement.EnumType.FLOAT, VertexFormatElement.EnumUsage.UV, 2);
        field_181716_p = new VertexFormatElement(1, VertexFormatElement.EnumType.SHORT, VertexFormatElement.EnumUsage.UV, 2);
        field_181717_q = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.NORMAL, 3);
        field_181718_r = new VertexFormatElement(0, VertexFormatElement.EnumType.BYTE, VertexFormatElement.EnumUsage.PADDING, 1);
        POSITION_COLOR = null;
        DefaultVertexFormats.BLOCK.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.BLOCK.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.BLOCK.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.BLOCK.func_181721_a(DefaultVertexFormats.field_181716_p);
        DefaultVertexFormats.ITEM.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.ITEM.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.ITEM.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.ITEM.func_181721_a(DefaultVertexFormats.field_181717_q);
        DefaultVertexFormats.ITEM.func_181721_a(DefaultVertexFormats.field_181718_r);
        DefaultVertexFormats.field_181703_c.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181703_c.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181703_c.func_181721_a(DefaultVertexFormats.field_181717_q);
        DefaultVertexFormats.field_181703_c.func_181721_a(DefaultVertexFormats.field_181718_r);
        DefaultVertexFormats.field_181704_d.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181704_d.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181704_d.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.field_181704_d.func_181721_a(DefaultVertexFormats.field_181716_p);
        DefaultVertexFormats.field_181705_e.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181706_f.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181706_f.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.field_181707_g.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181707_g.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181708_h.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181708_h.func_181721_a(DefaultVertexFormats.field_181717_q);
        DefaultVertexFormats.field_181708_h.func_181721_a(DefaultVertexFormats.field_181718_r);
        DefaultVertexFormats.field_181709_i.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181709_i.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181709_i.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.field_181710_j.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181710_j.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181710_j.func_181721_a(DefaultVertexFormats.field_181717_q);
        DefaultVertexFormats.field_181710_j.func_181721_a(DefaultVertexFormats.field_181718_r);
        DefaultVertexFormats.field_181711_k.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181711_k.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181711_k.func_181721_a(DefaultVertexFormats.field_181716_p);
        DefaultVertexFormats.field_181711_k.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.field_181712_l.func_181721_a(DefaultVertexFormats.field_181713_m);
        DefaultVertexFormats.field_181712_l.func_181721_a(DefaultVertexFormats.field_181715_o);
        DefaultVertexFormats.field_181712_l.func_181721_a(DefaultVertexFormats.field_181714_n);
        DefaultVertexFormats.field_181712_l.func_181721_a(DefaultVertexFormats.field_181717_q);
        DefaultVertexFormats.field_181712_l.func_181721_a(DefaultVertexFormats.field_181718_r);
    }
    
    public static void updateVertexFormats() {
        if (Config.isShaders()) {
            DefaultVertexFormats.BLOCK = SVertexFormat.makeDefVertexFormatBlock();
            DefaultVertexFormats.ITEM = SVertexFormat.makeDefVertexFormatItem();
            if (DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT.exists()) {
                SVertexFormat.setDefBakedFormat((VertexFormat)DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT.getValue());
            }
        }
        else {
            DefaultVertexFormats.BLOCK = DefaultVertexFormats.BLOCK_VANILLA;
            DefaultVertexFormats.ITEM = DefaultVertexFormats.ITEM_VANILLA;
            if (DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT.exists()) {
                SVertexFormat.copy(DefaultVertexFormats.FORGE_BAKED, (VertexFormat)DefaultVertexFormats.Attributes_DEFAULT_BAKED_FORMAT.getValue());
            }
        }
    }
    
    public static Object getFieldValue(final ReflectorField p_getFieldValue_0_) {
        try {
            final Field field = p_getFieldValue_0_.getTargetField();
            if (field == null) {
                return null;
            }
            final Object object = field.get(null);
            return object;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}
