package tests.base;

import framework.core.config.ConfigLoader;
import framework.core.driver.DriverFactory;
import framework.core.waits.Waits;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Waits waits;

    @BeforeEach
    void setUp() {
        driver = DriverFactory.createDriver();

        int timeout = ConfigLoader.config().timeoutSeconds();
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        waits = new Waits(driver, wait);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected void open(String path) {
        String baseUrl = ConfigLoader.config().baseUrl();
        if (path == null || path.isBlank() || "/".equals(path)) {
            driver.get(baseUrl);
        } else if (path.startsWith("http")) {
            driver.get(path);
        } else if (path.startsWith("/")) {
            driver.get(baseUrl + path);
        } else {
            driver.get(baseUrl + "/" + path);
        }
    }
}
