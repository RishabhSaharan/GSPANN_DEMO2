package com.gspann.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.gspann.constants.ConstantVariable;
import com.gspann.core.DriverFactory;
import com.gspann.pages.TDA_LoginPage;
import com.gspann.steps.LoginPage_Balances_Scenarios;
import com.gspann.steps.LoginPage_MyAccountOverview_Scenarios;
import com.gspann.utility.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by GSPANN
 */

public class TDA_HomePage_LoginTest_BalancesTest extends DriverFactory {

	public String Login_UserID = "wcrtest3";
    public String Login_pswd = "3wcrtest";
   
	@Test(description=LoginPage_Balances_Scenarios.verifyLogin_Balances)
	public void verifyLogin_Balances(){
		TDA_LoginPage tdaHome=new TDA_LoginPage(getDriver());
		
		String appTitle=tdaHome.driver.getTitle();

	//	Assert.assertEquals(appTitle, "Online Stock Trading, Investing, Online Broker | TD Ameritrade11");
		
		//NOTE: BELOW LINE OF SOFT ASSERTION IS FAILED INTENTIONALLY
		softAssertion.assertEquals(appTitle, "Online Stock Trading, Investing, Online Broker | TD Ameritrade11");
		tdaHome.signIn_balances(Login_UserID, Login_pswd);	
		softAssertion.assertAll();
	}
	
/*	@AfterMethod(alwaysRun=true)
	public void afterTest()
	{
		softAssertion.assertAll();
	}
	*/
}
