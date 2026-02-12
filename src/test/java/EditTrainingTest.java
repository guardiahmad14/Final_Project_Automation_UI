import config.CredentialConfig;
import core.BaseTest;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import pages.training.DetailTrainingPage;
import pages.training.EditTrainingPage;
import pages.training.TrainingPage;

import java.time.Duration;

public class EditTrainingTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(EditTrainingTest.class);

    @Test
    public void success_edit_training(){
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        WebDriver driver = DriverManager.getDriver();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        TrainingPage trainingPage = new TrainingPage(DriverManager.getDriver());
        EditTrainingPage editTrainingPage = new EditTrainingPage(DriverManager.getDriver());
        DetailTrainingPage detailTrainingPage = new DetailTrainingPage(DriverManager.getDriver());
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
        trainingPage.detailTrainingButtonIsDisplayed();
        log.info("Button detail training enable");
        trainingPage.clickDetailTrainingButton();
        log.info("Berhasil klik detail training");

        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("update-training-button")));
        // Gunakan getter untuk mengambil tombol edit
        editButton.click();

        editTrainingPage.verifyUpdateTrainingTextIsDisplayed();
        log.info("Title update training terlihat");
        editTrainingPage.inputTitleTextField("Youtube Bersama");
        log.info("Berhasil edit nama training");
        editTrainingPage.clickUpdateTrainingButton();
        log.info("Klik button training");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='css-d69z09']//div[@class='chakra-stack css-us59mg']")));
        log.info("Notifikasi update training success");

        detailTrainingPage.verifyTrainingTextIsDisplayed();
        log.info("Title manage training terlihat");
    }
}
