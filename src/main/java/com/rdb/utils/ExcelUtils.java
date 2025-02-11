package com.rdb.utils;

import com.rdb.constants.FrameworkConstants;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils() {
    }

    public static List<Map<String, String>> getTestDetails(String sheetname) {
        List<Map<String, String>> list = new ArrayList<>();
        try (
                FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
                XSSFWorkbook workbook = new XSSFWorkbook(fis);
        ) {

            XSSFSheet sheet = workbook.getSheet(sheetname);
            int lastrownum = sheet.getLastRowNum();
            int lastcolnum = sheet.getRow(0).getLastCellNum();

            for (int row = 1; row <= lastrownum; row++) {
                Map<String, String> map = new HashMap<>();
                for (int col = 0; col < lastcolnum; col++) {

                    DataFormatter df = new DataFormatter();

                    String key = df.formatCellValue(sheet.getRow(0).getCell(col));
                    String value = df.formatCellValue(sheet.getRow(row).getCell(col));

                    map.put(key, value);
                }
                list.add(map);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
