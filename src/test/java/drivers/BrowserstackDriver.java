package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static config.Project.config;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        return getAndroidDriver();
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", config.project());

        return capabilities;
    }

    private AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", System.getProperty("device_model", config.deviceModel()));
        capabilities.setCapability("os_version", System.getProperty("os_version", config.osVersion()));
        capabilities.setCapability("app", System.getProperty("bs_app", config.appUrl()));

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

}
