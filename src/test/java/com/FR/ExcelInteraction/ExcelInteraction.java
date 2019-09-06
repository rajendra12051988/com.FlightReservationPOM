package com.FR.ExcelInteraction;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelInteraction {
	
	Workbook wb=null;
	File file=null;
	FileInputStream inputstream=null;
	Sheet sheet = null;
	FileOutputStream outputStream = null;
	
	public ExcelInteraction(String filePath, String fileName) {
		try {
		file = new File(filePath+"\\"+fileName);
		
		inputstream = new FileInputStream(file);
		
		String fileExtension = fileName.substring(fileName.indexOf("."));
		
		if(fileExtension.equals(".xlsx")) {
		
				wb = new XSSFWorkbook(inputstream);
		
		}else if(fileExtension.equals(".xls")) {
			wb = new HSSFWorkbook(inputstream);
		}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	
	public int getRowCount(String sheetName) {
		sheet = wb.getSheet(sheetName);
		System.out.println("First Row number : "+sheet.getFirstRowNum());
		System.out.println("Last Row number : "+sheet.getLastRowNum());
		int rowCount =  sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		return rowCount;
		
	}
	
	
	
	public String getCellData(String sheetName, int rowno, int colno) {
		sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(colno);
		
		String data =  cell.getStringCellValue().trim();
		
		return data;
	}
	
	
	public void writeStatus(String sheetName, int rowno, int colno, String content) {
		sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowno);
		Cell cell = row.createCell(colno);
		cell.setCellValue(content);
		
		CellStyle style = wb.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		
		if(content.equals("Passed")) {
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}else if(content.equals("Failed")) {
			style.setFillForegroundColor(IndexedColors.RED.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}
		
		cell.setCellStyle(style);
		
		try {
			file = new File(System.getProperty("user.dir")+"\\TestData\\URLProvider.xls");
			outputStream = new FileOutputStream(file);
			wb.write(outputStream);
			outputStream.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void closeWorkbook() {
		try {
			wb.close();
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	public void closeInputStream() {
		try {
			inputstream.close();
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
}
