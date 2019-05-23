package cn.net.nigel.table;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class WorkBookDemo {

    public static void main(String[] args)throws Exception {
        //Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        //Create a blank spreadsheet
        XSSFSheet spreadsheet = workbook.createSheet("Sheet Name");
        Map<String, Object[]> empinfo = new TreeMap<>();
        empinfo.put( "1", new Object[] {
                "EMP ID", "EMP NAME", "DESIGNATION" });
        empinfo.put( "2", new Object[] {
                "tp01", "Gopal", "Technical Manager" });
        empinfo.put( "3", new Object[] {
                "tp02", "Manisha", "Proof Reader" });
        empinfo.put( "4", new Object[] {
                "tp03", "Masthan", "Technical Writer" });
        empinfo.put( "5", new Object[] {
                "tp04", "Satish", "Technical Writer" });
        empinfo.put( "6", new Object[] {
                "tp05", "Krishna", "Technical Writer" });
        //Iterate over data and write to sheet
        Set< String > keyid = empinfo.keySet();
        XSSFRow row;
        int rowid = 0;
        for (String key : keyid) {
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = empinfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }
        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File("src/main/java/cn/net/nigel/table/createworkbook.xlsx"));
        //write operation workbook using file out object
        workbook.write(out);
        out.close();
        System.out.println("createworkbook.xlsx written successfully");
    }
}
