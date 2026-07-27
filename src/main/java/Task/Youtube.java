//package Task;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.*;
//import java.time.Duration;
//import java.util.Arrays;
//
//public class Youtube {
//
//    public static WebDriver driver;
//
//
//    public static void ss(String imagename) throws IOException {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        //File path = new File("C:\\Users\\sivar\\IdeaProjects\\Selenium_AutomationTesting\\ScreenShots\\"+imagename+".png");
//        File path = new File(System.getProperty("user.dir") + "//ScreenShots//" + imagename + ".png");
//        System.out.println(path);
//        FileUtils.copyFile(screenshot, path);
//    }
//
//    public static void song(String movieName, String songName) throws InterruptedException, IOException {
//        driver = new ChromeDriver();
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//        WebElement apps = driver.findElement(By.xpath("//a[@aria-label='Google apps']"));
//        apps.click();
//        Thread.sleep(1000);
//        ss("Image1");
//        driver.switchTo().frame("app");
//        WebElement youTube = driver.findElement(By.xpath("//span[.='YouTube']"));
//        youTube.click();
//        Thread.sleep(5000);
//        ss("Image2");
//        driver.switchTo().defaultContent();
//        WebElement searchBox = driver.findElement(By.name("search_query"));
//        searchBox.sendKeys(movieName, Keys.ENTER);
//        Thread.sleep(3000);
//        ss("Image3");
//        WebElement play = driver.findElement(By.xpath("//a[contains(@title,'" + songName + "')]"));
//        play.click();
//
//        try {
//            driver.findElement(By.id="player-overlay-layout:g")
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//            WebElement skipadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ytp-skip-ad-button')]")));
//            skipadButton.click();
//            System.out.println("Ad Skipped");
//        } catch (Exception e) {
//            System.out.println("No Ad");
//        }
//        Thread.sleep(10000);
//        ss("Image4");
//
//
//        driver.quit();
//
//
//    }
//
//    public static void csvreader() throws IOException, InterruptedException {
//        String path = "src/test/Test_Data/TestData.csv";
//        BufferedReader br = new BufferedReader(new FileReader(path));
////        System.out.println(br.readLine());
//        String data;
//        while ((data=br.readLine())!=null){
//            String[] split = data.split(",");
//            String movieName = split[0];
//            String songName = split[1];
//            song(movieName, songName);
//
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException, IOException {
//
////        song("Don","Don - Bae Video");
////        song("Master", "Kutti Story");
//        csvreader();
//
//
//    }
//}
