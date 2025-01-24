package screens;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.*;

public class SearchResultsScreen {
    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia")),
            searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Ввести невалидный поисковый запрос")
    public SearchResultsScreen enterInvalidQuery(String query) {
        searchCard.click();
        searchBar.sendKeys(query);

        return this;
    }
}