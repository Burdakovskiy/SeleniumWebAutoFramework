package framework.pages.base;

import framework.core.waits.Waits;
import framework.pages.expandtesting.LoginPage;
import framework.pages.expandtesting.SecureAreaPage;
import org.openqa.selenium.WebDriver;

public class Pages {
    private final WebDriver driver;
    private final Waits waits;

    public Pages(WebDriver driver, Waits waits) {
        this.driver = driver;
        this.waits = waits;
    }

    public LoginPage login() {
        return new LoginPage(driver, waits, this);
    }

    public SecureAreaPage secureArea() {
        return new SecureAreaPage(driver, waits, this);
    }
}
