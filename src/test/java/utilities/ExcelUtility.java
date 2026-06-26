package utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public Workbook workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	public CellStyle style;   
	String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
		
	public int getRowCount(String sheetName) throws IOException 
	{
		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				return 0;
			}
			return localSheet.getLastRowNum();
		}
	}
	
	public int getCellCount(String sheetName,int rownum) throws IOException
	{
		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				return 0;
			}
			Row localRow = localSheet.getRow(rownum);
			if (localRow == null) {
				return 0;
			}
			return localRow.getLastCellNum();
		}
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				return "";
			}
			Row localRow = localSheet.getRow(rownum);
			if (localRow == null) {
				return "";
			}
			Cell localCell = localRow.getCell(colnum);
			DataFormatter formatter = new DataFormatter();
			return formatter.formatCellValue(localCell); // Returns formatted value regardless of cell type.
		}
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			try (Workbook newWorkbook = WorkbookFactory.create(true);
					FileOutputStream localFo = new FileOutputStream(path)) {
				newWorkbook.write(localFo);
			}
		}

		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				localSheet = localWorkbook.createSheet(sheetName);
			}

			Row localRow = localSheet.getRow(rownum);
			if (localRow == null) {
				localRow = localSheet.createRow(rownum);
			}

			Cell localCell = localRow.createCell(colnum);
			localCell.setCellValue(data);

			try (FileOutputStream localFo = new FileOutputStream(path)) {
				localWorkbook.write(localFo);
			}
		}
	}
	
	
	public void fillGreenColor(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				return;
			}

			Row localRow = localSheet.getRow(rownum);
			if (localRow == null) {
				return;
			}

			Cell localCell = localRow.getCell(colnum);
			if (localCell == null) {
				localCell = localRow.createCell(colnum);
			}

			CellStyle localStyle = localWorkbook.createCellStyle();
			localStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			localStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			localCell.setCellStyle(localStyle);

			try (FileOutputStream localFo = new FileOutputStream(path)) {
				localWorkbook.write(localFo);
			}
		}
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum) throws IOException
	{
		try (FileInputStream localFi = new FileInputStream(path);
				Workbook localWorkbook = WorkbookFactory.create(localFi)) {
			Sheet localSheet = localWorkbook.getSheet(sheetName);
			if (localSheet == null) {
				return;
			}

			Row localRow = localSheet.getRow(rownum);
			if (localRow == null) {
				return;
			}

			Cell localCell = localRow.getCell(colnum);
			if (localCell == null) {
				localCell = localRow.createCell(colnum);
			}

			CellStyle localStyle = localWorkbook.createCellStyle();
			localStyle.setFillForegroundColor(IndexedColors.RED.getIndex());
			localStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			localCell.setCellStyle(localStyle);

			try (FileOutputStream localFo = new FileOutputStream(path)) {
				localWorkbook.write(localFo);
			}
		}
	}
	
}