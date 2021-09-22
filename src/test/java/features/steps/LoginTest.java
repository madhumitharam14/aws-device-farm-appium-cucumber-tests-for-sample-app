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

package features.steps;

import java.io.IOException;

import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import features.AbstractBaseTests.TestBase;
import io.appium.java_client.AppiumDriver;
import Pages.LoginPage;

/**
 * Tests for a login page
 */


public class LoginTest extends TestBase {
    
   
	public static AppiumDriver driver;

    /**
     * Tests logging in with valid credentials by verifying if the login message is correct
     * @throws IOException 
     */
    @Given("^username is correct$")
    public void loginSuccess() throws InterruptedException, IOException {
    	 LoginPage loginPage = new LoginPage(driver);
    	 System.out.println("Login screen is displayed");
    	 test.log(LogStatus.PASS, "Login page is displayed");
        loginPage.validateLoginPage();
        
        
        
    }
    
    

    }
