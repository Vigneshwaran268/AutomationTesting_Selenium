package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class WindowHandling {

    public static void main(String[] args) throws IOException, InterruptedException {

        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\Test_Data\\config.properties");
        prop.load(file);

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("Google_URL"));
        Thread.sleep(2000);
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(prop.getProperty("Flipkart_URL"));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(prop.getProperty("Amazon_URL"));

        Set<String> window = driver.getWindowHandles();
        List<String> window_1 = new ArrayList<>(window);

        for (String windows: window_1){
            driver.switchTo().window(windows);
            Thread.sleep(2000);
        }
        driver.quit();
    }
}
