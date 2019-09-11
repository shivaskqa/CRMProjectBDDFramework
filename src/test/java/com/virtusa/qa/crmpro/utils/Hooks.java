package com.virtusa.qa.crmpro.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Hooks {

	
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;
	private static XSSFRow row;
    String data[][];
    
    
	
	public String[][] readExcel(String path,String sheetname)
	{
		
	  try {
		fis=new FileInputStream(path);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(sheetname);
		int lastrow=sheet.getLastRowNum();
		
		data=new String[lastrow][];
		
		
		for(int i=1;i<lastrow;i++)
		{ 
			row=sheet.getRow(i);
			int lastcellnum=row.getLastCellNum();
			 for(int j=0;j<lastcellnum;j++) {
				 cell=row.getCell(j);
			       String celldata=cell.getStringCellValue();
			       System.out.println(celldata);
			       data[i-1][j]=celldata;
			 }
			 System.out.println();
		}
		
		
	   } catch (FileNotFoundException e) {
		e.printStackTrace();
		
		}
	  catch(IOException e)
	  {
		  System.out.println(); 
	  }
		return data;
}	
		
	
	
	
	
}
