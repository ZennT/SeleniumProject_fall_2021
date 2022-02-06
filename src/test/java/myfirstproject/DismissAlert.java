package myfirstproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
dismissAlert()=> click on the second alert,
verify text "I am a JS Confirm”, click cancel,
and Verify “You clicked: Cancel”
 */
public class DismissAlert {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void dismissAlert() {
//        click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        verify text "I am a JS Confirm”,
        String actualAlertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Confirm", actualAlertText);
//        click cancel, "
        driver.switchTo().alert().dismiss();
//        "and Verify “You clicked: Cancel”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You clicked: Cancel", actualResult);

    }
    @Test
    public void sendKeysAlert(){

        /*
        sendKeysAlert()=> click on the third alert,
        verify text “I am a JS prompt”,
        type “Hello World”, click OK,
        and Verify “You entered: Hello Word”
         */

        //    click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
//    verify text “I am a JS prompt”,
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actualText);
//    type “Hello World”, click OK,
        driver.switchTo().alert().sendKeys("Hello World");
//        click OK
        driver.switchTo().alert().accept();
        //    and Verify “You entered: Hello Word”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);
    }


}

