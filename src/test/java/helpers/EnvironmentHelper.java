package helpers;

import static config.Project.config;

public class EnvironmentHelper {
    public static final String platform = System.getProperty("platform", "android");

    public static final String bsLogin = System.getProperty("bs_login", config.login());
    public static final String bsPassword = System.getProperty("bs_password", config.password());

    public static final boolean isAndroid = platform.equals("android");
    public static final String androidDevice = System.getProperty("device_model", config.deviceModel());
    public static final String androidVersion = System.getProperty("os_version", config.osVersion());
    public static final String androidBrowserstackApp = System.getProperty("bs_app", config.appUrl());

}
