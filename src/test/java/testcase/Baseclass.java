package testcase;

import java.time.Duration;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass
{
	public static  WebDriver driver;	
	
	  @Parameters({"os","browser"})
	   @BeforeClass(groups= {"Sanity","Regression","Master"})
	   public void setup(String os,String br)
	   {
		  switch (br.toLowerCase())
			{
			case "chrome":driver=new ChromeDriver();break;
			case "edge":driver=new EdgeDriver();break;
			case "firefox":driver=new FirefoxDriver();break;   
			default :System.out.println("invalid browser name....");return;
			}
		
	      driver.manage().deleteAllCookies(); 
		  
		  driver.manage().deleteAllCookies();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get("https://tutorialsninja.com/demo/index.php?");
		   driver.manage().window().maximize();
		   
	   }
		
	   @AfterClass(groups= {"Sanity","Regression","Master"})
	   public void teardown()
	   {
		   driver.quit();
	   }

	   
	  public String randomstring()
	     {
	    	     String   generatedstring =RandomStringUtils.randomAlphabetic(5);
	    	     return generatedstring;
	     }
		
	      public String randomnumeric()
	      {
	    	String   generatednumeric=RandomStringUtils.randomNumeric(10);
	    	return generatednumeric;
	      }
		
		 public String randomalpanumeric()
		 {
			 String   generatedstring =RandomStringUtils.randomAlphabetic(3);
			 String   generatednumeric=RandomStringUtils.randomNumeric(5);
			 return (generatedstring+"@"+generatednumeric);
			 
		 }
		 
		 public String captureScreen(String tname)
		 {
		String timestamp=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
			 
	   TakesScreenshot takescreenshot=(TakesScreenshot)driver;
	  File      sourcefile= takescreenshot.getScreenshotAs(OutputType.FILE);   
	String targerFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+timestamp+".png";
			File targetFile=new File(targerFilePath) ;
			
			sourcefile.renameTo(targetFile);
			
			return targerFilePath;
			
			
	
		
		 }
	   
	   
	   

}
