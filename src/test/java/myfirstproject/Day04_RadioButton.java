package myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.time.Duration;

public class Day04_RadioButton {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
            public void radioButton(){
        driver.get("https://www.facebook.com/");

        //        clicking on the create new account link
        driver.findElement(By.linkText("Create new account")).click();

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("MYNAME");  //sendKeys("MYNAME" + Keys.ENTER); --> click
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("LASTNAME");
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1111111");
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("secretpass1!");
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        // when there is an id with number in it, like id=u_2_4_5U, don't use it. these numbers may change everytime the page loads
        // value='1' --> okay, can be used


        //        NOTE: some ids might be DYNAMIC if id has NUMBER
//        It means id values can change after the next usage.
//        For this reason, we need to avoid using dynamic ids
//        HOW DO YOU HANDLE DYNAMIC ID?????
//        - Dynamic id means id value can change. In this case, i don't prefer to use id
//        If I have to use it I WRITE DYNAMIC XPATH!!!
//        I find what thing is the same everytime, then I choose it
//        I can use contains, start-with or ends-with dynamic xpath

//        //tag[contains(@attribute,’value’)]     => (//input[contains(@id,'u_')])[1]
//        //tag[starts-with(@attribute,’value’)]   => (//input[starts-with(@id,’u_')])[1]  Returns the first input whose id starts with u_
//        //tag[ends-with(@attribute,’value’)]    => //input[ends-with(@id,’P7’)] Returns the input elements who ends with P7

//        Selecting birth month
        WebElement month=driver.findElement(By.id("month"));
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("Jun");
//        Selecting birth day
        WebElement day = driver.findElement(By.id("day"));
        Select daySelect = new Select(day);
        daySelect.selectByIndex(2);
//        Selecting birth year
        WebElement year = driver.findElement(By.id("year"));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("2000");

//        clicking on the Sign Up
        driver.findElement(By.name("websubmit")).click();

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}

