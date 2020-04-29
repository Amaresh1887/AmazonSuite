package pageObjects;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import library.baseHelper;

public class Login {
	public Login(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sso_splash_logo")
	private AndroidElement mainLogo;
	
	
	@AndroidFindBy(xpath="//android.view.View[@text='Forgot password?']")
	private AndroidElement forgotPassword;
	
	

	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	private AndroidElement signInButton;
	
	
	@AndroidFindBy(className="android.widget.EditText")
	public AndroidElement EditField;
	
	@AndroidFindBy(className="android.widget.Button")
	private AndroidElement selectButton;
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/signin_to_yourAccount")
	private AndroidElement signInMsg;
	
	
	public AndroidElement getSignInMsg() {
		return signInMsg;
	}
	public AndroidElement getsignInButton()
	{
		
		return signInButton;
	}
	public AndroidElement getEditField()
	{
		
		return EditField;
	}
	
	public AndroidElement getselectButton()
	{
		
		return selectButton;
	}
	
	public AndroidElement getMainLogo() {
		return mainLogo;
	}
	
	public AndroidElement getForgotPassword() {
		return forgotPassword;
	}

	public void loginApp(String username,String password) throws InterruptedException {
		getsignInButton().click();
		getEditField().sendKeys(username);
		baseHelper.waitforSeconds(5);
		getselectButton().click();
		baseHelper.waitforSeconds(4);
		getEditField().sendKeys(password);

		getselectButton().click();
		baseHelper.waitforSeconds(7);
	}
}
