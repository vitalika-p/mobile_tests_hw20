package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import screens.ArticleScreen;
import screens.SearchScreen;
import screens.SearchResultScreen;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchTests extends TestBase {
    screens.SearchScreen searchScreen = new SearchScreen();
    screens.SearchResultScreen SearchResultScreen = new SearchResultScreen();
    screens.ArticleScreen articleScreen = new ArticleScreen();

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
        SearchResultScreen.openFirstSearchResult();
        articleScreen.verifyErrorPageWithText("An error occurred");
    }
}
