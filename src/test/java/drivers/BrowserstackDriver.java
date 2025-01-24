package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static helpers.BrowserstackHelper.getBrowserstackUrl;
import static helpers.EnvironmentHelper.*;
import static config.Project.config;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        if (isAndroid) {
            return getAndroidDriver();
        }
        return null;
    }

    private DesiredCapabilities commonCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", config.project());

        return capabilities;
    }

    private AndroidDriver getAndroidDriver() {
        DesiredCapabilities capabilities = commonCapabilities();
        capabilities.setCapability("deviceName", androidDevice);
        capabilities.setCapability("os_version", androidVersion);
        capabilities.setCapability("app", androidBrowserstackApp);

        return new AndroidDriver(getBrowserstackUrl(), capabilities);
    }

}