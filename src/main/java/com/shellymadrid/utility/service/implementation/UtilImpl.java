package com.shellymadrid.utility.service.implementation;

import com.shellymadrid.utility.service.UtilService;

import jakarta.enterprise.context.ApplicationScoped;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class UtilImpl implements UtilService {

    @Override
    public List<String> getNetworkInterface() {
        List<String> ips =  new ArrayList<>();
        try {
            // Get all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();

                // Ignore inactive, loopback, and point-to-point interfaces
                if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isPointToPoint()) {
                    continue;
                }

                // Get all IP addresses assigned to this network interface
                for (InterfaceAddress interfaceAddress : networkInterface.getInterfaceAddresses()) {
                    InetAddress address = interfaceAddress.getAddress();

                    // Check for site-local addresses (typically used in local networks)
                    if (address.isSiteLocalAddress()) {
                        System.out.println("Interface: " + networkInterface.getDisplayName());
                        System.out.println("IP Address: " + address.getHostAddress());
                        System.out.println();
                        ips.add(address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    return ips;
    }

    
}
