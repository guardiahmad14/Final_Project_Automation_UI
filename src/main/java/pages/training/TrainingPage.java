package pages.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class TrainingPage extends BasePage {
    public TrainingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1wdufod']")
    private WebElement manageTrainingText;

    @FindBy(id = "add-training-button")
    private WebElement addTrainingButton;

    @FindBy(id = "button-detail-training-0")
    private WebElement detailTrainingButton;

    public void verifyManageTrainingTextIsDisplayed(){
        Assert.assertTrue(manageTrainingText.isDisplayed(), "Manage Training text is not displayed");
    }

    public void addTrainingButtonIsDisplayed(){
        Assert.assertTrue(addTrainingButton.isDisplayed(), "Add Training Button is not displayed");
    }

    public void clickAddTrainingButton(){
        addTrainingButton.click();
    }

    public void detailTrainingButtonIsDisplayed(){
        Assert.assertTrue(detailTrainingButton.isDisplayed(), "Detail Training is not Displayed");
    }

    public void clickDetailTrainingButton(){
        detailTrainingButton.click();
    }
}
