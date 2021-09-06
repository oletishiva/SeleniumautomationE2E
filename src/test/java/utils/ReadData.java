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

public class ReadData {

    public ReadData(String filename, String workbookname) throws IOException {
        File f=new File(filename);
        FileInputStream fis=new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet xs=wb.getSheet(workbookname);
        XSSFRow row;
        XSSFCell col;
        Iterator rows=xs.rowIterator();
        while(rows.hasNext())
        {
           row=(XSSFRow)rows.next();
           Iterator cells=row.cellIterator();
           while(cells.hasNext())
           {
               col=(XSSFCell)cells.next();
               System.out.println(col.getStringCellValue());
           }
        }

    }
    public static void main(String args[]) throws IOException {
        ReadData rd=new ReadData("Data\\TestData.xlsx","LoginDetails");
    }
}
