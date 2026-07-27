package Selenium;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Extends_reports {

    public static void main(String[] args) {

        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Reports\\Report_1.html");
        ExtentReports extend = new ExtentReports();
        extend.attachReporter(spark);
        ExtentTest test = extend.createTest("Google Title Verification");
        WebDriver driver = new ChromeDriver();
        test.info("Launching browser");
        driver.get("https://www.google.com");
        test.info("Launching google");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";
        test.info("Actual Title: "+actualTitle);
        SoftAssert sa = new SoftAssert();
        if(actualTitle.equals(expectedTitle)){
            test.pass("Title Verification Passed");
        }
        else{
            test.fail("Title Verification Failed");
        }
        driver.quit();
        extend.flush();
    }
}
