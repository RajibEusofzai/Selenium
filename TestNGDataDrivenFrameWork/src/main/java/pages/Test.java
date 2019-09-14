package pages;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {

	public static void main(String[] args) {
		String filepath;
		FileInputStream fis = null;
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		XSSFRow row = null;
		XSSFCell cell = null;

		filepath = "./data/Data.xlsx";

		try {
			fis = new FileInputStream(filepath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(1);
			fis.close();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < row.getLastCellNum(); j++) {
					
					cell = row.getCell(j);
					
					String XlData = cell.toString();
					System.out.println(XlData);
				}
				
				System.out.println();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
