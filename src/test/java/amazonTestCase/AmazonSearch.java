
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

public class AmazonSearch extends baseHelper {

	public static readDataFromExcel data;
	public static Login login;
	public static HomePage home;
	public static Utilities utl;
	public static ProductPage page;
	public static AddToCartPage cartPage;

	@Test
	public void firstRun() throws InterruptedException, IOException {

		driver = capabilities("AmazonStoreApp");
		data = new readDataFromExcel();
		// Create Object for pageobject
		login = new Login(driver);
		home = new HomePage(driver);
		utl = new Utilities(driver);
		page = new ProductPage(driver);
		cartPage = new AddToCartPage(driver);

		ArrayList al = data.getData("AmazonLogin", "LoginC");
		String username = al.get(1).toString();
		String password = al.get(2).toString();
		String SearchItem = al.get(3).toString();
		String Itemname = al.get(4).toString();

		String dispalyname = login.getSignInMsg().getText();
		// Verify Correct App installed and Launched successfully or not
		Assert.assertEquals(dispalyname, baseHelper.getProperty("appdisplayname"));
		baseHelper.getScreenshot("Login Page");

		login.loginApp(username, password);

		// Creat Object for HomePAGE Class

		String homemessage = home.getCategory().getText();
		// Verify login successfull or not

		if (!homemessage.contains(baseHelper.getProperty("homeMsg"))) {
			Assert.fail();
		}
		baseHelper.getScreenshot("Ammazon Home Page");
		baseHelper.waitforSeconds(5);
		Boolean iselementpresent = driver.findElementsByXPath("//android.view.View[@text='close']").size() != 0;

		if (iselementpresent) {
		    	home.getEnglish().click();
				home.buttons.get(0).click();
			
		}
		home.getHomeSearch().click();
		baseHelper.waitforSeconds(5);
		home.getHomeSearch().sendKeys(SearchItem);
		baseHelper.waitforSeconds(5);

		utl.EnterKey();
		baseHelper.getScreenshot("Search Results");
		utl.scrollToText(Itemname);
		page.getProduct().click();

		baseHelper.waitforSeconds(5);
		Boolean popup = driver.findElementsByXPath("//android.view.View[@text='close']").size() != 0;

		if (popup) {
			
				home.getEnglish().click();
				home.buttons.get(0).click();
			
			
		}
		// Rotate Screen
		baseHelper.lRotate();

		baseHelper.waitforSeconds(5);
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