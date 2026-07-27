package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class HardAssertion {

    public static void main(String[] args) {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();
        String actualURL = driver.getCurrentUrl();
        String expectedUrl = "https://www.flipkart.com/";
        Assert.assertTrue(actualURL.contains(expectedUrl),"Invalid URL");
        driver.quit();
    }
}
