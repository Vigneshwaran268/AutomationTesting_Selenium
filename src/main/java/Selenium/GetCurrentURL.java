package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetCurrentURL {

    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String title = driver.getTitle();
        System.out.println(title);
        driver.quit();

    }
}
