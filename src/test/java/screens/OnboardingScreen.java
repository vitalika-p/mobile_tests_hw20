package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {
    private final SelenideElement onboardingScreenHeader = $(id("org.wikipedia.alpha:id/primaryTextView")),
            onboardingScreenText = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            addLanguageButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            languageList = $(id("org.wikipedia.alpha:id/option_label"));

    @Step("Check that page header contains {0} text")
    public OnboardingScreen checkHeader(String header) {
        onboardingScreenHeader.shouldHave(text(header));

        return this;
    }

    @Step("Check that page contains {0} text")
    public OnboardingScreen checkText(String text) {
        onboardingScreenText.shouldHave(text(text));

        return this;
    }

    @Step("Check Skip and Continue buttons are visible")
    public OnboardingScreen checkSkipContinueVisible() {
        skipButton.shouldBe(Condition.visible);
        continueButton.shouldBe(Condition.visible);

        return this;
    }

    @Step("Check Skip and Continue buttons are not visible")
    public OnboardingScreen checkSkipContinueNotVisible() {
        skipButton.shouldNotBe(Condition.visible);
        continueButton.shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Go to the next screen")
    public OnboardingScreen goNextScreen() {
        continueButton.click();

        return this;
    }

    @Step("Check that Get Started button is visible")
    public OnboardingScreen checkGetStartedButtonVisible() {
        getStartedButton.shouldBe(Condition.visible);

        return this;
    }

    @Step("Check that Get Started button is not visible")
    public OnboardingScreen checkGetStartedButtonNotVisible() {
        getStartedButton.shouldNotBe(Condition.visible);

        return this;
    }

    @Step("Click Get Started button")
    public OnboardingScreen getStarted() {
        getStartedButton.click();

        return this;
    }

    @Step("Check language list")
    public OnboardingScreen checkLanguageList(String languages) {
        languageList.shouldHave(text(languages));

        return this;
    }

    @Step("Check Add Language button existence")
    public OnboardingScreen checkAddLanguageButton() {
        addLanguageButton.shouldBe(Condition.visible);

        return this;
    }
}
