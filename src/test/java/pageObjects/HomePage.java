package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[normalize-space()='Sign Out' or normalize-space()='Logout' or contains(.,'Sign Out') or contains(.,'Logout')]")
	WebElement Logout;
	
	public void ClickLogout() {
		Logout.click();
	}

}
