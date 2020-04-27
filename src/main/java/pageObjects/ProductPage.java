package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All th objects belonging to one page will be defined in java class
public class ProductPage {
// 1. Is to call the driver object from testcase to Pageobject file
	
	//Concatenate driver
	public ProductPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Brooke Bond Red Label Tea Taste of Togetherness 1kg']")
	public WebElement product;


	public WebElement getProduct() {
		return product;
	}
	
    

	
	
	//driver.findElementByXpath("//android.widget.TextView[@text='Preference']");
	
	
	
	
}
