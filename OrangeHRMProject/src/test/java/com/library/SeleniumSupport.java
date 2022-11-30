package com.library;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumSupport {
	public static final Logger log = LogManager.getLogger(SeleniumSupport.class);

	private static WebDriver driver;
	private static int waitTimeInSecs = 30;
	private boolean isHeadless = false;
	private boolean isDemo = false;
	private boolean isRemote = false;

	public boolean getIsRemote() {
		return isRemote;
	}

	public void setIsRemote(boolean _isRemote) {
		this.isRemote = _isRemote;
	}

	public boolean getIsDemo() {
		return isDemo;
	}

	public void setIsDemo(boolean _isDemo) {
		this.isDemo = _isDemo;
	}

	public boolean getIsHeadless() {
		return isHeadless;
	}

	public void setIsHeadless(boolean _isHeadless) {
		this.isHeadless = _isHeadless;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver _driver) {
		this.driver = _driver;
	}

	public enum Browser {
		CHROME, FIREFOX, SAFARI, EDGE_CHROMIUM
	}

	public WebDriver startABrowser(Browser browser) {
		try {
			switch (browser) {

			case CHROME:
				driver = startChromeBrowser();
				break;

			case FIREFOX:
				driver = startFirefoxBrowser();
				break;

			case SAFARI:
				driver = startSafariBrowser();
				break;

			case EDGE_CHROMIUM:
				driver = startEdgeBrowser();
				break;

			default:
				log.info("Currently framework do not support this type of browser!");
				log.info("Default browser set to 'CHROME' ");
				driver = startChromeBrowser();
				break;
			}
			driver.manage().deleteAllCookies();
			log.info("Starting browser ---> " + browser);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private WebDriver startEdgeBrowser() {
		try {
			WebDriverManager.edgedriver().setup();
			EdgeOptions ops = new EdgeOptions();
			if (isHeadless) {
				ops.setHeadless(true);
			}
			driver = new EdgeDriver(ops);
			pageSync();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

		return driver;
	}

	private WebDriver startSafariBrowser() {
		// This is homework, please try to implement this method after today's class
		try {
			WebDriverManager.safaridriver().setup();
			SafariOptions ops = new SafariOptions();

			driver = new SafariDriver(ops);
			pageSync();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private WebDriver startFirefoxBrowser() {
		try {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions ops = new FirefoxOptions();
			if (isHeadless) {
				ops.setHeadless(true);
			}
			driver = new FirefoxDriver(ops);
			pageSync();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

		return driver;
	}

	private WebDriver startChromeBrowser() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			if (isHeadless) {
				ops.setHeadless(true);
			}
			driver = new ChromeDriver(ops);
			pageSync();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private void pageSync() {
		customWait(5);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTimeInSecs));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(waitTimeInSecs));
	}

	public void tearDown() {
		try {
			customWait(5);
			// close the browser
			driver.close();
			driver.quit();

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void highlightWebElement(WebElement element) {
		try {
			if (isDemo) {
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

				for (int i = 1; i < 4; i++) {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow");
					customWait(0.5);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
					customWait(0.5);
				}
				customWait(3);
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	
	 public void highlightWebElement2(List<WebElement> list) {
	        try {
	            WrapsDriver wrappedElement = (WrapsDriver) list;
	            JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

	            for (int i = 1; i < 2; i++) {
	                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", list,
	                        "color: red; border: 2px solid blue");
	                customWait(0.5);
//	                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
//	                customWait(0.5);
	            }
//	            customWait(3);
	            customWait(0.5);
	        } catch (Exception e) {
	            log.error("Error: ", e);
	            assertEquals(true, false);
	        }
	    }

	public void highlightWebElement(By by) {
		try {
			if (isDemo) {
				WebElement element = driver.findElement(by);
				WrapsDriver wrappedElement = (WrapsDriver) element;
				JavascriptExecutor js = (JavascriptExecutor) wrappedElement.getWrappedDriver();

				for (int i = 1; i < 4; i++) {
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
							"color: red; border: 2px solid yellow");
					customWait(0.5);
					js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
					customWait(0.5);
				}
				customWait(3);
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

	}

	public void handleCheckBox(By by, boolean isChecked) {
		try {
			WebElement checkBox = driver.findElement(by);
			highlightWebElement(checkBox);
			// User wants to check the box
			if (isChecked == true) {

				if (checkBox.isSelected()) {
					// box is checked----------------> nothing
				} else {
					// box is empty(Not checked)-----> Click
					checkBox.click();
					highlightWebElement(checkBox);
				}
			} else {
				// User wants to un-check the box
				if (checkBox.isSelected()) {
					// box is checked----------------> Click
					checkBox.click();
					highlightWebElement(checkBox);
				} else {
					// box is empty(Not checked)-----> nothing
				}
			}
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public String takeScreenshot(String screenshotName) {
		String finalScreenshotPath = null;

		try {
			String fileLocation = "target/" + screenshotName + "_" + getCurrentTime() + ".png";
			File absFilePath = new File(fileLocation);
			String newPath = absFilePath.getAbsolutePath();

			if (isRemote) {
				driver = new Augmenter().augment(driver);
			}
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Files.copy(scrFile, new File(newPath));
			finalScreenshotPath = newPath;
			log.info("screenshot location ----> " + newPath);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

		return finalScreenshotPath;
	}

	public void enterText(By by, String inputString) {
		try {
			WebElement element = driver.findElement(by);
			highlightWebElement(element);
			element.clear();
			element.sendKeys(inputString);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}
	

	public void enterText(By by, Keys keys) {
		try {
			WebElement element = driver.findElement(by);
			highlightWebElement(element);
			element.clear();
			element.sendKeys(keys);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}

	}

	public void selectDropDown(By by, String visibileOptionText) {
		try {
			WebElement dropDownElem = driver.findElement(by);
			highlightWebElement(dropDownElem);
			Select select = new Select(dropDownElem);
			select.selectByVisibleText(visibileOptionText);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void selectDropDown(By by, int index) {
		try {
			WebElement dropDownElem = driver.findElement(by);
			highlightWebElement(dropDownElem);
			Select select = new Select(dropDownElem);
			select.selectByIndex(index);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void selectDropDown(String valueString, By by) {
		try {
			WebElement dropDownElem = driver.findElement(by);
			highlightWebElement(dropDownElem);
			Select select = new Select(dropDownElem);
			select.selectByValue(valueString);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickElement(By by) {
		try {
			WebElement element = driver.findElement(by);
			highlightWebElement(element);
			element.click();

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void clickElement(WebElement element) {
		try {
			highlightWebElement(element);
			element.click();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void hoverOver(By mainMenuBy, By subMenuBy) {

		try {
			WebElement mainMenuElem = driver.findElement(mainMenuBy);
			highlightWebElement(mainMenuElem);

			// Moving mouse to Main menu elem
			Actions action = new Actions(driver);
			action.moveToElement(mainMenuElem).build().perform();

			// delay or pause 0.5 second for sub-menu to display/open
			customWait(0.5);

			WebElement subMenuElem = driver.findElement(subMenuBy);
			highlightWebElement(subMenuElem);
			// action.moveToElement(trackPackElem).click().build().perform();

			action.moveToElement(subMenuElem).build().perform();
			subMenuElem.click();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public WebElement waitForElementVisibility(By by) {
		WebElement elem = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSecs));
			elem = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			highlightWebElement(elem);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return elem;
	}

	
	
	public WebElement fluentWait(final By by) {
		WebElement elem = null;
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(waitTimeInSecs))
					.pollingEvery(Duration.ofSeconds(3))
					.ignoring(NoSuchElementException.class);

			elem = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(by);
				}
			});
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return elem;
	}

	
	
	
	public void scrollIntoView(WebElement element) {
		try {
			Actions action = new Actions(driver);
			action.scrollToElement(element).build().perform();
			customWait(0.25);
			highlightWebElement(element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void scrollIntoView(By by) {
		try {
			WebElement element = driver.findElement(by);
			Actions action = new Actions(driver);
			action.scrollToElement(element).build().perform();
			customWait(0.25);
			highlightWebElement(by);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void scrollIntoCenter(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			highlightWebElement(element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public void scrollIntoCenter(By by) {
		try {
			WebElement element = driver.findElement(by);
			scrollIntoCenter(element);
			highlightWebElement(element);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public WebDriver startARemoteBrowser(String hubURL, Browser browser) {
		try {
			switch (browser) {
			case CHROME:
				driver = startRemoteChromeBrowser(hubURL);
				break;
			case FIREFOX:
				driver = startRemoteFirefoxBrowser(hubURL);
				break;
			case EDGE_CHROMIUM:
				driver = startRemoteEdgeBrowser(hubURL);
				break;
			default:
				log.info("Currently framework do not support this type of remote browser!");
				log.info("Default remote browser set to 'Remote Chrome' browser");
				driver = startRemoteChromeBrowser(hubURL);
			}
			driver.manage().deleteAllCookies();
			pageSync();
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private WebDriver startRemoteChromeBrowser(String hubURL) {
		try {
			ChromeOptions chromeOps = new ChromeOptions();

			if (isHeadless == true) {
				chromeOps.setHeadless(true);
			}
			chromeOps.setCapability("browserName", "chrome");
			chromeOps.setCapability("platformName", "Windows");
			chromeOps.setCapability("se:name", "test name");
			chromeOps.setCapability("se:sampleMetadata", "Sample metadata value");

			log.info("Starting remote Chrome browser...");
			driver = new RemoteWebDriver(new URL(hubURL), chromeOps);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private WebDriver startRemoteFirefoxBrowser(String hubURL) {
		try {
			FirefoxOptions firefoxOps = new FirefoxOptions();

			if (isHeadless == true) {
				firefoxOps.setHeadless(true);
			}
			firefoxOps.setCapability("browserName", "firefox");
			firefoxOps.setCapability("platformName", "Windows");
			firefoxOps.setCapability("se:name", "test name");
			firefoxOps.setCapability("se:sampleMetadata", "Sample metadata value");

			log.info("Starting remote Firefox browser...");
			driver = new RemoteWebDriver(new URL(hubURL), firefoxOps);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	private WebDriver startRemoteEdgeBrowser(String hubURL) {
		try {
			EdgeOptions edgeOps = new EdgeOptions();

			if (isHeadless == true) {
				edgeOps.setHeadless(true);
			}
			edgeOps.setCapability("browserName", "edge");
			edgeOps.setCapability("platformName", "Windows");
			edgeOps.setCapability("se:name", "test name");
			edgeOps.setCapability("se:sampleMetadata", "Sample metadata value");

			log.info("Starting remote Edge browser...");
			driver = new RemoteWebDriver(new URL(hubURL), edgeOps);

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return driver;
	}

	public String fileUpload(By by, String filePath) {
		String fileFullPath = null;
		try {
			WebElement uploadElem = driver.findElement(by);
			highlightWebElement(uploadElem);
			File file = new File(filePath);
			fileFullPath = file.getAbsolutePath();
			// Remote file upload for selenium Grid/Hub/Node setup
			if (isRemote) {
				((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
			}
			uploadElem.sendKeys(fileFullPath);
			log.info("Uploading file ---> " + fileFullPath);
		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return fileFullPath;
	}
	
	public void selectOptionFromDropDown(List<WebElement> options, String value) {
		try {
			for (WebElement option : options) {
				if (option.getText().equals(value)) {
					option.click();
					break;
				}
			}
			
		} catch (Exception e) {
			
		}
	}
	public void findAllLinks() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int totalLinks = allLinks.size();
		
		List<String> LinksWithTexts = new ArrayList<String>();
		List<String> LinksNoTexts = new ArrayList<String>();
		int counter = 1;
		
		for(WebElement link : allLinks) {
			String linkTxt = link.getText();
			if(!linkTxt.isEmpty()) {
				LinksWithTexts.add(linkTxt);
				
			}else {
				LinksNoTexts.add(linkTxt);
			}
			System.out.println("(" + counter + ") link text is: [" + linkTxt + "]");
			counter = counter +1;
		}
		System.out.println("total link is: " + totalLinks);
		System.out.println("Links with text: " + LinksWithTexts.size());
		System.out.println("Links with no text: " + LinksNoTexts.size());
	}

	public void printValueDropDown(By by) {
		Select select = new Select(driver.findElement(by));
		List<WebElement> options = select.getOptions();
//		select.getAllSelectedOptions();
//		select.getOptions();
		
		System.out.println("total number of values: " + options.size());
		int i=1;
		for (WebElement e : options) {
			System.out.println(i + "." + e.getText());
		i++;
		
	}
	}
	
	public void sendKeysDownEnter(By by, String name) {
		WebElement element = driver.findElement(by);
		element.sendKeys(name);
		customWait(1);
		element.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
		
	
	}
	
    public List<WebElement> locateElements(By by) {

        List<WebElement> list = null;

        try {
            list = driver.findElements(by);

        } catch (Exception e) {
            log.error("Error:", e);
            assertEquals(true, false);
        }

        return list;
    }
    
    
    public void selectFromDropDownOptions(List<WebElement> options, String value) {

        try {

            for (WebElement option : options) {

                String optionTxt = option.getText();
                log.info("Option is: " + optionTxt);

                if (optionTxt.equals(value)) {
                    option.click();
                    break;
                }

            }

        } catch (Exception e) {
            log.error("Error: ", e);
            assertEquals(true, false);
        }

    }
    
    public void selectFromDropDownFromList(By dropDBy, By dropDOptionsBy, String Option) {

        try {

            log.info("Click on the dropdown ...");

            clickElement(dropDBy);
            customWait(2);
            
            log.info("Select from the dropdown options  ...");
            List<WebElement> list = locateElements(dropDOptionsBy);
            
            selectFromDropDownOptions(list, Option);
            
        } catch (Exception e) {
            log.error("Error: ", e);
            assertEquals(true, false);
        }
    }
	
    
   
	
	
///////// Helper Methods ---------------
//if within the same class, helper method should be declared in private
//

	public void customWait(double inSeconds) {
		try {
			// casting / converting data type from Double to Long
			long seconds = (long) (inSeconds * 1000);

			Thread.sleep(seconds);

			// below line of code is same 2 steps above merging into one line
			// Thread.sleep((long) (inSeconds * 1000));

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
	}

	public String getCurrentTime() {
		String finalTimeStamp = null;
		try {
			Date date = new Date();
			// log.info("current date1: " + date);
			String tempTime = new Timestamp(date.getTime()).toString();
			// log.info("current date2: " + tempTime);
			String newTemp = tempTime.replace(':', '_').replace('.', '_').replace(' ', '_').replace('-', '_');
			// log.info("current date3: " + newTemp);
			String newTemp2 = newTemp.replaceAll("_", "");
			// log.info("current date4: " + newTemp2);
			finalTimeStamp = newTemp2;

		} catch (Exception e) {
			log.error("Error: ", e);
			assertEquals(true, false);
		}
		return finalTimeStamp;
	}

	public static void main(String[] args) {
		SeleniumSupport myLibrary = new SeleniumSupport();
		myLibrary.getCurrentTime();

	}

}
