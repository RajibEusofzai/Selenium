package tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.AddContactPage;
import pages.LoginPage;
import pages.ReadXLPage;
import util.BrowserFactory;

public class AddContactTest {
	static String url = "http://techfios.com/test/billing/?ng=login/";

	@Test
	public void loginTest() throws IOException, InterruptedException {
		WebDriver driver = BrowserFactory.StartBrowser();
		driver.get(url);
		ReadXLPage readXLPage = PageFactory.initElements(driver, ReadXLPage.class);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);

		ArrayList<String> LoginData = new ArrayList<String>();
		String FilePath = "./data/Data.xlsx";
		int SheetNum = 0;
		LoginData.addAll(readXLPage.getXlData(FilePath, SheetNum));

		String User = LoginData.get(0);
		String Pwd = LoginData.get(1);
		loginPage.login(User, Pwd);
		
		Thread.sleep(3000);
		
		addContactPage.NavigateAddContact();
		
		//Thread.sleep(3000);
		
		ArrayList<String> ContactData = new ArrayList<String>();
		FilePath = "./data/Data.xlsx";
		SheetNum = 1;
		ContactData.addAll(readXLPage.getXlData(FilePath, SheetNum));
		
		String FullName = ContactData.get(0);
		String CompanyName = ContactData.get(1);
		String Email = ContactData.get(2);
		String Phone = ContactData.get(3);
		String Address = ContactData.get(4);
		String City = ContactData.get(5);
		String State = ContactData.get(6);
		String Zip = ContactData.get(7);
		String Country = ContactData.get(8);
		
		addContactPage.FillContactForm(FullName,CompanyName, Email,Phone,Address,City,State,Zip,Country);

	}

}
