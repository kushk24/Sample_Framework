package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountResistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC_001_AccountRegistrationTestCase extends BaseClass{

	public WebDriver driver;

	@Test
	public void verify_AccountRegistrationPage() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		// 1. Go to home page
		Thread.sleep(4000);
		hp.ClickRegister();

		AccountResistrationPage arp = new AccountResistrationPage(driver);
		// Enter First Name
		//arp.EnterFirstName("Joohn"); 
		arp.EnterFirstName(randomString().toUpperCase());
		
		// Enter the last Name
		//arp.EnterLastName("Doe");
		arp.EnterLastName(randomString().toUpperCase());
		
		// Enter the Email
		//arp.EnterEmail("jod@gmail.com");
		arp.EnterEmail(randomString()+"@gmail.com");
		
		// Enter mobile no
		//arp.EnterMobileNumber("9696405270");
		arp.EnterMobileNumber("9767"+randomNumber());
		
		// Select dropdown
		arp.selectDrp("Engineer");
		
		// Click male radio button
		arp.ClickRadioBtnMale();
		
		String password = randomAlphaNumberic();
		// Enter password
		//arp.EnterPassword("Jd@12345");
		arp.EnterPassword(password);
		
		// Enter Coinfirm Password
		//arp.EnterConfirmPassword("Jd@12345");
		arp.EnterConfirmPassword(password);
		
		// Click privacy check box
		arp.ClickCheckBox();
		
		// Enter Resiter
		arp.ClickRegister();
		
		String Msg = arp.getConfirmationMsg();
		Assert.assertEquals(Msg, "Account Created Successfully");

	}
	
}
