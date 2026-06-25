package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testbase.BaseClass;

public class TC_002_LoginTestCase extends BaseClass {
	
	@Test
	public void verify_LoginPage() {
		
		logger.info("********Starting TC_002_LoginTestCase********");
		try
		{
		LoginPage lp = new LoginPage(driver);
		
		lp.EnterEmail(p.getProperty("Email"));
		logger.info("Entered Email");
		
		lp.EnterPassword(p.getProperty("Password"));
		logger.info("Entered Password");
		
		lp.ClickLogin();
		logger.info("Clicked Login Button");
		
		String title= driver.getTitle();
		Assert.assertEquals(title, "Let's Shop");
		logger.info("Verified Login");
		
		HomePage hp = new HomePage(driver);
		hp.ClickLogout();
		logger.info("Logged out from page.....");
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed.......");
			logger.debug("Debug logs.....");
			Assert.fail();
		}
		
		logger.info("********Finished TC_002_LoginTestCase********");
		
	}
}
