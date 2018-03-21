package com.gspann.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.gspann.constants.ConstantVariable;
import com.gspann.core.DriverFactory;
import com.gspann.pages.TDA_LoginPage;
import com.gspann.steps.LoginPage_MyAccountOverview_Scenarios;
import com.gspann.utility.ExtentTestManager;
import com.relevantcodes.extentreports.LogStatus;

/**
 * Created by GSPANN
 */

public class TDA_HomePage_LoginTest_MyAccountOverviewTest extends DriverFactory {
	
	public String Login_UserID = "wcrtest3";
    public String Login_pswd = "3wcrtest";
    
	@Test(description=LoginPage_MyAccountOverview_Scenarios.verifyLogin_MyAccountOverview)
	public void verifyLogin_MyAccountOverview(){
		TDA_LoginPage tdaHome=new TDA_LoginPage(getDriver());

		String appTitle=tdaHome.driver.getTitle();
		
		Assert.assertEquals(appTitle, "Online Stock Trading, Investing, Online Broker | TD Ameritrade");
		
		tdaHome.signIn_myAccOverview(Login_UserID, Login_pswd);	
	
	}
}
