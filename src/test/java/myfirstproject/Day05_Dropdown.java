package myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Day05_Dropdown {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void selectByIndexTest() throws InterruptedException {
//        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. to use SELECT object
        Select select = new Select(dropdown);
        Thread.sleep(5000);
//        3. selecting the option by index
        select.selectByIndex(1); // selecting 2nd option - index starts from 0-
        Thread.sleep(5000);
        select.selectByIndex(2);  // selecting option 2
        Thread.sleep(5000);
        select.selectByIndex(1);

    }

    @Test
    public void selectByValueTest() throws InterruptedException {
        //        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));

//        2. to use SELECT object
        Select select = new Select(dropdown);
        Thread.sleep(5000);

//        3. selecting the option by value
        select.selectByValue("1");  // selecting option 1
        Thread.sleep(5000);
        select.selectByValue("2");  // selecting option 2
        Thread.sleep(5000);
        select.selectByValue("1");  // option 1

    }

    @Test
    public void selectByVisibleText() throws InterruptedException {
        //        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. to use SELECT object
        Select select = new Select(dropdown);
        Thread.sleep(3000);
//        3. selecting visible text
        select.selectByVisibleText("Option 1");  // selecting option 1
        Thread.sleep(3000);
        select.selectByVisibleText("Option 2");  // selecting option 2
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");  // option 1

    }

//        4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        //        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. to use SELECT object
        Select select = new Select(dropdown);

        //getOptions(); returns all options as List
        List<WebElement> allOptions = select.getOptions();
        for(WebElement eachOption : allOptions){
            System.out.println(eachOption.getText());  // eger getText() kullanmazsak elementin hashcode unu yazdirir
                                                        // cunku elementler webelement cinsinde
        }

       //  List<WebElement> all = driver.findElements(By.tagName("option"));
//        WebElement sel = myD.findElement(By.name("dropdown_name"));
//        List<WebElement> lists = sel.findElements(By.tagName("option"));
//        for(WebElement element: lists)
//        {
//            String var2 = tdElement.getText();
//            System.out.println(var2);
//        }



//        List<String> list = new ArrayList<>();
//        list.add("sdd");
//        list.add("7dd");
//        list.add("sd9d");
//        for(String str : list){
//            System.out.println(str);
//        }

    }

    @Test
    public void printFirstSelectedOoptionTest(){
        //        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. to use SELECT object
        Select select = new Select(dropdown);

//        getFirstSelectedOption() method returns only the selected option
        WebElement selectedOption = select.getFirstSelectedOption();
        System.out.println("selected option is " + selectedOption.getText());

//        Assertion
        Assert.assertEquals("Please select an option", selectedOption.getText());

    }
//    6. Find the size of the dropdown
//    print "expected is not equal actual" if there are 4 elements in the dropdown

    @Test
    public void sizeTest(){
        //        1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
//        2. to use SELECT object
        Select select = new Select(dropdown);

//        getting all options
        List<WebElement> allOptions = select.getOptions();

//        finding the number of options
        int numberOfOptions = allOptions.size();

//           assertion
        Assert.assertEquals("expected is not equal actual", numberOfOptions, 4);

    }
    @After
    public void tearDown(){
        driver.quit();
    }


}
