package Task;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;

public class Youtube_1 {

    public static WebDriver driver;


    public static void ss(String imagename) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        //File path = new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\"+imagename+".png");
        File path = new File(System.getProperty("user.dir") + "//ScreenShots//" + imagename + ".png");
        System.out.println(path);
        FileUtils.copyFile(screenshot, path);
    }

    public static void song(String movieName, String songName) throws InterruptedException, IOException {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement apps = driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
        apps.click();
        Thread.sleep(1000);
        ss("Image_1");
        driver.switchTo().frame("app");
        WebElement youTube = driver.findElement(By.xpath("//span[.='YouTube']"));
        youTube.click();
        Thread.sleep(5000);
        ss("Image_2");
        driver.switchTo().defaultContent();
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys(movieName, Keys.ENTER);
        Thread.sleep(3000);
        ss("Image_3");
        WebElement play = driver.findElement(By.xpath("//a[contains(@title,'" + songName + "')]"));
        play.click();
        Thread.sleep(3000);
        WebElement player = driver.findElement(By.className("html5-video-player"));
        System.out.println(player.getAttribute("class"));
        if (player.getAttribute("class").contains("ad-showing")){
            System.out.println("Ad is playing");
            driver.findElement(By.tagName("body")).sendKeys("m");
            System.out.println("Ad muted");
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement skipBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ytp-skip-ad-button']")));
            skipBtn.click();
            System.out.println("Ad Skipped");
            driver.findElement(By.tagName("body")).sendKeys("m");
            System.out.println("Ad unmuted");
        } catch (Exception e) {
            System.out.println("No Skip Ad Button");
        }
        driver.findElement(By.tagName("body")).sendKeys("f");






        Thread.sleep(20000);
        driver.quit();


    }

    public static void csvRead() throws IOException, InterruptedException {
        String path = "src/test/Test_Data/TestData.csv";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line = br.readLine();
        System.out.println(line);
        String[] split = line.split(",");
        System.out.println(split[0]);
        System.out.println(split[1]);
        song(split[0],split[1]);
        br.close();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        csvRead();
    }
}



