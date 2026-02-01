package pages.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class EditTrainingPage extends BasePage {
    public EditTrainingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "chakra-modal--header-update-training-modal")
    private WebElement updateTrainingText;

    @FindBy(id = "title")
    private WebElement titleTextField;

    @FindBy(id = "description")
    private WebElement deskripsiTextField;

    @FindBy(id = "update-training-submit-button")
    private WebElement updateTrainingButton;

    public void verifyUpdateTrainingTextIsDisplayed(){
        Assert.assertTrue(updateTrainingText.isDisplayed(), "Update Training text is not Displayed");
    }

    public void inputTitleTextField(String title){
        titleTextField.clear();
        titleTextField.sendKeys(title);
    }

    public void inputDeskripsiTextField(String deskripsi){
        deskripsiTextField.sendKeys(deskripsi);
    }

    public void updateTrainingButtonIsDisplayed(){
        Assert.assertTrue(updateTrainingButton.isDisplayed(), "Update Training Button is not displayed");
    }

    public void clickUpdateTrainingButton(){
        updateTrainingButton.click();
    }
}
