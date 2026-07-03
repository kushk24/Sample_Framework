package testcases;

/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups={"datadriven","Master"}) //getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("********Starting TC_003_LoginDDTTestCase********");
		try
		{
		LoginPage lp = new LoginPage(driver);
		
		lp.EnterEmail(email);
		logger.info("Entered Email");
		
		lp.EnterPassword(pwd);
		logger.info("Entered Password");
		
		lp.ClickLogin();
		logger.info("Clicked Login Button");
		
		String currentUrl = driver.getCurrentUrl();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			Assert.assertFalse(currentUrl.contains("/auth/login"), "Expected successful login, but still on login page.");
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			Assert.assertTrue(currentUrl.contains("/auth/login"), "Expected invalid login to stay on login page.");
		}
	}
		catch(Exception e)
		{
			logger.error("Test Failed.......", e);
			logger.debug("Debug logs.....");
			Assert.fail();
		}
		finally
		{
			// Reset the application state before the next data set runs.
			driver.get(p.getProperty("appURL"));
		}
		
		logger.info("********Finished TC_003_LoginDDTTestCase********");
		
	}
}
