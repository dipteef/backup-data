package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;

public class Creditscoreplan {
	

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
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
		element.sendKeys("9689698026");

//		Thread.sleep(2000);
//		driver.findElement(By.className("android.widget.EditText")).sendKeys("9689698026");
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

     	  Thread.sleep(1000);
     	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	

		  Thread.sleep(5000);
     	  driver.findElement(By.xpath("//android.widget.Button[@content-desc='I Agree']")).click();

     	 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement checkEligibility = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Check Eligibility']")));
	     checkEligibility.click();
     	  
	     driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Subscribe']")).click();
	     
	     // Get all contexts (Native & WebView)
	     Set<String> contexts = driver.getContextHandles();
	     for (String context : contexts) {
	         System.out.println("Available context: " + context);
	     }



	     WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement continueToPay = wait3.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId("Continue to Pay")));
	
	     
	     PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	     Sequence tap = new Sequence(finger, 0);
	     int centerX = 1080 / 2;  // Middle of the screen
	     int buttonY = 2150;  // Near the bottom but above the navigation bar
	     tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), centerX, buttonY));
	     tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	     tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	     driver.perform(Collections.singletonList(tap));

	     // Get all contexts (Native & WebView)
	     Set<String> contexts2 = driver.getContextHandles();
	     for (String context : contexts2) {
	         System.out.println("Available context: " + context);
	     }
	     
	     WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement paymentApp = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.webkit.WebView[@content-desc='primary_webview']")));
	     paymentApp.click();
	     
//	     driver.findElement(By.xpath("//android.webkit.WebView[@content-desc='primary_webview']")).click();
	     
	   
	     
	     Thread.sleep(4000);
	     driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='PROCEED TO PAY']")).click();

	     
     	  
	}     


}
