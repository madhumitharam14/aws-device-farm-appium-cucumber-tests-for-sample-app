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

package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.LogStatus;

import features.AbstractBaseTests.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.QuilPageObject;

/**
 * A login page
 */
public class LoginPage extends QuilPageObject {
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    

    /**
     * The login button
     */
    @AndroidFindBy(xpath = "//*[@class=\"android.widget.TextView\" and @text=\"Sign In\"]")
    private MobileElement signInButton;

       public LoginPage(AppiumDriver driver) {
		// TODO Auto-generated constructor stub
    	super(driver);
	}

		
	public void validateLoginPage() throws IOException, InterruptedException {
		System.out.println("Navigation to login page is successful");
		Thread.sleep(5000);
		signInButton.click();
		TestBase.test.log(LogStatus.PASS,test.addScreenCapture(capture(driver))+ "Button is clicked");
		
		
		
	}
	
	
}
