package pages.notif;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class NotificationMessage extends BasePage {
    public NotificationMessage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='css-d69z09']//div[@class='chakra-stack css-us59mg']")
    private WebElement messsageCreateEmployeeSuccess;

    public void verifyMessageSuccessCreateEmployeeAppear(){
        Assert.assertTrue(messsageCreateEmployeeSuccess.isDisplayed(), "Message tidak muncul");
    }

    @FindBy(xpath = "//div[@class='css-1ialerq']")
    private WebElement messageCreateTrainingSuccess;

    public void verifyMessageSuccessCreateTrainingSuccess(){
        Assert.assertTrue(messageCreateTrainingSuccess.isDisplayed(), "Message tidak muncul");
    }

    @FindBy(xpath = "//p[@class='chakra-text css-7knslz']")
    private WebElement messageCreateDivisionSuccess;

    public void verifyMessageCreateDivisionSuccess(){
        Assert.assertTrue(messageCreateDivisionSuccess.isDisplayed(), "Message tidak muncul");
    }

    @FindBy(xpath = "//p[@class='chakra-text css-7knslz']")
    private WebElement messageDuplicateEmail;

    public void verifyDuplicateEmail(){
        Assert.assertTrue(messageDuplicateEmail.isDisplayed(), "Failed create employee duplicate email");
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1bf7e4w']")
    private  WebElement deleteEmployeeSuccess;

    public void verifyMessageDeleteEmployeeSuccess(){
        Assert.assertTrue(deleteEmployeeSuccess.isDisplayed(), "Message tidak muncul");
    }

    @FindBy(xpath = "//div[@class='css-d69z09']//div[@class='chakra-stack css-us59mg']")
    private WebElement updateTraining;

    public void verifyMessageUpdateTrainingSuccess(){
        Assert.assertTrue(updateTraining.isDisplayed(), "Message tidak muncul");
    }

    @FindBy(xpath = "//p[@class='chakra-text css-7knslz']")
    private WebElement updateEmployee;

    public void verifyMessageUpdateEmployeeSuccess(){
        Assert.assertTrue(updateEmployee.isDisplayed(), "Message tidak muncul");
    }
}
