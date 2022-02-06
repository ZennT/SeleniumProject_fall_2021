package myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Day11_WriteExcel {
    /*
    Create a new class: WriteExcel
Create a new method: writeExcel()
Store the path of the file as string and open the file
Open the workbook
Open the first worksheet
Go to the first row
Create a cell on the 3rd column (2nd index) on the first row
Write “POPULATION” on that cell
Create a cell on the 2nd row 3rd cell(index2), and write 150000
Create a cell on the 3rd row 3rd cell(index2), and write 250000
Create a cell on the 4th row 3rd cell(index2), and write 54000
Write and save the workbook
Close the file
Close the workbook

     */

    @Test
    public void writeExcel() throws IOException {

//        store the path of file as string and open the file
        String path = "./src/test/java/resources/Capitals.xlsx";
//        open the file
        FileInputStream fileInputStream = new FileInputStream(path);

//        open workbook
        Workbook workbook = WorkbookFactory.create(fileInputStream);

//        open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);

//        go to the first row
        Row row1 = sheet1.getRow(0);

//        create a cell on the 3rd column(2nd index) on the first row
        Cell row1Cell3 = row1.createCell(2);

//        write POPULATION on that cell
        row1Cell3.setCellValue("POPULATION"); // not saved

//        Create a cell on the 2nd row 3rd cell(index2), and write 150000
        sheet1.getRow(1).createCell(2).setCellValue("150000");

//        Create a cell on the 3rd row 3rd cell(index2), and write 250000
        sheet1.getRow(2).createCell(2).setCellValue("250000");

//        Create a cell on the 4th row 3rd cell(index2), and write 54000
        sheet1.getRow(3).createCell(2).setCellValue("54000");

        //        both write and save the workbook
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

//        close the file
        fileInputStream.close();
        fileOutputStream.close();

//         close the workbook
        workbook.close();










    }
}
