package tests;



import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.Test;

import pages.ReadXLPage;

public class ReadXlTest {
	@Test
	public void readXlTest() throws IOException {
	ReadXLPage rx = new ReadXLPage();
	ArrayList<String> MyData = new ArrayList<String>();
	String FilePath = "./data/Data.xlsx";
	int SheetNum = 0;
	MyData.addAll(rx.getXlData(FilePath, SheetNum));
	
	
	for (int i=0;i<=MyData.size()-1;i++) {
		System.out.println(MyData.get(i));
	}
	
	
	
}
}
