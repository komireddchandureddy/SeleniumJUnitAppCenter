package com.swg.tests;

import com.microsoft.appcenter.appium.Factory;
import com.swg.utils.AndroidAppFunctions;

import org.junit.rules.TestWatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.net.MalformedURLException;

public class LoginTest extends AndroidAppFunctions {
	
	@Rule
	public TestWatcher watcher = Factory.createWatcher();

	@Before
	public void setUp() throws MalformedURLException, Exception {
		launchApp();
	}

	@Test
	public void testLogin()  {
		ApplicationLogin(serverIP, serverName, userName, password);
	}
	@After
	public void tearDown()  {
		logout();
			
	}
	
	
}
