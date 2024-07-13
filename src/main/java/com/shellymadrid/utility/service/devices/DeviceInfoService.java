package com.shellymadrid.utility.service.devices;

import com.shellymadrid.utility.service.Constants.ShellyDevice;

public interface DeviceInfoService {
    ShellyDevice getShellyDevice(String ip);
}