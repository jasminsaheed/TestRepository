package com.supermarket_utilities;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelUtil {
HSSFSheet sheet;
	
	public ExcelUtil() throws IOException {
		
		File newfile=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\excelFiles\\login.xls");  		//obtaining filepath(filepath:\\)
		FileInputStream file=new FileInputStream(newfile);							//obtains input bytes from a file
		@SuppressWarnings("resource")
		HSSFWorkbook workbook=new HSSFWorkbook(file);								//obtains workbook from the file
		sheet=workbook.getSheet("Sheet1");											//obtains sheet from workbook
	}
	
	public String readDataFromExcel(int i,int j) {    
		Row row=sheet.getRow(i);	//obtains row from the sheet
		Cell cell=row.getCell(j);	//obtains cell from the row
		CellType type=cell.getCellType(); //obtains the data type of the cell
		switch(type)				//condition,checking the datatype of the value in the cell
		{		
			case NUMERIC:
				return String.valueOf(cell.getNumericCellValue());	//getting the numeric value and converting the same to string
			
			case STRING:
				return cell.getStringCellValue();		//getting the string value	
			default:
				break;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) throws Exception {
		ExcelUtil obj=new ExcelUtil();
		String S=obj.readDataFromExcel(0,0);	//receives the string value of 0th row,1st column 
		System.out.println(S);
	}

}
