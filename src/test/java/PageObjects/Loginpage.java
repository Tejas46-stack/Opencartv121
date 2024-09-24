package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

 public class Loginpage extends BasePage
{

	public Loginpage(WebDriver driver)
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//*[@id=\"input-email\"]") WebElement txtemail;
	
	@FindBy(xpath="//*[@id=\"input-password\"]") WebElement txtpwd;
	
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input") WebElement login_btn;

	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setpwd(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void click_login()
	{
		login_btn.click();
	}
	 
}
