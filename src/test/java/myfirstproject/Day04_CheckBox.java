package myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Day04_CheckBox {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver"); //MAC
        driver = new ChromeDriver();
//      adding implicitly wait
        //        SELENIUM 4
//        Implicitly wait is used to put DYNAMIC WAIT for the driver
//        Dynamic wait means driver will only wait WHEN NEEDED.
//        When we use implicit wait in before method, then we do not need to use implicit wait again
//
//        Thread.sleep(10); > WAIT 10 second NO MATTER WHAT
//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // new with selenium 4
        // whenever we call driver wait runs too
//      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // selenium 3
        driver.manage().window().maximize();

    }
    @Test
    public void checkBox() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //  locating the first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

//        Verify that checkbox1 is NOT CHECKED
        Assert.assertFalse(checkbox1.isSelected()); // assertTrue(!checkbox1.isSelected());
        //checkbox1.click();

//        locating the checkbox2
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

//        Verify that checkbox2 is SELECTED
        Assert.assertTrue(checkbox2.isSelected()); // to see if the box is selected
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        How to check or Uncheck a check box
        checkbox1.click();//check
        Thread.sleep(5000);
        checkbox2.click();//unchecked

//        How to check only unchecked boxes?
//        if checkbox is NOT checked then click
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
    }
    @After
    public void tearDown(){
        driver.quit();
    }

}
