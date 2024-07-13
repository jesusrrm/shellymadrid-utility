package com.shellymadrid.utility.model;

public class DeviceWifi {
    private String ssid;
    private String password;
    private String staticIp;

    public DeviceWifi(String ssid, String password) {
        this.ssid = ssid;
        this.password = password;
    }

    public DeviceWifi(String ssid, String password, String staticIp) {
        this.ssid = ssid;
        this.password = password;
        this.staticIp = staticIp;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaticIp() {
        return staticIp;
    }

    public void setStaticIp(String staticIp) {
        this.staticIp = staticIp;
    }

}
