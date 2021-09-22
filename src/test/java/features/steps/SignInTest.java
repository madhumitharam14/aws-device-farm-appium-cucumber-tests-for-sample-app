package features.steps;

import features.AbstractBaseTests.TestBase;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import Pages.LoginPage;
import Pages.SignInPage;


//@CucumberOptions(
//        strict = true,
//        monochrome = true,
//        features = "classpath:src/test/resources/SignInTest/",
//        plugin = {"pretty"}
//)
public class SignInTest extends TestBase{
	
	public static AppiumDriver driver;
	//SignInPage SignInPage = new SignInPage();
	
	@Given("^The driver is launched to validate the signIn page$")
	public void setUp() {
		SignInPage SignInPage = new SignInPage(driver);
	}
	
	@Given("^userName is entered and signin button is clicked$")
    public void singinSuccess() throws InterruptedException, IOException {
		//SignIn.validateLoginPage();
		SignInPage SignInPage = new SignInPage(driver);
		SignInPage.signIn();
        //Assert.assertEquals(loginPage.getMessage(), LOGIN_SUCCESS_MESSAGE);
    }


//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return "SignInPage";
//	}
//
//
//	@Override
//	public void setUpPage() {
//		// TODO Auto-generated method stub
//		
//	}
//

}
