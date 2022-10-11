package com.Eme.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Eme.helper.helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManagement {

	public static WebDriver driver = null;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports reports;
	public static ExtentTest test;

	// browser activity method
	@SuppressWarnings("deprecation")
	@BeforeMethod
	public static void launchBrowser() {
		if (driver == null) {
			if (System.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (System.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (System.getProperty("browser").equalsIgnoreCase("safari")) {
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
			} else if (System.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				System.out.println("No associated webdriver found..");
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// driver.get("https://www.eyemyeye.com/");
		driver.get(System.getProperty("url"));
	}

	// Quit browser
	@AfterMethod
	public static void closeBrowser(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(
					System.getProperty("user.dir") + "/Screenshots/eme_" + helper.getCurrentDate() + ".png");
			FileUtils.copyFile(sourceFile, destinationFile);
		}
		driver.quit();
		driver = null;
	}

}
