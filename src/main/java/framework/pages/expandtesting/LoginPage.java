package framework.pages.expandtesting;

import framework.core.waits.Waits;
import framework.pages.base.BasePage;
import framework.pages.base.Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String PATH = "/login";

    private static final By USERNAME = By.xpath("//input[@id='username']");
    private static final By PASSWORD = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//button[@id='submit-login']");
    private static final By FLASH_MESSAGE = By.xpath("//div[@id='flash-message']");

    public LoginPage(WebDriver driver, Waits waits, Pages pages) {
        super(driver, waits, pages);
    }

    public LoginPage waitUntilLoaded() {
        waits.visible(USERNAME);
        waits.visible(PASSWORD);
        return this;
    }

    public LoginPage open() {
        openPath(PATH);

        waits.visible(USERNAME);
        return this;
    }

    public boolean isLoaded() {
        return isVisible(USERNAME) && isVisible(PASSWORD);
    }

    public LoginPage setUsername(String username) {
        type(USERNAME, username);
        return this;
    }

    public LoginPage setPassword(String password) {
        type(PASSWORD, password);
        return this;
    }

    //Вынести создание страницы отсюда
    public SecureAreaPage submitExpectSuccess() {
        click(LOGIN_BUTTON);
        return pages.secureArea().waitUntilLoaded();
    }

    public LoginPage submitExpectFailure() {
        click(LOGIN_BUTTON);
        waits.visible(FLASH_MESSAGE);
        return pages.login();
    }

    public String flashMessage() {
        return text(FLASH_MESSAGE);
    }
}
