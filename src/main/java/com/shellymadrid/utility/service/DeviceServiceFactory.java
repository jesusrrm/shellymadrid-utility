package com.shellymadrid.utility.service;
import com.shellymadrid.utility.service.Constants.ShellyDevice;
import com.shellymadrid.utility.service.devices.DeviceService;
import com.shellymadrid.utility.service.implementation.ShellyPlusPlugSImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;


@ApplicationScoped
public class DeviceServiceFactory {

    @Inject
    private ShellyPlusPlugSImpl shellyPlusPlugS;

  

    @Produces
    public DeviceService createDeviceService(Constants.ShellyDevice deviceType) {
        switch (deviceType) {
            case ShellyDevice.SHELLY_PLUG_S:
                return shellyPlusPlugS;

            default:
                throw new IllegalArgumentException("Unknown device type: " + deviceType);
        }
    }
}