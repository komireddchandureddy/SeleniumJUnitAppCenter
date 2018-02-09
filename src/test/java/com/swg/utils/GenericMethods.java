package com.swg.utils;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import com.microsoft.appcenter.appium.EnhancedIOSDriver;
import com.microsoft.appcenter.appium.Factory;
import com.swg.config.GlobalVariables;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class GenericMethods extends LogUtil {

	public static AppiumDriver<MobileElement> driver;

	public boolean launchApp() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			if (driverini.equals(androidLocal)) {
				// mandatory capabilities for real devices
				File app = new File("D:\\SWG\\Workspace\\QFM\\src\\test\\resources\\ConfigFiles\\com.swg.qfmmobile.apk");
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				cap.setCapability(CapabilityType.PLATFORM, platform);
				cap.setCapability(MobileCapabilityType.APP, app);
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				cap.setCapability(MobileCapabilityType.UDID, UDID);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,automationName);
				driver = new EnhancedAndroidDriver<MobileElement>(new URL(URL), cap, null);
			}else if (driverini.equals(iosLocal)) {
				cap.setCapability(MobileCapabilityType.DEVICE_NAME,iosDeviceName);
				cap.setCapability(MobileCapabilityType.LANGUAGE,"");
				cap.setCapability( "launchTimeout","500000");
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME,iosPlatformName);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,iosPlatformVersion);
				cap.setCapability(MobileCapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);	
				cap.setCapability(	"autoAcceptAlerts", true);	
			
				if(realDevice.equals("Y"))
				{
					cap.setCapability(MobileCapabilityType.UDID, iosUDID);
				}
				driver = new IOSDriver<>(new URL(URL), cap);
				
			}else if (driverini.equals(androidAppcenter)) {
				cap.setCapability("autoGrantPermissions", false);
				driver = Factory.createAndroidDriver(new URL(URL), cap);

			}else if (driverini.equals(iosAppcenter)) {
				cap.setCapability("autoGrantPermissions", true);
				cap.setCapability("autoAcceptAlerts", true);
				driver = Factory.createIOSDriver(new URL(URL), cap);
			}else {
				GlobalVariables.errMsg = "Environment type is not valid";
				return false;
			}
			return true;
		} catch (MalformedURLException e) {
			GlobalVariables.errMsg = e.getMessage();
			return false;
		}
	}

	public  boolean writeInInput(By type, String data, String message) {
		infoLog(getClass(), message);
		WebElement element = driver.findElement(type);
		element.clear();
		element.sendKeys(data);
		return true;

	}

	public  boolean writeInInputWithHide(By type, String data, String message) {
		infoLog(getClass(), message);
		WebElement element = driver.findElement(type);
		element.clear();
		element.sendKeys(data);
		HideKeyboard();
		return true;

	}

	public  boolean click(By type, String message) {	
		infoLog(getClass(), message);
		WebElement element = driver.findElement(type);
		element.click();
		return true;
	}

	public  boolean clickCamera(int eventNumber, String message) 
	{
		try 
		{
			infoLog(getClass(), message);
			Runtime.getRuntime().exec("cmd /C adb shell input keyevent " + eventNumber);
			Thread.sleep(3000);
			return true;
		} 
		catch (Throwable t) 
		{
			t.printStackTrace();
			return false;
		}
		
	}

	/*public void clickCamera(int String message)
	{
		keyBoardEvent(27);
		
	}*/

	public  boolean tapEnterKey( String message) throws InterruptedException {
		infoLog(getClass(), message);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.ENTER);
		return true;
	}

	public  boolean tapBack( String message) throws InterruptedException {
		infoLog(getClass(), message);
		driver.navigate().back();
		return true;
	}
	/*public void scrollAndClick(String visibleText) {
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();

	    }
	 */
	public void scrollDown(String message) {
		infoLog(getClass(), message);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);	    
	}
	//Generic function for Scroll
	public void scrollUsingTouchActions_ByElements(MobileElement startElement, MobileElement endElement, String message) {
		infoLog(getClass(), message);
		Duration d=new Duration(2, TimeUnit.SECONDS);
		TouchAction actions = new TouchAction(driver);
		actions.press(startElement).waitAction().moveTo(endElement).release().perform();
	}

	/*public static boolean waitUntilElementVisible(By vMatchers,int timeOut){

         int iTimer = 0;
         while(iTimer <= timeOut) {
             boolean status = isElementDisplayed(vMatchers);
             if(status)
                 return true;
         }

      return false;
 }*/

	/*static boolean scrollTo(String value ){
		while(driver.findElements(By.name(value)).size()==0)
		{
			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			((Object) driver).swipe(0,scrollStart,0,scrollEnd,2000);
		}
		if(driver.findElements(By.name(value)).size()>0)
		{
			return true;
		} 
		else
			return false;
	}
	 */
	/*static boolean scrollDown(By value ){
		WebElement element=driver.findElement(value);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	HashMap<String, String> scrollObject = new HashMap<String, String>();
	scrollObject.put("direction", "down");
	scrollObject.put("element", ((RemoteWebElement) value).getId());
	js.executeScript("mobile: scroll", scrollObject);
	return true;

	}*/
	public  boolean sign(By value , String message){
		infoLog(getClass(), message);

		Actions builder = new Actions(driver);
		WebElement canvasElement = driver.findElement(value);
		Actions drawAction = builder.moveToElement(canvasElement, 20, 20);
		drawAction.clickAndHold()
		.moveByOffset(80, 80)
		.moveByOffset(50, 20)
		.release()
		.build();
		drawAction.perform();
		return true;
	}
	public  boolean HideKeyboard() {
	
		try {
			driver.hideKeyboard();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public  WebElement explicitWaitForElement(By type, int time, String message) {
		infoLog(getClass(), message);
		// WebDriverWait wait = new WebDriverWait(driver,
		// GetIntValue("explicit_timeout"));
		WebDriverWait wait = new WebDriverWait(driver, time);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(type));
		return element;

	}

	public boolean  waitUntilElement(By type, int timeOut, String message) {
		infoLog(getClass(), message);

		int time=0;
		boolean status=false;
		while(time<timeOut)
		{
			status=driver.findElements(type).size()==0;
			if(status) {
				status =true;
				break;
			}
			time=time+30;
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {			
				e.printStackTrace();
			}

		}
		return status;

	}

	public  void delay(long time, String message) {
		infoLog(getClass(), message);

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}	
	}

	public  String GetValue(String key, String message) {
		infoLog(getClass(), message);

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");
		FileInputStream fileInput = null;
		Properties prop = new Properties();
		String strbaseURL = null;
		try {
			fileInput = new FileInputStream(file);
			prop.load(fileInput);
			strbaseURL = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strbaseURL;
	}

	public  int GetIntValue(String key, String message) {
		infoLog(getClass(), message);

		File file = new File(System.getProperty("user.dir") + "/src/test/resources/ConfigFiles/config.properties");

		FileInputStream fileInput = null;
		String strbaseURL = null;
		try {
			fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileInput);
			strbaseURL = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Integer.parseInt(strbaseURL);
	}

	public  boolean isWebElementVisible(By path, String type, String message) {
		infoLog(getClass(), message);

		boolean flag = false;
		if (driver.findElements(path).size() > 0) {
			flag = true;
		}
		return flag;

	}
	public  boolean isWebElementVisible(By path, String message) {
		infoLog(getClass(), message);

		boolean flag = false;
		if (driver.findElements(path).size() > 0) {
			flag = true;
		}
		return flag;

	}

	/*
	 * public static void loginMethod() throws InterruptedException{
	 * explicitWaitForElement(SWG.input_UserName);
	 * GenericMethods.infoLog(thisClass,"Enter User Name");
	 * writeInInput(SWG.input_UserName,GenericMethods.GetValue("UserName"));//
	 * "tester1_HD"); HideKeyboard();
	 * GenericMethods.infoLog(thisClass,"Enter Password");
	 * writeInInput(SWG.input_Password,GenericMethods.GetValue("Password"));
	 * HideKeyboard(); GenericMethods.infoLog(thisClass,"Click LogIn Button");
	 * click(SWG.btn_LogIn); explicitWaitForElement(SWG.tab_Active);
	 * GenericMethods.infoLog(thisClass,"Click on Active Tab");
	 * click(SWG.tab_Active); }
	 */

	/*
	 * if(driver.findElement(By.xpath(SWG.btn_Menu)).isDisplayed()){
	 * System.out.println("If condition"); click(SWG.btn_Menu); click(SWG.logout);
	 * click(SWG.popup_Ok); loginMethod(); } else
	 * if(driver.findElement(By.xpath(SWG.input_UserName)).isDisplayed()){
	 * loginMethod(); } else{ System.out.println("else condition");
	 * click(SWG.btn_Applogo); explicitWaitForElement(SWG.btn_Menu);
	 * click(SWG.btn_Menu); click(SWG.logout); click(SWG.popup_Ok); loginMethod(); }
	 */

	/*
	 * public static boolean isWebElementPresent(String path) { Boolean flag=false;
	 * if(driver.findElements(By.xpath(path)).size()>0) { flag=true; }
	 * 
	 * return flag;
	 * 
	 * } public static boolean enterInput(String path, String type, String data) {
	 * WebElement element = driver.findElement(locatortype(type, path));
	 * 
	 * ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].value = arguments[1]", element, data);
	 * 
	 * System.out.println("Value Entered"); return true;
	 * 
	 * }
	 */
}
