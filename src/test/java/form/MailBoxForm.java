package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailBoxForm extends BaseForm {
    private static final String xPathMailBoxString = "//div[@id = 'mailbox']";
    private static final String xPathLogInButtonString = xPathMailBoxString + "//button";

    public MailBoxForm(WebDriver driver) {
        super(driver, By.xpath(xPathMailBoxString));
    }

    public void clickLogInButton() {
        WebElement logInButton = driver.findElement(By.xpath(xPathLogInButtonString));
        logInButton.click();
    }
}
