package framework.pages.expandtesting;

import framework.core.waits.Waits;
import framework.pages.base.BasePage;
import framework.pages.base.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    private static final String PATH = "/secure";

    private static final By FLASH_MESSAGE = By.xpath("//div[@id='flash-message']");
    private static final By LOGOUT_BUTTON = By.xpath("//a[@href='/logout']");

    public SecureAreaPage(WebDriver driver, Waits waits, Pages pages) {
        super(driver, waits, pages);
    }

    public SecureAreaPage waitUntilLoaded() {
        waits.visible(LOGOUT_BUTTON);
        return this;
    }

    public boolean isLoaded() {
        return currentUrl().contains(PATH) && isVisible(LOGOUT_BUTTON);
    }

    public String flashMessage() {
        return text(FLASH_MESSAGE);
    }

    public LoginPage logout() {
        click(LOGOUT_BUTTON);
        return pages.login().waitUntilLoaded();
    }
}
