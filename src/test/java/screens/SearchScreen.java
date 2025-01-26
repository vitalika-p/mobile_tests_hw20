package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchScreen {
    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection searchKeyWords = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    public final SelenideElement clearButton = $(id("org.wikipedia.alpha:id/search_close_btn"));


    @Step("Открыть поиск")
    public SearchScreen openSearchPage() {
        searchCard.click();
        return this;
    }
    @Step("Ввести валидный поисковый запрос")
    public SearchScreen enterValidQuery(String query) {
        searchBar.sendKeys(query);
        return this;
    }

    @Step("Открыть первый результат")
    public SearchScreen openFirstSearchResult() {
        searchKeyWords.first().click();
        return this;
    }

    @Step("Ввести невалидный поисковый запрос")
    public SearchScreen enterInvalidQuery(String query) {
        searchBar.sendKeys(query);
        return this;
    }

    @Step("Нажать на крестик для очистки поля поиска")
    public SearchScreen clearSearchField() {
        clearButton.click();
        return this;
    }

    @Step("Проверить, что поле поиска пустое")
    public boolean isSearchFieldEmpty() {
        return searchBar.getText().isEmpty();
    }
}