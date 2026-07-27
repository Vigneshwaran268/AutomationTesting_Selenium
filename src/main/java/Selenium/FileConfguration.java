package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class FileConfguration {

    public static void main(String[] args) throws IOException, InterruptedException {


        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Test_Data\\config.properties");
        prop.load(file);

        String[] users = {prop.getProperty("Admin"), prop.getProperty("HR")};

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (String user: users) {
            driver.get(prop.getProperty("SauceDemo_URL"));
            driver.findElement(By.id("user-name")).sendKeys(user);
            driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
            driver.findElement(By.name("login-button")).click();
            String actualURL = driver.getCurrentUrl();
            Assert.assertTrue(actualURL.contains("saucedemo"),"Invalid URL");
            driver.findElement(By.id("react-burger-menu-btn")).click();
            WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
            logoutBtn.click();
            Thread.sleep(2000);
        }




//        driver.get(prop.getProperty("SauceDemo_URL"));
//        driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("HR"));
//        driver.findElement(By.id("password")).sendKeys(prop.getProperty("Password"));
//        driver.findElement(By.name("login-button")).click();
//        driver.findElement(By.id("react-burger-menu-btn")).click();
//        WebElement logoutBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("logout_sidebar_link")));
//        logoutBtn1.click();

        driver.quit();


    }
}
