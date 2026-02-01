package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static void initDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/driver/chromedriver.exe");
            driver.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/driver/geckodriver.exe");
            driver.set(new FirefoxDriver());
        } else {
            throw new IllegalArgumentException("Unsupported browser" + browser);
        }

        driver.get().get("https://lms-b2b.do.dibimbing.id/dibimbingqa/login");
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}
