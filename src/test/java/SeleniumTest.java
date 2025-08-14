import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

//import static java.lang.Thread.sleep;

public class SeleniumTest {

    public static ChromeOptions options ;
    public static WebDriver webDriver ;
    public static WebDriverWait wait;

    //chrome setup and launching a browser - setting up the test
    @BeforeTest
    public static void setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins");
        System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver(options);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://www.demoblaze.com/index.html");
        webDriver.manage().window().fullscreen();
    }

    @Test
    void testSteps() throws InterruptedException {
//        webDriver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[2]/a")).click();
//       Thread.sleep(2000);
//  signup testing
//        webDriver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();
//        Thread.sleep(2000);
//        webDriver.findElement(By.xpath("//*[@id=\"sign-username\"]")).sendKeys("meerkatjon");
//        webDriver.findElement(By.xpath("//*[@id=\"sign-password\"]")).sendKeys("0704jon14");
//
//        webDriver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
//login testing
        webDriver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("meerkatjon");
        webDriver.findElement(By.xpath("//*[@id=\"loginpassword\"]")).sendKeys("0704jon14");

        webDriver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));

        // searching for string
        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"itemc\"]"));

        String actualFirstCetegory = webElement.getText();
        String expectedFirstCategory = "Phones";
        Assert.assertEquals(actualFirstCetegory,expectedFirstCategory);

       //category visibility
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-group")));

        // click particular category
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Laptops']"))).click();

       //wait for products to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));

        //Wait for known laptop product to appear - wait for screen to load then click product
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#tbodyid .card-title a"), "Sony vaio i5"));
        //click first product
        webDriver.findElement(By.cssSelector("#tbodyid .card-title a")).click();
       //and add product to cart
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
    }
    @AfterTest
    public void browserClose(){
        webDriver.close();
    }
}
