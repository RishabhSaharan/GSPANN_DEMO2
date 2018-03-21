package com.gspann.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gspann.core.ActionDriver;
/**
 * Created by GSPANN
 */
public class TDA_LoginPage extends ActionDriver{
    
    private By getUsername= By.xpath("//*[@id=\'userid\']");
	private By getPassword=By.xpath("(//*[@id=\'password\'])");
    private By getDefaultDropVal=By.xpath("//*[@id=\'form-login\']/div[2]/div/button");
    private By getSelDropVal_myAccOverview=By.xpath("//*[@id=\'form-login\']/div[2]/div/ul/li[1]/label");
    private By getSelDropVal_balances=By.xpath("//*[@id=\"form-login\"]/div[2]/div/ul/li[2]/label");
    private By getLogInBtn=By.xpath("//button[@title='Log in']");
	
	public TDA_LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	public TDA_LoginPage typeUsername(String username) {
		type(getUsername, username);
		return new TDA_LoginPage(driver);
	}
	
	
	public TDA_LoginPage typePassword(String password){
		type(getPassword, password);
		return new TDA_LoginPage(driver);
	}
	
	
	public TDA_LoginPage clickLoginBtn1(){
		click(getLogInBtn);
		return new TDA_LoginPage(driver);
	}
	
	
	
	public TDA_LoginPage signIn_myAccOverview(String username,String password){
		type(getUsername, username);
		type(getPassword, password);
		click(getDefaultDropVal);
		click(getSelDropVal_myAccOverview);
		click(getLogInBtn);
		return new TDA_LoginPage(driver);
	}
	
	
	public TDA_LoginPage signIn_balances(String username,String password){
		type(getUsername, username);
		type(getPassword, password);
		click(getDefaultDropVal);
		click(getSelDropVal_balances);
		click(getLogInBtn);
		return new TDA_LoginPage(driver);
	}
	
	
	
}
