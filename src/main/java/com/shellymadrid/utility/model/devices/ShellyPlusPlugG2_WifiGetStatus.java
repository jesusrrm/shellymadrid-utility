package com.shellymadrid.utility.model.devices;

public class ShellyPlusPlugG2_WifiGetStatus {
    private String staIp;
    private String status;
    private String ssid;
    private int rssi;
    private int apClientCount;

    // Constructors, getters, and setters

    // Getters and setters for WifiStatus class
    public String getStaIp() {
        return staIp;
    }

    public void setStaIp(String staIp) {
        this.staIp = staIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public int getRssi() {
        return rssi;
    }

    public void setRssi(int rssi) {
        this.rssi = rssi;
    }

    public int getApClientCount() {
        return apClientCount;
    }

    public void setApClientCount(int apClientCount) {
        this.apClientCount = apClientCount;
    }
}
