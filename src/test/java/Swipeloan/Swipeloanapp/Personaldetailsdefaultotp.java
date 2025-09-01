package Swipeloan.Swipeloanapp;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.beust.jcommander.internal.Lists;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Personaldetailsdefaultotp {
	
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
		Thread.sleep(2000);
//		driver.findElement(By.className("android.widget.EditText")).click();
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement element = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.className("android.widget.EditText")));
		element.click();
		element.sendKeys("9689698026");

		driver.hideKeyboard();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//android.view.View[@content-desc='Get Started']")).click();
		Thread.sleep(2000);
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
     	  
     	    String s= "diptee2711@gmail.com";
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        // Click "Complete Application"
	        WebElement completeApplication = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Complete Application']")));
	        completeApplication.click();

	        // Get all EditText fields dynamically
	        List<WebElement> editTextFields = driver.findElements(By.className("android.widget.EditText"));
	        System.out.println("Number of EditText fields found: " + editTextFields.size());

	        // Check if the list contains the required number of elements before interacting
	        if (editTextFields.size() >= 1) {

	            // Enter Phone Number (Adjust index if necessary)
	            WebElement phoneField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields.get(0)));
	            phoneField.click();
	            phoneField.sendKeys("8888888888");
	            driver.hideKeyboard();

	            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
/*	            WebElement emailField = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Select Email']")));
	            emailField.click();
   */
	            WebElement emailField = (WebElement) driver.findElement(By.xpath("//android.view.View[@hint='Select Email']"));

	            if (emailField.isDisplayed() || emailField.isEnabled()) {
	                emailField.click();
	            } else {
	                System.out.println("Element is not clickable!");
	            }


	            // Find all Google accounts listed
	            List<WebElement> accounts = wait2.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//android.widget.LinearLayout[@resource-id='com.google.android.gms:id/account_picker_container']")));
	           
	            System.out.println("Number of accounts:"+ accounts.size());
	          
	            if (accounts.size() >= 1) {
	                accounts.get(0).click(); 
	                System.out.println("✅ Selected the third Google account.");
	            } 
	            
	           WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));
	   	      WebElement option = wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@hint='Select Gender']")));
	   	      option.click();
	   	      
	 

	   	PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	   	Sequence scroll = new Sequence(finger, 0);

	   	// Start at (500, 1500), move to (500, 500)
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1500));
	   	scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 500, 500));
	   	scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	   	driver.perform(Collections.singletonList(scroll));

	   	driver.findElement(By.xpath("//android.view.View[@content-desc='Female']")).click();
	   	      
	   	      driver.hideKeyboard();
	              
	   	   WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(30));
	            WebElement continueButton = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.View[@content-desc='Continue']")));
	            continueButton.click();
	/*            
	            WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(30));
	            String yearToSelect = "17";

	            WebElement seekbar =  driver.findElement(MobileBy.AndroidUIAutomator(
	            	    "new UiScrollable(new UiSelector().scrollable(true))" +
	            	    	    ".scrollIntoView(new UiSelector().index(2))"
	            	    	));
	            seekbar.click();
*/
	          
/*
	            List<WebElement> dateElements = driver.findElements(By.className("android.widget.SeekBar"));

	            for (int i = 0; i < dateElements.size(); i++) {
	                System.out.println("Index " + i + ": " + dateElements.get(i).getAttribute("content-desc"));
	            }
            

	            
       
	            List<WebElement> elements = driver.findElements(By.className("android.widget.SeekBar"));
	            for (WebElement el : elements) {
	                System.out.println(el.getAttribute("content-desc"));
	            }


	            driver.findElement(MobileBy.AndroidUIAutomator(
	            	    "new UiSelector().className(\"android.view.View\").instance(1)")
	            	).click();

	            WebElement element2 = driver.findElement(By.className("android.view.View"));
	            System.out.println("Element displayed: " + element2.isDisplayed());
	            System.out.println("Element enabled: " + element2.isEnabled());

	
	            // Get screen dimensions
	            Dimension size = driver.manage().window().getSize();
	            int startX = size.width / 2;
	            int startY = (int) (size.height * 0.8); // Start near the bottom
	            int endY = (int) (size.height * 0.2);   // End near the top

	            // Create touch gesture
	            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	            Sequence swipe = new Sequence(finger2, 1);

	            // Build gesture sequence
	            swipe.addAction(finger2.createPointerMove(Duration.ofMillis(0),
	                    PointerInput.Origin.viewport(), startX, startY));
	            swipe.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	            swipe.addAction(finger2.createPointerMove(Duration.ofMillis(600),
	                    PointerInput.Origin.viewport(), startX, endY));
	            swipe.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	            // Scroll until element is found
	            while (true) {
	                try {
	                    WebElement element4 = driver.findElement(By.xpath("//*[contains(@text, '" + 2002 + "')]"));
	                    if (element4.isDisplayed()) {
	                        break;
	                    }
	                } catch (Exception e) {
	                    // Continue scrolling if element not found
	                    driver.perform(Arrays.asList(swipe));
	                }
	            }

	           
   
	*/           
	            
	            
	         // Get screen size for dynamic scrolling
	            Dimension size = driver.manage().window().getSize();
	            int screenWidth = size.getWidth();
	            int screenHeight = size.getHeight();

	            // Define dynamic start and end points for scroll
	            int startX = screenWidth / 2;  // Center of screen
	            int startY = (int) (screenHeight * 0.7); // Start from 70% of screen height
	            int endY = (int) (screenHeight * 0.3);   // Move to 30% of screen height

	            // Create touch input
	            PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	            Sequence scroll2 = new Sequence(finger2, 1);

	            // Move to starting position & press down
	            scroll2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
	            scroll2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

	            // Scroll to end position
	            scroll2.addAction(finger2.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), startX, endY));
	            scroll2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	            // Perform scroll action
	            driver.perform(Collections.singletonList(scroll));

	            System.out.println("Swipe performed from (" + startX + ", " + startY + ") to (" + startX + ", " + endY + ")");

	            
      

//	            selectDateOfBirth("1995");
	        
	        }
	}  
	
	
/*	

	    public void selectDateOfBirth(String targetYear) {
	        try {
	

	            // Wait for the Date Picker to appear
	            Thread.sleep(2000);

	            // Locate the SeekBar element
	            WebElement seekBar = driver.findElement(By.className("android.view.View"));

	            // Get SeekBar position and dimensions
	            int startX = seekBar.getLocation().getX();
	            int endX = startX + seekBar.getSize().getWidth();
	            int yAxis = seekBar.getLocation().getY() + (seekBar.getSize().getHeight() / 2);

	            // Calculate position for the target year
	            int minYear = 1900; // Adjust this based on your app
	            int maxYear = 2025; // Adjust this based on your app
	            int totalSteps = maxYear - minYear;
	            int targetPosition = startX + ((Integer.parseInt(targetYear) - minYear) * (endX - startX) / totalSteps);

	            // Perform the swipe action using W3C Actions API
	            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	            Sequence drag = new Sequence(finger, 1);
	            drag.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, yAxis));
	            drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	            drag.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), targetPosition, yAxis));
	            drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	            driver.perform(Collections.singletonList(drag));

	            System.out.println("✅ SeekBar moved to: " + targetYear);

	            
	        } catch (Exception e) {
	            System.out.println("❌ Failed to select DOB: " + e.getMessage());
	        }
	    

	   
	}


*/
	        
/*
	        // Click Continue
	        WebElement continueButton = driver.findElement(By.xpath("//android.widget.Button[@text='Continue']"));
	        continueButton.click();
	*/       

	
	    

	
}


