package com.Eme.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ServiceUtil {

	public void clickElement(WebElement element);

	public void setInputVal(WebElement element, String textVal);

	public String getTitle(WebDriver driver);
	
	public boolean isElementPresent(WebElement element);
}
