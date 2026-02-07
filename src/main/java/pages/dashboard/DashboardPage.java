package pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1cyu4s8']")
    private WebElement dashboardText;

    @FindBy(xpath = "//div[@id='layout-desktop-menu-item-box-employee']//div[@class='chakra-stack css-16awuyr']")
    private WebElement employeeMenuButton;

    @FindBy(xpath = "//div[@id='layout-desktop-menu-item-box-training']//div[@class='chakra-stack css-16awuyr']")
    private WebElement trainingMenuButton;



    public void verifyDashboardTextIsDisplayed(){
        Assert.assertTrue(dashboardText.isDisplayed(), "Dashboard Text is not displayed");
    }

    public void verifyEmployeeMenuButtonIsDisplayed(){
        Assert.assertTrue(employeeMenuButton.isDisplayed(), "Employee button is not displayed");
    }

    public void clickEmployeeMenutButton(){
        employeeMenuButton.click();
    }

    public void verifyTrainingMenuButtonIsDisplayed(){
        Assert.assertTrue(trainingMenuButton.isDisplayed(), "Training button is not displayed");
    }

    public void clickTrainingMenuButton(){
        trainingMenuButton.click();
    }
}
