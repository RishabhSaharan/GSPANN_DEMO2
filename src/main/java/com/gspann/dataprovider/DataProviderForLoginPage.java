package com.gspann.dataprovider;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

import com.gspann.utility.ExcelHandler;
import com.gspann.utility.PropertyReader;


/**
 * Created by GSPANN
 */
public class DataProviderForLoginPage {
	
	 private final static Logger LOGGER = LogManager.getLogger(DataProviderForLoginPage.class); 
	 private static PropertyReader prop=new PropertyReader("config.properties"); 
	 
	@DataProvider
	public static Object[][] validCredentialsProvider(ITestContext context) throws Exception{
		String excelLoc=prop.getProperty("ExcelLoc");
		String excelSheet=prop.getProperty("ExcelSheet");
		LOGGER.info("Opening excel: "+excelLoc);
		ExcelHandler excel=new ExcelHandler(new File(System.getProperty("user.dir")+excelLoc));
		LOGGER.info("Opening excel sheet: "+excelSheet);
		excel.selectSheet(excelSheet);
		String username=excel.getCellData(4,3).getContents();
		String password=excel.getCellData(5,3).getContents();
		return new Object[][]{{username,password}};
	}
	
	@DataProvider
	public static Object[][] invalidCredentialsProvider(ITestContext context) throws Exception{
		String excelLoc=prop.getProperty("ExcelLoc");
		String excelSheet=prop.getProperty("ExcelSheet");
		LOGGER.info("Opening excel: "+excelLoc);
		ExcelHandler excel=new ExcelHandler(new File(System.getProperty("user.dir")+excelLoc));
		LOGGER.info("Opening excel sheet: "+excelSheet);
		excel.selectSheet(excelSheet);
		String username=excel.getCellData(4,4).getContents();
		String password=excel.getCellData(5,4).getContents();
		return new Object[][]{{username,password}};
	}
}
