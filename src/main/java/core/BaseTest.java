package core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public WebDriver driver;

    private static final Logger log = LogManager.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        DriverManager.initDriver(browser);
    }

   @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
