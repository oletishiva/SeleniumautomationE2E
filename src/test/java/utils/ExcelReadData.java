package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ExcelReadData {



    public  ExcelReadData(String filename, String workbookname) throws IOException {
        File f=new File(filename);
        FileInputStream fis=new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet xs=wb.getSheet(workbookname);
        XSSFRow row;
        XSSFCell col;
        Iterator rows=xs.rowIterator();
        System.out.println(rows.hasNext());
    }

    public void print()
    {

    }
    public static void main(String args) throws IOException {
        ExcelReadData erd= new ExcelReadData("TestData.xls","LoginDetails");
        erd.print();
    }

}
