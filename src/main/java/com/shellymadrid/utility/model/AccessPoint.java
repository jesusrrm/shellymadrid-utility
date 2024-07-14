package com.shellymadrid.utility.model;

public class AccessPoint {
    private final String ssid;

    public AccessPoint(String ssid) {
        this.ssid = ssid;
    }

    public String getSsid() {
        return ssid;
    }

    @Override
    public String toString() {
        return "AccessPoint{" +
                "ssid='" + ssid + '\'' +
                '}';
    }
}
