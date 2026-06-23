package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "userEmail")
	WebElement Email;

	public void EnterEmail(String email) {
		Email.sendKeys(email);
	}
	
	@FindBy(id = "userPassword")
	WebElement Password;

	public void EnterPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	
	@FindBy(id = "login")
	WebElement Login;

	public void ClickLogin() {
		Login.click();
	}
	

}
