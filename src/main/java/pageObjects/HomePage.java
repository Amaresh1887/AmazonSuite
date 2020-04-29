package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

// All th objects belonging to one page will be defined in java class
public class HomePage {
// 1. Is to call the driver object from testcase to Pageobject file
	
	//Concatenate driver
	public HomePage(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/web_home_shop_by_department_label")
	private AndroidElement category;
	
	public AndroidElement getCategory() {
		return category;
	}

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private AndroidElement HomeSearch;

	@AndroidFindBy(xpath="//android.view.View[@text='close']")
	private AndroidElement popup;
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='English - EN']")
	private AndroidElement English;

	public AndroidElement getEnglish() {
		return English;
	}



	@AndroidFindBy(className="android.widget.Button")
	public List<WebElement> buttons;

	public AndroidElement getHomeSearch() {
		return HomeSearch;
	}

	public AndroidElement getPopup() {
		return popup;
	}
	
	
	public void clickPopUp() {
		getEnglish().click();
		buttons.get(0).click();
	}
	
	
	
	
	
	
}
