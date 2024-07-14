package com.shellymadrid.utility.service.implementation;

import com.shellymadrid.utility.model.DeviceWifi;
import com.shellymadrid.utility.service.DeviceManagerService;
import com.shellymadrid.utility.service.devices.ChannelControlService;
import com.shellymadrid.utility.service.devices.DeviceService;
import com.shellymadrid.utility.service.devices.WifiService;

import java.util.List;
import java.util.ArrayList;

public class DeviceManagerImpl implements DeviceManagerService {
    private List<DeviceService> devices;

    public DeviceManagerImpl() {
        devices = new ArrayList<>();
    }

    @Override
    public void addDevice(DeviceService device) {
        devices.add(device);
    }

    @Override
    public void turnOnCahnnel1AllDevices() {
        for (DeviceService device : devices) {

            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOnChannel1("");

            }
        }
    }

    @Override
    public void turnOffChannel1AllDevices() {
        for (DeviceService device : devices) {
            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOffChannel1("");

            }
        }
    }

    @Override
    public void turnOffChannel2AllDevices() {
        for (DeviceService device : devices) {
            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOffChannel2("");

            }
        }
    }

    @Override
    public void turnOnCahnnel2AllDevices() {
        for (DeviceService device : devices) {
            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOnChannel2("");

            }
        }
    }

    @Override
    public void turnOnCahnnel3AllDevices() {
        for (DeviceService device : devices) {
            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOnChannel3("");

            }
        }
    }

    @Override
    public void turnOffChannel3AllDevices() {
        for (DeviceService device : devices) {
            if (device instanceof ChannelControlService) {
                ((ChannelControlService) device).turnOffChannel3("");

            }
        }
    }

    @Override
    public void showStatus() {
        for (DeviceService device : devices) {
            System.out.println(device.getStatus(""));
        }
    }

    @Override
    public void setWifi(String ssid, String password) {

        for (DeviceService device : devices) {
            if (device instanceof WifiService)
                ((WifiService) device).setWifi(new DeviceWifi(ssid, password));
            System.out.println(device.getStatus(""));
        }
    }

    @Override
    public void setWifi(String ssid, String password, int rangeBegin, int rangeEnds) {

        for (DeviceService device : devices) {
            if (device instanceof WifiService) {
                WifiService device0 = ((WifiService) device);
                if (rangeBegin <= rangeEnds) {
                    String[] octeto = device0.getWifi("").getStaticIp().split(".");
                    DeviceWifi deviceWifi = new DeviceWifi(ssid, password,
                            octeto[0] + "." + octeto[1] + "." + octeto[2] + "." + (rangeBegin++));
                    device0.setWifi(deviceWifi);
                    System.out.println(device.getStatus(""));
                }
            }
        }
    }
}
