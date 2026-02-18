package tests.base;

import framework.core.config.ConfigLoader;
import framework.core.driver.DriverFactory;
import framework.core.waits.Waits;

import framework.pages.base.Pages;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Waits waits;
    protected Pages pages;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();

        int timeout = ConfigLoader.config().timeoutSeconds();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        waits = new Waits(wait);

        pages = new Pages(driver, waits);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
