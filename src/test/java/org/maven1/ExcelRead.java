package org.maven1;

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

public class ExcelRead {

	public static void main(String[] args) throws Throwable {
	File f = new File("C:\\\\Users\\\\ELCOT\\\\eclipse-workspace\\\\TzMaven\\\\target\\\\maven.xlsx");
	FileInputStream f1 = new FileInputStream(f);
	Workbook w = new XSSFWorkbook(f1);
	Sheet sheet = w.getSheet("sheet1");
	
	for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
		Row r = sheet.getRow(i);
		
		for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			Cell cell = r.getCell(j);
			
			int type = cell.getCellType();
			
			if (type==1) {
				String string = cell.getStringCellValue();
				System.out.println(string);
			}
			else if (type==0) {
				if (DateUtil.isCellDateFormatted(cell)) {
					Date d = cell.getDateCellValue();
					SimpleDateFormat si = new SimpleDateFormat("MM/dd/yyyy");
					String format = si.format(d);
					System.out.println(format);
				}
				else {
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