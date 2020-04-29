package library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class baseHelper {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static MobileElement mobileElement;

	/**
	 * Author: Amaresh
	 * 
	 * To Start Android Port
	 * 
	 */
	
	public AppiumDriverLocalService startServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}
	
	/**
	 * Author: Amaresh
	 * 
	 * To Stop Android Port
	 * 
	 */
	public AppiumDriverLocalService stopServer() {

		boolean flag = checkIfServerIsRunnning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildDefaultService();
			service.stop();
		}
		return service;

	}
	/**
	 * Author: Amaresh
	 * 
	 * Check Android port is running or not
	 * 
	 */
	public static boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);

			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	/**
	 * Author: Amaresh
	 * 
	 * Set Capabilities for Android Driver
	 * 
	 */

	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException {

		File appDir = new File(getProperty("path"));
		File app = new File(appDir, getProperty(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		String device = System.getProperty("deviceName");

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		capabilities.setCapability("unicodeKeyboard", "true");
		capabilities.setCapability("resetKeyboard", "true");
		capabilities.setCapability("appPackage", getProperty("package"));
		capabilities.setCapability("appActivity", getProperty("activity"));
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		capabilities.setCapability("waitForIdleTimeout", 20000);
		capabilities.setCapability("disableWindowAnimation", true);
		capabilities.setCapability("noReset", "false");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	/**
	 * Author: Amaresh
	 * 
	 * Get ScreenShot
	 * 
	 */

	public static void getScreenshot(String name) throws IOException {
		String time = new SimpleDateFormat("HHMMSS").format(Calendar.getInstance().getTime());

		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile,
				new File(System.getProperty("user.dir") + "\\ScreenShot\\" + time + "\\" + name + ".png"));

	}

	/**
	 * Author: Amaresh
	 * 
	 * Get Property name from property file
	 * 
	 */

	public static String getProperty(String property) {
		if (System.getProperty(property) != null) {
			return System.getProperty(property);
		}
		File setupPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\global.properties");
		if (setupPropFile.exists()) {
			Properties prop = new Properties();
			FileReader reader;
			try {
				reader = new FileReader(setupPropFile);
				prop.load(reader);
				reader.close();
				return prop.getProperty(property);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Author: Amaresh
	 * 
	 * Sleep Time
	 * 
	 */

	public static void waitforSeconds(int seconds) throws InterruptedException {
		seconds = seconds * 1000;
		Thread.sleep(seconds);
	}

	/**
	 * Author: Amaresh
	 * 
	 * Landscape Rotate
	 * 
	 */

	public static void lRotate() {
		ScreenOrientation sr = driver.getOrientation();
		driver.rotate(sr.LANDSCAPE);

	}
	/**
	 * Author: Amaresh
	 * 
	 * Portrait Rotate
	 * 
	 */

	public static void pRotate() {
		ScreenOrientation sr = driver.getOrientation();
		driver.rotate(sr.PORTRAIT);
	}
	
	
}
