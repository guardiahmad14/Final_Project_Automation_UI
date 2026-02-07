import config.CredentialConfig;
import core.BaseTest;
import core.DriverManager;
import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.employee.AddDivisionPage;
import pages.dashboard.DashboardPage;
import pages.employee.EmployeePage;
import pages.login.LoginPage;
import pages.notif.NotificationMessage;
import tests.ExtentReportListener;
import tests.ScreenshotListener;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Listeners({ScreenshotListener.class, ExtentReportListener.class})

public class AddDivisionTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(AddDivisionTest.class);

    @Test
    public void add_division_test_success(){
        log.info("Add Division Success");
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        AddDivisionPage addDivisionPage = new AddDivisionPage(DriverManager.getDriver());
        NotificationMessage notificationMessage = new NotificationMessage(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        loginPage.inputUsernameTextField(email);
        log.info("Sukses Memasukkan Email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses Memasukkan Password");
        loginPage.clickLoginButton();
        log.info("Sukses Klik Button");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Pengguna Berhasil Login dan Diarahkan ke Dashboard");
        dashboardPage.clickEmployeeMenutButton();
        log.info("Berhasil klik Employee Button");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
        employeePage.verifyAddEmployeeButtonIsDisplayed();
        log.info("Telihat button add employee");
        employeePage.clickDivisionButton();
        log.info("Berhasil click tab division");
        employeePage.verifyManageDivisionTextIsDisplayed();
        log.info("Title manage division terlihat");
        employeePage.clickAddDivisionButton();
        log.info("Berhasil klik add division");

        addDivisionPage.inputNameTextField("Yayayaya");
        log.info("Berhasil input nama division");
        addDivisionPage.inputDivisionDescriptionTextField("Ini ya ramah tamah");
        log.info("Berhasil input deskripsi division");
        addDivisionPage.clickAddDivisionButton();
        log.info("Berhasil klik button add division");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@class='chakra-text css-7knslz']")));
        log.info("Berhasil membuat division baru");

        employeePage.verifyManageDivisionTextIsDisplayed();
        log.info("Kembali ke halaman manage division");
    }

    @Test
    public void add_division_test_failed(){
        log.info("Add Division Failed");
        CredentialConfig CredentialsConfig = null;
        String email = CredentialsConfig.EMAIL;
        String password = CredentialsConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        AddDivisionPage addDivisionPage = new AddDivisionPage(DriverManager.getDriver());

        loginPage.inputUsernameTextField(email);
        log.info("Sukses Memasukkan Email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses Memasukkan Password");
        loginPage.clickLoginButton();
        log.info("Sukses Klik Button");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Pengguna Berhasil Login dan Diarahkan ke Dashboard");
        dashboardPage.clickEmployeeMenutButton();
        log.info("Berhasil klik Employee Button");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
        employeePage.verifyAddEmployeeButtonIsDisplayed();
        log.info("Telihat button add employee");
        employeePage.clickDivisionButton();
        log.info("Berhasil click tab division");
        employeePage.verifyManageDivisionTextIsDisplayed();
        log.info("Title manage division terlihat");
        employeePage.clickAddDivisionButton();
        log.info("Berhasil klik add division");

        addDivisionPage.inputNameTextField("");
        log.info("Nama division tetap kosong");
        addDivisionPage.inputDivisionDescriptionTextField("Ini ya ramah tamah");
        log.info("Berhasil isi deskripsi division");
        addDivisionPage.clickAddDivisionButton();
        log.info("Berhasil klik add division");
    }

    @AfterMethod
    public void closeBrowser(){
        DriverManager.quitDriver();
        log.info("Browser ditutup setelah test selesai");
    }
}

