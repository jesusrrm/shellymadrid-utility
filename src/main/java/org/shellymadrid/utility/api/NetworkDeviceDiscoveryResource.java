package org.shellymadrid.utility.api;


import org.shellymadrid.utility.model.NetworkDevice;
import org.shellymadrid.utility.service.NetworkDeviceDiscoveryService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Set;

@Path("/discover")
public class NetworkDeviceDiscoveryResource {

    @Inject
    NetworkDeviceDiscoveryService discoveryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<NetworkDevice> discoverDevices(@QueryParam("baseIp") String baseIp) {
        return discoveryService.discoverNetworkDevices(baseIp);
    }
}