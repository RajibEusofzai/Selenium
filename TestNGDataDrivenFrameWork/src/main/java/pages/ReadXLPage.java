package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLPage {

	public String filepath;
	public static FileInputStream fis = null;
	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public Collection<? extends String> getXlData(String path, int sheetNum) throws IOException {
		String filePath = path;
		ArrayList<String> XlData = new ArrayList<String>();
		try {
			fis = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(sheetNum);
			fis.close();

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j <= row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					//System.out.print(cell + "\t");
					XlData.add(cell.toString());
				}
				//System.out.println();
				fis.close();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		return XlData;
	}
}