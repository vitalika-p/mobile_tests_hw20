package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})
public interface LocalConfig extends Config {
    @Key("osVersion")
    String osVersion();

    @Key("device")
    String device();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();
}