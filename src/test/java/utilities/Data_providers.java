package utilities;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class Data_providers 
{
	@DataProvider(name="logindata")
    public String[][] getdata() throws IOException
    {
		String path="H:\\practice_maduuuu_selenium\\opencart_121\\src\\test\\resources\\testdata\\Book1.xlsx";//taking xl file from test data
    	
    	Excel_Utility xlutil=new Excel_Utility(path);
    	
      int totalrows=xlutil.getRowcount("Sheet1");
      int totalcols=xlutil.getcell_count("Sheet1", 1);
      
   String logindata [][]=new String[totalrows][totalcols];
   
   for (int i = 1; i <=totalrows; i++)
   {
	   for (int j = 0; j < totalcols ; j++)
	   {
		   logindata [i-1][j]=xlutil.getcelldata("Sheet1", i, j);//1,0
	}
	
}
return logindata;
    	
    	
   }
	
}
