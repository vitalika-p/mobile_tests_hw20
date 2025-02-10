package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;


public class SearchScreen {
    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia"));
    private final SelenideElement searchKeyWords = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));


    @Step("Открыть поиск")
    public SearchScreen openSearchPage() {
        searchCard.click();
        return this;
    }

    @Step("Ввести валидный поисковый запрос")
    public SearchScreen enterValidQuery(String query) {
        searchKeyWords.sendKeys("Pushkin");
        return this;
    }

    @Step("Получить текст из поля поиска")
    public String getSearchInputText() {
        return searchKeyWords.getText();
    }


    @Step("Проверить, что поле поиска содержит текст")
    public void verifySearchFieldContainsText(String expectedText) {
        String text = getSearchInputText();
        assertThat(text).isEqualTo("Pushkin");
    }

    @Step("Проверка наличия результатов")
    public SearchScreen checkResultsQuantity() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
