package com.oleti.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.oleti.pages.BasePage;
import com.oleti.utils.logs.Log;

public class BaseTest extends BasePage{
       
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        Log.info("Navigate to"+BasePage.config.getProperty("testsiteurl"));
		BasePage.driver.get(BasePage.config.getProperty("testsiteurl"));
		BasePage.driver.manage().window().maximize();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        
    }

    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
       driver.quit();
    }
}