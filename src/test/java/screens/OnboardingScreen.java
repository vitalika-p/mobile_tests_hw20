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

    public static final String FIRST_SCREEN_HEADER = "The Free Encyclopedia\n…in over 300 languages";
    public static final String FIRST_SCREEN_TEXT = "We’ve found the following on your device:";
    public static final String LANGUAGE_LIST_TEXT = "1.\t\tEnglish";

    public static final String SECOND_SCREEN_HEADER = "New ways to explore";
    public static final String SECOND_SCREEN_TEXT = "Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. \n" +
            "Customize the feed to your interests – whether it’s learning about historical events On this day, or rolling the dice with Random.";

    public static final String THIRD_SCREEN_HEADER = "Reading lists with sync";
    public static final String THIRD_SCREEN_TEXT = "You can make reading lists from articles you want to read later, even when you’re offline. \n" +
            "Login to your Wikipedia account to sync your reading lists. Join Wikipedia";

    public static final String FOURTH_SCREEN_HEADER = "Data & Privacy";
    public static final String FOURTH_SCREEN_TEXT = "We believe that you should not have to provide personal information to participate in the free knowledge movement. " +
            "Usage data collected for this app is anonymous. Learn more about our privacy policy and terms of use.";

    @Step("Проверить, содержит ли заголовок страницы текст {0}")
    public OnboardingScreen checkHeader(String header) {
        onboardingScreenHeader.shouldHave(text(header));
        return this;
    }

    @Step("Проверить, что страница содержит {0} текст")
    public OnboardingScreen checkText(String text) {
        onboardingScreenText.shouldHave(text(text));
        return this;
    }

    @Step("Проверить, видны ли кнопки 'Пропустить' и 'Продолжить'")
    public OnboardingScreen checkSkipContinueVisible() {
        skipButton.shouldBe(Condition.visible);
        continueButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, не видны ли кнопки 'Пропустить' и 'Продолжить'")
    public OnboardingScreen checkSkipContinueNotVisible() {
        skipButton.shouldNotBe(Condition.visible);
        continueButton.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Перейти к следующему экрану")
    public OnboardingScreen goNextScreen() {
        continueButton.click();
        return this;
    }

    @Step("Проверить, что кнопка 'Get Started' видна")
    public OnboardingScreen checkGetStartedButtonVisible() {
        getStartedButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что кнопка 'Get Started'  не видна")
    public OnboardingScreen checkGetStartedButtonNotVisible() {
        getStartedButton.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Нажать на кнопку 'Get Started'")
    public OnboardingScreen getStarted() {
        getStartedButton.click();
        return this;
    }

    @Step("Проверить список языков")
    public OnboardingScreen checkLanguageList(String languages) {
        languageList.shouldHave(text(languages));
        return this;
    }

    @Step("Проверить наличие кнопки 'Add Language'")
    public OnboardingScreen checkAddLanguageButton() {
        addLanguageButton.shouldBe(Condition.visible);
        return this;
    }
}
