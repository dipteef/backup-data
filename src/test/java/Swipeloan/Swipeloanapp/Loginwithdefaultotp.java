package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Loginwithdefaultotp {
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
		Thread.sleep(3000);
		driver.findElement(By.className("android.widget.EditText")).click();
		driver.findElement(By.className("android.widget.EditText")).sendKeys("9689698026");
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
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//android.widget.Button[@content-desc='I Agree']")).click();

}
}
