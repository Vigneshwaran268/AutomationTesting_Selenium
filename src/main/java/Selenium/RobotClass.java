package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

    public class RobotClass {

        public static void main(String[] args) throws InterruptedException, AWTException, IOException {

            WebDriver driver =new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("https://www.ilovepdf.com/word_to_pdf");
            Thread.sleep(3000);
            WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
            //Button
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
            element.click();
            Thread.sleep(2000);
            String path= "C:\\Users\\sivar\\Desktop\\Java Notes.docx";
            StringSelection sel=new StringSelection(path);
            Thread.sleep(1000);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);

            Robot rb=new Robot();
            rb.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            rb.keyPress(KeyEvent.VK_V);
            Thread.sleep(2000);
            rb.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);

            WebElement processTask = driver.findElement(By.id("processTask"));
            processTask.click();




            driver.findElement(By.id("download")).click();
            Thread.sleep(2000);
            File downloadPage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(downloadPage,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\downloadPage.png\\"));




            driver.quit();











        }



    }

