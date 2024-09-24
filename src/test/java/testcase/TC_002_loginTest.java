package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Home_page;
import PageObjects.Loginpage;
import PageObjects.MyAccountpage;


public class TC_002_loginTest extends Baseclass
{
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		try {
		//home page
	Home_page hp=new Home_page(driver);
	hp.clickmyaccount();
	hp.cli_login();;
	
	Thread.sleep(4000);
	//login
	Loginpage lp=new Loginpage(driver);
	lp.setEmail("pavanoltraining@gmail.com");
	lp.setpwd("test@123");
	lp.click_login();
	
  //Myaccount 
	MyAccountpage macc=new  MyAccountpage(driver);
	boolean   targetpage=macc.ismyaccaountexists();
	
	Assert.assertEquals(targetpage, true);

	}//pavanoltraining@gmail.com     test@123
		catch(Exception e) 
		{
			Assert.fail();
		}
	}
	
	
	
	

}
