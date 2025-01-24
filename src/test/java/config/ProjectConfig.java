package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
    "classpath:remote.properties"
})
public interface ProjectConfig extends Config {
    @Key("appUrl")
    String appUrl();

    @Key("project")
    String project();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("android.deviceModel")
    String deviceModel();

    @Key("android.osVersion")
    String osVersion();

}
