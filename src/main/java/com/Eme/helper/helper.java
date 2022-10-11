package com.Eme.helper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Eme.pages.BrowserManagement;

public class helper extends BrowserManagement {

	public static boolean clickElemenetTest(WebElement element) {
		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
			return true;
		} else {
			return false;
		}
	}

	public static void scrollby(String toscroll) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(toscroll);
	}

	@SuppressWarnings("deprecation")
	public static void waitfornextAction(WebDriver driver, int timeout) {
		new WebDriverWait(driver, timeout);
	}

	@SuppressWarnings("deprecation")
	public static void waitForClick(WebDriver driver, WebElement webelement, int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(webelement));
		webelement.click();
	}

	public static boolean checkInternet() {
		try {
			URL url = new URL(System.getProperty("url"));
			URLConnection connection = url.openConnection();
			connection.connect();
			System.out.println("Internet is connected");
		} catch (MalformedURLException e) {
			System.out.println("Internet is not connected");
		} catch (IOException e) {
			System.out.println("Internet is not connected");
		}
		return true;
	}

	public static boolean validateText(String expectedText, String ActualText) {
		return expectedText.equals(ActualText);
	}

	public static String generateRandomVal() {
		int min = 200;
		int max = 400;
		int val = (int) (Math.random() * (max - min + 1) + min);
		String dataval = "test" + val;
		return dataval;
	}

	public static boolean isClicked(WebElement element) {
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static void waitToLoad(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getCurrentDate() {
		DateFormat customformat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customformat.format(currentDate);
	}
<<<<<<< HEAD

=======
	
	public static void waitForClick(WebDriver driver,WebElement element , int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
	
	//Internet check
	public static boolean checkInternet() {
		 try {
	         URL url = new URL(System.getProperty("url"));
	         URLConnection connection = url.openConnection();
	         connection.connect();
	         System.out.println("Internet is connected");
	      } catch (MalformedURLException e) {
	         System.out.println("Internet is not connected");
	      } catch (IOException e) {
	         System.out.println("Internet is not connected");
	      }
		return true;
	}
	
	public static String generateRandomVal() {
		int min = 200;  
		int max = 400; 
		int val = (int)(Math.random()*(max-min+1)+min);
		String dataval="test"+val;
		return dataval;	
	}
	
>>>>>>> 3bcb582619c88d28d9c91b270e2b32e784c3c475
	/*
	 * public static void main(String args[]) {
	 * System.out.println(helper.getCurrentDate()); }
	 */
}
