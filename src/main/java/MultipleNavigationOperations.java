import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MultipleNavigationOperations {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.navigate().to("https://www.amazon.com/");
        driver.navigate().to("https://www.flipkart.com/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.wikipedia.org");
        Set<String> w = driver.getWindowHandles();
        List<String> l = new ArrayList<>(w);

        for (String tab: l){
            driver.switchTo().window(tab);
            System.out.println(driver.getTitle());
        }

    }
}
