package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountResistrationPage;
import pageObjects.LoginPage;
import testbase.BaseClass;

public class TC_001_AccountRegistrationTestCase extends BaseClass{

	@Test
	public void verify_AccountRegistrationPage() throws InterruptedException {
		
		logger.info("********Starting TC_001_AccountRegistrationTestCase********");
		try
		{
		//Login Page
		LoginPage lp = new LoginPage(driver);
		logger.info("Home page loaded Successfully");
		Thread.sleep(4000);
		// 1. Clicked on Register button
		lp.ClickRegister();
		logger.info("Clicked on Register button");

		
		//Register Page
		AccountResistrationPage arp = new AccountResistrationPage(driver);
		// 2. Enter First Name
		//arp.EnterFirstName("Joohn"); 
		arp.EnterFirstName(randomString().toUpperCase());
		logger.info("Entered the First Name");
		
		// 3. Enter the last Name
		//arp.EnterLastName("Doe");
		arp.EnterLastName(randomString().toUpperCase());
		logger.info("Entered the last Name");

		
		// 4. Enter the Email
		//arp.EnterEmail("jod@gmail.com");
		arp.EnterEmail(randomString()+"@gmail.com");
		logger.info("Entered the email");

		
		// 5. Enter mobile no
		//arp.EnterMobileNumber("9696405270");
		arp.EnterMobileNumber("9767"+randomNumber());
		logger.info("Entered the contact Number");

		
		// 6. Select dropdown
		arp.selectDrp("Engineer");
		logger.info("Selected dropdown");

		
		// 7. Click male radio button
		arp.ClickRadioBtnMale();
		logger.info("Selected Gender - Male");

		
		String password = randomAlphaNumberic().toUpperCase()+randomAlphaNumberic().toLowerCase()+"@";
		//System.out.println(password);
		// 8. Enter password
		//arp.EnterPassword("Jd@12345");
		arp.EnterPassword(password);
		logger.info("Entered the Password");

		
		// 9. Enter Coinfirm Password
		//arp.EnterConfirmPassword("Jd@12345");
		arp.EnterConfirmPassword(password);
		logger.info("Entered the Password again");

		
		// 10. Click privacy check box
		arp.ClickCheckBox();
		logger.info("Clicked the privacy policy");

		
		// 11. Enter Resiter
		arp.ClickRegister();
		logger.info("Clicked the Register button");

		
		String Msg = arp.getConfirmationMsg();
		Assert.assertEquals(Msg, "Account Created Successfully");
		logger.info("Verified the success message");
		}
		catch(Exception e)
		{
			logger.error("Test Failed.......");
			logger.debug("Debug logs.....");
			Assert.fail();
		}
		
		logger.info("********Finished TC_001_AccountRegistrationTestCase********");
		

	}
	
}
