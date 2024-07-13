package com.shellymadrid.utility.service.restClient;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/")
@RegisterRestClient(configKey = "network-device-client")
public interface ShellyDeviceInfoClient {

@GET
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceInfoG1();

@GET
@Path("/rpc/Shelly.GetDeviceInfo")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceInfoG2();

@GET
@Path("/rpc/Shelly.GetDeviceInfo")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceInfoG3();

}
