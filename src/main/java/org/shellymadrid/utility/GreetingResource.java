package org.shellymadrid.utility;

import org.shellymadrid.utility.service.GreetingServiceInterface;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/greeting")
public class GreetingResource {

    @Inject
    GreetingServiceInterface greetingService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String greet() {
        return greetingService.greet("World");
    }
}
