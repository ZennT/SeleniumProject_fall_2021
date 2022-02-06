package myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;

public class Day06_IframeTest2 {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void iframeSize(){
//        Go to amazon
//        print the number of iframe

        int numberOfFrame = driver.findElements(By.tagName("iframe")).size();
        System.out.println(numberOfFrame);

        List<WebElement> numberOfFrame1 = driver.findElements(By.tagName("iframe"));
        for (WebElement eachelement : numberOfFrame1) {

            System.out.println(eachelement.getTagName());

        }

    }
    @After
    public void tearDown(){

        driver.quit();
    }

}

