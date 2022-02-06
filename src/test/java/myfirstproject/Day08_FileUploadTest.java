package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Day08_FileUploadTest extends TestBase {

    @Test
    public void fileUploadTest() throws InterruptedException {
//        Class Name: FileUploadTest
//        Method Name: fileUploadTest
//        When user goes to https://the-internet.herokuapp.com/upload
//        When user selects an image from the desktop
//        And click on the upload button
//        Then verify the File Uploaded!  Message displayed


        driver.get("https://the-internet.herokuapp.com/upload");
//      send the path of the file

//        STEP1: Path of the image
        String pathOfImage = System.getProperty("user.home") + "/Desktop/download.png";
        Thread.sleep(5000);

//        STEP 2: send keys the path of the image
        driver.findElement(By.id("file-upload")).sendKeys(pathOfImage);  // choose file locate ettik ve path of image gonderdik

//        STEP3 : Click upload
        driver.findElement(By.id("file-submit")).click();

//        1.way Verify the file is uploaded
        String actualSuccessMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!", actualSuccessMessage);

        // 2. way
//        WebElement actualSuccessMessage = driver.findElement(By.xpath("//h3"));
//        Assert.assertTrue(actualSuccessMessage.isDisplayed());

    }

//    @Test
//    public void fileUploadTest() throws InterruptedException {
//        driver.get("https://the-internet.herokuapp.com/upload");
////      send the path of the file
////        STEP1: Path of the image
//        String pathOfImage=System.getProperty("user.home")+"/Desktop/download.png";
//
//        Thread.sleep(3000);
////        STEP 2: send keys the path of the image
//        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
//        chooseFileButton.sendKeys(pathOfImage);
////        STEP3 : Click upload
//        WebElement submitButton = driver.findElement(By.id("file-submit"));
//        submitButton.click();
//
//        Thread.sleep(3000);
////        Verify the file is uploaded
//        String actualSuccessMessage = driver.findElement(By.xpath("//h3")).getText();
//        Assert.assertEquals("File Uploaded!",actualSuccessMessage);
//
//    }
}
