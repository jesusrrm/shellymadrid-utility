package com.shellymadrid.utility.api;

import com.shellymadrid.utility.model.NetworkDevice;
import com.shellymadrid.utility.service.NetworkDeviceDiscoveryService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import java.util.Set;

@Path("/devices")
public class DeviceResource {

    @Inject
    NetworkDeviceDiscoveryService discoveryService;

    @GET
    @Path("/discover")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<NetworkDevice> discoverDevices(@QueryParam("baseIp") String baseIp) {
        return discoveryService.discoverNetworkDevices(baseIp);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/discovered")
    public Set<NetworkDevice> getDiscoveredDevices() {
        return discoveryService.getDiscoveredNetworkDevices();
    }
}