package myfirstproject.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {   // why abstract ---> 1. we dont want to create an object from this class,TestBase, just to use the methods
//                                                      2. we just want to implement the methods without showing the details
//    Making this abstract, because we just want to implement the methods without showing the details
//    We also do not want to create an object on TestBase, just want to use the method inside it.


    // abstract class in constructor child class dan kullanilamamaz, dolayisiyla child dan bu class in object ini olusturamayiz.
    // bu sinifin abstract olmasi extend ederek methodlari kullanmamiz icin onemli

    //    TestBase will have only two methods
//    1. Before
//    2. After
//    Why TestBase?
//    We use TestBase for REPEATED PRE CONDITION AND AFTER CONDITION
//    our methods are reusable here
//    This will make actual class shorter

//    access modifier must be public or protected
//    because they are in different packages (utilities and test methods)

    protected WebDriver driver;

    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentReports extentReports;
    protected ExtentTest extentTest;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

//        Create html report under test-output folder. name = my_project_report.html
//        Path of the html report
        String reportPath =  System.getProperty("user.dir")+ "/test-output/my_project_report.html";
//        Creating html report in the file path
        extentHtmlReporter= new ExtentHtmlReporter(reportPath);
//        Creating extent report
        extentReports=new ExtentReports();
//        Attaching html report the Extent report
        extentReports.attachReporter(extentHtmlReporter);
//      So far the report creating is DONE.
        extentTest =extentReports.createTest("My Project Extent Report","My first extent reports");

        //adding custom information
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Team", "Team Galaxy");
        extentHtmlReporter.config().setReportName("GMI Bank test reports");
        extentHtmlReporter.config().setDocumentTitle("JUnit Reports");

    }


    @After
    public void tearDown(){
//        driver.close();
        extentReports.flush();
    }

}

