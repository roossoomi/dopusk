
package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ExcelReader {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\sonya\\Desktop\\Допуск.xlsx";
        try {
            FileInputStream file = new FileInputStream(new File(excelFilePath));
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0);

            int numberOfRows = sheet.getPhysicalNumberOfRows();
            double[] dataarray = new double[numberOfRows - 1];
            int count = 0;

            for (int i = 1; i < numberOfRows; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell cell3 = row.getCell(2);
                    if (cell3 != null) {
                        dataarray[count] = cell3.getNumericCellValue();
                        count++;
                    }
                }
            }
            workbook.close();
            file.close();

            System.out.println("Среднее арифметическое по 3 столбцу: " + ArithmeticMean.getArithmeticMean(dataarray));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}