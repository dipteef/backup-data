package pagePackage;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import io.netty.handler.timeout.TimeoutException;

public class VerifyOTPPage extends BaseTest {
	

	    AndroidDriver driver;
	    String otp = "121512";
	    String otpfield_xpath = "android.widget.EditText";
	    String continueButton_xpath = "//android.widget.Button[@content-desc=\"Continue\"]";
	    String allowButton_xpath = "//android.widget.Button[@resource-id=\"com.google.android.gms:id/positive_button\"]";

	    public VerifyOTPPage(AndroidDriver driver) {
	        this.driver = driver;
	    }

	    public void enterOTPAndContinue() throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        boolean otpEntered = false;
	        
	        try {
	            // Wait for and handle the "Allow" permission prompt if it appears.
	            // This is a common pattern for SMS auto-fill permissions.
	            WebElement allowButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(allowButton_xpath)));
	            if (allowButton != null) {
	                allowButton.click();
	                System.out.println("Clicked on the 'Allow' button.");
	                otpEntered = true; // Mark that OTP was handled by the "Allow" button
	            }
	        } catch (Exception e) {
	            System.out.println("The 'Allow' button did not appear or was not found within the timeout.");
	            // Continue with the execution even if the button is not present.
	        }

	        // Only enter the OTP if it wasn't handled by the 'Allow' button
	        if (!otpEntered) {
	        // Wait for and find all OTP fields.
	        // It's safer to wait for the elements to be present before trying to find them.
	        List<WebElement> otpFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(otpfield_xpath)));

	        if (!otpFields.isEmpty()) {
	            System.out.println(otpFields.size() + " OTP input fields detected. Using the first one.");
	            WebElement firstOtpField = otpFields.get(0);

	            // Click the field before sending keys. This is a good practice to ensure focus.
	            firstOtpField.click();
	            firstOtpField.sendKeys(otp);
	            System.out.println("OTP entered successfully.");
	        } else {
	            System.err.println("No OTP input fields were found.");
	            // You might want to throw an exception here to fail the test.
	        }
	        }
	        // The Thread.sleep is generally not recommended. It's better to use explicit waits.
	        // For demonstration, let's keep it but recommend using an explicit wait for a visible element.
	        Thread.sleep(2000);

	        // Wait for the continue button to be clickable and then click it.
	        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButton_xpath)));
	        continueButton.click();
	        System.out.println("Clicked on the 'Continue' button.");
	    }
	
}	
	
	
	
/*
	public VerifyOTPPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String otp="121512";
	String otpfield_xpath="android.widget.EditText";
	String ContinueButton_xpath= "//android.widget.Button[@content-desc=\"Continue\"]";
	
	String AllowButton_xpath= "//android.widget.Button[@resource-id=\"com.google.android.gms:id/positive_button\"]";
//	String AllowButton_xpath="//android.widget.Button[@content-desc='Allow']";
	
	public void enterOTPAndContinue() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		
//		 WebElement otpInputField= wait.until(ExpectedConditions.elementToBeClickable(By.className(otpfield_xpath))); 
//		 WebElement otpInputField = driver.findElement(By.className(otpfield_xpath));
//		otpInputField.click();
//	    otpInputField.sendKeys(otp);
		List<WebElement> otpFields = driver.findElements(By.className(otpfield_xpath));
	    
	    if (otpFields.size() == 1) {
	        System.out.println("Single OTP input field detected.");
	        otpFields.get(0).click();
	       
//			WebElement allowButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AllowButton_xpath)));
//			allowButton.click();
			
	        otpFields.get(0).sendKeys(otp);
	 
	        
	    } 

	    Thread.sleep(2000);
	    WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
//	    WebElement continueButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ContinueButton_xpath)));
 		continueButton.click();
     	
	}
*/

