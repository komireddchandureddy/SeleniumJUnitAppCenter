package com.swg.utils;

import org.openqa.selenium.By;

public class SWGObjects {
			
			public static class SWG{
			
			public static final By input_ServerIP=By.xpath("//android.widget.TextView[@text='Server IP/Hostname']/following::android.widget.EditText");
			public static final By input_ServerName=By.xpath("//android.widget.TextView[@text='Server Name']/following::android.widget.EditText");
			public static final By btn_OK=By.xpath("//android.widget.Button[contains(@text,'Ok')]");
			public static final By input_UserName=By.xpath("//android.widget.EditText[contains(@text,'Username')]");
			//public static final By input_Password=By.xpath("//android.widget.EditText[contains(@text,'Username')]/following::android.widget.EditText");
			public static final By input_Password=By.xpath("//android.widget.EditText[@NAF='true']");
			public static final By btn_LogIn=By.xpath("//android.widget.Button[contains(@text,'Log In')]");
			public static final By tab_Active=By.xpath("//android.widget.TextView[starts-with(@text,'Active (')]");
			//public static final By icon_Search=By.xpath("//android.view.ViewGroup[@index='1']/following::android.widget.ImageView[@index='0']");
			public static final By icon_Search=By.xpath("//android.widget.ImageView[@index='0'][1]/following::android.widget.ImageView");
			public static final By input_Search=By.xpath("//android.widget.EditText[@index='0']");
			//public static final By icon_Search=By.xpath("//android.widget.CheckedTextView[@text='All Sites']/preceding-sibling::button[@name='settings']");
			public static final By list_ActiveIteam=By.xpath("//android.widget.TextView[contains(@text,'Scheduled Start at ')]");
			public static final By btn_AcceptVisit=By.xpath("//android.widget.Button[contains(@text,'Accept Visit')]");
			public static final By btn_RejectVisit=By.xpath("//android.widget.Button[contains(@text,'Reject Visit')]");
			public static final By btn_StartVisit=By.xpath("//android.widget.Button[contains(@text,'Start Visit')]");
			
			public static final By btn_EndVisit=By.xpath("//android.widget.Button[contains(@text,'End Visit')]");
			public static final By btn_HoldVisit=By.xpath("//android.widget.Button[contains(@text,'On Hold')]");
			public static final By btn_ResumeVisit=By.xpath("//android.widget.Button[contains(@text,'Resume Visit')]");
			public static final By input_Remark=By.xpath("//android.widget.EditText[contains(@text,'Remarks')]");
			public static final By btn_VisitComplete=By.xpath("//android.widget.Button[contains(@text,'Visit Complete')]");
			public static final By btn_ReturnRequired=By.xpath("//android.widget.Button[contains(@text,'Return Required')]");
			public static final By input_Optional=By.xpath("//android.widget.EditText[contains(@text,'Customer name (optional)')]");
			public static final By CustomerService_Star=By.xpath("//android.widget.TextView[@text='Customer Service'][1]/following::android.widget.ImageView");
			public static final By Presentation_Star=By.xpath("//android.widget.TextView[@text='Presentation'][1]/following::android.widget.ImageView");
			public static final By Professionalism_Star=By.xpath("//android.widget.TextView[@text='Professionalism'][1]/following::android.widget.ImageView");
			public static final By input_AdditionalComment=By.xpath("//android.widget.EditText[contains(@text,'Additional comments')]");
			public static final By btn_Submit=By.xpath("//android.widget.Button[contains(@text,'Submit')]");
			public static final By btn_Cancel=By.xpath("//android.widget.Button[contains(@text,'Cancel')]");
			public static final By input_CustomerName=By.xpath("//android.widget.TextView[@text='Customer Name']/following::android.widget.EditText");
			
			
			public static final By input_Signhere=By.xpath("//android.widget.TextView[@text='Sign here']");		
			public static final By btn_SignOffCustomer=By.xpath("//android.widget.Button[@text='Sign Off']");
			
