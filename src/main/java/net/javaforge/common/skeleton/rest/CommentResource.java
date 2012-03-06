package net.javaforge.common.skeleton.rest;

import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Maxim Kalina (Maxim.Kalina@extern.isban.de)
 * @version $Id$
 */
@Path("/comment")
public class CommentResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getComments() {

        Random random = new Random();
        List<Comment> pins = new ArrayList<Comment>();
        for (int i = 0; i < random.nextInt(20); i++) {
            pins.add(new Comment());
        }
        return new Gson().toJson(pins);
    }


    private static final class Comment {

        String content;

        Date datetime;

        private Comment() {
            this.content = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam " +
                    "nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. " +
                    "At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea " +
                    "takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, " +
                    "consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et " +
                    "dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores " +
                    "et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.";
            this.datetime = new Date();
        }
    }


}
