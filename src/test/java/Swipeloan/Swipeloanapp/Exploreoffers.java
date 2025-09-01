package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Exploreoffers {
	
	private AndroidDriver driver;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("deviceName","Xiaomi M2010J19SI");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("appPackage", "com.kgil.swipeloan");   //com.swipeloan.swipe_loan_app
		capabilities.setCapability("appActivity", "com.kgil.swipeloan.MainActivity");  //com.swipeloan.swipe_loan_app.MainActivity
		capabilities.setCapability("autoGrantPermissions", true);
//		capabilities.setCapability("orientation", "PORTRAIT"); // or "LANDSCAPE"
//		capabilities.setCapability("noReset", true);
		capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("enforceXPath1", true);
		
        URL url= URI.create("http://127.0.0.1:4723/").toURL();
		driver= new AndroidDriver(url, capabilities);
	}
	
	@Test
	public void login() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.className("android.widget.Button")).click();

		 
	        // Click buttons sequentially
/*	        List<WebElement> buttons = driver.findElements(By.className("android.widget.Button"));
	        for (WebElement button : buttons) {
	            button.click();
	        }
*/

		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     // Enter phone number
	        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.EditText")));
	        phoneInput.click();
	        phoneInput.sendKeys("9689698026");
	        driver.hideKeyboard();
		
	     // Click 'Get Started'
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Get Started']"))).click();
		
	        
	        // Enter OTP
	        String otp = "121512";
	        WebElement otpInputField = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.EditText")));
	        otpInputField.sendKeys(otp);
		
	        // Handle multiple OTP fields (if any)
	        List<WebElement> otpFields = driver.findElements(By.className("android.widget.EditText"));
	        if (otpFields.size() == 1) {
	        	System.out.println("Single OTP input field detected.");
		        otpFields.get(0).click();
		        otpFields.get(0).clear();
		        otpFields.get(0).sendKeys(otp);
	        
	        }
		
	            // Click 'Continue' button
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Continue']"))).click();
	            
	            // Click 'Continue' button
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Continue']"))).click();

	            // Click 'I Agree'
	            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='I Agree']"))).click();

	            Thread.sleep(2000);
//	            driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Insta Fund Upto 1 Lac']")).click();

	            WebElement instafund = wait.until(ExpectedConditions.elementToBeClickable(
	                    new AppiumBy.ByAccessibilityId("Insta Fund\nUpto 1 Lac")));
	            instafund.click();
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("//android.view.View[@content-desc=\"Explore Offers\"]")).click();
	            
	            Thread.sleep(2000);
	            driver.findElement(By.xpath("(//android.widget.Button[@content-desc=\"Eligible\"])[1]")).click();
	            
	           
	}

}
