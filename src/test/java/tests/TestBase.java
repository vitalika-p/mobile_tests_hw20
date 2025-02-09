package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import screens.ArticleScreen;
import screens.OnboardingScreen;
import screens.SearchResultScreen;
import screens.SearchScreen;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    screens.SearchScreen searchScreen = new SearchScreen();
    screens.SearchResultScreen searchResultScreen = new SearchResultScreen();
    screens.ArticleScreen articleScreen = new ArticleScreen();
    screens.OnboardingScreen onboardingScreen = new OnboardingScreen();

    @BeforeAll
    static void beforeAll() {
        String deviceHost = System.getProperty("deviceHost", "emulation");
        if (deviceHost.equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if (deviceHost.equals("emulation")) {
            Configuration.browser = LocalDriver.class.getName();
        } else {
            throw new RuntimeException("Unknown deviceHost was provided.");
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);
        Attach.pageSource();
        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}