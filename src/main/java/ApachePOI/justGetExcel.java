package ApachePOI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class justGetExcel {

    public static ArrayList<Object[]> getDataFromExcel() throws IOException {
        ArrayList<Object[]>myData = new ArrayList<>();
        FileInputStream fis = new FileInputStream("src/POI.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i =1; i<=sheet.getLastRowNum(); i++){
            String name = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            Object[]obj = {name,password};
            myData.add(obj);
        }
        return myData;
    }
}
