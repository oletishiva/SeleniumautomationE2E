package com.oleti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.oleti.commonActions.CommonWaitActons;

public class CatalogItemDetails extends BasePage{
	WebDriver driver;
		
	By productItemTv=By.xpath("//*[@id=\"lnk-viewBreadcrumb-2\"]");
	By addToCardButton=By.xpath("//*[@class='Button__StyledButton-r30g8h-0 uwdlB AddToCartButton__AddToCartButtonElem-dtemKR bwuoky']");
	By addProductSuccssMessage=By.xpath("//*[@class=\"Alert-jglfde-0 Notification__CustomAlert-lcdOEy fmgHJA\"]");
	
	public CatalogItemDetails(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void addItemToCartPage()
	{
		CommonWaitActons.waitUntilElementIsVisible(driver, addToCardButton);
		driver.findElement(addToCardButton).click();
	}
	
	public void navigateBacktoProductFilterPage()
	{
		driver.findElement(productItemTv).click();
	}

}
