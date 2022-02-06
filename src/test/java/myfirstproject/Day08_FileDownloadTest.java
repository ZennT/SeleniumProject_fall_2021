package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

//        We can't test windows application with selenium. But we can use JAVA to test.
//        We can use Java to check if a file exist on our computer or not
//        System.getProperty("user.dir"); =>gives the path of the current folder
//        System.getProperty("user.home"); =>gives you the user folder
//        Files.exists(Paths.get(“path of the file”)); =>Checks if a file path exist on your computer or not
//        We can use this Java concept to check if a downloaded file is in our download folder


//        Create a class:FileDownloadTest
//        downloadTest()
//        In the downloadTest() method, do the following test:
//        Go to https://the-internet.herokuapp.com/download
//        Download flower.png file
//        Then verify if the file downloaded successfully

public class Day08_FileDownloadTest extends TestBase {

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");

//        clicking on the link to download
        driver.findElement(By.linkText("IMG_1354.jpg")).click();

//        Verify if the download is successful
//        Waiting for the file to be downloaded completely
        Thread.sleep(2000);
//        path of the downloaded file
        String filePath = System.getProperty("user.home")+"/Downloads/IMG_1354.jpg";

//        Verification
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);


    }
}
