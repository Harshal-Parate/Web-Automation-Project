package org.hdp.utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public final class ExcelReaderUtility {

    private ExcelReaderUtility() {}

    public static Object[][] getData() {
        Workbook w = null;
        Sheet s;
        Row r;
        Cell c;

        FileInputStream fs = null;
        try {
            fs = new FileInputStream("src/test/resources/testdata/DataFile.xlsx");
            w = WorkbookFactory.create(fs);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        s = w.getSheet("dataSheet");
        int rows = s.getLastRowNum()+1;
        int col = s.getRow(0).getLastCellNum();

        String[][] arr = new String[rows][col];

        for(int i=0; i<rows; i++) {
            r = s.getRow(i);
            for(int j=0; j<col; j++) {
                arr[i][j] = r.getCell(j).getStringCellValue();
            }
        }
        return arr;
    }
}