package com.gspann.core;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.gspann.utility.ExtentManager;
import com.gspann.utility.ExtentTestManager;
import com.gspann.utility.PropertyReader;

/**
 * Created by GSPANN
 */
public class DriverFactory {
	public SoftAssert softAssertion= new SoftAssert();
	protected static ThreadLocal<WebDriver> driver;
	private DesiredCapabilities caps;
	PropertyReader prop;
	private final static Logger LOGGER = LogManager.getLogger(DriverFactory.class);  
	
	@BeforeClass
	public void initializeDriver(){
		 try {
			 prop=new PropertyReader("config.properties"); 
		     } catch (Exception e) {
		      e.printStackTrace();
		      throw new RuntimeException("Problem with config file");
		    }
		driver=new ThreadLocal<WebDriver>();
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void openBrowser(@Optional("firefox") String browser) throws MalformedURLException{
		String grid=prop.getProperty("Grid");
		String baseURL=prop.getProperty("BaseURL");
		LOGGER.info("Initializing "+browser);
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			caps=DesiredCapabilities.firefox();
			driver.set(grid.equalsIgnoreCase("yes") ?
	             new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps):
                 new FirefoxDriver());
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			caps=DesiredCapabilities.chrome();
			driver.set(grid.equalsIgnoreCase("yes") ?
		             new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps):
	                 new ChromeDriver());
			}
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			caps=DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			driver.set(grid.equalsIgnoreCase("yes") ?
		             new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps):
	                 new InternetExplorerDriver());
		}
		else{
			caps=DesiredCapabilities.firefox();
			driver.set(grid.equalsIgnoreCase("yes") ?
		             new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps):
	                 new FirefoxDriver());
			}
		getDriver().manage().window().maximize();
		getDriver().get(baseURL);
	}
	
	public static WebDriver getDriver(){
		return driver.get();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
	ExtentTestManager.endTest();
	ExtentManager.getInstance().flush();
	if(getDriver()!=null){
		getDriver().quit();
		
	}
  }
}
