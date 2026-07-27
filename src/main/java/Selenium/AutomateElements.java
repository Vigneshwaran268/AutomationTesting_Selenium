package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AutomateElements {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> radiobtn = driver.findElements(By.xpath("//input[@type='radio']"));
        for (WebElement w:radiobtn){
            w.click();
            Thread.sleep(2000);
        }

        WebElement country = driver.findElement(By.xpath("//input[contains(@class,'inputs ui-autocomplete-input')]"));
        country.click();
        country.sendKeys("Ind");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='India']")).click();

        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        Select s = new Select(dropdown);
        s.selectByValue("option1");

        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement w1: checkbox){
            w1.click();
            Thread.sleep(2000);
        }












        driver.quit();
    }
}
