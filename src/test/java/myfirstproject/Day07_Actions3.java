package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions3 extends TestBase {

//    Create a class: Actions3
//    Create test method : keysUpDown()
//    Go to google/amazon
//    Send iPhone X prices => convert small letter capital vice versa.
//    Highlight the search box by double clicking



    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));

//    Send iPhone X prices => convert small letter capital vice versa.
//    Highlight the search box by double clicking
//        searchBox.sendKeys("iPhone X prices");

//        1. Create actions object for keyboard actions
        Actions actions = new Actions(driver);
        actions
                .keyDown(searchBox, Keys.SHIFT) // pressing SHIFT  button while on the searchBox
                .sendKeys("iPhone X prices")    // typing in the searchbox
                .keyUp(searchBox, Keys.SHIFT)   // unpressing, release the button
                .sendKeys(" too expensive OMG!" + Keys.ENTER)
                .perform();   // execute actions class. without perform() actions will not work

        //searchBox.sendKeys(" too expensive OMG!" + Keys.ENTER);




    }



}
