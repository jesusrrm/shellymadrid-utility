package com.shellymadrid.utility.model.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShellyPlusPlugG2_SysGetConfig {
    private Device device;
    private Location location;
    private Debug debug;
    private Object uiData; // Assuming it can be of any type
    private RpcUdp rpcUdp;
    private Sntp sntp;
    private int cfgRev;

    // Constructors, getters, and setters

    // Getters and setters for ConfigData class
    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Debug getDebug() {
        return debug;
    }

    public void setDebug(Debug debug) {
        this.debug = debug;
    }

    public Object getUiData() {
        return uiData;
    }

    public void setUiData(Object uiData) {
        this.uiData = uiData;
    }

    public RpcUdp getRpcUdp() {
        return rpcUdp;
    }

    public void setRpcUdp(RpcUdp rpcUdp) {
        this.rpcUdp = rpcUdp;
    }

    public Sntp getSntp() {
        return sntp;
    }

    public void setSntp(Sntp sntp) {
        this.sntp = sntp;
    }

    public int getCfgRev() {
        return cfgRev;
    }

    public void setCfgRev(int cfgRev) {
        this.cfgRev = cfgRev;
    }

    // Nested classes

    public static class Device {
        private String name;
        private String mac;
        @JsonProperty("fw_id")
        private String fwId;
        @JsonProperty("eco_mode")
        private boolean ecoMode;
        private String profile;
        private boolean discoverable;

        // Constructors, getters, and setters

        // Getters and setters for Device class
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getFwId() {
            return fwId;
        }

        public void setFwId(String fwId) {
            this.fwId = fwId;
        }

        public boolean isEcoMode() {
            return ecoMode;
        }

        public void setEcoMode(boolean ecoMode) {
            this.ecoMode = ecoMode;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public boolean isDiscoverable() {
            return discoverable;
        }

        public void setDiscoverable(boolean discoverable) {
            this.discoverable = discoverable;
        }
    }

    public static class Location {
        private String tz;
        private double lat;
        private double lon;

        // Constructors, getters, and setters

        // Getters and setters for Location class
        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    public static class Debug {
        private Mqtt mqtt;
        private Websocket websocket;
        private Udp udp;

        // Constructors, getters, and setters

        // Getters and setters for Debug class
        public Mqtt getMqtt() {
            return mqtt;
        }

        public void setMqtt(Mqtt mqtt) {
            this.mqtt = mqtt;
        }

        public Websocket getWebsocket() {
            return websocket;
        }

        public void setWebsocket(Websocket websocket) {
            this.websocket = websocket;
        }

        public Udp getUdp() {
            return udp;
        }

        public void setUdp(Udp udp) {
            this.udp = udp;
        }
    }

    // Inner classes for Debug class
    public static class Mqtt {
        private boolean enable;

        // Constructors, getters, and setters

        // Getters and setters for Mqtt class
        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }
    }

    public static class Websocket {
        private boolean enable;

        // Constructors, getters, and setters

        // Getters and setters for Websocket class
        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }
    }

    public static class Udp {
        private String addr;

        // Constructors, getters, and setters

        // Getters and setters for Udp class
        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }
    }

    public static class Sntp {
        private String server;

        // Constructors, getters, and setters

        // Getters and setters for Sntp class
        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }
    }

    public static class RpcUdp {
        @JsonProperty("dst_addr")
        private String dstAddr;
        @JsonProperty("listen_port")
        private Integer listenPort;

        // Constructors, getters, and setters

        // Getters and setters for RpcUdp class
        public String getDstAddr() {
            return dstAddr;
        }

        public void setDstAddr(String dstAddr) {
            this.dstAddr = dstAddr;
        }

        public Integer getListenPort() {
            return listenPort;
        }

        public void setListenPort(Integer listenPort) {
            this.listenPort = listenPort;
        }
    }
}
