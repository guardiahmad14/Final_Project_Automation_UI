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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.employee.AddEmployeePage;
import pages.dashboard.DashboardPage;
import pages.employee.EmployeePage;
import pages.login.LoginPage;
import tests.ExtentReportListener;
import tests.ScreenshotListener;

import java.time.Duration;


@Listeners({ScreenshotListener.class, ExtentReportListener.class})

public class AddEmployeeTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(AddEmployeeTest.class);

    @Test
    public void add_employee_test_success(){
        log.info("Add Employee Success");
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage = new AddEmployeePage(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        loginPage.inputUsernameTextField(email);
        log.info("Sukses input email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses input password");
        loginPage.clickLoginButton();
        log.info("Sukses klik button login");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Dashboard text terlihat");
        dashboardPage.clickEmployeeMenutButton();
        log.info("Sukses klik menu employee");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
        employeePage.verifyAddEmployeeButtonIsDisplayed();
        log.info("Telihat button add employee");
        employeePage.clickAddEmployeeButton();
        log.info("Sukses klik add employee button");

        addEmployeePage.inputNameTextField("Kinan Test 1");
        log.info("Sukses input nama");
        addEmployeePage.inputEmployeeIdTextFiled("Sup123");
        log.info("Sukses input Employee ID");
        addEmployeePage.inputEmailTextField("kinanahananaa@gmail.com");
        log.info("Sukses input email");
        addEmployeePage.inputPhoneNumberTextField(123456765);
        log.info("SUkses input nomor hp");
        addEmployeePage.inputEmployeeRoleTextField("Staff");
        log.info("Sukses input role");
        addEmployeePage.verifyDivisionButtonIsDisplayed();
        log.info("Terlihat field Division");
        addEmployeePage.clickSalahSatuDivision();
        log.info("Sukses memilih salah satu divisi");
        addEmployeePage.verifyAddEmployeeSubmitIsDisplayed();
        log.info("Button add employee enable");
        addEmployeePage.clickAddEmployeeSubmitButton();
        log.info("Sukses klik button add employee");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='css-d69z09']//div[@class='chakra-stack css-us59mg']")));
        log.info("Notifikasi sukses membuat employee baru");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
    }

    @Test
    public void add_employee_test_failed(){
        log.info("Add Employee Failed");
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        AddEmployeePage addEmployeePage = new AddEmployeePage(DriverManager.getDriver());
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));

        loginPage.inputUsernameTextField(email);
        log.info("Sukses input email");
        loginPage.inputPasswordTextField(password);
        log.info("Sukses input password");
        loginPage.clickLoginButton();
        log.info("Sukses klik button login");

        dashboardPage.verifyDashboardTextIsDisplayed();
        log.info("Dashboard text terlihat");
        dashboardPage.clickEmployeeMenutButton();
        log.info("Sukses klik menu employee");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
        employeePage.verifyAddEmployeeButtonIsDisplayed();
        log.info("Telihat button add employee");
        employeePage.clickAddEmployeeButton();
        log.info("Sukses klik add employee button");

        addEmployeePage.inputNameTextField("Kinan Test 1");
        log.info("Sukses input nama");
        addEmployeePage.inputEmployeeIdTextFiled("Sup123");
        log.info("Sukses input Employee ID");
        addEmployeePage.inputEmailTextField("kinanaaaasdaaa@gmail.com");
        log.info("Sukses input email");
        addEmployeePage.inputPhoneNumberTextField(123456765);
        log.info("SUkses input nomor hp");
        addEmployeePage.inputEmployeeRoleTextField("Staff");
        log.info("Sukses input role");
        addEmployeePage.verifyDivisionButtonIsDisplayed();
        log.info("Terlihat field Division");
        addEmployeePage.clickSalahSatuDivision();
        log.info("Sukses memilih salah satu divisi");
        addEmployeePage.verifyAddEmployeeSubmitIsDisplayed();
        log.info("Button add employee enable");
        addEmployeePage.clickAddEmployeeSubmitButton();
        log.info("Sukses klik button add employee");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@class='chakra-text css-7knslz']")));
        log.info("Notifikasi duplicate email");
    }

}
