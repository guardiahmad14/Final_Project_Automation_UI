import config.CredentialConfig;
import core.BaseTest;
import core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.employee.DetailEmployeePage;
import pages.employee.EditEmployeePage;
import pages.employee.EmployeePage;
import pages.login.LoginPage;

import java.time.Duration;

public class EditEmployeeTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(EditEmployeeTest.class);

    @Test
    public void success_edit_employee(){
        log.info("Edit Employee Success");
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        DetailEmployeePage detailEmployeePage = new DetailEmployeePage(DriverManager.getDriver());
        EditEmployeePage editEmployeePage = new EditEmployeePage(DriverManager.getDriver());
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
        employeePage.clickDetailEmployee();
        log.info("Berhasil klik detail employee");

        detailEmployeePage.verifyDetailEmployeeTextIsDisplayed();
        log.info("Title detail employee terlihat");
        detailEmployeePage.clickEditEmployeeButton();
        log.info("Klik button edit employee");
        detailEmployeePage.verifyDetailEmployeeTextIsDisplayed();
        log.info("Title edit employee terlihat");

        editEmployeePage.inputNameTextField("Rosemarian");
        log.info("Berhasil input nama");
        editEmployeePage.clickSaveChangesButton();
        log.info("Berhasil klik save changes edit employee");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@class='chakra-text css-7knslz']")));
        log.info("Notifikasi success update employee");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("Title manage employee list terlihat");
    }
}
