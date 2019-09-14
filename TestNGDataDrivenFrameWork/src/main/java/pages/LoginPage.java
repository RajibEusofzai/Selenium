package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {
	
	WebDriver driver;
	
	/*public LoginPage() {
		this.driver = driver;
	}*/

	@FindBy(how = How.ID, using = "username")WebElement UserName;
	@FindBy(how = How.ID, using = "password")WebElement PassWord;
	@FindBy(how = How.NAME, using = "login")WebElement SignIn;
		
	public void login(String username, String password) {
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		SignIn.click();
	}
}
