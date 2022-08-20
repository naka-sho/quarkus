package org.my.hobby;

import org.my.hobby.service.ImageConvertService;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

@Path("image")
public class ImageController {

    @Inject
    ImageConvertService imageConvertService;

    @GET
    @Path("convert")
    public String convert(@QueryParam("url") String url, @QueryParam("savePath") String savePath){
        try {
            BufferedImage bufferedImage = ImageIO.read(new URL(url));
            String convert = imageConvertService.convert(bufferedImage, savePath);
            return convert;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
