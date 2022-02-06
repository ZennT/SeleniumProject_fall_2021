package myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewTabsSel4 {

    @Test
    public void newTabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1. open google in the tab 1
        //we use windowHandle to switch between the windows
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle(); //to switch back when needed and to get window ID

        //2. open amazon in the tab2
        //creating and switching a new blank tab
        WebDriver amazonTab = driver.switchTo().newWindow(WindowType.TAB);  //opens a new blank tab
        amazonTab.get("https://www.amazon.com");
        String amazonWindowHandle = driver.getWindowHandle();

        //3. open likedIn in a new tab
        WebDriver linkedInTab = driver.switchTo().newWindow(WindowType.TAB);
        linkedInTab.get("https://www.linkedin.com");

        //getting the window handle of that window bec I am working on multiple tabs
        String linkedInHandle = driver.getWindowHandle();

        //switching back to google window
        Thread.sleep(3000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("Google URL==>" +driver.getCurrentUrl());

        //switching back to amazon window
        Thread.sleep(3000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("amazon URL==>" +driver.getCurrentUrl());

        //switching back to linkedIn window
        Thread.sleep(3000);
        driver.switchTo().window(linkedInHandle);
        System.out.println("linkedIn URL==>" +driver.getCurrentUrl());


    }
    @After
    public void tearDown(){
        //driver.quit();
    }
}
