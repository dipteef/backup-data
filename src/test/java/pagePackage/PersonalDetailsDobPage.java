package pagePackage;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableList;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class PersonalDetailsDobPage extends BaseTest{
	
	private AndroidDriver driver;
	public PersonalDetailsDobPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	public void Dob(String day, String month, String year) {
		// Wait for the date picker columns to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("android.widget.SeekBar")));
        
        List<WebElement> datePickers = driver.findElements(By.className("android.widget.SeekBar"));

        if (datePickers.size() != 3) {
            System.err.println("Could not find the three date picker columns.");
            return;
        }

        WebElement dayPicker = datePickers.get(0);
        WebElement monthPicker = datePickers.get(1);
        WebElement yearPicker = datePickers.get(2);

        // Scroll and select the day
        scrollToAndSelect(dayPicker, day);
        // Scroll and select the month
        scrollToAndSelect(monthPicker, month);
        // Scroll and select the year
        scrollToAndSelect2(yearPicker, year);

        // Click the 'Continue' button
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.Button[@content-desc='Continue']")));
        continueButton.click();
    }

    private void scrollToAndSelect(WebElement picker, String targetValue) {
        // Get the coordinates of the picker element
        int startY = picker.getLocation().getY() + (picker.getSize().getHeight() / 2);
        int startX = picker.getLocation().getX() + (picker.getSize().getWidth() / 2);
        int endY = startY - (picker.getSize().getHeight() / 4);

        // Use a loop to swipe until the target element is found
        boolean found = false;
        long startTime = System.currentTimeMillis();
        long timeout = 20000; // 20 seconds
        
        // Use a more specific locator to find the target value
        String targetXpath = String.format("//*[@content-desc='%s']", targetValue);
        
        while (!found && (System.currentTimeMillis() - startTime) < timeout) {
            try {
                WebElement targetElement = picker.findElement(By.xpath(targetXpath));
                targetElement.click();
                found = true;
                System.out.println("Selected " + targetValue);
            } catch (Exception e) {
                // Perform a swipe gesture
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.ordinal()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.ordinal()));
                
                driver.perform(ImmutableList.of(swipe));
            }
        }
    }
    
    private void scrollToAndSelect2(WebElement picker, String targetValue) {
        // Get the coordinates of the picker element
        int startY = picker.getLocation().getY() + (picker.getSize().getHeight() / 2);
        int startX = picker.getLocation().getX() + (picker.getSize().getWidth() / 2);

        // To scroll UP, the end Y-coordinate must be higher than the start Y-coordinate.
        // The previous code had a typo and was scrolling down.
        int endY = startY + (picker.getSize().getHeight() / 2); 

        boolean found = false;
        long startTime = System.currentTimeMillis();
        long timeout = 20000; // 20 seconds
        
        // Use a more specific locator to find the target value
        String targetXpath = String.format("//*[@content-desc='%s']", targetValue);
        
        while (!found && (System.currentTimeMillis() - startTime) < timeout) {
            try {
                // Try to find the element
                WebElement targetElement = picker.findElement(By.xpath(targetXpath));
                targetElement.click();
                found = true;
                System.out.println("Selected " + targetValue);
            } catch (Exception e) {
                // If not found, perform an UPWARD swipe gesture
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 1)
                    .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.ordinal()))
                    .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), startX, endY))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.ordinal()));
                
                driver.perform(ImmutableList.of(swipe));
            }
        }
    }
    
		
    
}