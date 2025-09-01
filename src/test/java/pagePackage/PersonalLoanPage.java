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

public class PersonalLoanPage extends BaseTest{
	
	public PersonalLoanPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String PersonalLoan_xpath="//android.view.View[@content-desc=\"Personal Loan\"]/android.widget.ImageView";
	String loan_xpath ="Personal\nLoan";
	String ConsentCheckbox_xpath = "android.widget.CheckBox";
	String ExploreOffers_xpath="//android.widget.Button[@content-desc=\"Explore Offers\"]";
	
	public void PersonalLoan() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 

		WebElement personalloan = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId(loan_xpath)));
				// wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.androidUIAutomator("new UiSelector().description(\"Personal Loan\")")));
				// wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PersonalLoan_xpath)));
		personalloan.click();
		
		 try {
	            // Attempt to find the checkbox element.
	            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.className(ConsentCheckbox_xpath)));

	            // If found, click it.
	            System.out.println("Checkbox is present. Clicking on it.");
	            checkbox.click();

	        } catch (NoSuchElementException e) {
	            // If the checkbox is not found, the NoSuchElementException is caught.
	            System.out.println("Checkbox is not present. Completing the process by clicking the 'Explore Offers' button.");
	    }
		
		
		WebElement exploreOffers= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ExploreOffers_xpath)));
		exploreOffers.click();
		
	}

}
