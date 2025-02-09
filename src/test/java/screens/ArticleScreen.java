package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class ArticleScreen {
    private final SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text")),
    articleTitle = $(className("android.webkit.WebView"));


    @Step("Проверить текст ошибки на экране статьи")
    public void verifyErrorPageWithText(String expectedErrorText) {
        errorText.shouldBe(Condition.visible);
        String actualErrorText = errorText.getText();
        assertThat(actualErrorText).isEqualTo("An error occurred");
    }

    @Step("Проверить название статьи {0}")
    public ArticleScreen checkArticleTitle(String expectedTitle) {
        articleTitle.shouldHave(text(expectedTitle));
        return this;
    }

}
