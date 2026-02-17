package framework.core.driver;

import framework.core.config.ConfigLoader;
import framework.core.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        TestConfig config = ConfigLoader.config();

        String browser = config.browser().toLowerCase();
        return switch (browser) {
            case "chrome" -> createChrome(config);
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }

    private static WebDriver createChrome(TestConfig config) {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        if (config.headless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=" + config.windowWidth() + "," + config.windowHeight());

        return new ChromeDriver(options);
    }
}
