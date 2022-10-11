package com.Eme.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Eme.helper.DataSlayer;
import com.Eme.helper.commonServices;
import com.Eme.helper.helper;

public class LoginPage extends commonServices {

	WebDriver driver;
	commonServices services;
	public LoginPage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	    services=new commonServices();
	}
	
	@FindBy(xpath = "//div[@class=\"cont_signin\"]")
	WebElement Loginlink;
	
	@FindBy(xpath = "//input[@id=\"userinput\"]")
	WebElement emailinput;
	
	@FindBy(xpath = "//button[@class=\"btn btn-success btn-block\"]/child::span")
	WebElement proceedbtn1;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement passwordinput;
	
	@FindBy(xpath="//a[contains(text(),'Use Password?')]")
	WebElement userpassword;
	
	@FindBy(xpath = "//form[@class=\"form-signin form-height-lg cwAuthForm hidden form-code-2010 form-code-2017 ng-pristine ng-valid\"]/child::button")
	WebElement proceedbtn;
	
	@FindBy(xpath = "//span[@class=\"signin_icon\"]")
	WebElement signinicon;
	
	@FindBy(xpath = "//button[@class=\"close\"]/child::span")
	WebElement logincrossbtn;
	
	@FindBy(xpath = "//form[@method=\"post\"]/child::input[@id=\"otp\"]")
	WebElement otpinput;
	
	@FindBy(xpath = "//button[text()=\"Verify\"]")
	WebElement verifybtn;
	
	@FindBy(xpath = "//a[text()=\"Resend Code\"]")
	WebElement resendbtn;
	
	@FindBy(xpath = "//a[text()=\"Forgot Password?\"]")
	WebElement forgetpass;
	
	@FindBy(xpath = "//input[@id=\"passwordnew\"]")
	WebElement passnew;
	
	@FindBy(xpath = "//button[text()=\" Update \"]")
	WebElement updatepassbtn;
	
	@FindBy(xpath = "//div[@class=\"psd-wrap\"]/child::i[@toggle=\"#password\"]")
	WebElement eyeicon;
	
	@FindBy(xpath = "//form[@name=\"f-verify-mobile\"]/descendant::a[6]")
	WebElement termsLink;
	
	@FindBy(xpath = "//a[@href=\"mailto:nodalofficer@eyemyeye.com\"]")
	WebElement nodalmail;
	
	@FindBy(xpath = "//input[@id=\"whatsapp-check2\"]")
	WebElement whatsappcheck;
	
	@FindBy(xpath = "//p[@class=\"text-center sub-title1\"]/child::a")
	WebElement change;
	
	public boolean loginByPass(String username, String password) {
		if (Loginlink.isDisplayed()) {
            Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			//helper.waitForClick(driver, proceedbtn1, 3000);
			try {
				helper.waitForClick(driver, userpassword, 3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			passwordinput.sendKeys(password);
			proceedbtn.click();
			signinicon.isDisplayed();
		} else {
            System.out.println("Element not displayed");
		}
		return true;
	}
	
	public boolean isLoginPopupClose() {
		if (Loginlink.isDisplayed() && Loginlink.isEnabled()) {
			Loginlink.click();
			logincrossbtn.click();
		}else {
			System.out.println("Login link not displayed");
		}
		return true;
	}
	
	public boolean loginByOtp(String username, String otp) {
		if (Loginlink.isDisplayed() && Loginlink.isEnabled()) {
			Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			otpinput.sendKeys(otp);
			verifybtn.click();
		}else {
			System.out.println("Login link not displayed");
		}
		return true;
	}
	
	public boolean resendOtp(String username) {
		boolean isclick=false;
		if (helper.checkInternet()) {
			Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			helper.waitForClick(driver, resendbtn, 5000);
			isclick=true;
		} else {
            System.out.println("No Internet connectivity");
		}
		return isclick;
	}
	
	public void forgetPassword(String username, String otp) {
		if (helper.checkInternet()) {
            Loginlink.click();
			emailinput.sendKeys(username);
			emailinput.sendKeys(Keys.ENTER);
			//helper.waitForClick(driver, proceedbtn1, 3000);
			try {
				helper.waitForClick(driver, userpassword, 3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			helper.waitForClick(driver, forgetpass, 3000);
			//forgetpass.click();
			otpinput.sendKeys(otp);
			String updatedpass=helper.generateRandomVal();
			passnew.sendKeys(updatedpass);
			updatepassbtn.click();
			helper.waitfornextAction(driver, 3000);
			passwordinput.sendKeys(updatedpass);
			System.out.println(updatedpass);
			helper.waitForClick(driver, proceedbtn, 3000);
		}else {
			System.out.println("Something went wrong!!");
		}
	}
	
	public boolean showPassword() {
		clickElement(Loginlink);
		//Loginlink.click();
		setInputVal(emailinput, DataSlayer.getData(1, 0, 1));
		//emailinput.sendKeys(username);
		emailinput.sendKeys(Keys.ENTER);
		try {
			//helper.waitForClick(driver, userpassword, 3000);
			clickElement(userpassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setInputVal(passwordinput, DataSlayer.getData(1, 1, 1));
		//passwordinput.sendKeys(password);
		clickElement(eyeicon);
		//eyeicon.click();
		return true;
	}
	
	public Boolean validateWsappUncheck() {
		boolean linkBoolean = false;
		if (Loginlink.isDisplayed()) {
			clickElement(Loginlink);
		} else {
            System.out.println("Login link not Displayed on Menu");
		}
		setInputVal(emailinput, DataSlayer.getData(1, 0, 1));
		emailinput.sendKeys(Keys.ENTER);
		linkBoolean= helper.isClicked(whatsappcheck);
		
		return linkBoolean;	
	}
	
	public void loginBase() {
		if (Loginlink.isDisplayed()) {
			clickElement(Loginlink);
			setInputVal(emailinput, DataSlayer.getData(1, 0, 1));
			emailinput.sendKeys(Keys.ENTER);
		} else {
            System.out.println("Login link not Displayed on Menu");
		}
	}
	
	public String changeLogin() {
		loginBase();
		helper.waitToLoad(3000);
		clickElement(change);
		String inputval= emailinput.getAttribute("value");
		return inputval;
	}
	
	
}
