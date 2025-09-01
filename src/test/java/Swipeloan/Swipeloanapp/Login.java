package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumClientConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Login {

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

		
//		HttpClient.Factory factory = HttpClient.Factory.create("apache-http-client");
		
/*		AppiumClientConfig config = AppiumClientConfig.defaultConfig()
			    .baseUrl(new URL("http://localhost:4723"));  // Use baseUrl() instead of serverUrl()

		AndroidDriver driver = new AndroidDriver(config, capabilities);


*/		
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
		driver.findElement(By.className("android.widget.EditText")).sendKeys("9975561091");
		driver.hideKeyboard();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Get Started']")).click();
		Thread.sleep(1000);
			
		

		  // Open the notification panel
		  driver.openNotifications();

		  // Locate the notification text containing the OTP
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Wait for up to 30 seconds
          WebElement otpNotification = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text, 'Your OTP')]")));

		  // Extract the OTP using regex
		  String notificationText = otpNotification.getText();
		  Pattern otpPattern = Pattern.compile("\\d{4,6}"); // Assuming OTP is 4 to 6 digits
		  Matcher matcher = otpPattern.matcher(notificationText);

		  if (matcher.find()) {
		  String otp = matcher.group();
		  System.out.println("Extracted OTP: " + otp);

		  driver.pressKey(new KeyEvent(AndroidKey.BACK));
		  // Use the OTP in the app
		  WebElement otpInputField = driver.findElements(By.className("android.widget.EditText")).get(0);
		  otpInputField.sendKeys(otp);

		  // Submit the OTP
		  driver.findElements(By.className("android.widget.EditText")).get(0).click();
		                
		  char[] otpDigits = otp.toCharArray();
		            	
		  Thread.sleep(1000);
		  driver.findElements(By.className("android.widget.EditText")).get(0).click();
		  driver.findElements(By.className("android.widget.EditText")).get(0).sendKeys(String.valueOf(otpDigits[0]));
		  driver.findElements(By.className("android.widget.EditText")).get(1).click();
		  driver.findElements(By.className("android.widget.EditText")).get(1).sendKeys(String.valueOf(otpDigits[1]));
		  driver.findElements(By.className("android.widget.EditText")).get(2).click();
		  driver.findElements(By.className("android.widget.EditText")).get(2).sendKeys(String.valueOf(otpDigits[2]));
		  driver.findElements(By.className("android.widget.EditText")).get(3).click();
		  driver.findElements(By.className("android.widget.EditText")).get(3).sendKeys(String.valueOf(otpDigits[3]));
		  driver.findElements(By.className("android.widget.EditText")).get(4).click();
		  driver.findElements(By.className("android.widget.EditText")).get(4).sendKeys(String.valueOf(otpDigits[4]));
		  driver.findElements(By.className("android.widget.EditText")).get(5).click();
		  driver.findElements(By.className("android.widget.EditText")).get(5).sendKeys(String.valueOf(otpDigits[5]));   
		                
		  } else 
		  {
		           System.out.println("No OTP found in the notification.");
		  }
		
     	  Thread.sleep(1000);
     	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	  Thread.sleep(1000);
    	  driver.findElement(By.xpath("//android.view.View[@content-desc='Continue']")).click();
     	  Thread.sleep(1000);
     	  driver.findElement(By.xpath("//android.widget.Button[@content-desc='I Agree']")).click();
		

	}
}
