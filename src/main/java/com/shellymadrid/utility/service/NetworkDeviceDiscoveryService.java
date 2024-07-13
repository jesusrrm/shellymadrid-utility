package com.shellymadrid.utility.service;

import com.shellymadrid.utility.model.NetworkDevice;

import java.util.Set;

public interface NetworkDeviceDiscoveryService {
    Set<NetworkDevice> discoverNetworkDevices(String baseIp);

    Set<NetworkDevice> getDiscoveredNetworkDevices();

}
