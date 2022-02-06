package myfirstproject;

import myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day09_ScreenshotSel4 extends TestBase {

    /*
     * In selenium 4, we can take screenshot of specific elements
     *
     * */

    @Test
    public void takeScreenShotTest() throws IOException {
        driver.get("https://www.google.com");
//        get the screenshot of ONLY THE GOOGLE LOGO
        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));

        File googleLogoImage = googleLogo.getScreenshotAs(OutputType.FILE);
//        save the file as googlelogo.png

        File finalPath = new File("googleLogo.png");
        FileUtils.copyFile(googleLogoImage,finalPath);

    }


}
