package features.steps;


import org.testng.annotations.AfterClass;

import cucumber.api.java.After;
import features.AbstractBaseTests.TestBase;

public class Hooks{
    

@After
    public void tearDown(){
	System.out.println(":::Restarting app");
	TestBase.driver.resetApp();
}
}


