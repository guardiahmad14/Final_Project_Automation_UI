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
import pages.employee.AddEmployeePage;
import pages.employee.DetailEmployeePage;
import pages.employee.EmployeePage;
import pages.login.LoginPage;

import java.time.Duration;

public class DeleteEmployeeTest extends BaseTest {
    private static final Logger log = LoggerFactory.getLogger(DeleteEmployeeTest.class);

    @Test
    public void success_delete_employee() {
        log.info("Delete Employee");
        CredentialConfig credentialConfig = new CredentialConfig();
        String email = credentialConfig.EMAIL;
        String password = credentialConfig.PASSWORD;
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        EmployeePage employeePage = new EmployeePage(DriverManager.getDriver());
        DetailEmployeePage detailEmployeePage = new DetailEmployeePage(DriverManager.getDriver());
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
        detailEmployeePage.verifyDeleteEmployeeButtonIsDisplayed();
        log.info("Delete button enable");
        detailEmployeePage.clickDeleteEmployeeButton();
        log.info("Konfirmasi delete employee");
        detailEmployeePage.clickConfirmationDeleteButton();
        log.info("Berhasil klik button");

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//p[@class='chakra-text css-1bf7e4w']")));
        log.info("Notifikasi sukses hapus employee");

        employeePage.verifyManageEmployeeListTextIsDisplayed();
        log.info("itle manage employee list terlihat");
    }
}
