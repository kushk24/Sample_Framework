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

public class TC_003_LoginDDT extends BaseClass {
	
	@Test
	public void verify_LoginDDT() {
		
		logger.info("********Starting TC_003_LoginDDTTestCase********");
		try
		{
		LoginPage lp = new LoginPage(driver);
		
		
		
		

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
