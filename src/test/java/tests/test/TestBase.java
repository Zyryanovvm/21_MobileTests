package tests.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.drivers.BrowserStackMobileDriver;
import tests.drivers.EmulationMobileDriver;
import tests.drivers.RealMobileDriver;
import tests.drivers.SelenoidMobileDriver;
import tests.helpers.Attach;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static io.qameta.allure.Allure.step;
import static tests.helpers.Attach.sessionId;

public class TestBase {
    static String driver = System.getProperty("deviceHost", "emulation");

    @BeforeAll
    public static void setup() {
        if (driver.equals("browserstack")) {
            Configuration.browser = BrowserStackMobileDriver.class.getName();
        } else if (driver.equals("emulation")) {
            Configuration.browser = EmulationMobileDriver.class.getName();
        } else if (driver.equals("real")) {
            Configuration.browser = RealMobileDriver.class.getName();
        } else if (driver.equals("selenoid")) {
            Configuration.browser = SelenoidMobileDriver.class.getName();
        } else {
            System.out.println("Невозможно запустить тест, так как вы ввели некорректное название стенда!");
        }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String sessionId = sessionId();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        step("Close driver", Selenide::closeWebDriver);

        if (driver.equals("browserstack")) {
            Attach.video(sessionId);
        }
    }

}
