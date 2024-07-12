package org.shellymadrid.utility.service;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/")
@RegisterRestClient(configKey = "network-device-client")
public interface NetworkDeviceClient {

@GET
@Path("/status")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceStatusG1();

@GET
@Path("/rpc/Shelly.GetStatus")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceStatusG2();

@GET
@Path("/rpc/Shelly.GetStatus")
@Produces(MediaType.APPLICATION_JSON)
Response getDeviceStatusG3();

}
