package com.oleti.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.oleti.pages.BasePage;
import com.oleti.pages.CartPage;
import com.oleti.pages.CatalogItemDetails;
import com.oleti.pages.HomePage;
import com.oleti.pages.SearchResults;
import com.oleti.utils.logs.Log;

import static com.oleti.utils.extentreports.ExtentTestManager.startTest;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import com.oleti.utils.logs.Log;
public class CheckOutCart extends BaseTest {
	SearchResults s;
	HomePage h;
	CatalogItemDetails c;
	CartPage cp;
	List<String> dataproductIdsInCart;
	
	public CheckOutCart()
	{
		dataproductIdsInCart=new ArrayList<String>();
		h=new HomePage(driver);
		s=new SearchResults(driver);
		c=new CatalogItemDetails(driver);
		cp=new CartPage(driver);
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
		filterAndAddProduct("132 - 43 นิ้ว");
				
	}
	
	@Test(dependsOnMethods= {"filterProductWithScreenSize3243"}, description="add Product to the cart of 32-43 inches")
	public void addProduct3243inchitemToCart(Method method) throws InterruptedException
	{
		startTest(method.getName(),"add product to the cart");
		addFirstItemToCart();
	}
	
	@Test(dependsOnMethods= {"addProduct3243inchitemToCart"}, description="Verify Items in Cart")
	public void verifyItemsInCart() throws InterruptedException
	{
		Thread.sleep(10000);
		cp.gotoCartDetails();
		Thread.sleep(10000);
		cp.getCartItemsProductIds();
		Log.info("dataproductIdsInCart"+dataproductIdsInCart.toString());
		Log.info("CartPage.prodcutIdsInCart"+CartPage.prodcutIdsInCart.toString());
		for (String s:dataproductIdsInCart)
		{
			Assert.assertEquals(true, CartPage.prodcutIdsInCart.contains(s), "ProductIdInCart"+s);
			
		}
		
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
		String addedProuctId=s.addFirstAvailableItemToCart();
		dataproductIdsInCart.add(addedProuctId);
		Log.info("***************"+dataproductIdsInCart.toString());
	}
}
