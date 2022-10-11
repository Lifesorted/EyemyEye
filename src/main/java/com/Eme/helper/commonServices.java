package com.Eme.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class commonServices implements ServiceUtil {
	
	@Override
	public void clickElement(WebElement element) {
		element.click();	
	}

	@Override
	public void setInputVal(WebElement inputelement, String textVal) {
		inputelement.sendKeys(textVal);
	}

	@Override
	public String getTitle(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isElementPresent(WebElement element) {
		if (element.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
}
