package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InfoMessageForm extends BaseForm {
    private static final By xPathInfoSendMessage = By.xpath("//div[contains(@class,'layer-sent-page')]");

    public InfoMessageForm(WebDriver driver) {
        super(driver, xPathInfoSendMessage);
    }
}

