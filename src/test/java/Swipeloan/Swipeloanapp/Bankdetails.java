package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Bankdetails {
	
	private AndroidDriver driver;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("deviceName","Xiaomi M2010J19SI");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("platformVersion", "12");
		capabilities.setCapability("appPackage", "com.kgil.swipeloan");   
		capabilities.setCapability("appActivity", "com.kgil.swipeloan.MainActivity");  
		capabilities.setCapability("autoGrantPermissions", true);
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
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     // Enter phone number
	        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.EditText")));
	        phoneInput.click();
	        phoneInput.sendKeys("9689698026");
	        driver.hideKeyboard();
		
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Get Started']")).click();
		Thread.sleep(1000);
		String otp="121512";
		WebElement otpInputField = driver.findElement(By.className("android.widget.EditText"));
	    otpInputField.sendKeys(otp);
		List<WebElement> otpFields = driver.findElements(By.className("android.widget.EditText"));
	    
	    // Ensure that there are enough fields to accommodate each digit of the OTP.
	    if (otpFields.size() == 1) {
	        // Single input field case
	        System.out.println("Single OTP input field detected.");
	        otpFields.get(0).click();
	        otpFields.get(0).clear();
	        otpFields.get(0).sendKeys(otp);
	    } 

		
     	  Thread.sleep(4000);
     	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	  Thread.sleep(2000);
    	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
    	  
    	  // Click 'I Agree'
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='I Agree']"))).click();
		
     	// Click "Complete Application"
     	
	     WebElement completeApplication = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Complete Application']")));
	     completeApplication.click();
	     
	     List<WebElement> editTextFields = driver.findElements(By.className("android.widget.EditText"));
	        System.out.println("Number of EditText fields found: " + editTextFields.size());
	        if (editTextFields.size() >= 3) {
	        	 WebElement banknameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]")));
		            banknameField.click();
		            Thread.sleep(2000);
		            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).click();
		            Thread.sleep(2000);
		            driver.findElement(By.xpath("//android.widget.ScrollView/android.widget.EditText[1]")).sendKeys("bank of maharashtra");
		            
	        
	  // Wait for the dropdown to show results and select the item
	     WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement option = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Bank of Maharashtra']")));
	     option.click();
	     driver.hideKeyboard();
	     
	     WebElement accountNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
         accountNumberField.click();
         accountNumberField.sendKeys("60151358046");
         driver.hideKeyboard();
         
	     Thread.sleep(2000);
         WebElement confirmaccountNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")));
         confirmaccountNumberField.click();
         confirmaccountNumberField.sendKeys("60151358046");
         driver.hideKeyboard();
         
         Thread.sleep(2000);
         WebElement ifscCodeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[3]")));
         ifscCodeField.click();
         ifscCodeField.sendKeys("MAHB0001750");
         driver.hideKeyboard();
         
        } 
	        
         Thread.sleep(1000);
        driver.findElement(By.xpath("//android.view.View[@content-desc='Submit']")).click();

	}
	
	
	
}
