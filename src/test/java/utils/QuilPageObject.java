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

package utils;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import cucumber.api.java.After;
import features.AbstractBaseTests.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * A base for all the pages within the suite
 */
public abstract class QuilPageObject extends TestBase{
    private static final int KEYBOARD_ANIMATION_DELAY = 1000;
    private static final int XML_REFRESH_DELAY = 1000;

    /**
     * The driver
     */
    public static AppiumDriver driver;

    /**
     * A base constructor that sets the page's driver
     *
     * The page structure is being used within this test in order to separate the
     * page actions from the tests.
     *
     * Please use the AppiumFieldDecorator class within the page factory. This way annotations
     * like @AndroidFindBy within the page objects.
     * @param driver2 
     *
     * @param driver the appium driver created in the beforesuite method.
     * @return 
     * @return 
     */
    public QuilPageObject(AppiumDriver driver2){
    	
        this.driver = TestBase.driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
       
    }
    
//    public AndroidDriver<MobileElement> getDriver() {
//    	
//    	this.driver = TestBase.driver;
//    	
//		return (AndroidDriver<MobileElement>) this.driver;
//    }
    
    	public static String capture(AppiumDriver driver2) throws IOException {
    	File scrFile = ((TakesScreenshot) driver2).getScreenshotAs(OutputType.FILE);
    	File Dest = new File(System.getProperty("user.dir") + "/TestsScreenshots/" + System.currentTimeMillis()
    	+ ".png");
    	String errflpath = Dest.getAbsolutePath();
    	FileUtils.copyFile(scrFile, Dest);
    	return errflpath;
    	}

    /**
     * Tries three times to send text to element properly.
     *
     * Note: This method was needed because Appium sometimes sends text to textboxes incorrectly.
     *
     * @param input String to be sent
     * @param element WebElement to receive text, cannot be a secure text field.
     * @param appendNewLine true to append a new line character to incoming string when sending to element, else false
     *
     * @return true if keys were successfully sent, otherwise false.
     */
    public boolean sendKeysToElement(String input, WebElement element, boolean appendNewLine) throws InterruptedException {
        final int MAX_ATTEMPTS = 3;
        int attempts = 0;

        do {
            element.clear();
            Thread.sleep(KEYBOARD_ANIMATION_DELAY);

            if (appendNewLine) {
                element.sendKeys(input + "\n");
            } else {
                element.sendKeys(input);
            }

            Thread.sleep(XML_REFRESH_DELAY);
        } while (!element.getText().contains(input) && ++attempts < MAX_ATTEMPTS);

        return element.getText().contains(input);
    }
    
    
    
}