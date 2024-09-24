package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Utility 
{
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public Excel_Utility (String path)
	{
		this.path=path;
	}
	
	public int getRowcount(String sheetName) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int row_count=sheet.getLastRowNum();
		workbook.close();
		return row_count;
		
	}
	
	public int getcell_count(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		return cellcount;
		
	}
	
	public String getcelldata(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formattter=new DataFormatter();
		String data;
		
		try {
		data=formattter.formatCellValue(cell);
		}
		catch(Exception e)
		{
		    data="";	
		}
		workbook.close();
		fi.close();
		return data;
		
		
		
	}
	
	/*public void sellCelldata(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File x1file=new File(path);
		if(!x1file.exists())
		{
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(path);
			workbook.write(fo);
		}
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
	if(workbook.getSheetIndex(sheetName)==-1)//if sheet not exists then create new sheet
		workbook.createSheet(sheetName);
	 sheet=workbook.getSheet(sheetName);
		
	 if(sheet.getRow(rownum)==null)
		 sheet.createRow(rownum);
	   row=sheet.getRow(rownum);
	   
	   cell=row.createCell(colnum);
	   cell.setCellValue(data);
	   fo=new FileOutputStream(path);
	   workbook.write(fo);
	   workbook.close();
	   fi.close();
	   fo.close();
	}
	*/
	
	

}
