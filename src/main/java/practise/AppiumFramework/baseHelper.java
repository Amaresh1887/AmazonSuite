package practise.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;


public class baseHelper {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<AndroidElement>  driver;
	  public static MobileElement mobileElement;
	
	public AppiumDriverLocalService startServer()
	{
		
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}


	public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
	

		// TODO Auto-generated method stub
	 File appDir = new File(getProperty("path"));
     File app = new File(appDir, (String) prop.get(appName)); 
     DesiredCapabilities capabilities = new DesiredCapabilities();
     String device= System.getProperty("deviceName");
 
     capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
    
     capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
     
     capabilities.setCapability("unicodeKeyboard","true");
     capabilities.setCapability("resetKeyboard","true");
     capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
     capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
     capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
     capabilities.setCapability("waitForIdleTimeout", 20000);
     capabilities.setCapability("disableWindowAnimation", true);
     capabilities.setCapability("noReset", "false");
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
  
 
    
	    
	    return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
		String time = new SimpleDateFormat("HHMMSS")
				.format(Calendar.getInstance().getTime());
		String file= s+time;
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\ScreenShot\\"+time+"\\"+s+".png"));
	
	}
	
	
	public static String getProperty(String property) {
		if (System.getProperty(property) != null) {
			return System.getProperty(property);
		}
		File setupPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
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
	
	public static void waitforSeconds( int seconds) throws InterruptedException {
		seconds = seconds * 1000;
		Thread.sleep(seconds);
	}
	
	public static  void lRotate() {
		ScreenOrientation sr=driver.getOrientation();
		 driver.rotate(sr.LANDSCAPE);
		
	}
	
	public static  void pRotate() {
		ScreenOrientation sr=driver.getOrientation();
	    driver.rotate(sr.PORTRAIT);
	}
		
	
	
}
