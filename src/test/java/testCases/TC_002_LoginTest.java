package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

	@Test(groups= {"regression","master"})
	public void verify_login()
	{
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
	    lp.clickLogin();
	    
	    MyAccountPage maac= new MyAccountPage(driver);
	   boolean targetPage= maac.isMyAccountPageExists();
		
	if(targetPage==true) {
		Assert.assertTrue(true);
	}
	else {
		Assert.fail();
	}
		
		}
	catch(Exception e) {
		
	Assert.fail();
	
		}
	}
		
	
	}
