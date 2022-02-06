package homework;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Locators extends TestBase {

    @Test
    public void locators(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        driver.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        List<WebElement> priceList = driver.findElements(By.className("inventory_item_price"));
        for (WebElement each : priceList){
            System.out.println(each.getText());
        }

        List<Double> prices = new ArrayList<>();



    }
}
