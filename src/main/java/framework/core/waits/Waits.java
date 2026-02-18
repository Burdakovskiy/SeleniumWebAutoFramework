package framework.core.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waits {

    private final WebDriverWait wait;

    public Waits(WebDriverWait wait) {
        this.wait = wait;
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement present(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public boolean gone(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean textToBe(By locator, String text) {
        return wait.until(ExpectedConditions.textToBe(locator, text));
    }

    public boolean textContains(By locator, String textPart) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, textPart));
    }

    public boolean valueToBe(By locator, String value) {
        return wait.until(ExpectedConditions.attributeToBe(locator, "value", value));
    }

    public boolean attributeContains(By locator, String attr, String part) {
        return wait.until(ExpectedConditions.attributeContains(locator, attr, part));
    }
}
