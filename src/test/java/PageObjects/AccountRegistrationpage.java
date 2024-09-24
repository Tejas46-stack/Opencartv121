package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class AccountRegistrationpage extends BasePage
{
	public AccountRegistrationpage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//input[@id='input-firstname']") WebElement txtfirstname;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]") WebElement txtLastname;
	
	@FindBy(xpath="//*[@id=\"input-email\"]") WebElement txtemail;
	
	@FindBy(xpath="//*[@name=\"telephone\"]") WebElement txtTelephone;
	
	@FindBy(xpath="//*[@id=\"input-password\"]") WebElement txtpassword;
	
	@FindBy(xpath="//*[@id=\"input-confirm\"]") WebElement txtconfirmpassword;
	
	@FindBy(xpath="//*[@name=\"agree\"]") WebElement checkpolicy ;
	
	@FindBy(xpath="//*[@value=\"Continue\"]")  WebElement btnContinue ;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") 
	WebElement msgConfirmation ;
	
	public void setFirstName(String fname)
	{
		txtfirstname.sendKeys(fname);
	}
	
	public void setLastname(String Lname)
	{
		txtLastname.sendKeys(Lname);
	}
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setpassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setconfirmpwd(String pwd)
	{
		txtconfirmpassword.sendKeys(pwd);
	}
	
	public void chkpolicy()
	{
		checkpolicy.click();
	}
	public void clickContinue()
	{
		btnContinue.click();
		
		//solution2
		//btnContinue.submit();
		
		//Actions act=new Actions(driver);
		//act.moveToElement(btnContinue).click().perform();
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();",btnContinue);
		
	}
	
	public String getConfirmationMsg()
	{
		try {
		return (msgConfirmation.getText());
		}
		catch(Exception e)
		{
			return (e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
