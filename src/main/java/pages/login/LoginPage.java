package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "input-username-or-email")
    private WebElement usernameTextField;

    @FindBy(id = "input-password")
    private WebElement passwordTextField;

    @FindBy(id = "button-sign-in")
    private  WebElement loginButton;

    public void verifyUsernameTextFieldIsDisplayed(){
        Assert.assertTrue(usernameTextField.isDisplayed(), "Username TextField is not displayed");
    }

    public void inputUsernameTextField(String uname){
        usernameTextField.sendKeys(uname);
    }

    public void verifyPasswordTextFieldIsDisplayed(){
        Assert.assertTrue(passwordTextField.isDisplayed(), "Password TextField is not displayed");
    }
    public void inputPasswordTextField(String pass){
        passwordTextField.sendKeys(pass);
    }

    public void verifyLoginButtonIsDisplayed(){
        Assert.assertTrue(loginButton.isDisplayed(), "Login Button is not displayed");
    }

    public void clickLoginButton(){
        loginButton.click();
    }
}
