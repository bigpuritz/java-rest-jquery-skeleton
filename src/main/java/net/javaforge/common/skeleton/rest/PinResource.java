package net.javaforge.common.skeleton.rest;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Returns dummy list of pins.
 *
 * @author Maxim Kalina
 */
@Path("/pin")
public class PinResource {

    public static int counter = 0;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPins() {

        List<Pin> pins = new ArrayList<Pin>();
        for (int i = 0; i < 3; i++) {
            pins.add(new Pin("title" + counter, "desc" + counter, "tag1", "tag2", "tag3"));
            counter++;
        }
        return new Gson().toJson(pins);
    }


    private static final class Pin {

        String title;

        String description;

        String[] tags;

        private Pin(String title, String description, String... tags) {
            this.title = title;
            this.description = description;
            this.tags = tags;
        }
    }


}
