package testCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_LoginDDT(String email,String password,String res) {
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
	    lp.clickLogin();
	    
	    MyAccountPage maac= new MyAccountPage(driver);
	   boolean targetPage= maac.isMyAccountPageExists();
		
	   if(res.equalsIgnoreCase("Valid")) {
		   if(targetPage==true) {
			   maac.clickLogout();
			   Assert.assertTrue(true);	   }
	   }
	   if(res.equalsIgnoreCase("Invalid")) {
		   if(targetPage==true)
		   {
			   maac.clickLogout();
			   Assert.assertTrue(false);
			   }
		   else {
			   Assert.assertTrue(true);
		   }
		   }
		}catch(Exception e){
			Assert.fail();
			
		}
	}

}