			public static final By input_SignhereOperative=By.xpath("//android.widget.TextView[@text='Sign here']");	
			public static final By btn_SignOffOperative=By.xpath("//android.widget.Button[@text='Sign Off']");
				
				
			public static final By txt_Finish=By.id("android:id/message");
			
			public static final By list_CompletedIteam=By.xpath("//android.widget.TextView[contains(@text,'Completed at')]");
			public static final By list_ReadyToCancelIteam=By.xpath("//android.widget.TextView[contains(@text,'Ready To Cancel')]");
			public static final By btn_CancelVisit=By.xpath("//android.widget.Button[contains(@text,'Cancel Visit')]");
			public static final By btn_ContinueVisit=By.xpath("//android.widget.Button[contains(@text,'Continue Visit')]");
				
			
			
			public static final By dropdown_Equipmentcondition=By.xpath("//android.widget.TextView[@text='Equipment condition']/following::android.widget.CheckedTextView");
		//	public static final By value_Equipmentcondition=By.xpath("//android.widget.CheckedTextView[@text='"+GenericMethods.GetValue("value_Equipmentcondition")+"']");
			public static final By dropdown_AnyweartearEquipment=By.xpath("//android.widget.TextView[@text='Any wear and tear on Equipment?']/following::android.widget.CheckedTextView");
			public static final By input_Describewearandtear=By.xpath("//android.widget.TextView[@text='Describe wear and tear']/following::android.widget.EditText");
			public static final By dropdown_EquipmentOperational=By.xpath("//android.widget.TextView[@text='Is Equipment operational?']/following::android.widget.CheckedTextView");
			public static final By dropdown_Equipmentsaferegularusage=By.xpath("//android.widget.TextView[@text='Is Equipment safe for regular usage?']/following::android.widget.CheckedTextView");
			public static final By dropdown_Cansafesamllfix=By.xpath("//android.widget.TextView[@text='If not, can it be made safe by small fix?']/following::android.widget.CheckedTextView");
			public static final By dropdown_replacementsuggested=By.xpath("//android.widget.TextView[@text='Is replacement suggested?']/following::android.widget.CheckedTextView");
			public static final By dropdown_PriorityReplacement=By.xpath("//android.widget.TextView[@text='Priority for Replacement']/following::android.widget.CheckedTextView");
			public static final By input_Remarks=By.xpath("//android.widget.TextView[@text='Remarks']/following::android.widget.EditText");
			//public static final By input_EstimatedCost=By.xpath("//android.widget.TextView[@text='Estimated Cost']/following::android.widget.EditText");
			public static final By btn_Finish=By.xpath("//android.widget.Button[contains(@text,'Finish')]");
		
			//Reject Visit Locators
			public static final By dropdown_RejectionDetails=By.xpath("//android.widget.Spinner");
			
			
			//public static final By input_Remark=By.xpath("//android.widget.EditText[contains(@text,'Remarks')]");
			public static final By btn_Reject=By.xpath("//android.widget.Button[contains(@text,'Reject')]");
			public static final By dropdown_RejectUntilDate=By.xpath("//android.widget.CheckedTextView[contains(@text,'Reject Until Date')]");
			public static final By dropdown_RejectPermanently=By.xpath("//android.widget.CheckedTextView[contains(@text,'Reject Permanently')]");
			public static final By input_Date=By.xpath("//android.widget.CheckedTextView[contains(@text,'Reject Until Date')]/following::android.widget.EditText[1]");
			public static final By input_Time=By.xpath("//android.widget.CheckedTextView[contains(@text,'Reject Until Date')]/following::android.widget.EditText[2]");
			public static final By list_ActiveRejectedIteam=By.xpath("//android.widget.TextView[contains(@text,'Rejected at')]");
			
