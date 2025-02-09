package config;

import org.aeonbits.owner.ConfigFactory;

public class LocalProjectConfig {
    public static LocalConfig config = ConfigFactory.create(LocalConfig.class, System.getProperties());
}