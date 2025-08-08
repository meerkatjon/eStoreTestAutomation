import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import static java.lang.Thread.sleep;

public class SeleniumTest {

    public static ChromeOptions options ;
    public static WebDriver webDriver ;
    //chrome setup and launching a browser - setting up the test
    @BeforeTest
    public static void setup(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins");
        System.setProperty("webDriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver(options);

        webDriver.get("https://www.demoblaze.com/index.html");
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


        WebElement webElement = webDriver.findElement(By.xpath("//*[@id=\"itemc\"]"));

        String actualFirstCetegory = webElement.getText();
        String expectedFirstCategory = "Phones";

        Assert.assertEquals(actualFirstCetegory,expectedFirstCategory);

        webDriver.close();
    }

}
