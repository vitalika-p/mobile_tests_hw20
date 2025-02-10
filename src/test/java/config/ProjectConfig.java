package config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectConfig {
    public static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    public static AppConfig appConfig = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
}
