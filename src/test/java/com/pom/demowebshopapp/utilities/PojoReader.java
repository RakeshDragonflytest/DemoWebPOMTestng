package com.pom.demowebshopapp.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.pom.demowebshopapp.supporters.ExcelReader;
import com.pom.demowebshopapp.supporters.PropertiesReader;



public class PojoReader {
	public static ExcelReader getExcelObj() throws EncryptedDocumentException, IOException 
	{
		ExcelReader excelReader=new ExcelReader(FilePaths.excelFilePath);
		return excelReader;
	}

	public static PropertiesReader getPrConf() throws IOException 
	{
		PropertiesReader prConf=new PropertiesReader(FilePaths.confFilePath);
		return prConf;
	}
}
