package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/word_to_pdf");
        driver.manage().window().maximize();
        String path = "C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots";
        File mainpage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(mainpage, new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\Image1.png"));

        WebElement button = driver.findElement(By.xpath("//input[@type='file']"));
        File buttonScreenshot = button.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(buttonScreenshot,new File(path+"\\Image2.png"));


       File particularRegionScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       BufferedImage image = ImageIO.read(particularRegionScreenShot);
       int x=35,y=90,h=65,w=15;
       BufferedImage cropImage = image.getSubimage(x,y,h,w);
       ImageIO.write(cropImage,"png",new File(path+"//Image3.png"));



        driver.quit();
    }
}
