package myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Day03_Locators {

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver"); //MAC
//      System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");// WINDOWS
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://a.testaddressbook.com/sign_in");
    }



    @Test
    public void locators() throws InterruptedException {

//      locating the email input
        driver.findElement(By.id("session_email")).sendKeys("testtechproed@gmail.com");

//      locating the password and typing the password
        driver.findElement(By.id("session_password")).sendKeys("Test1234!");


//      locating the sign in button and clicking on it
        driver.findElement(By.name("commit")).click();
        Thread.sleep(3000);

//        Then verify that the expected user id testtechproed@gmail.com (USE getText() method to get the text from the page)
//        1. locate the element
//        2. getText will return the text as String
//        3. assert

        WebElement userId = driver.findElement(By.className("navbar-text"));


        // WebDriver -> interface  (driver is an instance variable belonging to this class )
        // WebElement -> interface
        // both extends  org.openqa.selenium.SearchContext interface --> so we are able to use findElement and findElements methods (belonging SearchContext interface) with driver

        System.out.println(userId);

        String actualUserIdText = userId.getText();
        System.out.println(actualUserIdText);
        String expectedUserId="testtechproed@gmail.com";
        Assert.assertEquals("ID Test Fails",expectedUserId,actualUserIdText);  // message is displayed only when the test fails

//      Verify the Addresses and Sign Out texts are displayed

//      addresses
        WebElement addressesElement=driver.findElement(By.linkText("Addresses"));

//        isDisplayed() return true if element is displayed.
//        Returns false if element is not displayed
          Assert.assertTrue(addressesElement.isDisplayed());


//        sign out
        WebElement signOutElement = driver.findElement(By.linkText("Sign out"));
        Assert.assertTrue(signOutElement.isDisplayed());

//        Find the number of total link on the page
//        a tag is used to create links
        // findElements method returns a list of elements
        // so we create a List for all elements with the same tag
        List<WebElement> allLinks = driver.findElements(By.tagName("a")); //return all links on the page
        System.out.println("Total number of link : "+ allLinks.size());  // we use size() method to see how many elements are in the list



//        Sign out from the page
        driver.findElement(By.partialLinkText("Sign ")).click();

//        NOTE: make sure do the assertion to verify that sign out is successful
//        boolean isSignedOut = driver
//                .getCurrentUrl()
//                .equals("http://a.testaddressbook.com/sign_in");

//        Assert.assertTrue(driver
//                .getCurrentUrl()
//                .equals("http://a.testaddressbook.com/sign_in"));

        Assert.assertEquals("http://a.testaddressbook.com/sign_in", driver
                .getCurrentUrl());
        Thread.sleep(2000);


    }

    @After
    public void tearDown(){
          driver.quit();  //--> mesela crossbrowser testing de hepsini kapatir
        //driver.close();
        // driver. quit() is used to exit the browser,
        // end the session, tabs, pop-ups etc.
        // But the when you driver. close(), only the window that has focus is closed.

    }
}
