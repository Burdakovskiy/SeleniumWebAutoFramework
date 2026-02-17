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
import tests.base.BaseTest;


import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

public class SmokeHomeTest extends BaseTest {
    @Test
    void homePage_shouldOpen() {
        open("/");

        WebElement h1 = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h2)[1]"))
        );

        assertThat(driver.getTitle()).isNotBlank();
        assertThat(h1.getText()).isNotBlank();
        System.out.println(h1.getText());
    }
}
