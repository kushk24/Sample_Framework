package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountResistrationPage;
import pageObjects.HomePage;
import testbase.BaseClass;

public class TC_001_AccountRegistrationTestCase extends BaseClass{

	@Test
	public void verify_AccountRegistrationPage() throws InterruptedException {
		
		logger.info("********Starting TC_001_AccountRegistrationTestCase********");
		try
		{
		HomePage hp = new HomePage(driver);
		// 1. Go to home page
		Thread.sleep(4000);
		hp.ClickRegister();
		logger.info("Clicked on Register button");

		AccountResistrationPage arp = new AccountResistrationPage(driver);
		// Enter First Name
		//arp.EnterFirstName("Joohn"); 
		arp.EnterFirstName(randomString().toUpperCase());
		logger.info("Entered the First Name");
		
		// Enter the last Name
		//arp.EnterLastName("Doe");
		arp.EnterLastName(randomString().toUpperCase());
		logger.info("Entered the last Name");

		
		// Enter the Email
		//arp.EnterEmail("jod@gmail.com");
		arp.EnterEmail(randomString()+"@gmail.com");
		logger.info("Entered the email");

		
		// Enter mobile no
		//arp.EnterMobileNumber("9696405270");
		arp.EnterMobileNumber("9767"+randomNumber());
		logger.info("Entered the contact Number");

		
		// Select dropdown
		arp.selectDrp("Engineer");
		logger.info("Selected dropdown");

		
		// Click male radio button
		arp.ClickRadioBtnMale();
		logger.info("Selected Gender - Male");

		
		String password = randomAlphaNumberic();
		// Enter password
		//arp.EnterPassword("Jd@12345");
		arp.EnterPassword(password);
		logger.info("Entered the Password");

		
		// Enter Coinfirm Password
		//arp.EnterConfirmPassword("Jd@12345");
		arp.EnterConfirmPassword(password);
		logger.info("Entered the Password again");

		
		// Click privacy check box
		arp.ClickCheckBox();
		logger.info("Clicked the privacy policy");

		
		// Enter Resiter
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
