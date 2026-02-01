package pages.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class AddDivisionPage extends BasePage {
    public AddDivisionPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "name")
    private WebElement nameTextField;

    @FindBy(id = "description")
    private WebElement divisionDescriptionTextField;

    @FindBy(id = "add-division-confirm-button")
    private WebElement addDivisionButton;

    public void verifyNameTextFieldIsDisplayed(){
        Assert.assertTrue(nameTextField.isDisplayed(), "Name text field is not displayed");
    }

    public void inputNameTextField(String name){
        nameTextField.sendKeys(name);
    }

    public void verifyDivisionDescriptionIsDisplayed(){
        Assert.assertTrue(divisionDescriptionTextField.isDisplayed(), "Division Description is not displayed");
    }

    public void inputDivisionDescriptionTextField(String desc){
        divisionDescriptionTextField.sendKeys(desc);
    }

    public void verifyAddDivisionButtonIsDisplayed(){
        Assert.assertTrue(addDivisionButton.isDisplayed(), "Add division button is not displayed");
    }

    public void clickAddDivisionButton(){
        addDivisionButton.click();
    }

}
