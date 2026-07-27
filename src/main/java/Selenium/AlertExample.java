package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Alert ale = driver.switchTo().alert();
        Thread.sleep(2000);
        String msg1 = ale.getText();
        System.out.println(msg1);
        Thread.sleep(2000);
        ale.accept();
        Thread.sleep(3000);

        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(5000);
        Alert ale1 = driver.switchTo().alert();
        Thread.sleep(2000);
        String msg2 = ale1.getText();
        System.out.println(msg2);
        ale1.accept();
        Thread.sleep(3000);

        driver.findElement(By.id("confirmButton")).click();
        Alert ale2 = driver.switchTo().alert();
        Thread.sleep(2000);
        String msg3 = ale2.getText();
        System.out.println(msg3);
        ale2.dismiss();
        Thread.sleep(3000);

        driver.findElement(By.id("promtButton")).click();
        Alert ale3 = driver.switchTo().alert();
        Thread.sleep(2000);
        ale3.sendKeys("Vikki");
        Thread.sleep(2000);
        ale3.accept();

        driver.quit();




    }
}
