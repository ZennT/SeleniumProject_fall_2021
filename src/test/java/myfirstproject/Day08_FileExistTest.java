package myfirstproject;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Day08_FileExistTest {

    // selenium only can automate web browsers
    // if you want to interact with the files on the computer, you can not use selenium
    // for this reason we can use java methods to interact with files on the computer


    /*
    choose a file from your computer
    verify that file exists in your computer

    And verify a file exist in your computer
Steps:
Download the image that I shared.
Move in your desktop
And verify that file exist.

     */

    @Test
    public void isExist(){

        // we need the path of the file
        // getting HomePath / directory

        String homeDirectory = System.getProperty("user.home"); // returns home directory as String type, it is home path
        System.out.println(homeDirectory); // /users/zenn

//        file path (path of the image)
        String pathOfImage = homeDirectory + "/Desktop/download.png";
        System.out.println(pathOfImage);

//        verify if a path exist
        boolean isExist = Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);  // if the path exist returns true

//          if the test fails, it means the path is not correct or the file doesn't exist

//        we can not check several files at the same time, need to do it one by one
//        because we have a unique path for each file
    }



}
