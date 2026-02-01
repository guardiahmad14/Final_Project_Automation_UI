import config.CredentialConfig;
import core.BaseTest;
import core.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import tests.ExtentReportListener;
import tests.ScreenshotListener;

@Listeners({ScreenshotListener.class, ExtentReportListener.class})

public class LoginTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTest.class);

    @Test
    public void success_login(){
        log.info("Success Login");
        CredentialConfig CredentialsConfig = null;
        String email = CredentialsConfig.EMAIL;
        String password = CredentialsConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());

        loginPage.inputUsernameTextField(email);
        log.info("Sukses Memasukkan Email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses Memasukkan Password");
        loginPage.clickLoginButton();
        log.info("Sukses Klik Button");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Pengguna Berhasil Login dan Diarahkan ke Dashboard");
    }

//    @Test
//    public void failed_login(){
//        log.info("Success Login");
//        CredentialConfig CredentialsConfig = null;
//        String email = CredentialsConfig.EMAIL;
//        String password = CredentialsConfig.PASSWORD;
//        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
//        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
//
//        loginPage.inputUsernameTextField("email");
//        log.info("Sukses Memasukkan Email");
//        loginPage.inputPasswordTextField("password");
//        log.info("Sukses Memasukkan Password");
//        loginPage.clickLoginButton();
//        log.info("Sukses Klik Button");
//
//        dashboardPage.verifyDashboardTextIsDisplayed();
//        log.info("Pengguna Berhasil Login dan Diarahkan ke Dashboard");
//    }

    @AfterMethod
    public void closeBrowser(){
        DriverManager.quitDriver();
        log.info("Browser ditutup setelah test selesai");
    }
}
