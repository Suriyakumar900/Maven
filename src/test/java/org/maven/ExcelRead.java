package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelRead {

	public static void main(String[] args) throws Throwable {
		
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\TzMaven\\target\\maven.xlsx");
		FileInputStream f1 = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
		Sheet s = w.getSheet("Sheet1");
		for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
			Row r = s.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell cell = r.getCell(j);
				int c = cell.getCellType();
				//cell type
			   //return type 1 -- characters
			  //return type 0 -- number & date
				
				if(c==1) {
					String value = cell.getStringCellValue();
					System.out.println(value);
				}
				else if (c==0) {
					if(DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
					String format = sd.format(d);
					System.out.println(format);
				} else {
					double num = cell.getNumericCellValue();
					long l = (long)num;
					String valueOf = String.valueOf(l);
					System.out.println(valueOf);
					
				  }

				}
				
			}
			
		}
		
	}
}
