package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {

    public static void main(String[] args) {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.gooogle.com/";
        SoftAssert sa = new SoftAssert();
        sa.assertFalse(expectedUrl.contains("google"), "Invalid Url");
        driver.quit();
        sa.assertAll();

    }
}
