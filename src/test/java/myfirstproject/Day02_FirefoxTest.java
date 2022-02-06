package myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {
    public static void main(String[] args) {

        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver");

        // creating firefox driver
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");


    }
}
