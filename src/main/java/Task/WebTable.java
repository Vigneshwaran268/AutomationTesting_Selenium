package Task;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {

    public static void table(String input, String input_1) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/webtable");

        WebElement myTable = driver.findElement(By.id("myTable"));

        // Get all headers
        List<WebElement> headers = myTable.findElements(By.xpath(".//thead//th"));

        int ind = 0;

        for (WebElement header : headers) {
            ind++;

            if (header.getText().equalsIgnoreCase(input_1)) {
                break;
            }
        }

        // Get all rows
        List<WebElement> rows = myTable.findElements(By.xpath(".//tbody/tr"));

        for (WebElement row : rows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));

            boolean found = false;

            // Search the entire row
            for (WebElement cell : cells) {

                if (cell.getText().contains(input)) {
                    found = true;
                    break;
                }
            }

            if (found) {

                if (input_1.equalsIgnoreCase("Select")) {

                    row.findElement(By.xpath("./td[1]//input")).click();
                    System.out.println("Checkbox selected for : " + input);

                } else {

                    System.out.println(input_1 + " : " + cells.get(ind - 1).getText());
                }

                break;
            }
        }

        driver.quit();
    }

    public static void main(String[] args) {

        table("Product Owner", "Name");


    }
}