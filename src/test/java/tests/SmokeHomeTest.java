package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import tests.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeHomeTest extends BaseTest {
    @Test
    void homePage_shouldOpen() {
        open("/");

        WebElement h1 = waits.visible(By.xpath("(//h1)[1]"));

        assertThat(driver.getTitle()).isNotBlank();
        assertThat(h1.getText()).isNotBlank();
        System.out.println(h1.getText());
    }
}
