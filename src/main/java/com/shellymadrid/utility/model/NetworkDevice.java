package com.shellymadrid.utility.model;

import com.shellymadrid.utility.model.devices.common.ShellyGetDeviceInfo;

public class NetworkDevice {
    private String ipAddress;
    private ShellyGetDeviceInfo shellyGetDeviceInfo;
    
    public NetworkDevice(String ipAddress, ShellyGetDeviceInfo shellyGetDeviceInfo) {
        this.ipAddress = ipAddress;
        this.shellyGetDeviceInfo = shellyGetDeviceInfo;
        this.hostname = shellyGetDeviceInfo.getId();
    }

    public ShellyGetDeviceInfo getShellyGetDeviceInfo() {
        return shellyGetDeviceInfo;
    }

    public void setShellyGetDeviceInfo(ShellyGetDeviceInfo shellyGetDeviceInfo) {
        this.shellyGetDeviceInfo = shellyGetDeviceInfo;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private String hostname;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public NetworkDevice(String ipAddress, String hostname) {
        this.ipAddress = ipAddress;
        this.hostname = hostname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
        result = prime * result + ((hostname == null) ? 0 : hostname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NetworkDevice other = (NetworkDevice) obj;
        if (ipAddress == null) {
            if (other.ipAddress != null)
                return false;
        } else if (!ipAddress.equals(other.ipAddress))
            return false;
        if (hostname == null) {
            if (other.hostname != null)
                return false;
        } else if (!hostname.equals(other.hostname))
            return false;
        return true;
    }


}
