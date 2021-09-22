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
        tags = {"@login"},
        plugin = {"pretty","html:reports/test-report"}
		
)
public class TestRunner2 extends AbstractTestNGCucumberTests{
	
	
}
