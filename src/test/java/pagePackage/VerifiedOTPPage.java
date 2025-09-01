package pagePackage;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class VerifiedOTPPage extends BaseTest{
	
	public VerifiedOTPPage(AndroidDriver driver) {
		this.driver= driver;
	}

	String ContinueButton_xpath= "//android.widget.Button[@content-desc=\"Continue\"]";
	String ContinueButton2_xpath= "Continue";
	String Nextscreenelement_xpath= "Select Email";
	
	public void verify() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    // Click Continue button
	    WebElement continueButton = wait.until(
	        ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("Continue"))
	    );
	    continueButton.click();
/*
		try {
	        WebElement nextScreenElement = new WebDriverWait(driver, Duration.ofSeconds(30))
	            .until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Nextscreenelement_xpath")));
	        System.out.println("Next screen loaded successfully.");
	    } catch (Exception e) {
	        System.out.println("Next screen did not appear. Possible flow or performance issue.");
	    }
	*/	
		
		
//		 WebElement continueButton2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ContinueButton_xpath)));
//		 WebElement continueButton2 = wait.until(
//				    ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(ContinueButton2_xpath)));
 //      WebElement continueButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
//		  continueButton2.click();
		
	}
	
	
}
