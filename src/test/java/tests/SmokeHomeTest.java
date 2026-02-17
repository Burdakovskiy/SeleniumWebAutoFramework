package tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class SmokeHomeTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1400,900");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterEach
    void tearDown() {
        if (driver != null ) {
            driver.quit();
        }
    }

    @Test
    void homePage_shouldOpen() {
        driver.get("https://practice.expandtesting.com/");

        WebElement h1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]"))
        );

        assertThat(driver.getTitle()).isNotBlank();
        assertThat(h1.getText()).isNotBlank();
        System.out.println(h1.getText());
    }
}
