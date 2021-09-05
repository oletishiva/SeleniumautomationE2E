package com.oleti.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.oleti.commonActions.CommonWaitActons;
import com.oleti.utils.logs.Log;

public class SearchResults extends BasePage {
	String categoryName;
	String tvScreenSize;
	WebDriver driver;

	By filterCategeory1 = By
			.xpath("//*[ @title='ช่วงขนาดหน้าจอ (นิ้ว)'  and contains(@class,'CardCollaspe__CardView-')]");
	By filterCategeory = By
			.xpath("//*[ @title='" + categoryName + "'  and contains(@class,'CardCollaspe__CardView-')] ");
	By filterCategeoryIntoView = By.xpath("//*[ @title='ช่วงขนาดหน้าจอ (นิ้ว)']");
	By loadingIndicator=By.xpath("//div[@class='LoadingScreen__Relative-buBEEi bfqcdg']");
	By itemsAvailableToAddToCart=By.xpath("//div[@class=\"ProductGridItem__Label-iQRkAY jLwkyu\"]/parent::div/parent::div/parent::div");
	
	public SearchResults(WebDriver driver)
	{
		this.driver=driver;
	}
	

	public void scrollIntoViewPort() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(10000);
		WebElement element = driver.findElement(filterCategeoryIntoView);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void selectScreenSizeGroup(String screensize) throws InterruptedException {
		Thread.sleep(10000);
		By screenSizeGroup = By.xpath("//*[text()='" + screensize
				+ "']/ancestor::div[@class=\"Row__Wrapper-v6uxgu-0 kSLyDU\"][1]//*[@data-testid='btn-checkbox']");
		Log.info("Tests is starting!");
		Log.info("Tests is starting!"+screenSizeGroup);
		driver.findElement(screenSizeGroup).click();
		CommonWaitActons.waitUntilElementNotVisible(driver, loadingIndicator);
		/*
		 * Boolean wait=new WebDriverWait(driver,
		 * Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOf(driver.
		 * findElement(loadingIndicator))); if(wait)
		 * Log.info("Loading Screen dismissed:"+wait); else
		 * Log.info("Loading Screen not dismissed:"+wait);
		 */
			
			
	}
	
	public void addFirstAvailableItemToCart()
	{
		String firstItem=driver.findElements(itemsAvailableToAddToCart).get(0).getText();
		driver.findElements(itemsAvailableToAddToCart).get(0).click();
		Log.info("FirstItem"+firstItem);
	}

	
}
