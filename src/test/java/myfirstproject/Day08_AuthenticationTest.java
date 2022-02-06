package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/*
Auth are used for security reason
One way to auth is to use below syntax:
https://username:password@URL
       username : admin
       password : admin
       url      :  the-internet.herokuapp.com/basic_auth

     URL FOR AUTH:
     https://admin:admin@the-internet.herokuapp.com/basic_auth
driver.get(“https://admin:admin@the-internet.herokuapp.com/basic_auth”);
This will auth the page
 */
public class Day08_AuthenticationTest extends TestBase {

    @Test
    public void basicAuth(){
//        Authentication is done for verification
//        https://username:password@URL

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");  // log in

//        verifying the log in is successfull
        String congratsMessage = driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(congratsMessage.contains("Congratulations!"));


    }

}
