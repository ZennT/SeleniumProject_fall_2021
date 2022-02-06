package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day10_Synchronization2 extends TestBase {

    @Test
    public void isEnabled(){

//        Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

//        Click enable Button
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

//        add wait explicitly until the web element loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement enabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

//        And verify the message is equal to “It's enabled!”
        String enabledMessageText = enabledMessage.getText();
        Assert.assertEquals("It's enabled!",enabledMessageText);

//        And verify the textbox is enabled (I can type in the box)
        boolean enabledBox = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        Assert.assertTrue(enabledBox);

//        And click on Disable button
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

//        And verify the message is equal to “It's disabled!”
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));

//        And verify the textbox is disabled (I cannot type in the box)
        boolean disabledBox = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        Assert.assertFalse(disabledBox);

    }

//    Create a class:Synchronization2. Create a method: isEnabled
//    Go to https://the-internet.herokuapp.com/dynamic_controls
//    Click enable Button
//    And verify the message is equal to “It's enabled!”
//    And verify the textbox is enabled (I can type in the box)
//    And click on Disable button
//    And verify the message is equal to “It's disabled!”
//    And verify the textbox is disabled (I cannot type in the box)
//    NOTE: .isEnabled(); is used to check if an element is enabled or not



//    Import the apache poi dependency in your pom file
//    Create resources directory under java folder(right click on java and create the folder)
//    Add the excel file on the resources folder
//    Create a new package: excelautomation
//    Create a new class : ReadExcel
//    Create a new test method : readExcel()
//    Store the path of the  file in a string
//    Open the file
//    Open the workbook using fileinputstream
//    Open the first worksheet
//    Go to first row
//    Go to first cell on that first row and print
//    Go to second cell on that first row and print
//    Go to 2nd row first cell  and assert if the data equal to USA
//    Go to 3rd row 2nd cell-chain the row and cell
//    Find the number of row
//    Find the number of used row
//    Print country, capitol key value pairs as map object
}






