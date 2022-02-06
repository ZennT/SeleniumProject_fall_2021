package myfirstproject;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Day11_ReadExcel {

    /*
    Import the apache poi dependency in your pom file
Create resources directory under java folder(right click on java and create the folder)
Add the excel file on the resources folder
Create a new package: excelautomation
Create a new class : ReadExcel
Create a new test method : readExcel()
Store the path of the  file in a string
Open the file
Open the workbook using fileinputstream
Open the first worksheet
Go to first row
Go to first cell on that first row and print
Go to second cell on that first row and print
Go to 2nd row first cell  and assert if the data equal to USA
Go to 3rd row 2nd cell-chain the row and cell
Find the number of row
Find the number of used row
Print country, capitol key value pairs as map object
     */


    @Test
    public void readExcel() throws IOException {
        String path = "./src/test/java/resources/Capitals.xlsx";

//        open the file
        FileInputStream fileInputStream = new FileInputStream(path); // bu excel sheet ile calisacagim, go and find it diyoruz

//        Workbook > Worksheet > Row > Cell seklinde buyukten kucuge gidecegiz

//        open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);  // elimizdeki file i workbook a cevirdik diyebilir miyiz?

//        open the first sheet
        Sheet sheet1 = workbook.getSheetAt(0); // ilk sirada hangi sheet varsa onu alir
//        excel de index degismez o yuzden index kullanarak bulmak saglikli bir yol
       // String sheet2 = workbook.getSheetName(Integer.parseInt("alican"));  // isimle bulabiliriz



//      go to first row
        Row row1 = sheet1.getRow(0);

//        go to first cell on that row and print
        Cell cell = row1.getCell(0);
        System.out.println(cell); // to verify if we are on the correct place

        //everyting, excel files should be inside the project to reach and use

//        go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2.toString().toLowerCase());  // bizim objectimiz cell data type inda, onu string e cevirirsek manipule etmek kolay olur
        System.out.println("---------" + cell2);

//        go to 2nd row first cell
//        long way
        Row row2 = sheet1.getRow(1);
        Cell cell21 = row2.getCell(0);
        System.out.println(cell21);
        Assert.assertEquals("USA", cell21.toString());



//        short way
        String row2Cell1 = sheet1.getRow(1).getCell(0).toString();  // getRow gives the entire row, then I reach specific cell with index
        Assert.assertEquals("USA", row2Cell1); //assert object string data type kullandigi icin bu objeyi string e cevirmeliyiz
        // yoksa assert yapamayiz
        System.out.println(row2Cell1);

        Cell cell33 = workbook.getSheetAt(1).getRow(1).getCell(2); // cetin bey in ornegi


//        go to 3rd row, 2nd cell
        String row3Cell2 = sheet1.getRow(2).getCell(1).toString();
        System.out.println(row3Cell2);

//        find the number of row
//        index starts from 0 so add 1 to match the row number
       int lastRowNumber =  sheet1.getLastRowNum() + 1;   // get PhysicalNumberOfRows da kullanilabilir, bu metod sadece dolu olan cell leri alir
//        +1 ekledik cunku index start from zero, counting numbers start from 1. always add 1 to get the last row number
        System.out.println(lastRowNumber);

//        find the number of used rows
//        index starts from 1, no need to add 1 to match
        int numberOfUsedRows = sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfUsedRows);
        int numberOfRowsUsed2 = workbook.getSheet("alican").getPhysicalNumberOfRows(); // sheet adi yazarak bulunabilir

//        getLastRowNum() and getPhysicalNumberOfRows()
//        reaches the same result, does the same thing
//        but don't forget to add 1 with getLastRowNum()

//        print country, capital key value pairs as map object
//        {USA = DC, France = Paris, England = London...}
//        (we should use Map to see such a key-value pair)

//        create Map object
        Map<String, String > countryCapitals = new HashedMap<>(); // to get data from excel into the Map
        // (map doesn't hold index numbers, puts data randomly inside the map)

        //using for loop to get each cell data and store in the map
        // rowNumber=1 olunca baslik yazan ilk cell almiyor
        for(int rowNumber = 1; rowNumber<lastRowNumber;rowNumber++){
//            usa = sheet1.getRow(1).getCell(0);
//            france = sheet1.getRow(2).getCell(0);
//            england = sheet1.getRow(3).getCell(0);
//            turkey = sheet1.getRow(4).getCell(0);
//            DC = sheet1.getRow(1).getCell(1);
//            paris = sheet1.getRow(2).getCell(1);
//            london = sheet1.getRow(3).getCell(1);
//            ankara = sheet1.getRow(4).getCell(1);

//           get the data (countries and capitals)
            String countries = sheet1.getRow(rowNumber).getCell(0).toString();
            String capitals = sheet1.getRow(rowNumber).getCell(1).toString();
//            System.out.println("countries: " + countries);
//            System.out.println("capitals: " + capitals);

            // store inside the map
//            map put function is used to add key value pairs inside the map
            countryCapitals.put(countries, capitals);
        }
        System.out.println(countryCapitals);








            }
        }













