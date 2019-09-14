package tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ReadXLPage;
import util.BrowserFactory;

public class LoginTest {
	static String url = "http://techfios.com/test/billing/?ng=login/";

	@Test
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver = BrowserFactory.StartBrowser();
		driver.get(url);
		ReadXLPage readXLPage = PageFactory.initElements(driver, ReadXLPage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

		ArrayList<String> MyData = new ArrayList<String>();
		String FilePath = "./data/Data.xlsx";
		int SheetNum = 0;
		MyData.addAll(readXLPage.getXlData(FilePath, SheetNum));

		String User = MyData.get(0);
		String Pwd = MyData.get(1);
		loginPage.login(User, Pwd);

	}

}
