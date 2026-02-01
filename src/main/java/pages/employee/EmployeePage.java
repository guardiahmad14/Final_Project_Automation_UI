package pages.employee;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class EmployeePage extends BasePage {
    public EmployeePage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1wdufod']")
    private WebElement manageEmployeeListText;

    @FindBy(id = "button-add-employee")
    private WebElement addEmployeeButton;

    @FindBy(id = "tabs-admin-employee--tab-1")
    private WebElement tabDivision;

    @FindBy(xpath = "//p[@class='chakra-text css-1wdufod']")
    private  WebElement manageDivisionText;

    @FindBy(id = "add-division-button")
    private WebElement addDivisionButton;

    @FindBy(id = "button-detail-employee-2")
    private WebElement detailEmployeeButton;

    @FindBy(id = "menu-button-admin-employee-action")
    private WebElement actionButton;

    @FindBy(id = "menu-list-admin-employee-action-menuitem-:r1s:")
    private WebElement downloadButton;

    @FindBy(id = "menu-button-:r1k:")
    private WebElement filterAngkatanButton;

    @FindBy(id = "menu-list-:r1k:-menuitem-:r1m:")
    private WebElement pilihAngkatanButton;

    public void verifyManageEmployeeListTextIsDisplayed(){
        Assert.assertTrue(manageEmployeeListText.isDisplayed(), "Employee List Text is not Displayed");
    }

    public void verifyAddEmployeeButtonIsDisplayed(){
        Assert.assertTrue(addEmployeeButton.isDisplayed(), "Add employee button is not Displayed");
    }

    public void clickAddEmployeeButton(){
        addEmployeeButton.click();
    }

    public void verifyDivisionButtonIsDisplayed(){
        Assert.assertTrue(tabDivision.isDisplayed(), "Tab division button is not Displayed");
    }

    public void clickDivisionButton(){
        tabDivision.click();
    }

    public void verifyManageDivisionTextIsDisplayed(){
        Assert.assertTrue(manageEmployeeListText.isDisplayed(), "Manage Division Text is not Displayed");
    }

    public void verifyAddDivisionButtonIsDisplayed(){
        Assert.assertTrue(addDivisionButton.isDisplayed(), "Division button is not displayed");
    }

    public void clickAddDivisionButton(){
        addDivisionButton.click();
    }

    public void verifyDetailEmployeeButtonIsDisplayed(){
        Assert.assertTrue(detailEmployeeButton.isDisplayed(), "Detail employee button is not displayed");
    }

    public void clickDetailEmployee(){
        detailEmployeeButton.click();
    }

    public void verifyActionButtonIsDisplayed(){
        Assert.assertTrue(actionButton.isDisplayed(), "Action button is not displayed");
    }

    public void clickActionButton(){
        actionButton.click();
    }

    public void verifyDownloadButtonIsDisplayed(){
        Assert.assertTrue(downloadButton.isDisplayed(), "Download button is not displayed");
    }

    public void clickDownloadButton(){
        downloadButton.click();
    }

    public void verifyFilterAngkatanButtonIsDisplayed(){
        Assert.assertTrue(filterAngkatanButton.isDisplayed(), "Filter angkatan is not Displayed");
    }

    public void clickFilterAngkatanButton(){
        filterAngkatanButton.click();
    }

    public void verifyPilihanAngkatanButtonIsDisplayed(){
        Assert.assertTrue(pilihAngkatanButton.isDisplayed(), "Pilih angkatan is not displayed");
    }

    public void clickPilihAngkatanButton(){
        filterAngkatanButton.click();
    }
}
