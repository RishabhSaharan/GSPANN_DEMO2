package com.gspann.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import com.gspann.core.ActionDriver;
import com.gspann.core.DriverFactory;
/**
 * Created by GSPANN
 */
public class TDA_HomePage extends ActionDriver{

	private By getOpenAccount=By.xpath("//li[contains(@class,'emphasized')]");
	
	public TDA_HomePage(WebDriver driver) {
		super(driver);
		if(!isElementPresent(getOpenAccount)){
			throw new NoSuchWindowException("This is not a home page and page is: "+getTitle());
		}
	}
	
	
	public boolean GetOpenAccount(String value){
		return isElementPresent(getOpenAccount);
	}
	
/*	DriverFactory df = new DriverFactory();
	
	public TDA_HomePage getAttributeByTitle(String string){
		return df.itle").equalsIgnoreCase("Open New Account");
	}*/
}
