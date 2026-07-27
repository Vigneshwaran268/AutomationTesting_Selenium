package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Frame {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/frame");

        WebElement firstFrame = driver.findElement(By.id("firstFr"));
        driver.switchTo().frame(firstFrame);
        WebElement name = driver.findElement(By.name("fname"));
        name.sendKeys("Vignesh");
        driver.findElement(By.name("lname")).sendKeys("S");
        Thread.sleep(2000);

        WebElement innerFrame = driver.findElement(By.xpath("//iframe[@src='/innerframe']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",innerFrame);
        driver.switchTo().frame(innerFrame);
        driver.findElement(By.name("email")).sendKeys("vikki9747@gmail.com");
        Thread.sleep(2000);

        driver.switchTo().parentFrame();
        name.clear();
        name.sendKeys("Vikki");
        Thread.sleep(2000);

        driver.switchTo().defaultContent();
        WebElement title = driver.findElement(By.xpath("//h1[.='Selenium.Frame']"));
        js.executeScript("arguments[0].scrollIntoView(true);",title);
        String title_1 = title.getText();
        System.out.println(title_1);


        driver.quit();
    }
}
