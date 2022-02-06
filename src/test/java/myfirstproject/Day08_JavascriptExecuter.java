package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Day08_JavascriptExecuter extends TestBase {
    // selenium dan gelen bir class. javascriptexecuter
    // language of the browser is javascript so javascript browser ile daha iyi anlasir
/*

What is JS executor?
    -It is a selenium api that is used for handling some elements.
    -Javascripts executor has some methods that makes automation effective.

How did you use it in your framework?
    -I used js executor to click the elements. It works well handling the clicks
    -I also use it for scrolling. Js executor let us scroll on to the specific web elements.

* */

    @Test
    public void scrollIntoView() throws InterruptedException {
//        CREATING javascript executor object
//        Casting driver

//        byte x = 1;
//        int y = 4;
//        byte z = (byte) y;

        JavascriptExecutor je = (JavascriptExecutor) driver;
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(5000);
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        je.executeScript("arguments[0].scrollIntoView(true);",ourRooms); //

    }

    @Test
    public void clickWithJS(){
        driver.get("http://a.testaddressbook.com/sign_in");

//        click on sign in button using js executor
        WebElement signInButton=driver.findElement(By.xpath("//input[@type='submit']"));
//        signInButton.click();
//      Normally, click() method works wiht selenium. We use this when it is good.
//        Some elements can be challenging to click
//        In that case, we have javascriptexecutor click as an alternative
//        This performs better on some applications
//        Note that we can use js click anytime

//        1. create javascriptexecutor object
        JavascriptExecutor je=(JavascriptExecutor) driver;

//        2. use the aproppriate method
        je.executeScript("arguments[0].click();",signInButton);

//        Assert that the click happened using the message
        Assert.assertTrue(driver.getPageSource().contains("Bad email or password."));

    }

    @Test
    public void scrollDownWithJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);

//        scroll down to the page using js executer
        JavascriptExecutor je=(JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }
}
