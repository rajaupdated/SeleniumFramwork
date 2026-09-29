package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static Map<String,String> getTestData(String TestcaseID) {

        Map<String,String> data = new HashMap<>();

        try {

            FileInputStream fis =
                new FileInputStream(
                    "src/test/resources/TestData.xlsx");

            XSSFWorkbook workbook =
                new XSSFWorkbook(fis);

            XSSFSheet sheet =
                workbook.getSheet("TestData");

            Row headerRow = sheet.getRow(0);

            for (int i = 1;
                 i <= sheet.getLastRowNum();
                 i++) {

                Row row = sheet.getRow(i);

                if(row.getCell(0).getStringCellValue()
                        .equalsIgnoreCase(TestcaseID)) {

                    for(int j = 0;
                        j < headerRow.getLastCellNum();
                        j++) {

                        data.put(
                            headerRow.getCell(j)
                                     .getStringCellValue(),
                            row.getCell(j)
                               .getStringCellValue());
                    }

                    break;
                }
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}