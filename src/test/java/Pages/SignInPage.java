package Pages;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import features.AbstractBaseTests.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.QuilPageObject;

public class SignInPage extends QuilPageObject{
	
	@AndroidFindBy(xpath="//*[@text=\"Email\"]")
	private MobileElement emailEditBox;
	
	@AndroidFindBy(xpath="//*[@text=\"Password\"]")
	private MobileElement passwordEditBox;
	
	@AndroidFindBy(xpath="//*[@content-desc='Password']/following::android.widget.TextView[@text='Sign In']")
	private MobileElement signInButton;
	
	public SignInPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	public void signIn() throws IOException {
		emailEditBox.sendKeys("test.user@test.com");
		passwordEditBox.sendKeys("");
		TestBase.test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "User name and password is entered");
		signInButton.click();
	}



}
