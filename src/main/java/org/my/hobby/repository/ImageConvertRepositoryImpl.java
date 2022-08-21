package org.my.hobby.repository;

import com.luciad.imageio.webp.WebPWriteParam;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Singleton;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Singleton
public class ImageConvertRepositoryImpl implements ImageConvertRepository {
    @Override
    public String convert(BufferedImage image, String pathname) {
        // Obtain a WebP ImageWriter instance
        ImageWriter writer = ImageIO.getImageWritersByMIMEType("image/webp").next();

        // Configure encoding parameters
        WebPWriteParam writeParam = new WebPWriteParam(writer.getLocale());
        writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        writeParam.setCompressionType(writeParam.getCompressionTypes()[WebPWriteParam.LOSSLESS_COMPRESSION]);

        // Configure the output on the ImageWriter
        try {
            writer.setOutput(new FileImageOutputStream(new File(pathname)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Encode
        try {
            writer.write(null, new IIOImage(image, null, null), writeParam);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return image.toString();
    }
}
