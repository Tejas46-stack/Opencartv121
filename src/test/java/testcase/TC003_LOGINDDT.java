package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Home_page;
import PageObjects.Loginpage;
import PageObjects.MyAccountpage;
import utilities.Data_providers;

public class TC003_LOGINDDT extends Baseclass
{
	
	@Test(dataProvider="logindata",dataProviderClass=Data_providers.class,groups="DataDriven")
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		try {
		Home_page hp=new Home_page(driver);
		hp.clickmyaccount();
		hp.cli_login();
		
		Thread.sleep(4000);
		//login
		Loginpage lp=new Loginpage(driver);
		lp.setEmail(email);
		lp.setpwd(pwd);
		lp.click_login();
		
	  //Myaccount 
		MyAccountpage macc=new  MyAccountpage(driver);
		boolean   targetpage=macc.ismyaccaountexists();
		
	if(exp.equalsIgnoreCase("valid"))	
	{
		if(targetpage==true)
		{
			Assert.assertTrue(true);
			macc.clicklogout();
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	if(exp.equalsIgnoreCase("Invalid"))
	{
		if(targetpage==true)
		{
			macc.clicklogout();
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
			Assert.fail();
		}
		
	}

}
