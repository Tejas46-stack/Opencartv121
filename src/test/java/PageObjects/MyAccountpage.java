package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePage;

public class MyAccountpage extends BasePage
{

	public MyAccountpage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement msgheading;
	
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	WebElement logout_btn;
	
	
	public boolean ismyaccaountexists()
	{
		try {
		return (msgheading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clicklogout()
	{
		logout_btn.click();
	}

}
