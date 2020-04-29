package library;

import org.openqa.selenium.Keys;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	AndroidDriver<AndroidElement> driver;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}

	/**
	 * Author: Amaresh
	 * 
	 * Scroll to find element
	 * 
	 */
	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}
	/**
	 * Author: Amaresh
	 * 
	 * Click device keyboard enter
	 * 
	 */

	public void EnterKey() {

		driver.getKeyboard().pressKey(Keys.ENTER);

	}
	
	
	

}
