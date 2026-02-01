package pages.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class EditEmployeePage extends BasePage {
    public EditEmployeePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "chakra-modal--header-:r6q:")
    private WebElement editEmployeeText;

    @FindBy(id = "edit-employee-name-input")
    private WebElement editNameTextField;

    @FindBy(id = "edit-employee-employee-id-input")
    private WebElement editEmployeeidTextField;

    @FindBy(id = "edit-employee-email-input")
    private WebElement editEmailTextField;

    @FindBy(id = "edit-employee-save-changes-button")
    private WebElement saveChangesButton;

    public void verifyEditEmployeeTextIsDisplayed(){
        Assert.assertTrue(editEmployeeText.isDisplayed(), "Edit Employee Text is not displayed");
    }

    public void inputNameTextField(String name){
        editNameTextField.sendKeys(name);
    }

    public void inputEmployeeidTextField(String id){
        editEmailTextField.sendKeys(id);
    }

    public void inputEmailTextField(String email){
        editEmailTextField.sendKeys(email);
    }

    public void verifySaveChangesButton(){
        Assert.assertTrue(saveChangesButton.isDisplayed());
    }

    public void clickSaveChangesButton(){
        saveChangesButton.click();
    }

}
