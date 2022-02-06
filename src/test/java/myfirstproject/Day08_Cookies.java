package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class Day08_Cookies extends TestBase {
   /* Class: Cookies
    Method: handleCookies
-Go to amazon  and automate the tasks:
            1. Find the total number of cookies
2. Print all the cookies
3. Get the cookies by their name
4. Add new cookie
5. Delete cookie by name
6. Delete all of the cookies
*/

    @Test
    public void handleCookies(){
//        go to amazon.com
        driver.get("https://amazon.com");

//        1. find the total number of cookies
        Set<Cookie> allCookies = driver.manage().getCookies();
        int numberOfCookies = allCookies.size();  // setteki cookie sayisi
        System.out.println("number of cookie in amazon.com  " + numberOfCookies );

//2. Print all the cookies
        for (Cookie eachCookie : allCookies) {

            System.out.println("each cookie : " + eachCookie); // weird words including numbers, time, location etc
            System.out.println("each cookie : " + eachCookie.getName());  // print cookie name
            System.out.println("each cookie : " + eachCookie.getValue());  // print cookie value

        }

//3. Get the cookies by their name
        System.out.println("Cookie name i18n-prefs : " + driver.manage().getCookieNamed("i18n-prefs"));

//4. Add new cookie
//        a- create cookie object
        Cookie cookie = new Cookie("My-Fav-Cookie","White-Chocolate"); // created custom object

//        b- add cookie
        driver.manage().addCookie(cookie);

//        c- check if cookie is added
        allCookies = driver.manage().getCookies();
        System.out.println(allCookies.size());

//5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id"); // deleting the last cookie named "session-id"

//        check if cookie is deleted
        allCookies = driver.manage().getCookies();
        System.out.println(allCookies.size());

//6. Delete all of the cookies
        driver.manage().deleteAllCookies();
        //    check if All cookies are deleted

        allCookies=driver.manage().getCookies(); //
        System.out.println(allCookies.size());//0









    }
}
