package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import javax.management.Query;

public class SearchTests extends TestBase {

    @Test
    @Tag("android")
    @DisplayName("Ввести валидный поисковый запрос в строку поиска")
    void successfulSearchTest() {
        screens.SearchScreen searchPage = new screens.SearchScreen();

        searchPage.enterSearchQuery("QA Engineer");
    }

    @Test
    @Tag("android")
    @DisplayName("Ввести невалидный поисковый запрос в строку поиска")
    void unSuccessfulSearchTest() {
        screens.SearchResultsScreen searchPage = new screens.SearchResultsScreen();

        searchPage.enterInvalidQuery("slhjhfkshj");
    }

}