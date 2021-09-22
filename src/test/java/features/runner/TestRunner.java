package features.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import features.AbstractBaseTests.TestBase;


@CucumberOptions(
		features= {"src/test/resources/features"},
		glue = {"features.steps"},
        tags = {"@Signin"},
        plugin = {"pretty","html:reports/test-report"}
		
)
public class TestRunner extends AbstractTestNGCucumberTests{
	
//	@BeforeClass(alwaysRun = true)
//	public void createReport() {
//		TestBase.report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
//		TestBase.test = TestBase.report.startTest("Sign Functionality");
//	}
	
	
}
