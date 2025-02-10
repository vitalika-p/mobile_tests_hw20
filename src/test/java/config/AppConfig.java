package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:app.properties"
})
public interface AppConfig extends Config {
    @Key("appUrl")
    String appUrl();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("project")
    String project();
}
