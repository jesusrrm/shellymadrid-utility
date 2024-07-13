package com.shellymadrid.utility.service;

import com.shellymadrid.utility.service.devices.ChannelControlService;
import com.shellymadrid.utility.service.devices.DeviceService;

public interface DeviceManagerService  {

    public void addDevice(DeviceService device);

    public void turnOnCahnnel1AllDevices();

    public void turnOffChannel1AllDevices();

    public void turnOffChannel2AllDevices();

    public void turnOnCahnnel2AllDevices();

    public void turnOnCahnnel3AllDevices();

    public void turnOffChannel3AllDevices();

    public void showStatus();

    public void setWifi(String ssid, String password);

    public void setWifi(String ssid, String password, int rangeBegin, int rangeEnds);
}
