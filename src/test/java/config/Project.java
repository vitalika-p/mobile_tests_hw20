package config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static config.ProjectConfig config = ConfigFactory.create(config.ProjectConfig.class, System.getProperties());
}
