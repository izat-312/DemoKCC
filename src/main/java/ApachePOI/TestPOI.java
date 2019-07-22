package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class TestPOI {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("src/POI.xlsx");
        XSSFWorkbook workSheets = new XSSFWorkbook(fis);
        XSSFSheet sheet = workSheets.getSheetAt(0);
        XSSFRow row = sheet.getRow(1);
        XSSFCell cell = row.getCell(2);

        System.out.println(workSheets.getNumberOfSheets());
        System.out.println(sheet.getFirstRowNum());
        System.out.println(row.getCell(1));
        System.out.println(cell.getColumnIndex()+" and "+cell.getRowIndex());
    }
}
//dependency apache POI and Apache ooxml