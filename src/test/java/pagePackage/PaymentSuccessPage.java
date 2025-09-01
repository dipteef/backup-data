package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PaymentSuccessPage extends BaseTest{
	
	public PaymentSuccessPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String nextElement_xpath ="//android.widget.Button[@content-desc=\"Refresh your Score\"]";
	
	
	public void PaymentSuccess() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120)); // Generous timeout for the entire process

        // Find and click the Pay button
 //       WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(payButtonLocator));
 //       payButton.click();

        // --- Wait for the next screen element to confirm payment ---
        try {
            WebElement nextScreenElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(nextElement_xpath)));
            System.out.println("Successfully navigated to the next screen, indicating payment was successful.");
            
            // You can now proceed with further actions on this new screen.

        } catch (org.openqa.selenium.TimeoutException e) {
            System.err.println("Timeout: The next screen did not appear within 120 seconds. The payment may have failed.");
            // Handle the failure here, such as taking a screenshot or throwing a custom exception.
            throw e;
        }
    }
	

}
