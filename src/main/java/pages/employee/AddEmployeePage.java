package pages.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class AddEmployeePage extends BasePage {
    public AddEmployeePage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "chakra-modal--header-:rm:")
    private WebElement addNewEmployeeText;

    @FindBy(id = "name")
    private WebElement nameTextField;

    @FindBy(id = "employeeId")
    private WebElement employeeidTextField;

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberTextField;

    @FindBy(id = "division")
    private WebElement divisionButton;

    //cari tau gimana buat pilih salah satu division
    @FindBy(id = "add-employee-division-select-option-29")
    private WebElement pilihDivision;

    @FindBy(id = "employeeRole")
    private WebElement employeeRoleTextField;

    @FindBy(id = "button-add-employee-submit")
    private WebElement addEmployeeSubmitButton;

    public void verifyAddNewEmployeeTextIsDisplayed(){
        Assert.assertTrue(addNewEmployeeText.isDisplayed(), "Add new employee text is not displayed");
    }

    public void inputNameTextField(String name){
        nameTextField.sendKeys(name);
    }

    public void inputEmployeeIdTextFiled(String id){
        employeeidTextField.sendKeys(id);
    }

    public void inputEmailTextField(String email){
        emailTextField.sendKeys(email);
    }

    public void inputPhoneNumberTextField(Integer number){
        phoneNumberTextField.sendKeys(number.toString());
    }

    public void verifyDivisionButtonIsDisplayed(){
        divisionButton.click();
    }

    public void inputEmployeeRoleTextField(String role){
        employeeRoleTextField.sendKeys(role);
    }

    public void verifyAddEmployeeSubmitIsDisplayed(){
        Assert.assertTrue(addEmployeeSubmitButton.isDisplayed(), "Add Employee Button is not Displayed");
    }

    public void clickAddEmployeeSubmitButton(){
        addEmployeeSubmitButton.click();
    }

    public void clickSalahSatuDivision(){
        pilihDivision.click();
    }
}
