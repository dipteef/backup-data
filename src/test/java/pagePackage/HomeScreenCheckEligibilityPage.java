package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenCheckEligibilityPage extends BaseTest {
	
	public HomeScreenCheckEligibilityPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String CheckEligibilityButton_xpath="//android.widget.Button[@content-desc=\"Check Eligibility\"]";
	
	public void CheckEligibility() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement checkEligibility = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CheckEligibilityButton_xpath)));
	     checkEligibility.click();
	}
	
	

}
