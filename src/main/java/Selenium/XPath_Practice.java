package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XPath_Practice {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form?utm_source=chatgpt.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Vignesh");
        driver.findElement(By.xpath("//input[@id='firstName']/following::input[1]")).sendKeys("S");
        driver.findElement(By.xpath("//input[@id='firstName']/following::input[2]")).sendKeys("vikki@gmail.com");
        driver.findElement(By.xpath("//input[@id='userNumber']/preceding::input[3]")).click();
        driver.findElement(By.xpath("(//input[contains(@class,'form-control')])[4]")).sendKeys("9876543210");
        WebElement dob = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        dob.click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        Select s1 = new Select(month);
        s1.selectByValue("0");
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        Select s2 = new Select(year);
        s2.selectByVisibleText("2001");
        driver.findElement(By.xpath("(//div[.='10'])[1]")).click();
        String dob1 = dob.getAttribute("value");
        System.out.println(dob1);
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys("English");
        subject.sendKeys(Keys.ENTER);
        WebElement sub = driver.findElement(By.xpath("//div[contains(@class,'value-container--is-multi subjects')]"));
        System.out.println(sub.getText());
        WebElement sports = driver.findElement(By.xpath("//label[.='Sports']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",sports);
        WebElement music = driver.findElement(By.xpath("//label[.='Music']"));
        js.executeScript("arguments[0].click()",music);
        driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\sivar\\Downloads\\image.png");
        driver.findElement(By.xpath("//textarea[@placeholder='Current Address']")).sendKeys("Chennai");
        WebElement state = driver.findElement(By.id("react-select-3-input"));
        state.sendKeys("Uttar Pradesh");
        state.sendKeys(Keys.ENTER);
        WebElement city = driver.findElement(By.id("react-select-4-input"));
        city.sendKeys("Agra");
        city.sendKeys(Keys.ENTER);
        WebElement submitbtn = driver.findElement(By.xpath("//button[@id='submit']"));
        js.executeScript("arguments[0].scrollIntoView(true);",submitbtn);
        js.executeScript("arguments[0].click();", submitbtn);
        WebElement thanksmsg = driver.findElement(By.xpath("//div[starts-with(text(),'Thanks for')]"));
        System.out.println(thanksmsg.getText());
        driver.findElement(By.xpath("//button[@id='closeLargeModal']")).click();
        driver.quit();

    }
}

