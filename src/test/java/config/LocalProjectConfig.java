package config;

import org.aeonbits.owner.ConfigFactory;

public class LocalProjectConfig {
    public static AppConfig appConfig = ConfigFactory.create(AppConfig.class, System.getProperties());
    public static DeviceConfig deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
}
