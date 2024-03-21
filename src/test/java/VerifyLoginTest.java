import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class VerifyLoginTest {

    WebDriver driver;

    @BeforeTest
    @Parameters("browser")
    public void setUp(String browser) throws MalformedURLException {
        driver = SeleniumRemoteDriver.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Driver started for browser: " + browser);
    }


    @Test
    public void verifyFightPriceOnSkyScanner() {
        driver.get("https://www.flipkart.com/");
        WebElement threeDotsEl = driver.findElement(By.xpath("//a[@title='Dropdown with more help links']"));


        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(threeDotsEl).pause(3000)
                .moveToElement(driver.findElement(By.xpath("//a[@title='Notification Preferences']"))).pause(3000).build();

        action.perform();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
