package testcases;

/*Data is valid  - login success - test pass  - logout
	login failed - test fail

Data is invalid - login success - test fail  - logout
	login failed - test pass
*/

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class) //getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) {
		
		logger.info("********Starting TC_003_LoginDDTTestCase********");
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
		
		
		HomePage hp = new HomePage(driver);
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(title.equals("Let's Shop"))
			{
				hp.ClickLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(title.equals("Let's Shop"))
			{
				hp.ClickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
		catch(Exception e)
		{
			logger.error("Test Failed.......");
			logger.debug("Debug logs.....");
			Assert.fail();
		}
		
		logger.info("********Finished TC_003_LoginDDTTestCase********");
		
	}
}
