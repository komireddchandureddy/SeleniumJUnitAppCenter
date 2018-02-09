package com.swg.tests;

import com.microsoft.appcenter.appium.Factory;
import com.swg.utils.AndroidAppFunctions;

import org.junit.rules.TestWatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;

public class CompleteVisitTest extends AndroidAppFunctions {
	public static String logging_step;
	public boolean status=false;
	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	@Before
	public void setUp()  {
		launchApp();
		ApplicationLogin(serverIP, serverName, userName, password);
		
	}

	@Test
	public void testCompleteVist() {
		
		clickOn1stEvent();
		status = completeVisit();
		if(!status) {
			infoLog(getClass(), "test Complete Vist failed");
			
		}
				
	}
	
	
	@Test
	public void testAddAttachmentVisit()  {
		
		clickOn1stEvent();
		status = addAttachmentVisit();
		if(!status) {
			infoLog(getClass(), "test Add Attachment Vist failed");
			
		}
	}
	
	@Test
	public void testHoldVisit()  {
		
		clickOn1stEvent();
		status = holdVisit();
		if(!status) {
			infoLog(getClass(), "test Hold Vist failed");
			
		}
	}
	@Test
	public void testRefreshStartedContinueVisit() {
		
		clickOn1stEvent();
		status = cancelVisit();
		if(!status) {
			infoLog(getClass(), "test Continue after refresh failed");
			
		}	
		/*infoLog(thisClass, "Verify Ready to Cancel status");
		isWebElementVisible(SWG.list_ReadyToCancelIteam);
	*/	
				
	}
	@Test
	public void testRefreshStartedVisit() {
		
		clickOn1stEvent();
		status = cancelVisit();
		if(!status) {
			infoLog(getClass(), "test Refresh after started failed");
			
		}	
		/*infoLog(thisClass, "Verify Ready to Cancel status");
		isWebElementVisible(SWG.list_ReadyToCancelIteam);
	*/	
				
	}
	
	
	@Test
	public void testRefreshVisit() {
		
		status = refreshIcon();
		/*infoLog(thisClass, "Verify Ready to Cancel status");
		isWebElementVisible(SWG.list_ReadyToCancelIteam);
	*/	
		if(!status) {
			infoLog(getClass(), "test Refresh Vist failed");
			
		}	
	}
	@Test
	public void testRejectVisitPermanently() {
		
		clickOn1stEvent();
		status = rejectVisitPermanently();
		if(!status) {
			infoLog(getClass(), "test Reject Visit permanently failed");
			
		}	
	}
	@Test
	public void testRejectVisitUntilDate() {
		
		clickOn1stEvent();
		status = rejectVisitUntilDate();
		if(!status) {
			infoLog(getClass(), "test Reject Visit until date failed");
			
		}
	}
	@Test
	public void testResumeVisit()  {
		
		clickOn1stEvent();
		status = resumeVisit();	
		if(!status) {
			infoLog(getClass(), "test Resume Vist failed");
			
		}
	}
	@Test
	public void testReturnRequiredVisit()  {
		
		clickOn1stEvent();
		status = returnRequiredVisit();	
		if(!status) {
			infoLog(getClass(), "test Return Required failed");
			
		}
	}
	
	@After
	public void tearDown()  {
		//logout();
	
		}
	
	
}
