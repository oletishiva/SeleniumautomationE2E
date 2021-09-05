package com.oleti.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchBox = By.id("txt-searchBox-input");
	By serachButton=By.id("btn-searchBox-input");
	By loadingIndicator=By.xpath("//div[@class='LoadingScreen__Relative-buBEEi bfqcdg']");
	
	public void enterTextToSearch(String str)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf((driver.findElement(serachButton))));
		driver.findElement(searchBox).sendKeys(str);
		driver.findElement(serachButton).click();
	}

}
