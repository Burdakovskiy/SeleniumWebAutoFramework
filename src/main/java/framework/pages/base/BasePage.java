package framework.pages.base;

import framework.core.config.ConfigLoader;
import framework.core.waits.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
    protected final WebDriver driver;
    protected final Waits waits;
    protected final Pages pages;

    protected BasePage(WebDriver driver, Waits waits, Pages pages) {
        this.driver = driver;
        this.waits = waits;
        this.pages = pages;
    }

    protected void openPath(String path) {
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

    public String currentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isVisible(By locator) {
        try {
            return waits.visible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void click(By locator) {
        WebElement el = waits.visible(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center', inline:'center'});", el);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected void type(By locator, String value) {
       WebElement element =  waits.visible(locator);
       element.clear();
       element.sendKeys(value);
    }

    protected void append(By locator, String value) {
        WebElement element = waits.visible(locator);
        element.sendKeys(value);
    }

    protected void clear(By locator) {
        waits.visible(locator).clear();
    }

    protected String text(By locator) {
        return waits.visible(locator).getText();
    }

    protected String value(By locator) {
        return waits.visible(locator).getAttribute("value");
    }
}
