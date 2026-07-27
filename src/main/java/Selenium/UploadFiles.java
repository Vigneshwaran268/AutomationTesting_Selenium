package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class UploadFiles {

    public static void main(String[] args) throws IOException, InterruptedException {



        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Test_Data\\config.properties");
        prop.load(file);

        WebDriver driver = new ChromeDriver();
        driver.get(prop.getProperty("FileUpload_URL"));
        driver.manage().window().maximize();

        File pdfMainPageScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(pdfMainPageScreenshot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\PdfMainPageScreenshot.png"));

        driver.findElement(By.xpath("(//a[@href='/word_to_pdf'])[3]")).click();

        WebElement uploadbtn = driver.findElement(By.xpath("//input[@type='file']"));
        File uploadButtonScreenshot = uploadbtn.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(uploadButtonScreenshot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\UploadButtonScreenshot.png"));
        uploadbtn.sendKeys("C:\\Users\\sivar\\Desktop\\Java Notes.docx");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Convert to PDF']")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement downloadbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@slot='downloadUrl']")));
        File downloadButtonScreenshot = downloadbtn.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(downloadButtonScreenshot, new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots//DownloadButtonScreenshot.png"));
        downloadbtn.click();
        Thread.sleep(5000);

        File downloadPageScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        BufferedImage image = ImageIO.read(downloadPageScreenshot);
        int X = 80, Y = 70, W = 495, H = 82;
        BufferedImage cropImage = image.getSubimage(X,Y,W,H);
        ImageIO.write(cropImage,"png",new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\downloadPageScreenshot.png"));










        driver.quit();




    }
}
