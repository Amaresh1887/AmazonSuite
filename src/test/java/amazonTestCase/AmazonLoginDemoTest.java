
package amazonTestCase;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import library.Utilities;
import library.baseHelper;
import library.readDataFromExcel;
import pageObjects.AddToCartPage;
import pageObjects.HomePage;
import pageObjects.Login;
import pageObjects.ProductPage;

public class AmazonLoginDemoTest extends baseHelper {

	public static AndroidDriver<AndroidElement> driver;

	@Test
	public void firstRun() throws InterruptedException, IOException {

		readDataFromExcel data = new readDataFromExcel();
		ArrayList al = data.getData("AmazonLogin", "LoginC");
		String username = al.get(1).toString();
		String password = al.get(2).toString();
		String SearchItem = al.get(3).toString();
		String Itemname = al.get(4).toString();

		service = startServer();
		// Set Capabilities
		AndroidDriver<AndroidElement> driver = capabilities("AmazonStoreApp");

		// Creat Object for Login Class
		Login login = new Login(driver);
		String dispalyname = login.getSignInMsg().getText();
		// Verify Correct App installed and Launched successfully or not
		Assert.assertEquals(dispalyname, baseHelper.getProperty("appdisplayname"));
		baseHelper.getScreenshot("Login Page");

		login.getsignInButton().click();
		login.getEditField().sendKeys(username);
		baseHelper.waitforSeconds(5);
		login.getselectButton().click();
		baseHelper.waitforSeconds(5);

		login.getEditField().sendKeys(password);

		login.getselectButton().click();
		baseHelper.waitforSeconds(15);

		// Creat Object for HomePAGE Class
		HomePage home = new HomePage(driver);
		String homemessage = home.getCategory().getText();
		// Verify login successfull or not
		
		if(!homemessage.contains(baseHelper.getProperty("homeMsg"))) {
			Assert.fail();
		}
		baseHelper.getScreenshot("Ammazon Home Page");
		baseHelper.waitforSeconds(5);
		Boolean iselementpresent = driver.findElementsByXPath("//android.view.View[@text='close']").size() != 0;

		if (iselementpresent) {
			try {
				home.getEnglish().click();
				home.buttons.get(0).click();
			} catch (Exception ex) {
			}
		}
		home.getHomeSearch().click();
		baseHelper.waitforSeconds(5);
		home.getHomeSearch().sendKeys(SearchItem);
		baseHelper.waitforSeconds(5);
		Utilities utl = new Utilities(driver);
		utl.EnterKey();
		baseHelper.getScreenshot("Search Results");
		utl.scrollToText(Itemname);
		ProductPage page = new ProductPage(driver);
		page.getProduct().click();

		baseHelper.waitforSeconds(10);
		Boolean popup = driver.findElementsByXPath("//android.view.View[@text='close']").size() != 0;

		if (popup) {
			try {
				home.getEnglish().click();
				home.buttons.get(0).click();
			} catch (Exception ex) {
			}
		}
		// Rotate Screen
		AddToCartPage cartPage = new AddToCartPage(driver);
		baseHelper.lRotate();

		baseHelper.waitforSeconds(10);
		baseHelper.getScreenshot("LANDSCAPE Mode");

		String displayProductName = cartPage.getProductName().getText();

		// Verify Correct product selected or Not
		Assert.assertEquals(displayProductName, Itemname);

		baseHelper.pRotate();
		baseHelper.getScreenshot("Portrait");
		utl.scrollToText(baseHelper.getProperty("AddToCart"));

		 cartPage.getAddToCart().click();
		

	}

}