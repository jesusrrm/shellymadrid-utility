package com.shellymadrid.utility.service.restClient;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/")
@RegisterRestClient(configKey = "network-device-client")
public interface ShellyPlusPlugS_G2 {


    @POST
    @Path("/rpc/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response setSwitch(String jsonPayload);
}
