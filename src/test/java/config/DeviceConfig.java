package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
        "classpath:remote.properties"
})
public interface DeviceConfig extends Config {
    @Key("deviceModel")
    String deviceModel();

    @Key("osVersion")
    String osVersion();
}
