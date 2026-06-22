package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountResistrationPage extends BasePage {

	public AccountResistrationPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "firstName")
	WebElement FirstName;

	@FindBy(id = "lastName")
	WebElement LastName;

	@FindBy(id = "userEmail")
	WebElement Email;

	@FindBy(id = "userMobile")
	WebElement MobileNumber;

	@FindBy(tagName = "select")
	WebElement drpOccupation;

	@FindBy(xpath = "//input[@value='Male']")
	WebElement RadioBtnMale;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "confirmPassword")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@type='checkbox']")
	WebElement CheckBox;

	@FindBy(id = "login")
	WebElement Register;

	@FindBy(xpath = "//h1[normalize-space()='Account Created Successfully']")
	WebElement msgConfirmation;

	public void EnterFirstName(String fname) {
		FirstName.sendKeys(fname);
	}

	public void EnterLastName(String lname) {
		LastName.sendKeys(lname);
	}

	public void EnterEmail(String email) {
		Email.sendKeys(email);
	}

	public void EnterMobileNumber(String mobileNumber) {
		MobileNumber.sendKeys(mobileNumber);
	}

	// dropdown
	public void selectDrp(String drp) {
		Select sl = new Select(drpOccupation);
		sl.selectByVisibleText(drp);
	}

	public void ClickRadioBtnMale() {
		RadioBtnMale.click();
	}

	public void EnterPassword(String pwd) {
		Password.sendKeys(pwd);
	}

	public void EnterConfirmPassword(String pwd) {
		ConfirmPassword.sendKeys(pwd);
	}

	public void ClickCheckBox() {
		CheckBox.click();
	}

	public void ClickRegister() {
		//1. Register.click();
		// 2.
		Register.submit();

		// 3. Actions act = new Actions(driver);
		// act.moveToElement(Register).click().perform();

		//4.
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();", Register);

		// 5. Register.sendKeys(Keys.ENTER);
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirmation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
