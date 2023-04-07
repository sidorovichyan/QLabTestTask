package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToolbarForm extends BaseForm {
    private static final By xPathNewLetterButton = By.xpath("//a[contains(@class,'compose-button')]");

    public ToolbarForm(WebDriver driver) {
        super(driver, xPathNewLetterButton);
    }

    public void clickNewLetterButton() {
        driver.findElement(xPathNewLetterButton).click();
    }
}
