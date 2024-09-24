package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationpage;
import PageObjects.Home_page;

public class TC001_AccountRegistrationTest extends Baseclass
{
   
     @Test(groups= {"Regression","Master"})
    public void verify_Account_registration()
    {
    	
    	Home_page hp=new Home_page(driver);
    	hp.clickmyaccount();
    	hp.clickonregister();
    	
    AccountRegistrationpage regpage=new AccountRegistrationpage(driver);
       regpage.setFirstName(randomstring().toUpperCase());
       regpage.setLastname(randomstring().toUpperCase());
       regpage.setEmail(randomstring()+"@gmail.com");
       regpage.setTelephone(randomnumeric());
                     
        String password=randomalpanumeric();
       regpage.setpassword(password);
       regpage.setconfirmpwd(password);
       
        regpage.chkpolicy();
        regpage.clickContinue();
        
     String     confirmmsg=regpage.getConfirmationMsg();
    Assert.assertEquals(confirmmsg,"Your Account Has Been Created!");
    
    
    }
     
    
	

}
