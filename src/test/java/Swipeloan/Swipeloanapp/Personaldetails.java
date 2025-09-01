package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Personaldetails {

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
	
	@Test (priority=1)
	public void login() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		driver.findElement(By.className("android.widget.Button")).click();
		Thread.sleep(2000);
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
	
	@Test (priority=2)
	public void personalDetails() throws InterruptedException {
		
                String s= "diptee2711@gmail.com";
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		        // Click "Complete Application"
		        WebElement completeApplication = wait.until(ExpectedConditions.elementToBeClickable(
		            By.xpath("//android.view.View[@content-desc='Complete Application']")));
		        completeApplication.click();

		        // Get all EditText fields dynamically
		        List<WebElement> editTextFields = driver.findElements(By.className("android.widget.EditText"));
		        System.out.println("Number of EditText fields found: " + editTextFields.size());

		        // Check if the list contains the required number of elements before interacting
		        if (editTextFields.size() >= 4) {
		            // Enter Name (Adjust index if necessary)
		            WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields.get(0)));
		            nameField.click();
		            nameField.sendKeys("Diptee");
		            driver.hideKeyboard();

		            // Enter Gender (Adjust index if necessary)
		            WebElement surnameField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields.get(1)));
		            surnameField.click();
		            surnameField.sendKeys("F");
		            driver.hideKeyboard();

		            // Enter Phone Number (Adjust index if necessary)
		            WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields.get(2)));
		            phoneField.click();
		            phoneField.sendKeys("8888888888");
		            driver.hideKeyboard();

		           
		            WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields.get(3)));
		            emailField.click();
          
		            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

		            // Find all Google accounts listed
		            List<WebElement> accounts = wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/account_picker_container']")));
		            		// (By.className("android.widget.LinearLayout")));
		            System.out.println("Number of accounts:"+ accounts.size());
		          
		            if (accounts.size() >= 1) {
		                accounts.get(0).click(); 
		                System.out.println("✅ Selected the third Google account.");
		            } 
		              
		            // Click "Continue" Button
		            Thread.sleep(5000);
		            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Continue']")));
		            continueButton.click();
		        }
		        

		        try {
		            WebElement element = driver.findElement(By.xpath("//android.widget.SeekBar[@content-desc='2022']"));
		            element.click();
		        } catch (Exception e) {
		            System.out.println("❌ Element not found using XPath: ");
		        }
		       

	/*			for (int i = 0; i < 5; i++) { // Scroll up to 5 times
				    try {
				    	 WebElement day= driver.findElement(MobileBy.AndroidUIAutomator(
					        	    "new UiScrollable(new UiSelector().className(\"android.widget.SeekBar\")).scrollIntoView(new UiSelector().description(\"8\").instance(3))"));
				        day.click();
				        break; // Exit loop if element is found
				    } catch (Exception e) {
				        // Perform scroll again if element not found
				        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"));
				    }
				}

*/
	}
	
}
