package com.shellymadrid.utility.api;

import com.shellymadrid.utility.service.Constants.ShellyDevice;
import com.shellymadrid.utility.service.devices.ChannelControlService;
import com.shellymadrid.utility.service.devices.DeviceService;
import com.shellymadrid.utility.service.factory.DeviceServiceFactory;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;

@Path("/device")
public class DeviceCtlApi {

    @Inject
    DeviceServiceFactory deviceServiceFactory;

    @GET
    @Path("/turnOnChannel1")
    public void turnOnChannel1(@QueryParam("deviceType") ShellyDevice deviceType, @QueryParam("ip") String ip) {

        DeviceService deviceService = deviceServiceFactory.createDeviceService(deviceType);
        if (deviceService instanceof ChannelControlService) {
            ((ChannelControlService) deviceService).turnOnChannel1(ip);

        }
    }

    @GET
    @Path("/turnOffChannel1")
    public void turnOffChannel1(@QueryParam("deviceType") ShellyDevice deviceType, @QueryParam("ip") String ip) {
        DeviceService deviceService = deviceServiceFactory.createDeviceService(deviceType);
        if (deviceService instanceof ChannelControlService) {
            ((ChannelControlService) deviceService).turnOffChannel1(ip);

        }
    }

}