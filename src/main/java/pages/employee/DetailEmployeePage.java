package pages.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class DetailEmployeePage extends BasePage {
    public DetailEmployeePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1wdufod']")
    private WebElement detailEmployeeText;

    @FindBy(id = "delete-employee-button")
    private WebElement deleteEmployeeButton;

    @FindBy(id = "activation-employee-button")
    private WebElement statusEmployeeButton;

    @FindBy(id = "resend-email-button")
    private WebElement resendEmialButton;

    @FindBy(id = "edit-employee-button")
    private WebElement editEmployeeButton;

    @FindBy(id = "confirm-delete-button")
    private  WebElement confirmDeleteButton;

    @FindBy(id = "activation-employee-confirm-button")
    private WebElement confirmActivationButton;

    @FindBy(id = "resend-email-confirm-button")
    private WebElement resendEmailConfirmationButton;

    public void verifyDetailEmployeeTextIsDisplayed(){
        Assert.assertTrue(detailEmployeeText.isDisplayed(), "Detail Employee text is not Displayed");
    }

    public void verifyDeleteEmployeeButtonIsDisplayed(){
        Assert.assertTrue(detailEmployeeText.isDisplayed());
    }

    public void clickDeleteEmployeeButton(){
        deleteEmployeeButton.click();
    }

    public void verifyStatusEmployeeButtonIsDisplayed(){
        Assert.assertTrue(statusEmployeeButton.isDisplayed());
    }

    public void clickStatusEmployeeButton(){
        statusEmployeeButton.click();
    }

    public void verifyResendEmailButtonIsDisplayed(){
        Assert.assertTrue(resendEmialButton.isDisplayed());
    }

    public void clickResenedEmailButton(){
        resendEmialButton.click();
    }

    public void verifyEditEmployeeButtonIsDisplayed(){
        Assert.assertTrue(editEmployeeButton.isDisplayed());
    }

    public void clickEditEmployeeButton(){
        editEmployeeButton.click();
    }

    public void verifyConfirmDeleteButtonIsDisplayed(){
        Assert.assertTrue(confirmDeleteButton.isDisplayed());
    }

    public void clickConfirmationDeleteButton(){
        confirmDeleteButton.click();
    }

    public void verifyConfirmActivationButtonIsDisplayed(){
        Assert.assertTrue(confirmActivationButton.isDisplayed());
    }

    public void clickConfirmationActivationButton(){
        confirmActivationButton.click();
    }

    public void verifyResendEmailConfirmationButtonIsDisplayed(){
        Assert.assertTrue(resendEmailConfirmationButton.isDisplayed());
    }

    public void clickResendEmailConfirmationButton(){
        resendEmailConfirmationButton.click();
    }
}
