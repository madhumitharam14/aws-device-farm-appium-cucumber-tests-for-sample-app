/*
 * Copyright 2014-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package features.AbstractBaseTests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * An abstract base for all of the Android tests within this package
 *
 * Responsible for setting up the Appium test Driver
 */

public abstract class TestBase {
    /**
     * Make the driver static. This allows it to be created only once
     * and used across all of the test classes.
     */
    public static AndroidDriver<MobileElement> driver;
    
    /**
     * Extent report
     */
    public static ExtentTest test;
    public static ExtentReports report;

    /**
     * This allows the navigation to work within the app.
     * The category name is returned so we can navigate to it from the navigation
     * drawer.
     *
     * @return The name of the Android category
     */
   // public abstract String getName();

    
     public static Properties variables = new Properties();

    /**
     * Method to initialize the test's page
     */
//    @BeforeTest
//    public abstract void setUpPage();

    /**
     * This method runs before any other method.
     *
     * Appium follows a client - server model:
     * We are setting up our appium client in order to connect to Device Farm's appium server.
     *
     * We do not need to and SHOULD NOT set our own DesiredCapabilities
     * Device Farm creates custom settings at the server level. Setting your own DesiredCapabilities
     * will result in unexpected results and failures.
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    @BeforeSuite
    public void setUpAppium() throws FileNotFoundException, IOException {
    	
    	variables.load(new FileReader(System.getProperty("user.dir")+"\\Config.properties"));
    	
        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";

        URL url = new URL(URL_STRING);

        //Use a empty DesiredCapabilities object
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //Set the DesiredCapabilities capabilities only for local development
        capabilities.setCapability("deviceName",variables.getProperty("deviceName"));
        //capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
        capabilities.setCapability(CapabilityType.VERSION,variables.getProperty("compatabilityVersion"));
        capabilities.setCapability("platformName",variables.getProperty("platformName"));
        capabilities.setCapability("appPackage",variables.getProperty("appPackage"));
        capabilities.setCapability("appActivity",variables.getProperty("appActivity"));
        capabilities.setCapability("unicodeKeyboard", false);
        capabilities.setCapability("resetKeyboard", false);
        

        driver = new AndroidDriver<MobileElement>(url, capabilities);

        //Use a higher value if your mobile elements take time to show up
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
    	test = report.startTest("Login Functionality");
    }
    
    @BeforeClass
    public void navigateTo() throws InterruptedException {
        System.out.println("Before class");
    }
    
    

    /**
     * Always remember to quit
     */
    @AfterSuite
    public void tearDownAppium() {
    	System.out.println("Ending suite");
    	report.endTest(test);
    	report.flush();
        driver.quit();
    }

   
    
    public AndroidDriver<MobileElement> getDriver(){
    	return driver;
    }
    
    
}