package com.shellymadrid.utility.service.devices;

import com.shellymadrid.utility.model.DeviceWifi;

public interface WifiService {
    DeviceWifi getWifi(String ip);
    void setWifi(DeviceWifi deviceWifi);
}

