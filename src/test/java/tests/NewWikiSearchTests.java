package tests;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class NewWikiSearchTests extends TestBase {

    @Test
    void searchTest() {
        back();
//        switchTo().alert().accept(); - Команда на закрытие системных всплывающих окон
        step("Type search", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });
        step("Assert textView", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }


    @Test
    void searchInfoForWiki() {
        back();
        step("", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Zyryanov");
        });

        step("Assert textView", () -> {
            String actualText = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .first().text();
            assertThat(actualText).isEqualTo("Konstantin Zyryanov");
        });

    }

    @Test
    void searchInfoWiki() {
        back();
        step("", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/search_container")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("Zyryanov");
        });

        step("Assert textView", () -> {
            String actualText = $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .first().text();
            assertThat(actualText).isEqualTo("Konstantin Zyryanov");
        });

        step("", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/page_list_item_title"))
                    .first().click();
            String actualPage = $(AppiumBy.id("org.wikipedia.alpha:id/tabsCountText"))
                    .text();
            assertThat(actualPage).isEqualTo("1");
        });

    }
}
