package com.Eme.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.Eme.helper.DataSlayer;
import com.Eme.pages.BrowserManagement;
import com.Eme.pages.cartOperations;

public class cartTestCases extends BrowserManagement {

	cartOperations cartoperate;

	@BeforeMethod
	public void initializewebElement() {
		cartoperate = new cartOperations(driver);
	}

	@Test(priority = 0, description = "Empty cart test", enabled = false)
	public void emptyCartTest() {
		String emptycartval = cartoperate.emptyCart();
		Assert.assertEquals(emptycartval, DataSlayer.getData(2, 0, 1));
	}

	@Test(priority = 0, description = "Login popup open from empty cart test", enabled = false)
	public void loginPopupOpenTest() {
		boolean cartloginlink = cartoperate.openLoginPopup();
		Assert.assertEquals(cartloginlink, true);
	}

	@Test(priority = 0, description = "My Bag stepper color for empty cart Test", enabled = false)
	public void myBagColorTest() {
		Assert.assertEquals(cartoperate.myBagColor(), DataSlayer.getData(2, 1, 1));
	}

	@Test(priority = 0, description = "Get empty cart buttons", enabled = false)
	public void emptyCartbtnTest() {
		String btntext = cartoperate.getemptyCartbtn();
		String btnarrtext[] = null;
		btnarrtext = btntext.split(",");
		for (int i = 0; i < btnarrtext.length; i++) {
			System.out.println(btnarrtext[i]);
		}
		Assert.assertEquals(btnarrtext.length, 2);
	}
	
	@Test(priority = 0, description = "Get progress step data", enabled = false)
	public void cartStepDataTest() {
		String steptext = cartoperate.cartProgressStep();
		String btnarrtext[] = null;
		btnarrtext = steptext.split(",");
		for (int i = 0; i < btnarrtext.length; i++) {
			System.out.println(btnarrtext[i]);
		}
		Assert.assertEquals(btnarrtext.length, 3 );
	}
	
	@Test(priority = 0, description = "Is logo exist on empty cart", enabled = true)
	public void isLogoExist() {
		Assert.assertTrue(cartoperate.isLogoExist());
	}
}
