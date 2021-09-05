package com.oleti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class SearchResult extends BasePage{
	String categoryName;
	
	By filterCategeory1=By.xpath("//*[ @title='ช่วงขนาดหน้าจอ (นิ้ว)'  and contains(@class,'CardCollaspe__CardView-')]");
	By filterCategeory=By.xpath("//*[ @title='"+categoryName+"'  and contains(@class,'CardCollaspe__CardView-')] ");
	
	
	public void scrollIntoViewPort() {
		// TODO Auto-generated method stub
		WebElement element=driver.findElement(filterCategeory1);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	
	

}
