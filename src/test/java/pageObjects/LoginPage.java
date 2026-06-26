package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "login")
	WebElement Login;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Register;

	public void EnterEmail(String email) {
		Email.clear();
		Email.sendKeys(email);
	}

	public void EnterPassword(String pwd) {
		Password.clear();
		Password.sendKeys(pwd);
	}

	public void ClickLogin() {
		Login.click();
	}

	public void ClickRegister() {
		Register.click();
	}

}
