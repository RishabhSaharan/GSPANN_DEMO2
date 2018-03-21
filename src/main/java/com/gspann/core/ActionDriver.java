package com.gspann.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gspann.utility.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;


/**
 * Created by GSPANN
 */
public class ActionDriver {
	
	public final static Logger LOGGER = LogManager.getLogger(ActionDriver.class);  
	public WebDriver driver;
	WebDriverWait wait;
	private long waitTime=30;
	
	public ActionDriver(WebDriver driver){
	
		
		this.driver=driver;
		wait=new WebDriverWait(driver,waitTime);
	}
	
	
	public void infoLog(String info){
	//	driver=getDriver();
	 ExtentTestManager.getTest().log(LogStatus.INFO,info);
	 LOGGER.info(info);
	}
	
/*	private WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
*/

	public String getTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	return driver.getTitle();
	}
	
	public void type(By loc,String value){
		infoLog("Waiting for element: "+loc);
		WebElement element=waitForElementPresent(loc);
		infoLog("element found: "+loc);
		infoLog("Typing '" +value+"' into "+loc);
		element.sendKeys(value);
		
	}

	public void click(By loc){
		infoLog("Waiting for element: "+loc);
		WebElement element=waitForElementPresent(loc);
		infoLog("clicking on element: "+loc);
		element.click();
	}
	
	public boolean textEqualTo(By loc,String value){
		infoLog("Waiting for element: "+loc);
		return waitForElementPresent(loc).getText().equals(value);
		}
	
	public String getTitle(){
		return driver.getTitle();
	}
	
	public WebElement waitForElementPresent(By loc){
		infoLog("Waiting for element: "+loc);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	
	public boolean isElementPresent(By loc){
		infoLog("Waiting for element: "+loc);
		WebElement element=waitForElementPresent(loc);
		return element.isDisplayed();
		}
}
