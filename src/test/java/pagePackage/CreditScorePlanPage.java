package pagePackage;

import java.time.Duration;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class CreditScorePlanPage extends BaseTest {
	
	public CreditScorePlanPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String SubscribeButton_xpath="//android.widget.ImageView[@content-desc='Subscribe']";
	String FirstPlan_xpath = "//android.widget.ImageView[contains(@content-desc, '₹1.00') and contains(@content-desc, 'Monthly')]";
		
	String ContinueToPayButton_accessibilityid="Continue to Pay";
	
	public void Subscribe() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// Java Example
		driver.findElement(MobileBy.AndroidUIAutomator(
		    "new UiScrollable(new UiSelector().scrollable(true))" +
		    ".scrollForward()")); // Scrolls forward (down)
		
		WebElement firstPlan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(FirstPlan_xpath)));
		firstPlan.click();
		
		Thread.sleep(2000);
		WebElement subscribeButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SubscribeButton_xpath)));
		subscribeButton.click();
		
		/*
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement continueToPay = wait.until(ExpectedConditions.elementToBeClickable(
	    	        new AppiumBy.ByAccessibilityId(ContinueToPayButton_accessibilityid)));
	     
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
	     */
	}

}
