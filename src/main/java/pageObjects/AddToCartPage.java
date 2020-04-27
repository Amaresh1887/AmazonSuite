package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddToCartPage {
	public AddToCartPage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	

	
	
	@AndroidFindBy(xpath="(//android.view.View[contains(@text,'Brooke Bond')])[2]")
	private WebElement productName;
	
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Add to Cart']")
	private WebElement addToCart;



	public WebElement getProductName() {
		return productName;
	}



	public WebElement getAddToCart() {
		return addToCart;
	}
	
	
	
}
