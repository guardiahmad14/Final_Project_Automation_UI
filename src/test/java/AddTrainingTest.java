import config.CredentialConfig;
import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import pages.training.AddTrainingPage;
import pages.training.TrainingPage;

import java.time.Duration;

public class AddTrainingTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(AddTrainingTest.class);

    @Test
    public void add_training_success(){
        log.info("Add Employee");
        CredentialConfig CredentialsConfig = null;
        String email = CredentialsConfig.EMAIL;
        String password = CredentialsConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        TrainingPage trainingPage = new TrainingPage(DriverManager.getDriver());
        AddTrainingPage addTrainingPage = new AddTrainingPage(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        loginPage.inputUsernameTextField(email);
        log.info("Sukses Memasukkan Email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses Memasukkan Password");
        loginPage.clickLoginButton();
        log.info("Sukses Klik Button");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Dashboard text terlihat");
        dashboardPage.clickTrainingMenuButton();
        log.info("Berhasil klik training menu");

        trainingPage.verifyManageTrainingTextIsDisplayed();
        log.info("Title manage training terlihat");
        trainingPage.addTrainingButtonIsDisplayed();
        log.info("Add training button enable");
        trainingPage.clickAddTrainingButton();
        log.info("Berhasil klik add training");

        addTrainingPage.inputTitleTextField("Berselancar di Yogya");
        log.info("Berhasil input nama training");
        addTrainingPage.inputDescriptionTextField("jam 2 pagi");
        log.info("Berhasil input deskripsi training");
        addTrainingPage.verfifyTrainingSubmitButtonIsDisplayed();
        log.info("Submit button enable");
        addTrainingPage.clickAddTrainingSubmitButton();
        log.info("Berhasil klik add training");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='css-1ialerq']")));
        log.info("Berhasil membuat training baru");

        trainingPage.verifyManageTrainingTextIsDisplayed();
    }
}
