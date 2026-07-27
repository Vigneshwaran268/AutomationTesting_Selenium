package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUpload_1 {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Test_Data\\config.properties");
        prop.load(file);


        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("FileUpload_URL_1"));
        driver.manage().window().maximize();
        Thread.sleep(5000);

        File fileUploadPageScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(fileUploadPageScreenshot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\FileUploadPageScreenshot.png"));

        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\sivar\\Desktop\\Java Notes.docx");

        WebElement uploadbtn_1 = driver.findElement(By.id("file-submit"));
        File uploadButtonScreenshot_1 = uploadbtn_1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(uploadButtonScreenshot_1, new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\UploadButtonScreenshot_1.png"));
        uploadbtn_1.click();
        Thread.sleep(5000);

        File finalPageScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(finalPageScreenShot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\FinalPageScreenShot.png"));


        driver.quit();

    }
}
