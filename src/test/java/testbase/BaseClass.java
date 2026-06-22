package testbase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public WebDriver driver;
	public Logger logger; //log4j
	
	@BeforeClass
	public void setUp() {
		
		logger = LogManager.getLogger(this.getClass());
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
			
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");	
		driver.manage().window().maximize();
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString()
	{
		String generateString= RandomStringUtils.randomAlphabetic(5);
		return generateString;
	}
	
	public String randomNumber()
	{
		String generateNumber= RandomStringUtils.randomNumeric(6);
		return generateNumber;
	}
	
	public String randomAlphaNumberic()
	{
		String generateString= RandomStringUtils.randomAlphabetic(3);
		String generateNumber= RandomStringUtils.randomNumeric(5);
		return (generateString+"@"+generateNumber);
	}

}
