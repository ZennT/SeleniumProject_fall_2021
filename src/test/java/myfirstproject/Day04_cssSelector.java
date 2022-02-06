package myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_cssSelector {

    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver"); //MAC
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.carettahotel.com/Account/Logon");
    }

    @Test
    public void cssTest(){
        /*
        cssSelector: similar to xpath
        tag[attribute='value']
        . = class
        # = id
        <input id="btnSubmit" type="submit" value="Log in" class="btn-primary">
css = input[id='btnSubmit']   ---> //input[@id='btnSubmit'] (xpath)
css = .btn-primary
css = #btnSubmit

         */
//        username
       driver.findElement(By.cssSelector("input[id='UserName']")).sendKeys("manager");
//        password
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Manager1!");
//        login button
        WebElement submit = driver.findElement(By.cssSelector("#btnSubmit"));
        submit.click();


    }

    @After
    public void tearDown(){
        driver.quit();


    }
}
