package pagePackage;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class BusinessLoanPage extends BaseTest{
	
	public BusinessLoanPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String BusinessLoan_xpath="Business\nLoan";
	String Consent_xpath = "android.widget.CheckBox";
	String ExploreOffers_xpath = "//android.widget.Button[@content-desc=\"Explore Offers\"]";
	
	public void BusinessLoan() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 

		WebElement businessloan = wait.until(ExpectedConditions.elementToBeClickable(
		        new AppiumBy.ByAccessibilityId(BusinessLoan_xpath)));
		
		businessloan.click();
		
		 try {
	            // Attempt to find the checkbox element.
	            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.className(Consent_xpath)));

	            // If found, click it.
	            System.out.println("Checkbox is present. Clicking on it.");
	            checkbox.click();

	        } catch (NoSuchElementException e) {
	            // If the checkbox is not found, the NoSuchElementException is caught.
	            System.out.println("Checkbox is not present. Completing the process by clicking the 'Explore Offers' button.");
	    }
		
		Thread.sleep(2000);
		WebElement offers = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ExploreOffers_xpath)));
		offers.click();
		
	}

}
