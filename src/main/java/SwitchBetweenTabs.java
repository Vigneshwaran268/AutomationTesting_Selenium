import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SwitchBetweenTabs {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.amazon.com/");
        Set<String> window = driver.getWindowHandles();
        List<String> window_1 = new ArrayList<>(window);
        driver.switchTo().window(window_1.get(0));
        String googleTitle = driver.getTitle();
        driver.switchTo().window(window_1.get(1));
        Thread.sleep(2000);
        String amazonTitle = driver.getTitle();
        System.out.println(googleTitle);
        System.out.println(amazonTitle);
        driver.quit();


    }
}
