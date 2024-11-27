package com.pom.demowebshopapp.supporters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	private String filePath;
	private FileInputStream fileInputStream;
	private Workbook workbook;
	private Sheet sheet;
	public Row row;
	private Cell cell;
	private String cellValue;
	public ExcelReader(String filePath) throws EncryptedDocumentException, IOException 
	{
		this.filePath=filePath;
		
		fileInputStream=new FileInputStream(filePath);
		workbook=WorkbookFactory.create(fileInputStream);
		}
	public Sheet getTotalNooFsheets()
	{
		int noofSheets=0;
		if(workbook!=null)
		{
			noofSheets=workbook.getNumberOfSheets();
		}
		else
		{
			System.out.println("Workbook is pointing to null");
		}
		return sheet;
	}
	public Sheet getSheetObj(String how,String howValue)
	{
		if(workbook!=null)
		{
			if(how.equalsIgnoreCase("sheetName"))
			{
				sheet=(Sheet) workbook.getSheet(howValue);
			}
			else if(how.equalsIgnoreCase("index"))
					{
				int indx=Integer.parseInt(howValue);
				
					sheet=workbook.getSheetAt(indx);
					}
			else {
				System.out.println("Sheet is pointing to null");
			}
			
	}
		return sheet;
	}
	public Row getRowObj(String how,String howValue,int rowNum)
	{
		sheet=getSheetObj(how, howValue);
		if(sheet!=null)
		{
			row=sheet.getRow(rowNum);
		}
		else
		{
			System.out.println("Sheet pointing to null");
		}
		return row;
	}
	public Cell getCellObj(String how,String howValue,int rowNum,int cellNum)
	{
		row=getRowObj(how,howValue,rowNum);
		if(row!=null)
		{
			cell=row.getCell(cellNum);
		}
		else
		{
			System.out.println("Row is pointing to null");
		}
					
		return cell;
	}
	public String getCellData(String how,String howValue,int rowNum,int cellNum)
	{
		cell=getCellObj(how,howValue,rowNum,cellNum);
		System.out.println(filePath);
		if(cell!=null)
		{
			if(cell.getCellType()==CellType.STRING)
			{
				cellValue=cell.getStringCellValue();
			}
			else if(cell.getCellType()==CellType.NUMERIC)
			{
				cellValue=cell.getNumericCellValue()+"";
			}
			else if(cell.getCellType()==CellType.BOOLEAN)
			{
				cellValue=cell.getBooleanCellValue()+"";
			}
		}
		else
		{
			System.out.println("Cell is pointing to null");
		}
		return cellValue;
		}

	public List<String> getRowData(String how,String howValue,int rowNum)
	{
		List<String> rowData=new ArrayList<String>();
		for(int i=0;i<row.getLastCellNum();i++)
		{
			cell=row.getCell(i);
			if(cell!=null)
			{
				if(cell.getCellType()==CellType.STRING)
				{
					cellValue=cell.getStringCellValue();
				}
				else if(cell.getCellType()==CellType.NUMERIC)
				{
					cellValue=cell.getNumericCellValue()+"";
				}
				else if(cell.getCellType()==CellType.BOOLEAN)
				{
					cellValue=cell.getBooleanCellValue()+"";
				}
			}
			else
			{
				System.out.println("Cell is pointing to null");
			}
			}
		return rowData;
	}
	public List<String> getSheetData(String how,String howValue)
	{
		List<String>sheetData=new ArrayList<String>();
		sheet=getSheetObj(how, howValue);
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				cell=row.getCell(j);
				if(cell!=null)
				{
					if(cell.getCellType()==CellType.STRING)
					{
						cellValue=cell.getStringCellValue();
					}
					else if(cell.getCellType()==CellType.NUMERIC)
					{
						cellValue=cell.getNumericCellValue()+"";
					}
					else if(cell.getCellType()==CellType.BOOLEAN)
					{
						cellValue=cell.getBooleanCellValue()+"";
						sheetData.add(cellValue);
					  }
					else
					{
						System.out.println("Cell is pointing to null");
					}
					}
					}
		}
			return sheetData;
		}
	public Set<String> getIniqueSheetData(String how,String howValue)
	{
		Set<String> setData=null;
		List<String> listData=getSheetData(how,howValue);
		if(listData.size()>2)
		{
			Set<String> sesetData=new HashSet<>(listData);
		}
		return setData;
		}

}
