package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class Day07_Actions2 extends TestBase {
//    Create a class: Actions2
//    Create test method : hoverOver() and test the following scenario:
//    Given user is on the https://www.amazon.com/
//    When use click on “Account” link
//    Then verify the page title contains “Your Account”



    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList")); // this is the element I want to hover over

//        try{
////    IF NO THANKS IS VISIBLE, IT CLICKS
////    OTHERWISE, WE WILL CATCH HTE EXCELTIP IN CATCH BLOCK
////    CODE WILL CONTINUE TO EXECUTE
//            driver.findElement(By.xpath("No,Thanks")).click();
//
//        }catch (Exception e){
//            e.getMessage();
//        }
        // catch icine alttaki code yazilabilir

        // 1. create actions object from Actions class
        Actions actions = new Actions(driver);

//        2. use proper actions method
//        move the mouse over account list element
        actions.moveToElement(accountList).perform();
        Thread.sleep(5000);

//        clicking on account option
        driver.findElement(By.linkText("Account")).click();

//        Then verify the page title contains “Your Account”
        Assert.assertEquals("Your Account", driver.getTitle());


    }


}
