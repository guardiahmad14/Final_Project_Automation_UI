package pages.training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class DetailTrainingPage extends BasePage {
    public DetailTrainingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//p[@class='chakra-text css-1cyu4s8'][normalize-space()='Training']")
    private WebElement trainingText;

    @FindBy(id = "update-training-button")
    private WebElement editButton;

    public void verifyTrainingTextIsDisplayed(){
        Assert.assertTrue(trainingText.isDisplayed(), "Training Text is not displayed");
    }

    public void editButtonIsDisplayed(){
        Assert.assertTrue(editButton.isDisplayed(), "Edit button is not displayed");
    }

    public By clickEditButton(){
        editButton.click();
        return null;
    }
}
