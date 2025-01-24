package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {
    private final SelenideElement searchCard = $(accessibilityId("Search Wikipedia")),
        searchBar = $(id("org.wikipedia.alpha:id/search_src_text"));

    @Step("Ввести поисковый запрос")
    public SearchScreen enterSearchQuery(String query) {
        searchCard.click();
        searchBar.sendKeys(query);

        return this;
    }
}