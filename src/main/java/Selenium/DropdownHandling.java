package Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownHandling {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("(//div[@class='css-hlgwow'])[1]")).click();
        driver.findElement(By.xpath("(//div[.='Group 1, option 1'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='col-md-6 col-sm-12'])[4]")).click();
        driver.findElement(By.xpath("(//div[.='Mr.'])[1]")).click();
        Thread.sleep(2000);

        WebElement color = driver.findElement(By.id("oldSelectMenu"));
        Select s = new Select(color);
        s.selectByVisibleText("Blue");
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@class='css-13cymwt-control'])[3]")).click();
        driver.findElement(By.xpath("//div[.='Green']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[.='Blue']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@aria-label='Remove Green']")).click();
        Thread.sleep(2000);

        WebElement car = driver.findElement(By.name("cars"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",car);
        Select s1 = new Select(car);
        s1.selectByIndex(0);
        Thread.sleep(2000);
        car.sendKeys(Keys.CONTROL);
        s1.selectByValue("opel");
        Thread.sleep(2000);
        car.sendKeys(Keys.CONTROL);
        s1.selectByVisibleText("Audi");
        Thread.sleep(2000);





        driver.quit();

    }
}
