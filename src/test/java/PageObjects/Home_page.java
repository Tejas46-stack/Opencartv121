package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class Home_page extends BasePage
{
	public Home_page(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement inmyaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkregister;
	
	@FindBy(xpath="//*[text()='Login']") WebElement login_link ;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement linklogin;
	
	public void clickmyaccount()
	{
		
		inmyaccount.click();
	}
	
	public void clickonregister()
	{
		lnkregister.click();
	}
	
	public void login_linkk()
	{
		login_link .click();
	}

	public void cli_login()
	{
		linklogin.click();	}
}