			public static final By dropdown_Operative=By.xpath("//android.widget.TextView[contains(@text,'Operative')]/following::android.widget.Spinner");
			public static final By dropdown_Reason=By.xpath("//android.widget.TextView[contains(@text,'Return Reason')]/following::android.widget.Spinner");
			public static final By dropdown_Skill=By.xpath("//android.widget.TextView[contains(@text,'Return Skill')]/following::android.widget.Spinner");
			public static final By dropdown_SelectOperative=By.xpath("//android.widget.CheckedTextView[contains(@text,'Contractor 1_Operative 1')]");
			public static final By dropdown_SelectOperative3000=By.xpath("//android.widget.CheckedTextView[contains(@text,'Contractor 1000_Operative 3000')]");
			
			public static final By dropdown_SelectReason=By.xpath("//android.widget.CheckedTextView[contains(@text,'Reason')]");
			public static final By dropdown_SelectSkill=By.xpath("//android.widget.CheckedTextView[contains(@text,'skill 1')]");
			public static final By input_EstimatedCost=By.xpath("//android.widget.TextView[@text='Estimated Cost']/following::android.widget.EditText");
			public static final By input_EstimatedDuration=By.xpath("//android.widget.TextView[@text='Estimated Duration']/following::android.widget.EditText");
			public static final By btn_Done=By.xpath("//android.widget.Button[@text='Done']");
		//	public static final By btn_Cancel=By.xpath("//android.widget.Button[@text='Cancel']");
			public static final By txt_ReturnMessage=By.xpath("//android.widget.TextView[contains(@text,'This visit is completed with a return visit set')]");
			
			public static final By icon_Refresh=By.xpath("//android.widget.ViewGroup[@index='0']");
			
			public static final By icon_Camera=By.xpath("//android.view.ViewGroup[@index='1']");
			//public static final By icon_Camera=By.xpath("//android.view.ViewGroup[@index='0']");
			public static final By icon_Upload=By.xpath("//android.widget.ViewGroup[@index='2']");
			public static final By icon_Link=By.xpath("//android.widget.ViewGroup[@index='3']/");
			public static final By icon_MENUID_SHUTTER=By.id("MENUID_SHUTTER");
			public static final By txt_OK=By.xpath("//android.widget.TextView[@index='1']");
			public static final By icon_Refresh1=By.xpath("//android.widget.ViewGroup[@index='2']");
			public static final By icon_Refresh3=By.xpath("//android.widget.ViewGroup[@index='0']");
			
			//public static final By txt_OK=By.id("com.sec.android.app.camera:id/okay");
			
			
			//apublic static final By icon_ImageOk=By.id("android.widget.Button");
			public static final By txt_ImageName=By.xpath("//android.widget.EditText[@index='0']");
			public static final By txt_Photo=By.xpath("//android.widget.TextView[@text='Photo']");
			
			public static final By NavigateBack=By.xpath("//android.widget.ImageButton[contains(@content-desc,'Navigate up']");
			
		/*	public static final By btn_Menu=By.xpath("//android.widget.ImageView[contains(@resource-id,'android:id/up')]");
			public static final By btn_Applogo=By.xpath("//android.widget.ImageView[contains(@resource-id,'android:id/home')]");
			public static final By logout=By.xpath("//android.widget.TextView[contains(@text,'Log Out')]");
			public static final By popup_LogoutQ=By.xpath("//android.widget.TextView[contains(@text,'Are you sure you want to log out?')]");
			public static final By popup_Ok=By.xpath("//android.widget.Button[contains(@text,'Ok')]");
			public static final By popup_Cancel=By.xpath("//android.widget.Button[contains(@text,'Cancel')]");
			*/
				public static final By btn_Menu=By.xpath("//android.widget.ImageButton");
				public static final By btn_Applogo=By.xpath("//android.widget.ImageView[contains(@resource-id,'android:id/home')]");
				public static final By logout=By.xpath("//android.widget.TextView[contains(@text,'Log Out')]");
				public static final By popup_LogoutQ=By.xpath("//android.widget.TextView[contains(@text,'Are you sure you want to log out?')]");
				public static final By popup_Ok=By.xpath("//android.widget.Button[contains(@text,'Ok')]");
				public static final By popup_Cancel=By.xpath("//android.widget.Button[contains(@text,'Cancel')]");
		
		}
			
			
		
		
}
