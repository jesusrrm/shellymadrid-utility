package com.shellymadrid.utility.model.devices;

import java.util.List;
import java.util.Map;

public class Shelly1_1PM_G1 {

    private List<Relay> relays;
    private List<Meter> meters;
    private List<Input> inputs;
    private Map<String, Object> ext_sensors;
    private Map<String, Object> ext_temperature;
    private Map<String, Object> ext_humidity;
    private double temperature;
    private boolean overtemperature;
    private TemperatureInfo tmp;
    private String temperature_status;
    private Map<String, ExtSwitch> ext_switch;

    // Getters and setters

    public List<Relay> getRelays() {
        return relays;
    }

    public void setRelays(List<Relay> relays) {
        this.relays = relays;
    }

    public List<Meter> getMeters() {
        return meters;
    }

    public void setMeters(List<Meter> meters) {
        this.meters = meters;
    }

    public List<Input> getInputs() {
        return inputs;
    }

    public void setInputs(List<Input> inputs) {
        this.inputs = inputs;
    }

    public Map<String, Object> getExt_sensors() {
        return ext_sensors;
    }

    public void setExt_sensors(Map<String, Object> ext_sensors) {
        this.ext_sensors = ext_sensors;
    }

    public Map<String, Object> getExt_temperature() {
        return ext_temperature;
    }

    public void setExt_temperature(Map<String, Object> ext_temperature) {
        this.ext_temperature = ext_temperature;
    }

    public Map<String, Object> getExt_humidity() {
        return ext_humidity;
    }

    public void setExt_humidity(Map<String, Object> ext_humidity) {
        this.ext_humidity = ext_humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public boolean isOvertemperature() {
        return overtemperature;
    }

    public void setOvertemperature(boolean overtemperature) {
        this.overtemperature = overtemperature;
    }

    public TemperatureInfo getTmp() {
        return tmp;
    }

    public void setTmp(TemperatureInfo tmp) {
        this.tmp = tmp;
    }

    public String getTemperature_status() {
        return temperature_status;
    }

    public void setTemperature_status(String temperature_status) {
        this.temperature_status = temperature_status;
    }

    public Map<String, ExtSwitch> getExt_switch() {
        return ext_switch;
    }

    public void setExt_switch(Map<String, ExtSwitch> ext_switch) {
        this.ext_switch = ext_switch;
    }

    // Nested classes

    public static class Relay {
        private boolean ison;
        private boolean has_timer;
        private long timer_started;
        private long timer_duration;
        private long timer_remaining;
        private boolean overpower;
        private String source;

        // Getters and setters

        public boolean isIson() {
            return ison;
        }

        public void setIson(boolean ison) {
            this.ison = ison;
        }

        public boolean isHas_timer() {
            return has_timer;
        }

        public void setHas_timer(boolean has_timer) {
            this.has_timer = has_timer;
        }

        public long getTimer_started() {
            return timer_started;
        }

        public void setTimer_started(long timer_started) {
            this.timer_started = timer_started;
        }

        public long getTimer_duration() {
            return timer_duration;
        }

        public void setTimer_duration(long timer_duration) {
            this.timer_duration = timer_duration;
        }

        public long getTimer_remaining() {
            return timer_remaining;
        }

        public void setTimer_remaining(long timer_remaining) {
            this.timer_remaining = timer_remaining;
        }

        public boolean isOverpower() {
            return overpower;
        }

        public void setOverpower(boolean overpower) {
            this.overpower = overpower;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }

    public static class Meter {
        private int power;
        private double overpower;
        private boolean is_valid;
        private long timestamp;
        private List<Integer> counters;
        private int total;

        // Getters and setters

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public double getOverpower() {
            return overpower;
        }

        public void setOverpower(double overpower) {
            this.overpower = overpower;
        }

        public boolean isIs_valid() {
            return is_valid;
        }

        public void setIs_valid(boolean is_valid) {
            this.is_valid = is_valid;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public List<Integer> getCounters() {
            return counters;
        }

        public void setCounters(List<Integer> counters) {
            this.counters = counters;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }

    public static class Input {
        private int input;
        private String event;
        private int event_cnt;

        // Getters and setters

        public int getInput() {
            return input;
        }

        public void setInput(int input) {
            this.input = input;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public int getEvent_cnt() {
            return event_cnt;
        }

        public void setEvent_cnt(int event_cnt) {
            this.event_cnt = event_cnt;
        }
    }

    public static class TemperatureInfo {
        private double tC;
        private double tF;
        private boolean is_valid;

        // Getters and setters

        public double gettC() {
            return tC;
        }

        public void settC(double tC) {
            this.tC = tC;
        }

        public double gettF() {
            return tF;
        }

        public void settF(double tF) {
            this.tF = tF;
        }

        public boolean isIs_valid() {
            return is_valid;
        }

        public void setIs_valid(boolean is_valid) {
            this.is_valid = is_valid;
        }
    }

    public static class ExtSwitch {
        private int input;

        // Getters and setters

        public int getInput() {
            return input;
        }

        public void setInput(int input) {
            this.input = input;
        }
    }
}
