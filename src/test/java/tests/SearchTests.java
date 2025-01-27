package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;
import screens.SearchResultScreen;
import screens.OnboardingScreen;


public class SearchTests extends TestBase {
    private SearchScreen searchScreen = new SearchScreen();
    private SearchResultScreen searchResultScreen = new SearchResultScreen();
    private OnboardingScreen onboardingScreen = new OnboardingScreen();

    @Test
    @Tag("android")
    @DisplayName("Вывод результатов поиска")
    void successfulSearchTest() {
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("Pushkin");
        searchScreen.verifySearchFieldContainsText("Pushkin");
        searchScreen.checkResultsQuantity();
    }

    @Test
    @Tag("android")
    @DisplayName("Открыть первый результат и проверить текст ошибки")
    void verifyErrorTextTest() {
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("Pushkin");
        searchScreen.verifySearchFieldContainsText("Pushkin");
        searchResultScreen.openFirstSearchResult();
        searchResultScreen.verifyErrorPageWithText("An error occurred");
    }

    @Test
    @Tag("android")
    @DisplayName("Проверка экранов онбординга")
    void onboardingScreensTest() {
        //first screen
        onboardingScreen
                .checkHeader("The Free Encyclopedia\n" +
                        "…in over 300 languages")
                .checkText("We’ve found the following on your device:")
                .checkLanguageList("1.\t\tEnglish")
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //second screen
                .checkHeader("New ways to explore")
                .checkText("Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
                        "\nCustomize the feed to your interests – whether it’s learning about historical events " +
                        "On this day, or rolling the dice with Random.")
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //third screen
                .checkHeader("Reading lists with sync")
                .checkText("You can make reading lists from articles you want to read later, even when you’re offline. " +
                        "\nLogin to your Wikipedia account to sync your reading lists. Join Wikipedia")
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                //four screen
                .checkHeader("Data & Privacy")
                .checkText("We believe that you should not have to provide personal information to " +
                        "participate in the free knowledge movement. Usage data collected for this app is anonymous. " +
                        "Learn more about our privacy policy and terms of use.")
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
    }
}
