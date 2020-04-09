
package practise.AppiumFramework;
import java.io.IOException;
import org.junit.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import junit.framework.Assert;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.ProductPage;
import practise.AppiumFramework.Utilities;
import practise.AppiumFramework.baseHelper;


public class AmazonLoginDemoTest extends baseHelper {
	
	public static AndroidDriver<AndroidElement>  driver;
	
	
	@Test
	public void firstRun()  throws InterruptedException, IOException {
		
		
		
		         service=startServer();
		         //Set Capabilities
		         AndroidDriver<AndroidElement> driver=capabilities("AmazonStoreApp");
				
			     
			     //Creat Object for Login Class
			     Login login=new Login(driver);
			     baseHelper.getScreenshot("Final");
			     /*login.getsignInButton().click();
			    
			     login.getEditField().sendKeys(baseHelper.getProperty("username"));
			     baseHelper.waitforSeconds(5);
			     login.getselectButton().click();
			     baseHelper.waitforSeconds(5);
			     login.getEditField().sendKeys(baseHelper.getProperty("password"));
			    
			     login.getselectButton().click();
			     baseHelper.waitforSeconds(15);
			   //Creat Object for HomePAGE Class
			     HomePage home= new HomePage(driver);
			     baseHelper.waitforSeconds(10);
			     if(home.getPopup().isDisplayed()) {
			    	 try {
			    	 home.getEnglish().click();
			    	 home.buttons.get(0).click();
			    	 }
			    	 catch(Exception ex) {
			    		 home.getPopup().click(); 
			    	 }
			     }
			     home.getHomeSearch().click();
			     baseHelper.waitforSeconds(5);
			     home.getHomeSearch().sendKeys(baseHelper.getProperty("key"));
			     baseHelper.waitforSeconds(5);
			     Utilities utl= new Utilities(driver);
			     utl.EnterKey();
			     
			     utl.scrollToText(baseHelper.getProperty("Value"));
			     ProductPage page= new ProductPage(driver);
			     page.getProduct().click();
			    

			     baseHelper.waitforSeconds(10);
			     if(home.getPopup().isDisplayed()) {
			    	 home.getPopup().click(); 
			     }
			     AddToCartPage cartPage= new AddToCartPage(driver);
                 baseHelper.lRotate();
			     
			     baseHelper.waitforSeconds(10);
			     String s=cartPage.getProductName().getText();
                 // Verify Correct product selected or Not
                 Assert.assertEquals(s,baseHelper.getProperty("Value"));
			     utl.scrollToText(baseHelper.getProperty("AddToCart"));
			     
			     //cartPage.getAddToCart().click();
			   // Rotate Screen
			   
			     baseHelper.pRotate();
			     baseHelper.getScreenshot("Final");
			     */
		 
	}
	

}