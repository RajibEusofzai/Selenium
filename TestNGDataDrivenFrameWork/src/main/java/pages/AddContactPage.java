package pages;

import java.util.Random;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AddContactPage {
	
	WebDriver driver;
	
	/*public LoginPage() {
		this.driver = driver;
	}*/

	@FindBy(how = How.ID, using = "username")WebElement UserName;
	@FindBy(how = How.ID, using = "password")WebElement PassWord;
	@FindBy(how = How.NAME, using = "login")WebElement SignIn;
	@FindBy (how = How.XPATH, using = "//span[contains(text(),'CRM')]") WebElement CRM;
	@FindBy(how = How.LINK_TEXT, using = "Add Contact") WebElement AddContactButton;
	@FindBy(how = How.ID, using = "account")WebElement FullName;
	@FindBy(how = How.ID, using = "company")WebElement CompanyName;
	@FindBy(how = How.ID, using = "email")WebElement Email;
	@FindBy(how = How.ID, using = "phone")WebElement Phone;
	@FindBy(how = How.ID, using = "address")WebElement Address;
	@FindBy(how = How.ID, using = "city")WebElement City;
	@FindBy(how = How.ID, using = "state")WebElement State;
	@FindBy(how = How.ID, using = "zip")WebElement Zip;
	@FindBy(how = How.ID, using = "select2-country-container")WebElement Country;
	@FindBy(how = How.XPATH, using = "/html/body/span/span/span[1]/input")WebElement CountryTextbox;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")WebElement Submit;
	
	
	
		
	public void login(String username, String password) {
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		SignIn.click();
	}
	
	public void NavigateAddContact() {
		CRM.click();
		AddContactButton.click();
	}
	
	public void FillContactForm(String fn, String cm, String em, String ph, String ad, String ct, String st, String zp, String cntr) {
		
		Random random = new Random();
		int rnd = random.nextInt(999);
		
		FullName.sendKeys(fn+rnd);
		CompanyName.sendKeys(cm);
		Email.sendKeys(em+rnd);
		Phone.sendKeys(ph);
		Address.sendKeys(ad);
		City.sendKeys(ct);
		State.sendKeys(st);
		Zip.sendKeys(zp);
		Country.click();
		CountryTextbox. sendKeys(cntr);
		CountryTextbox. sendKeys(Keys.ENTER);
		Submit.click();
	}
}
