package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchResultScreen {
    private final ElementsCollection searchKeyWords = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text"));

    @Step("Открыть первый результат")
    public SearchResultScreen openFirstSearchResult() {
        searchKeyWords.first().click();
        return this;
    }

    @Step("Проверить текст ошибки")
    public void verifyErrorPageWithText(String expectedErrorText) {
        errorText.shouldBe(Condition.visible);
        String actualErrorText = errorText.getText();
        Assertions.assertEquals(expectedErrorText, actualErrorText, "An error occurred");
    }

}