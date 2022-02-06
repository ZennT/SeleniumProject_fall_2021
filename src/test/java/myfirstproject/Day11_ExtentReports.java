package myfirstproject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
public class Day11_ExtentReports extends TestBase {

//    3 libraries to remember?????
//    Extent reports are used for customized html reports
//    it is used to add steps on the test case when needed.
//    we have the extent reports set ups in test base

//    protected ExtentHtmlReporter extentHtmlReporter;  ---> creates the html report
//    protected ExtentReports extentReports;   ----> creates the actual report, without it we can not see that layout
//    protected ExtentTest extentTest;     ---> is used to add some test information
//     extentreport is mostly used to log information, if you want to add explanation
    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the google home page");
        driver.get("https://www.google.com");
        extentTest.pass("Searching for iphone");
        driver.findElement(By.name("q")).sendKeys("iphone x"+ Keys.ENTER);
        extentTest.pass("Printing the result");
//        Logging as failed
        extentTest.fail("THIS WILL FAIL");
//        logging as sipped
        extentTest.skip("THI IS SKIPPED");

    }
}
