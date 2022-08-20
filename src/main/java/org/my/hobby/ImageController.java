package org.my.hobby;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("image")
public class ImageController {

    @GET
    @Path("convert")
    public String convert(@QueryParam("url") String url){
        return url;
    }
}
