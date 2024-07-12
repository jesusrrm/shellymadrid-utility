package org.shellymadrid.utility.service;

import org.shellymadrid.utility.model.NetworkDevice;

import java.util.Set;

public interface NetworkDeviceDiscoveryService {
    Set<NetworkDevice> discoverNetworkDevices(String baseIp);
}
