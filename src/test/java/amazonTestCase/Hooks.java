package amazonTestCase;

import java.io.FileNotFoundException;
import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import library.baseHelper;

public class Hooks extends baseHelper{
	

	
	
	/*
	 * it will run before all scenarios, we can use appium start stop
	 */
	@BeforeTest
	public void setUp() throws IOException, Throwable
	{
		AndroidDriver<AndroidElement> driver ;
		service = startServer();
        
				
	}

	
	/*
	 * it will run after all scenarios
	 */
	@AfterTest
	public void tearDown()
	{
		
		service = stopServer();
	   
	    	
	}
	

}
