package tests;


import core.BaseTest;
import core.DriverManager;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.ITestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {}

    @Override
    public void onStart(org.testng.ITestContext context) {}
    @Override
    public void onFinish(org.testng.ITestContext context) {}

    @Override
    public void onTestSuccess(ITestResult result){
        TakeScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result){
        TakeScreenshot(result);
    }

    private void TakeScreenshot(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();

        try {
            if (driver != null){
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                String fileName = "screenshots/" + result.getName() + "_" + System.currentTimeMillis() + ".png";

                Files.createDirectories(Paths.get("screenshots"));

                Files.write(Paths.get(fileName), screenshot);

                System.out.println("Screenshot saved to: " + fileName);
            } else {
                System.out.print("Driver is null , cannot take screenshot");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



