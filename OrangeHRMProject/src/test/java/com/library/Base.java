package com.library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.library.SeleniumSupport.Browser;

public class Base {

	public static final Logger log = LogManager.getLogger(Base.class);

	public static WebDriver driver;
	public SeleniumSupport myLibGS = new SeleniumSupport();

	private String configPath = "src/test/resources/config.properties";
	private String browserType = "src/test/resources/config.properties";
	private String isDemoMode = "src/test/resources/config.properties";
	private String isHeadlessMode = "src/test/resources/config.properties";
	private String isRemoteMode = "src/test/resources/config.properties";
	private String hubURLString = "src/test/resources/config.properties";

	@BeforeClass
	public void beforeAllTest() {
		// this method will run only one time, right before any method in this class
		// runs.
		log.info("Running before all tests.");
		JavaPropertiesManager readProp = new JavaPropertiesManager(configPath);
		browserType = readProp.readProperty("browser").toLowerCase();
		isDemoMode = readProp.readProperty("isDemoMode").toLowerCase();
		isHeadlessMode = readProp.readProperty("isHeadless").toLowerCase();
		isRemoteMode = readProp.readProperty("isRemote").toLowerCase();
		hubURLString = readProp.readProperty("hubURL").toLowerCase();
	}

	
	@AfterClass
	public void afterAllTest() {
		// this method will run only one time, right after all test/other methods
		// executed.
		log.info("Running after all tests.");
	}

	@BeforeMethod
	public void setUp() {
		if(isHeadlessMode.contains("yes")) {
			myLibGS.setIsHeadless(true);
		}
		
		if(isDemoMode.contains("on")) {
			myLibGS.setIsDemo(true);
		}
		
		if (isRemoteMode.contains("on")) {
			myLibGS.setIsRemote(true);
			
			if(browserType.contains("chrome")) {
				driver = myLibGS.startARemoteBrowser(hubURLString, Browser.CHROME);
			} else if (browserType.contains("edge")) {
				driver = myLibGS.startARemoteBrowser(hubURLString, Browser.EDGE_CHROMIUM);
			} else if (browserType.contains("firefox")) {
				driver = myLibGS.startARemoteBrowser(hubURLString, Browser.FIREFOX);
			}
			
		} else {

			if (browserType.contains("chrome")) {
				driver = myLibGS.startABrowser(Browser.CHROME);
			} else if (browserType.contains("edge")) {
				driver = myLibGS.startABrowser(Browser.EDGE_CHROMIUM);
			} else if (browserType.contains("firefox")) {
				driver = myLibGS.startABrowser(Browser.FIREFOX);
			} else if (browserType.contains("safari")) {
				driver = myLibGS.startABrowser(Browser.SAFARI);
			} else {
				log.info("Currently framework do not support '" + browserType + "' type of browser!");
				log.info("Default browser set to 'CHROME' ");
				driver = myLibGS.startABrowser(Browser.CHROME);
			}
		}
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			// capture screenshot when test fails
			myLibGS.takeScreenshot(result.getName());
		}

		myLibGS.tearDown();

	}

}
