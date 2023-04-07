package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseForm {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private By uniqElement;

    public BaseForm(WebDriver driver, By uniqElement) {
        this.driver = driver;
        this.uniqElement = uniqElement;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void waitForDisplay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(uniqElement));
    }

    public boolean isOpen() {
        return driver.findElement(uniqElement).isDisplayed();
    }
}
