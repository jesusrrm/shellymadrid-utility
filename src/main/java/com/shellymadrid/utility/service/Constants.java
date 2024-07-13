package com.shellymadrid.utility.service;

public interface Constants {

    // Enum for different Shelly devices
    enum ShellyDevice {
        SHELLY_1,
        SHELLY_1PM,
        SHELLY_2,
        SHELLY_2PM,
        SHELLY_3EM,
        SHELLY_4PRO,
        SHELLY_BULB,
        SHELLY_BULB_RGBW,
        SHELLY_DIMMER,
        SHELLY_DIMMER2,
        SHELLY_EM,
        SHELLY_FLOOD,
        SHELLY_GAS,
        SHELLY_HT,
        SHELLY_I3,
        SHELLY_PLUG,
        SHELLY_PLUG_S,
        SHELLY_RGBW,
        SHELLY_RGBW2,
        SHELLY_SMOKE,
        SHELLY_VINTAGE,
        SHELLY_BUTTON1,
        SHELLY_DOOR_WINDOW,
        SHELLY_DOOR_WINDOW2,
        SHELLY_MOTION,
        SHELLY_TRV,
        SHELLY_UNI,
        SHELLY_DUO,
        SHELLY_PLUG_US,
        SHELLY_PRO_4PM,
        SHELLY_PRO_EM,
        SHELLY_PRO_1,
        SHELLY_PRO_1PM,
        SHELLY_PRO_2PM,
        SHELLY_PRO_3EM,
        SHELLY_PRO_4PM_PLUS
    }

    // Enum for device statuses
    enum DeviceStatus {
        ON,
        OFF,
        RESTARTING,
        UPDATING,
        ERROR,
        UNKNOWN
    }

    // Enum for device statuses
    enum Generation {
        GEN1,
        GEN2,
        GEN3,
        GEN4,
        UNKNOWN
    }

    // Enum for device features
    enum DeviceFeature {
        RELAY,
        METER,
        SENSOR,
        TEMPERATURE,
        HUMIDITY,
        POWER,
        LIGHT,
        DIMMER,
        RGB,
        PLUG,
        BUTTON,
        FLOOD,
        GAS,
        SMOKE,
        DOOR_WINDOW,
        MOTION,
        TRV,
        VINTAGE,
        I3,
        UNI
    }

    public static ShellyDevice fromString(String deviceString) {
        switch (deviceString) {
            case "PlusPlugS":
                return ShellyDevice.SHELLY_PLUG_S;
            // Add other mappings if needed
            default:
                throw new IllegalArgumentException("Unknown device string: " + deviceString);
        }
    }
}
