package tests.test;

import com.codeborne.selenide.CollectionCondition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class OldWikiSearchTests extends TestBase {

    @Test
    @Disabled
    void oldSearchTest() {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId("Search Wikipedia")).click();
            $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"))
                    .sendKeys("BrowserStack");
        });
        step("Assert textView", () -> {
            $$(AppiumBy.className("android.widget.TextView"))
                    .shouldHave(CollectionCondition.sizeGreaterThan(0));
        });
    }

}
