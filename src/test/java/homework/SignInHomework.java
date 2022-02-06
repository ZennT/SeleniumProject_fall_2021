package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SignInHomework {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void createAnAccount() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();  // sign in link
        driver.findElement(By.xpath("//input[@id='email_create']")).clear();// email button
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("aabbcd1@hotmail.com");
        driver.findElement(By.xpath("//span/i[@class='icon-user left']")).click(); // create an account button
        driver.findElement(By.xpath("//h1[@class='page-heading']")).isDisplayed(); // create an account text
        driver.findElement(By.xpath("//h3[.='Your personal information']")).isDisplayed(); //your personal information text
        driver.findElement(By.xpath("//*[.='Title']")).isDisplayed();   // Title text
        driver.findElement(By.xpath("//input[@type='radio']")).click();  // click Mr
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("ali"); // firstname
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("can");  // last name
        driver.findElement(By.xpath("//input[@id='email']")).clear(); // email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aabbcd1@hotmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("a123455");

        WebElement dropdown = driver.findElement(By.id("days"));
        Select select = new Select(dropdown);
        select.selectByValue("4");

        WebElement dropdownM = driver.findElement(By.id("months"));
        Select select1 = new Select(dropdownM);
        select1.selectByValue("4");

        WebElement dropdownY = driver.findElement(By.id("years"));
        Select select2 = new Select(dropdownY);
        select2.selectByValue("2000");

        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='firstname'])")).clear();
        driver.findElement(By.xpath("(//input[@id='firstname'])")).sendKeys("ali");
        driver.findElement(By.xpath("//input[@id='lastname']")).clear();
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("can");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("techpro");
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("california");
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("istanbul");

        WebElement dropdownState = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select select3 = new Select(dropdownState);
        select3.selectByValue("2");

        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("this is a test");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+265498609-7");
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("+265498609-7");
        driver.findElement(By.xpath("//input[@id='alias']")).clear();
        driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("this is a reference");
        driver.findElement(By.xpath("//*[.='Register']")).click();

        driver.findElement(By.xpath("//h1[@class='page-heading']")).isDisplayed(); // verify my account text

    }

    @After
    public void tearDown() {
        driver.close();
    }


}


