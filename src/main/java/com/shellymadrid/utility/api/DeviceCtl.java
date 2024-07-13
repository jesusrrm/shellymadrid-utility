package com.shellymadrid.utility.api;

import com.shellymadrid.utility.service.Constants.ShellyDevice;
import com.shellymadrid.utility.service.devices.DeviceService;
import com.shellymadrid.utility.service.DeviceServiceFactory;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;



@Path("/device")
public class DeviceCtl {

    @Inject
    DeviceServiceFactory deviceServiceFactory;

    
    @GET
    @Path("/turnOnChannel1")
    public void turnOnChannel1(@QueryParam("deviceType") ShellyDevice deviceType, @QueryParam("ip") String ip) {
       
        DeviceService deviceService = deviceServiceFactory.createDeviceService(deviceType);
        deviceService.turnOnChannel1(ip);
    }

    @GET
    @Path("/turnOffChannel1")
    public void turnOffChannel1(@QueryParam("deviceType") ShellyDevice deviceType, @QueryParam("ip") String ip) {
        DeviceService deviceService = deviceServiceFactory.createDeviceService(deviceType);
        deviceService.turnOffChannel1(ip);
    }
   
}