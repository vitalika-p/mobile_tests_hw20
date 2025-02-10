package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.OnboardingScreen;


import static com.codeborne.selenide.Selenide.back;


public class SearchTests extends TestBase {


    @Test
    @Tag("android")
    @DisplayName("Вывод результатов поиска")
    void successfulSearchTest() {
        back();
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("");
        searchScreen.verifySearchFieldContainsText("");
        searchScreen.checkResultsQuantity();
    }

    @Disabled
    @Test
    @Tag("android")
    @DisplayName("Открыть первый результат и проверить текст ошибки")
    void verifyErrorTextTest() {
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("");
        searchScreen.verifySearchFieldContainsText("");
        searchResultScreen.openFirstSearchResult();
        articleScreen.verifyErrorPageWithText();
    }


  
    @Test
    @Tag("android")
    @DisplayName("Открыть первый результат и проверить название статьи")
    void verifyArticleTitleTest() {
        back();
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("");
        searchScreen.verifySearchFieldContainsText("");
        searchResultScreen.openFirstSearchResult();
        articleScreen.checkArticleTitle("Alexander Pushkin");
    }


    @Test
    @Tag("android")
    @DisplayName("Проверка экранов онбординга")
    void onboardingScreensTest() {
        onboardingScreen
                .checkHeader(OnboardingScreen.FIRST_SCREEN_HEADER)
                .checkText(OnboardingScreen.FIRST_SCREEN_TEXT)
                .checkLanguageList(OnboardingScreen.LANGUAGE_LIST_TEXT)
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                .checkHeader(OnboardingScreen.SECOND_SCREEN_HEADER)
                .checkText(OnboardingScreen.SECOND_SCREEN_TEXT)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                .checkHeader(OnboardingScreen.THIRD_SCREEN_HEADER)
                .checkText(OnboardingScreen.THIRD_SCREEN_TEXT)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueVisible()
                .goNextScreen()

                .checkHeader(OnboardingScreen.FOURTH_SCREEN_HEADER)
                .checkText(OnboardingScreen.FOURTH_SCREEN_TEXT)
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
    }
}
