package homework;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropDown extends TestBase {

    @Test
    public void dropDownTest() throws InterruptedException {

        driver.get("https://www.amazon.com");

//        locate the dropdown element
        WebElement dropdown = driver.findElement(By.id(("searchDropdownBox")));

//        create SELECT object
        Select select = new Select(dropdown);
        Thread.sleep(5000);

//        Print the first selected option and assert if it equals “All Departments”
        String firstOption = select.getFirstSelectedOption().getText();
        System.out.println(firstOption);
        Assert.assertEquals("All Departments", firstOption);
        Thread.sleep(3000);

//        Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.
        select.selectByIndex(3);
        Thread.sleep(2000);
        String fourthOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Amazon Explore", fourthOption);

//       Print all of the dropdown options
        List<WebElement> dropDown = driver.findElements(By.tagName("option"));
        for (WebElement each: dropDown) {
            System.out.println(each.getText());
        }

//        Print the total number of options in the dropdown
        System.out.println(dropDown.size());

//        Check if Appliances is a drop-down option. Print true if “Appliances” is an option. Print false
//        otherwise.
        if(select.getOptions().contains("Appliances")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
}
