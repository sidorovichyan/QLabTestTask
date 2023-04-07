package form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewLetterForm extends BaseForm {
    private static final String xPathNewLetterFormString = "//div[contains(@class,'focus-zone')]";
    private static final String xPathInputToWhomLetterString = "//label//input";
    private static final String xPathInputSubjectLetterString = "//input[@name = 'Subject']";
    private static final String xPathBodyLetterString = "//div[@role='textbox']";
    private static final String xPathSendButtonString = "//button[@data-test-id='send']";

    private static final By xPathNewLetterForm = By.xpath(xPathNewLetterFormString);
    private By xPathInputToWhomLetter = By.xpath(xPathNewLetterFormString + xPathInputToWhomLetterString);
    private By xPathInputSubjectLetter = By.xpath(xPathNewLetterFormString + xPathInputSubjectLetterString);
    private By xPathBodyLetter = By.xpath(xPathNewLetterFormString + xPathBodyLetterString);
    private By xPathSendButton = By.xpath(xPathNewLetterFormString + xPathSendButtonString);


    public NewLetterForm(WebDriver driver) {
        super(driver, xPathNewLetterForm);
    }

    public void fillToWhomLetter(String email) {
        WebElement inputToWhomLetter = driver.findElement(xPathInputToWhomLetter);
        inputToWhomLetter.sendKeys(email);
    }

    public void fillSubjectLetter(String subject) {
        WebElement inputSubjectLetter = driver.findElement(xPathInputSubjectLetter);
        inputSubjectLetter.sendKeys(subject);
    }

    public void fillBodyLetter(String text) {
        WebElement bodyLetter = driver.findElement(xPathBodyLetter);
        bodyLetter.sendKeys(text);
    }

    public void clickSendButton() {
        WebElement sendButton = driver.findElement(xPathSendButton);
        sendButton.click();
    }
}
