package pages.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class AddTrainingPage extends BasePage {
    public AddTrainingPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "chakra-modal--header-add-training-modal")
    private WebElement addNewTrainingText;

    @FindBy(id = "title")
    private WebElement titleTextField;

    @FindBy(id = "description")
    private WebElement deskripsiTextField;

    @FindBy(id = "add-training-close-button")
    private WebElement trainingCloseButton;

    @FindBy(id = "add-training-submit-button")
    private WebElement addTrainingSubmitButton;

    public void verifyAddNewTrainingIsDisplayed(){
        Assert.assertTrue(addNewTrainingText.isDisplayed());
    }

    public void inputTitleTextField(String title){
        titleTextField.sendKeys(title);
    }

    public void inputDescriptionTextField(String deskripsi){
        deskripsiTextField.sendKeys(deskripsi);
    }

    public void verifyTrainingCloseButtonIsDisplayed(){
        trainingCloseButton.click();
    }

    public void verfifyTrainingSubmitButtonIsDisplayed(){
        Assert.assertTrue(addTrainingSubmitButton.isDisplayed());

    }
    public void clickAddTrainingSubmitButton(){
        addTrainingSubmitButton.click();
    }
}
