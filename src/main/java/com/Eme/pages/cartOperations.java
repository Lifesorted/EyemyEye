package com.Eme.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Eme.helper.commonServices;
import com.Eme.helper.helper;

public class cartOperations extends commonServices {

	commonServices services;

	public cartOperations(WebDriver driver) {
		PageFactory.initElements(driver, this);
		services = new commonServices();
	}

	@FindBy(xpath = "//span[@class=\"cart_icon\"]")
	WebElement carticon;

	@FindBy(xpath = "//h6[@class=\"font-size-base mb-4 text-center\"]")
	WebElement cartemptylbl;

	@FindBy(xpath = "//a[@class=\"nav-link\"]")
	WebElement loginsignuplink;

	@FindBy(xpath = "//a[@class=\"font-weight-bold activemenu\"]")
	WebElement mybag;

	@FindBy(xpath = "//div[@class=\"text-center\"]/child::a[1]")
	WebElement emptycartbtn;

	@FindBy(xpath = "//ul[@id=\"progressbar\"]/descendant::span")
	WebElement progressbarval;

	@FindBy(xpath = "//div[@class=\"container-fluid px-10\"]/child::a")
	WebElement emptylogo;

	public String emptyCart() {
		clickElement(carticon);
		String labelval = cartemptylbl.getText();
		if (!(labelval == null)) {
			return labelval;
		} else {
			return "Cart not empty";
		}
	}

	public boolean openLoginPopup() {
		clickElement(carticon);
		helper.waitToLoad(3000);
		boolean clickstatus = helper.isClicked(loginsignuplink);
		return clickstatus;
	}

	public String myBagColor() {
		clickElement(carticon);
		helper.waitToLoad(3000);
		String color = mybag.getCssValue("color");
		String hexString = Color.fromString(color).asHex();
		return hexString;
	}

	public String getemptyCartbtn() {
		clickElement(carticon);
		helper.waitToLoad(3000);
		String textlist = "";
		try {
			List<WebElement> btndataElements = BrowserManagement.driver
					.findElements(By.xpath("//div[@class=\"text-center\"]/child::a"));
			for (WebElement webElement : btndataElements) {
				textlist += webElement.getText() + ",";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return textlist;
	}

	public String cartProgressStep() {
		clickElement(carticon);
		helper.waitToLoad(3000);
		String progressdata = "";
		try {
			List<WebElement> progressElements = progressbarval
					.findElements(By.xpath("//ul[@id=\"progressbar\"]/descendant::span"));
			for (WebElement webElement : progressElements) {
				if (webElement == null) {
					return "No data found";
				} else {
					progressdata += webElement.getText() + ",";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return progressdata;
	}

	//check logo
	public boolean isLogoExist() {
		clickElement(carticon);
		helper.waitToLoad(3000);
		return isElementPresent(emptylogo);
	}
}