package com.swg.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import com.swg.utils.SWGObjects.SWG;

import io.appium.java_client.TouchAction;

public class AndroidAppFunctions extends GenericMethods {

	public boolean ApplicationLogin(String serverIP, String serverName, String userName, String password) {
		try {
		delay(40000, "wait for 40 seconds");

		writeInInput(SWG.input_ServerIP, serverIP, "Enter Sever IP");// "azuretest.swgasp.com");
		HideKeyboard();
		delay(2000, "wait for 2 seconds");
		writeInInput(SWG.input_ServerName, serverName, "Enter Sever Name");// "QFMMobileServer_2_03_52_14");
		HideKeyboard();
		delay(2000, "wait for 2 seconds");
		click(SWG.btn_OK, "Click OK Button");
		delay(50000, "wait for 50 seconds");
		tapBack("Click Device Back Button");
		// explicitWaitForElement(SWG.input_UserName);
		waitUntilElement(SWG.input_UserName, 300, "wait until UserName element");
		writeInInput(SWG.input_UserName, userName, "Enter User Name");
		HideKeyboard();
		writeInInput(SWG.input_Password, password, "Enter Password");
		HideKeyboard();
		click(SWG.btn_LogIn, "Click LogIn Button");
		explicitWaitForElement(SWG.tab_Active, wait, "wait until element seconds");
		click(SWG.tab_Active, "Click on Active Tab");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public void AcceptVisitButton()  {
		click(SWG.btn_AcceptVisit, "Click on Accept visit button");
	}

	public void StartVisitButton() {

		click(SWG.btn_StartVisit, "Click on Start visit button");
	}

	public void UDFFrom() {

		click(SWG.btn_StartVisit, "Click on Start visit button");
	}

	public boolean VisitFlow() {
		try {
		explicitWaitForElement(SWG.dropdown_Equipmentcondition, wait, "wait until element seconds");
		click(SWG.dropdown_Equipmentcondition, "Click on drop down Equipment condition");

		By value_EquipmentconditionEle = By
				.xpath("//android.widget.CheckedTextView[@text='" + value_Equipmentcondition + "']");
		click(value_EquipmentconditionEle, "Select Equipment condition value");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean SearchVisit(String visitEvent) {
		try {
		click(SWG.icon_Search, "Click on Search Icon");
		explicitWaitForElement(SWG.input_Search, wait, "wait until element seconds");
		writeInInput(SWG.input_Search, visitEvent, "Enter text in Search bar");// "505791/v1");
		delay(5000, "wait for 5 seconds");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public void clickOn1stEvent() {
		delay(5000, "wait for 5 seconds");

		click(SWG.list_ActiveIteam, "Click on Frist iteam in Active List");
	}

	public boolean refreshIcon() {
		try {
		delay(5000, "wait for 5 seconds");

		click(SWG.icon_Refresh1, "Click on Refresh Icon");
		return true;
	}
	catch(Exception e) {
		return false;	
	}

	}

	public boolean rejectVisitUntilDate() {
		try {

		click(SWG.btn_RejectVisit, "Click on Reject Visit button");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_RejectionDetails, "Select Reject Details");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_RejectUntilDate, "Click on Reject Until Date");

		click(SWG.btn_Reject, "Click on Reject button");

		click(SWG.popup_Ok, "Click on Ok button");

		isWebElementVisible(SWG.list_ActiveRejectedIteam, "Verify Rejected Visit");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean rejectVisitPermanently() {
		try {
		click(SWG.btn_RejectVisit, "Click on Reject Visit button");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_RejectionDetails, "Select Reject Details");

		click(SWG.dropdown_RejectPermanently, "Click on Reject Permanently");
		delay(2000, "wait for 2 secs");

		click(SWG.btn_Reject, "Click on Reject button");

		click(SWG.popup_Ok, "Click on Ok button");
	
		isWebElementVisible(SWG.list_ActiveRejectedIteam, "Verify Rejected Visit");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean completeVisit() {
		try {
		delay(11000, "wait for 11 seconds");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");

		click(SWG.btn_EndVisit, "Click on End visit button");

		writeInInput(SWG.input_Remark, "Mobile Automation Test", "Enter text remarks text box");
		HideKeyboard();
		delay(5000, "wait for 5 seconds");

		click(SWG.btn_VisitComplete, "Click on visit complete button");
		boolean status = isWebElementVisible(SWG.input_Optional, "Verify Optional");
		if (!status) {
			click(SWG.btn_VisitComplete, "Click on complete visit button");
		}
		delay(2000, "wait for 2 secs");

		writeInInput(SWG.input_Optional, "Vimith", "Enter Customer Name");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		click(SWG.CustomerService_Star, "Click on Customer Service Star");

		click(SWG.Presentation_Star, "Click on Presentation Star");

		while (driver.findElements(SWG.input_AdditionalComment).size() == 0) {

			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			new TouchAction(driver).press(100, scrollStart + 100).waitAction(Duration.ofSeconds(5)).moveTo(0, scrollEnd)
					.release().perform();
		}

		click(SWG.Professionalism_Star, "Click on Professionalism Star");

		writeInInput(SWG.input_AdditionalComment, "Additional Comment Test", "Enter text in remarks text box");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		click(SWG.btn_Submit, "Click on Submit");

		writeInInput(SWG.input_CustomerName, "Customer Test", "Enter Customer name");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		click(SWG.input_Signhere, "Click on Sign here(Signature of customer) ");

		click(SWG.btn_SignOffCustomer, "Click on Sign Off of Customer ");

		click(SWG.input_SignhereOperative, "Click on Sign here(Signature of Operator) ");

		click(SWG.btn_SignOffOperative, "Click on Sign Off of Operator ");

		isWebElementVisible(SWG.txt_Finish, "Verify Finish Message");

		click(SWG.popup_Ok, "Click on Ok ");

		isWebElementVisible(SWG.list_CompletedIteam, "Verify completed Visit");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean holdVisit() {
		try {
		delay(11000, "wait for 11 seconds");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");

		click(SWG.btn_HoldVisit, "Click on Hold visit button");

		isWebElementVisible(SWG.btn_ResumeVisit, "Verify Resume Visit button");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean cancelVisit() {
		try {
		delay(11000, "wait for 11 seconds");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");
		delay(5000, "wait for 5 seconds");

		click(SWG.icon_Refresh, "Click on Refresh Icon");

		click(SWG.btn_CancelVisit, "Click on Cancel Visit button ");

		isWebElementVisible(SWG.btn_ResumeVisit, "Verify Completed Tab");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean continueVisit() {
		try {
		delay(11000, "wait for 11 seconds");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");
		delay(5000, "wait for 5 seconds");

		click(SWG.icon_Refresh, "Click on Refresh Icon");

		click(SWG.btn_ContinueVisit, "Click on Continue Visit button ");

		isWebElementVisible(SWG.btn_ResumeVisit, "Verify Completed Tab");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public void backToHome() {

		click(SWG.NavigateBack, "Click on Back arrow symbol");
	}

	public boolean resumeVisit() {
		try {
		delay(11000, "wait for 11 seconds");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");

		click(SWG.btn_HoldVisit, "Click on Hold visit button");

		click(SWG.btn_ResumeVisit, "Click on Resume visit button");

		isWebElementVisible(SWG.btn_HoldVisit, "Verify Hold Visit button");

		isWebElementVisible(SWG.btn_EndVisit, "Verify End Visit button");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean returnRequiredVisit() {
		try {
		delay(2000, "wait for 2 secs");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");

		click(SWG.btn_StartVisit, "Click on Start visit button");

		click(SWG.btn_EndVisit, "Click on End visit button");

		click(SWG.btn_ReturnRequired, "Enter Return Required button");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_Operative, "Select Operative");

		click(SWG.dropdown_SelectOperative3000, "Click on Operative");
		delay(2000, "wait for 2 secs");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_Reason, "Select Reason");

		click(SWG.dropdown_SelectReason, "Click on Reason");
		delay(2000, "wait for 2 secs");

		delay(2000, "wait for 2 secs");
		click(SWG.dropdown_Skill, "Select Skill");

		click(SWG.dropdown_SelectSkill, "Click on Skill 1");
		delay(2000, "wait for 2 secs");

		writeInInput(SWG.input_Remark, "Mobile Automation Test", "Enter Remarks");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		while (driver.findElements(SWG.input_EstimatedDuration).size() == 0) {

			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			new TouchAction(driver).press(100, scrollStart + 100).waitAction(Duration.ofSeconds(5)).moveTo(0, scrollEnd)
					.release().perform();
		}

		writeInInput(SWG.input_EstimatedCost, "180", "Enter Estimated Cost");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		writeInInput(SWG.input_EstimatedDuration, "240", "Enter Estimated Duration");
		HideKeyboard();
		delay(2000, "wait for 2 secs");

		click(SWG.btn_Done, "Click on done button");

		isWebElementVisible(SWG.txt_ReturnMessage, "Verify message");

		click(SWG.popup_Ok, "Click on Ok ");

		isWebElementVisible(SWG.list_CompletedIteam, "Verify completed Visit");
		return true;
	}
	catch(Exception e) {
		return false;	
	}
	}

	public boolean addAttachmentVisit() {
		try {
		delay(11000, "wait for 11 secs");
		click(SWG.btn_AcceptVisit, "Click on Accept Vist button");
		click(SWG.btn_StartVisit, "Click on Start visit button");
		click(SWG.icon_Camera, "Click on Camera Image");

		// infoLog(thisClass, "Click on Camera shooter Image");
		// driver.pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
		clickCamera(27, "Click on Camera shooter Image");
		// click(SWG.icon_MENUID_SHUTTER);
		delay(5000, "wait for 5 seconds");
		waitUntilElement(SWG.txt_OK, 200, "wait for OK ");
		click(SWG.txt_OK, "Click on OK ");
		writeInInput(SWG.txt_ImageName, "Mobile Automation", "Enter Image name");
		HideKeyboard();
		delay(2000, "wait for 2 secs");
		click(SWG.popup_Ok, "Click on ok");
		delay(2000, "wait for 2 secs");
		isWebElementVisible(SWG.txt_Photo, "Verify Photo attachment");
		click(SWG.btn_EndVisit, "Click on End visit button");
		writeInInput(SWG.input_Remark, "Mobile Automation Test", "Enter text remarks text box");
		HideKeyboard();
		delay(2000, "wait for 2 secs");
		click(SWG.btn_VisitComplete, "Click on visit complete button");
		writeInInput(SWG.input_Optional, "Vimith", "Enter Customer Name");
		HideKeyboard();
		delay(2000, "wait for 2 secs");
		click(SWG.CustomerService_Star, "Click on Customer Service Star");
		click(SWG.Presentation_Star, "Click on Presentation Star");
		while (driver.findElements(SWG.input_AdditionalComment).size() == 0) {

			Dimension dimensions = driver.manage().window().getSize();
			Double screenHeightStart = dimensions.getHeight() * 0.5;
			int scrollStart = screenHeightStart.intValue();
			Double screenHeightEnd = dimensions.getHeight() * 0.2;
			int scrollEnd = screenHeightEnd.intValue();
			new TouchAction(driver).press(100, scrollStart + 100).waitAction(Duration.ofSeconds(5)).moveTo(0, scrollEnd)
					.release().perform();
		}
		click(SWG.Professionalism_Star, "Click on Professionalism Star");
		writeInInput(SWG.input_AdditionalComment, "Additional Comment Test", "Enter text in remarks text box");
		HideKeyboard();
		delay(2000, "wait for 2 secs");
		click(SWG.btn_Submit, "Click on Submit");
		writeInInput(SWG.input_CustomerName, "Customer Test", "Enter Customer name");
		HideKeyboard();
		delay(2000, "wait for 2 secs");
		click(SWG.input_Signhere, "Click on Sign here(Signature of customer) ");
		click(SWG.btn_SignOffCustomer, "Click on Sign Off of Customer ");
		click(SWG.input_SignhereOperative, "Click on Sign here(Signature of Operator) ");
		click(SWG.btn_SignOffOperative, "Click on Sign Off of Operator ");
		isWebElementVisible(SWG.txt_Finish, "Verify Finish Message");
		click(SWG.popup_Ok, "Click on Ok ");
		isWebElementVisible(SWG.list_CompletedIteam, "Verify completed Visit");
		return true;
		}
		catch(Exception e) {
			return false;	
		}
	

	}

	public void logout() {
		try {
			if (driver.findElements(SWG.btn_Menu).size() == 0) {
				backToHome();
			}
			click(SWG.btn_Menu, "tap on Menu");
			click(SWG.logout, "tap on Logout");
			click(SWG.popup_Ok, "tap on Ok");
			if (closeApp.equals("Y")) {
			driver.closeApp();		
			}
			}
			catch(Exception e) {
				
			}
}
}
