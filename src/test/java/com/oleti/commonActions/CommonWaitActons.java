package com.oleti.commonActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oleti.utils.logs.Log;

public class CommonWaitActons {
	WebElement element;
	
	public static void waitUntilElementNotVisible(WebDriver driver,By by)
	{
		Boolean wait=new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
		if(wait)
			Log.info("Loading Screen dismissed:"+wait);
		else
			Log.error("Loading Screen not dismissed:"+wait);
	}
	
	public static void waitUntilElementIsVisible(WebDriver driver,By by)
	{
		WebElement wait=new WebDriverWait(driver, Duration.ofSeconds(40)).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
		if(wait.isEnabled())
			Log.info("Is Element Enabled ?:"+wait.isEnabled());
		else
			Log.error("Is Element Enabled?:"+wait.isEnabled());
	}

}
