package com.shellymadrid.utility.model.devices.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShellyGetDeviceInfo {
    private String name;
    private String id;
    private String mac;
    private int slot;
    private String model;
    private int gen;
    private String fwId;
    private String ver;
    private String app;
    private boolean authEn;
    private String authDomain;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getGen() {
        return gen;
    }

    public void setGen(int gen) {
        this.gen = gen;
    }

    public String getFwId() {
        return fwId;
    }

    public void setFwId(String fwId) {
        this.fwId = fwId;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public boolean isAuthEn() {
        return authEn;
    }

    public void setAuthEn(boolean authEn) {
        this.authEn = authEn;
    }

    public String getAuthDomain() {
        return authDomain;
    }

    public void setAuthDomain(String authDomain) {
        this.authDomain = authDomain;
    }

    @Override
        public String toString() {
            return "DeviceDetails{" +
                    "name='" + name + '\'' +
                    ", id='" + id + '\'' +
                    ", mac='" + mac + '\'' +
                    ", slot=" + slot +
                    ", model='" + model + '\'' +
                    ", gen=" + gen +
                    ", fwId='" + fwId + '\'' +
                    ", ver='" + ver + '\'' +
                    ", app='" + app + '\'' +
                    ", authEn=" + authEn +
                    ", authDomain='" + authDomain + '\'' +
                    '}';
        }
    }
