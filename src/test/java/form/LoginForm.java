package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginForm extends BaseForm {
    private static final By xPathIframe = By.xpath("//div[contains(@class,'ag_js-popup-frame')]//iframe");
    private final By xPathNextButton = By.xpath("//form//button");

    private final By xPathInputUserLogin = By.xpath("//form//input[@name = 'username']");
    private final By xPathInputUserPassword = By.xpath("//form//input[@name = 'password']");

    private WebElement iFrame = driver.findElement(xPathIframe);

    public LoginForm(WebDriver driver) {
        super(driver, xPathIframe);
    }

    public void switchToFrame() {
        driver.switchTo().frame(iFrame);
    }

    public void clickNextButton() {
        driver.findElement(xPathNextButton).click();
    }

    public void fillUserLogin(String login) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xPathInputUserLogin));
        driver.findElement(xPathInputUserLogin).sendKeys(login);
    }

    public void fillUserPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xPathInputUserPassword));
        driver.findElement(xPathInputUserPassword).sendKeys(password);
    }
}
