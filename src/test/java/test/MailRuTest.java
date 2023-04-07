package test;

import form.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.data.ConfigDataHelper;
import util.data.TestDataHelper;

public class MailRuTest {

    private static final Logger logger = Logger.getLogger(MailRuTest.class);

    private WebDriver driver;

    @BeforeClass
    public void beforeClassMethod() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(ConfigDataHelper.getInstance().getValue("url-page"));
    }

    @AfterClass
    public void afterClassMethod() {
        driver.quit();
    }

    @Test
    public void sendingMailTest() {
        logger.info("Navigate to mail.ru");
        MailBoxForm mainForm = new MailBoxForm(driver);
        mainForm.waitForDisplay();
        mainForm.clickLogInButton();

        logger.info("Fill user data to login");
        LoginForm loginForm = new LoginForm(driver);
        loginForm.waitForDisplay();
        loginForm.switchToFrame();
        loginForm.fillUserLogin(TestDataHelper.getInstance().getValue("user-login"));
        loginForm.clickNextButton();
        loginForm.fillUserPassword(TestDataHelper.getInstance().getValue("user-password"));
        loginForm.clickNextButton();
        driver.switchTo().defaultContent();

        logger.info("Open 'new letter' form");
        ToolbarForm toolbarForm = new ToolbarForm(driver);
        toolbarForm.waitForDisplay();
        toolbarForm.clickNewLetterButton();

        logger.info("Fill letter data");
        NewLetterForm newLetterForm = new NewLetterForm(driver);
        newLetterForm.waitForDisplay();
        newLetterForm.fillToWhomLetter(TestDataHelper.getInstance().getValue("letter-to-whom"));
        newLetterForm.fillSubjectLetter(TestDataHelper.getInstance().getValue("letter-subject"));
        newLetterForm.fillBodyLetter(TestDataHelper.getInstance().getValue("letter-body"));
        logger.info("Click send button");
        newLetterForm.clickSendButton();
        InfoMessageForm infoMessageForm = new InfoMessageForm(driver);
        infoMessageForm.waitForDisplay();
        Assert.assertTrue(infoMessageForm.isOpen(), "Letter not sent");
    }
}
