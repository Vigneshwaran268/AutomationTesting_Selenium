package Selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Demo_Project {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Read the URL from Config file
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\src\\test\\Test_Data\\config.properties");
        prop.load(file);

        //Opening the browser in incognito mode
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        //Launching browser, load the URL and maximize the browser
        WebDriver driver = new ChromeDriver(opt);
        driver.get(prop.getProperty("DemoProject_Url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String path = "C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots";

        //Click Element--> Text Box, enter all the details, submit, verify the displayed output and take a screenshot
        driver.findElement(By.xpath("(//div[contains(@class,'top-card')])[1]")).click();
        driver.findElement(By.id("item-0")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Vigneshwaran S");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("vikki9747@gmail.com");
        driver.findElement(By.xpath("(//label[@class='form-label'])[3]/following::textarea[1]")).sendKeys("Sivakasi");
        driver.findElement(By.xpath("(//label[@class='form-label'])[3]/following::textarea[2]")).sendKeys("Sivakasi");
        WebElement submitbtn = driver.findElement(By.xpath("//button[.='Submit']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",submitbtn);
        js.executeScript("arguments[0].click();",submitbtn);
        String actualFullname = driver.findElement(By.id("name")).getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(actualFullname,"Name:Vigneshwaran S");
        String emailId = driver.findElement(By.cssSelector("#email")).getText();
        sa.assertEquals(emailId,"Email:vikki9747@gmail.com");
        String currentAddress = driver.findElement(By.cssSelector("#output #currentAddress")).getText();
        sa.assertEquals(currentAddress,"Current Address :Sivakasi");
        String permanentAddress = driver.findElement(By.cssSelector("#output #permanentAddress")).getText();
        sa.assertEquals(permanentAddress,"Permananet Address :Sivakasi");
        sa.assertAll("Text field verification passed");
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\TextFieldPage_Screenshot.png"));

        //Check Box Operations
        WebElement checkboxbtn = driver.findElement(By.xpath("//span[.='Check Box']"));
        js.executeScript("arguments[0].scrollIntoView(true);",checkboxbtn);
        js.executeScript("arguments[0].click();",checkboxbtn);
        WebElement checkBoxPageHeader = driver.findElement(By.xpath("//h1[.='Check Box']"));
        js.executeScript("arguments[0].scrollIntoView(true);",checkBoxPageHeader);
        System.out.println(checkBoxPageHeader.getText());
        driver.findElement(By.xpath("//span[contains(@class,'rc-tree-switcher')]")).click();
        driver.findElement(By.xpath("//span[@role='checkbox']")).click();
        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        sa.assertTrue(result.contains("home"));
        sa.assertTrue(result.contains("desktop"));
        sa.assertTrue(result.contains("documents"));
        sa.assertTrue(result.contains("downloads"));
        sa.assertAll();
        File checkboxpageScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(checkboxpageScreenshot,new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\CheckboxPage_Screenshot.png"));

        //Radio button operations
        driver.findElement(By.xpath("//span[.='Radio Button']")).click();
        driver.findElement(By.cssSelector("#yesRadio")).click();
        String actualResult = driver.findElement(By.className("mt-3")).getText();
        System.out.println(actualResult);
        sa.assertEquals(actualResult,"You have selected Yes");
        sa.assertAll();
        driver.findElement(By.xpath("//input[@id='impressiveRadio']")).click();
        String actualResult1 = driver.findElement(By.className("mt-3")).getText();
        System.out.println(actualResult1);
        sa.assertEquals(actualResult1,"You have selected Impressive");
        sa.assertAll();
        WebElement noRadioBtn = driver.findElement(By.xpath("//input[@id='noRadio']"));
        System.out.println(noRadioBtn.isEnabled());
        File radioBtnpage = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(radioBtnpage,new File(path+"\\RadioButtonPage_Screenshot.png"));







        //Close the browser
        driver.quit();


    }
}
