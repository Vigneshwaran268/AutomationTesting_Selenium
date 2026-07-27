package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class RobotClass_1 {

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_word");
        driver.manage().window().maximize();
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(2000);
        String path = "C:\\Users\\sivar\\Downloads\\Java Notes.pdf";
        StringSelection s = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);

        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(2000);
        rb.keyPress((KeyEvent.VK_V));
        Thread.sleep(2000);
        rb.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(5000);
        driver.findElement(By.id("processTask")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("download")).click();
        Thread.sleep(3000);
        File downloadPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\downloadPage.png");
        FileUtils.copyFile(downloadPage, dest);






        driver.quit();


    }
}
