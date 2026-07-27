package Selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Extend_Reports_1 {

    public static void main(String[] args) {

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Reports\\Report_1.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);
        ExtentTest test = extent.createTest("Google Title Verification");
        WebDriver driver = new ChromeDriver();
        test.info("Launching Browser");
        driver.get("https://www.google.com");
        test.info("Launching Google");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gooogle";
        if (actualTitle.equals(expectedTitle)){
            test.pass("Google verification Passed");
        }
        else {
            test.fail("Google Verification Failed");
        }
        extent.flush();
        driver.quit();

    }
}
