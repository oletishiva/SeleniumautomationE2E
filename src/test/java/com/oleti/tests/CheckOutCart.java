package com.oleti.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.oleti.pages.BasePage;
import com.oleti.pages.CatalogItemDetails;
import com.oleti.pages.HomePage;
import com.oleti.pages.SearchResults;
import com.oleti.utils.logs.Log;

import static com.oleti.utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;

public class CheckOutCart extends BaseTest {
	SearchResults s;
	HomePage h;
	CatalogItemDetails c;
	
	public CheckOutCart()
	{

		h=new HomePage(driver);
		s=new SearchResults(driver);
		c=new CatalogItemDetails(driver);
	}
	
	@Test(description = "Search Product TV ")
	public void searchProduct(Method method) throws InterruptedException
	{
		startTest(method.getName(),"Search for product");
		h.enterTextToSearch("TV");
		
			
	}
	@Test(dependsOnMethods= {"searchProduct"}, description="Filter the Product with Screen Size and Select First Item")
	public void filterProductWithScreenSize4455(Method method) throws InterruptedException
	{
		startTest(method.getName(),"Filter the Product with Screen Size\"");
		filterAndAddProduct("44 - 55 นิ้ว");
		
	}
	
	@Test(dependsOnMethods= {"filterProductWithScreenSize4455"}, description="add Product to the cart of 44-55 inches")
	public void addProduct4455ScreenSizeToCart(Method method) throws InterruptedException
	{
		startTest(method.getName(),"add product to the cart");
		addFirstItemToCart();
	}
	
	@Test(dependsOnMethods= {"addProduct4455ScreenSizeToCart"}, description="Filter the Product with Screen Size 32-43 and Select First Item")
	public void filterProductWithScreenSize3243(Method method) throws InterruptedException
	{
		startTest(method.getName(),"Filter the Product with Screen Size 32 to 43\"");
		filterAndAddProduct("32 - 43 นิ้ว");
				
	}
	
	@Test(dependsOnMethods= {"filterProductWithScreenSize3243"}, description="add Product to the cart of 32-43 inches")
	public void addProduct3243inchitemToCart(Method method) throws InterruptedException
	{
		startTest(method.getName(),"add product to the cart");
		addFirstItemToCart();
	}
	
	// Reusable methods in this test
	
	public void addFirstItemToCart() throws InterruptedException
	{
		Thread.sleep(30000);
		c.addItemToCartPage();
		c.navigateBacktoProductFilterPage();
	}

	public void filterAndAddProduct(String size) throws InterruptedException
	{
		s.selectScreenSizeGroup(size);
		s.addFirstAvailableItemToCart();
	}
}
