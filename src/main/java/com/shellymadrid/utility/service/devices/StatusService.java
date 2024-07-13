package com.shellymadrid.utility.service.devices;

import com.shellymadrid.utility.service.Constants;
import com.shellymadrid.utility.service.Constants.DeviceStatus;

public interface StatusService {
    DeviceStatus getStatus(String ip);
}