package Task;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Google {

    static WebDriver driver;
    static String movie;
    static String song;

    public static void launchBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    public static void openApps(){
        driver.findElement(By.id("gbwa")).click();
        driver.switchTo().frame("app");
    }


    public static void readcsv() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\src\\test\\Test_Data\\TestData.csv"));
        String line = br.readLine();
        String[] data = line.split(",");
        movie = data[0];
        song = data[1];
        br.close();
    }

    public static void screenshot(String imageName) throws IOException {
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\"+imageName+".png");
        FileUtils.copyFile(screenshot,dest);
    }

    public static void scroll(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public static void youtube() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[text()='YouTube']")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
        readcsv();
        System.out.println("Playing: "+movie+"-"+song);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query")));
        screenshot("YouTubeHomePage");
        searchBox.sendKeys((movie+" "+song), Keys.ENTER);
        WebElement playSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@id='video-title'])[1]")));
        screenshot("YouTubeSongPage");
        playSong.click();
        WebElement player = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".html5-video-player")));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ad-showing")));
            System.out.println("Ad Started");
            long adStartTime = System.currentTimeMillis();
            player.sendKeys("m");
            System.out.println("Ad Muted");
            try {
                WebElement skipAd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ytp-skip-ad-button')]")));
                skipAd.click();
                System.out.println("Ad Skipped");
            }
            catch (Exception e){
                System.out.println("No Skip Ad Button found");
            }
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ad-showing")));
            System.out.println("Ad Finished");
            long adEndTime = System.currentTimeMillis();
            long adDuration = adEndTime - adStartTime;
            System.err.println("Ad Duration: "+(adDuration/1000)+" seconds");
            player.sendKeys("m");
            System.out.println("Video Unmuted");
        } catch (Exception e) {
            System.out.println("No Ad Found");
        }
        WebElement body = driver.findElement(By.tagName("body"));
        body.sendKeys("f");
        Thread.sleep(15000);
        Actions actions = new Actions(driver);
        actions.moveToElement(body).perform();
        WebElement songDuration =wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ytp-time-duration")));
        System.out.println("Song Duration: "+songDuration.getText());
    }

    public static void maps() throws IOException, InterruptedException {
        driver.findElement(By.xpath("//span[text()='Maps']")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
        screenshot("MapsMainPage");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement directionButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Directions']")));
        directionButton.click();
        WebElement fromBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@aria-label,'starting point')]")));
        fromBox.sendKeys("Madurai");
        WebElement toBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@aria-label,'destination')]")));
        toBox.sendKeys("Chennai", Keys.ENTER);
        String totaldistance = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'km')]"))).getText();
        System.out.println("Total Distance: " + totaldistance);
        String[] modesOfTransport = {"Driving", "Two-wheeler", "Transit", "Walking"};
        for (String mode : modesOfTransport){
            WebElement transport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='" + mode + "']")));
            transport.click();
            Thread.sleep(3000);
            WebElement duration = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'Fk3sm')])[1]")));
            System.out.println(mode + " : " + duration.getText());
        }
        Thread.sleep(3000);
        screenshot("MaduraiToChennaiRoute");
        WebElement closeDirectionButton = driver.findElement(By.xpath("//button[@aria-label='Close directions']"));
        closeDirectionButton.click();
        for(int i=1; i<=4; i++){
            WebElement zoomOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label='Zoom out'])[1]")));
            zoomOutButton.click();
        }
        Thread.sleep(3000);
        screenshot("WorldMap");
        WebElement layersButton = driver.findElement(By.xpath("//button[contains(@aria-labelledby,'ucc')]"));
        layersButton.click();
        Thread.sleep(3000);
        screenshot("LayersMap");

    }

    public static void gmail() throws InterruptedException, IOException {
        driver.findElement(By.xpath("//span[text()='Gmail']")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement signinbutton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Sign in'])[1]")));
        signinbutton.click();
        Set<String> tabHandles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<String>(tabHandles);
        driver.switchTo().window(tabs.get(1));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
        email.sendKeys("vikki9747@gmail.com",Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Couldn’t sign you in']")));
        screenshot("GmailLoginPage");

    }

    public static void playstore() throws IOException {
        WebElement photos = driver.findElement(By.xpath("//span[text()='Photos']"));
        scroll(photos);
        driver.findElement(By.xpath("//span[text()='Play']")).click();
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Search']")));
        searchButton.click();
        WebElement searchName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='Search Google Play']")));
        searchName.sendKeys("Pubg",Keys.ENTER);
        WebElement game = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/store/apps/details?id=com.pubg.imobile']")));
        game.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='About this game']")));
        screenshot("GamePage");
    }

    public static void application(String app) throws IOException, InterruptedException {
        launchBrowser();
        openApps();
        switch (app.toLowerCase()){
            case "youtube":
                youtube();
                break;
            case "maps":
                maps();
                break;
            case "gmail":
                gmail();
                break;
            case "playstore":
                playstore();
                break;
            default:
                System.out.println("Temperorly App Not Found");

        }
        driver.quit();

    }

        public static void main (String[]args) throws IOException, InterruptedException {
           application("maps");

        }
}
