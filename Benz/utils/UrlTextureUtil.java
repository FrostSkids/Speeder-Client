// 
// Decompiled by Procyon v0.5.36
// 

package Benz.utils;

import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.ITextureObject;
import java.io.File;
import java.awt.image.BufferedImage;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FilenameUtils;

public class UrlTextureUtil
{
    public static void downloadAndSetTexture(final String url, final ResourceLocationCallback callback) {
        if (url != null && !url.isEmpty()) {
            final String baseName = FilenameUtils.getBaseName(url);
            final ResourceLocation resourcelocation = new ResourceLocation("clientname_temp/" + baseName);
            final TextureManager texturemanager = Minecraft.getMinecraft().getTextureManager();
            final ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
            if (itextureobject != null && itextureobject instanceof ThreadDownloadImageData) {
                final ThreadDownloadImageData threaddownloadimagedata = (ThreadDownloadImageData)itextureobject;
                if (threaddownloadimagedata.imageFound != null) {
                    if (threaddownloadimagedata.imageFound) {
                        callback.onTextureLoaded(resourcelocation);
                    }
                    return;
                }
            }
            final IImageBuffer iimagebuffer = new IImageBuffer() {
                ImageBufferDownload ibd = new ImageBufferDownload();
                
                @Override
                public BufferedImage parseUserSkin(final BufferedImage image) {
                    return image;
                }
                
                @Override
                public void skinAvailable() {
                    callback.onTextureLoaded(resourcelocation);
                }
            };
            final ThreadDownloadImageData threaddownloadimagedata2 = new ThreadDownloadImageData(null, url, null, iimagebuffer);
            threaddownloadimagedata2.pipeline = true;
            texturemanager.loadTexture(resourcelocation, threaddownloadimagedata2);
        }
    }
    
    public interface ResourceLocationCallback
    {
        void onTextureLoaded(final ResourceLocation p0);
    }
}
