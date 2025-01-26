package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.SearchScreen;

import javax.management.Query;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTests extends TestBase {
    screens.SearchScreen searchScreen = new SearchScreen();

    @Test
    @Tag("android")
    @DisplayName("Открытие первого валидного результата")
    void successfulSearchTest() {
        searchScreen.openSearchPage();
        searchScreen.enterValidQuery("QA Engineer");
        searchScreen.openFirstSearchResult();
    }

    @Test
    @Tag("android")
    @DisplayName("Очистка поля ввода после тапа на крестик")
    void clearSearchFieldTest() {
        searchScreen.openSearchPage();
        searchScreen.enterInvalidQuery("!@#$%^&*");
        searchScreen.clearSearchField();
        searchScreen.isSearchFieldEmpty();
    }
}