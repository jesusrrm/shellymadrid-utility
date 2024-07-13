package com.shellymadrid.utility.model.devices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShellyPlusPlugG2_SysGetStatus {
    private int id;
    private String src;
    private Result result;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "DeviceInfo{" +
                "id=" + id +
                ", src='" + src + '\'' +
                ", result=" + result +
                '}';
    }

    public static class Result {
        private String mac;
        @JsonProperty("restart_required")
        private boolean restartRequired;
        private String time;
        private long unixtime;
        private long uptime;
        @JsonProperty("ram_size")
        private int ramSize;
        @JsonProperty("ram_free")
        private int ramFree;
        @JsonProperty("fs_size")
        private int fsSize;
        @JsonProperty("fs_free")
        private int fsFree;
        @JsonProperty("cfg_rev")
        private int cfgRev;
        @JsonProperty("kvs_rev")
        private int kvsRev;
        @JsonProperty("schedule_rev")
        private int scheduleRev;
        @JsonProperty("webhook_rev")
        private int webhookRev;
        @JsonProperty("available_updates")
        private AvailableUpdates availableUpdates;

        // Getters and Setters
        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public boolean isRestartRequired() {
            return restartRequired;
        }

        public void setRestartRequired(boolean restartRequired) {
            this.restartRequired = restartRequired;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public long getUnixtime() {
            return unixtime;
        }

        public void setUnixtime(long unixtime) {
            this.unixtime = unixtime;
        }

        public long getUptime() {
            return uptime;
        }

        public void setUptime(long uptime) {
            this.uptime = uptime;
        }

        public int getRamSize() {
            return ramSize;
        }

        public void setRamSize(int ramSize) {
            this.ramSize = ramSize;
        }

        public int getRamFree() {
            return ramFree;
        }

        public void setRamFree(int ramFree) {
            this.ramFree = ramFree;
        }

        public int getFsSize() {
            return fsSize;
        }

        public void setFsSize(int fsSize) {
            this.fsSize = fsSize;
        }

        public int getFsFree() {
            return fsFree;
        }

        public void setFsFree(int fsFree) {
            this.fsFree = fsFree;
        }

        public int getCfgRev() {
            return cfgRev;
        }

        public void setCfgRev(int cfgRev) {
            this.cfgRev = cfgRev;
        }

        public int getKvsRev() {
            return kvsRev;
        }

        public void setKvsRev(int kvsRev) {
            this.kvsRev = kvsRev;
        }

        public int getScheduleRev() {
            return scheduleRev;
        }

        public void setScheduleRev(int scheduleRev) {
            this.scheduleRev = scheduleRev;
        }

        public int getWebhookRev() {
            return webhookRev;
        }

        public void setWebhookRev(int webhookRev) {
            this.webhookRev = webhookRev;
        }

        public AvailableUpdates getAvailableUpdates() {
            return availableUpdates;
        }

        public void setAvailableUpdates(AvailableUpdates availableUpdates) {
            this.availableUpdates = availableUpdates;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "mac='" + mac + '\'' +
                    ", restartRequired=" + restartRequired +
                    ", time='" + time + '\'' +
                    ", unixtime=" + unixtime +
                    ", uptime=" + uptime +
                    ", ramSize=" + ramSize +
                    ", ramFree=" + ramFree +
                    ", fsSize=" + fsSize +
                    ", fsFree=" + fsFree +
                    ", cfgRev=" + cfgRev +
                    ", kvsRev=" + kvsRev +
                    ", scheduleRev=" + scheduleRev +
                    ", webhookRev=" + webhookRev +
                    ", availableUpdates=" + availableUpdates +
                    '}';
        }
    }

    public static class AvailableUpdates {
        private Stable stable;

        // Getters and Setters
        public Stable getStable() {
            return stable;
        }

        public void setStable(Stable stable) {
            this.stable = stable;
        }

        @Override
        public String toString() {
            return "AvailableUpdates{" +
                    "stable=" + stable +
                    '}';
        }
    }

    public static class Stable {
        private String version;

        // Getters and Setters
        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        @Override
        public String toString() {
            return "Stable{" +
                    "version='" + version + '\'' +
                    '}';
        }
    }
}
