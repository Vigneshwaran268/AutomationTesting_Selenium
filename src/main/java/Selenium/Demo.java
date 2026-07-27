package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.knowledgeware.in/Automation/practiceform.html?utm_source=chatgpt.com");
        driver.manage().window().maximize();
        WebElement name = driver.findElement(By.id("fname"));
        name.sendKeys("Vignesh");
        String str = name.getAttribute("value");
        System.out.println(str);
        driver.findElement(By.name("lname")).sendKeys("S");
        driver.findElement(By.cssSelector("#email")).sendKeys("vikki@gmail.com");
        driver.findElement(By.cssSelector("input[type='radio']")).click();
        driver.findElement(By.id("mobile")).sendKeys("987654321");
        driver.findElement(By.cssSelector("input[type='date']")).sendKeys("10.01.2001");
        driver.findElement(By.id("subjects")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("input[value='sports']")).click();
        driver.findElement(By.cssSelector("#music")).click();
        driver.findElement(By.id("picture")).sendKeys("C:\\Users\\sivar\\Pictures\\Screenshots\\Screenshot 2026-06-18 141026.png");
        driver.findElement(By.tagName("textarea")).sendKeys("Chennai");
        WebElement selectState = driver.findElement(By.id("countrySelect"));
        Select dropDown1 = new Select(selectState);
        dropDown1.selectByVisibleText("Karnataka");
        WebElement selectCity = driver.findElement(By.id("citySelect"));
        Select dropDown2 = new Select(selectCity);
        dropDown2.selectByIndex(0);
        WebElement title = driver.findElement(By.id("textb"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",title);
        System.out.println(title.getText());
        WebElement submitBtn = driver.findElement(By.name("submit"));
        js.executeScript("arguments[0].scrollIntoView(true);",submitBtn);
        try {
            submitBtn.click();
            System.out.println("Form Submitted");
        }
        catch (Exception e){
            System.out.println("Form Not Submitted");
        }
        driver.quit();

    }
}
