package com.oleti.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.oleti.utils.logs.Log;

public class CartPage extends BasePage {
	WebDriver driver;

	By cartButton = By.xpath("//*[@id=\"btn-openMiniCart\"]/img");
	By cartItems = By.xpath("//*[@data-product-section=\"Cart\"]");
	String productId;
	public static List<String> prodcutIdsInCart;

	public CartPage(WebDriver driver) {

		this.driver = driver;

	}
	
	public void gotoCartDetails()
	{
		driver.findElement(cartButton).click();
	}
	
	public void getCartItemsProductIds()
	{
		List<WebElement> allItems = driver.findElements(cartItems);
		prodcutIdsInCart=new ArrayList<String>();
		
		log.info("element"+allItems.toString());

		for(WebElement element: allItems)
		{
			log.info("element"+element);
			String s=element.getAttribute("data-productid");
			prodcutIdsInCart.add(s);
		}
		log.info("Cart Items Product IDs:"+prodcutIdsInCart.toString());
		
	}
}
