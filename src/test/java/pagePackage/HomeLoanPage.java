package pagePackage;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
// import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class HomeLoanPage extends BaseTest{
	
	public HomeLoanPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String HomeLoan_xpath="Home\nLoan";
	String Checkbox_xpath = "android.widget.CheckBox";
	String ExploreOffers_xpath = "//android.widget.Button[@content-desc=\"Explore Offers\"]";
	
	public void HomeLoan() throws InterruptedException {
/*		
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	   	Sequence scroll = new Sequence(finger, 0);

	   	// Start at (500, 1500), move to (500, 500)
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1500));
	   	scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 500, 500));
	   	scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	   	driver.perform(Collections.singletonList(scroll));
*/	   	
	   	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		WebElement homeloan = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId(HomeLoan_xpath)));
		homeloan.click();
		
		 try {
	            // Attempt to find the checkbox element.
	            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.className(Checkbox_xpath)));

	            // If found, click it.
	            System.out.println("Checkbox is present. Clicking on it.");
	            checkbox.click();

	        } catch (NoSuchElementException e) {
	            // If the checkbox is not found, the NoSuchElementException is caught.
	            System.out.println("Checkbox is not present. Completing the process by clicking the 'Explore Offers' button.");
	    }
		
		
		Thread.sleep(2000);
		WebElement offers= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ExploreOffers_xpath)));
		offers.click();
		
	}

}
