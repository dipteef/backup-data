package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class HomeScreenCompleteApplicationPage extends BaseTest {
	
	public HomeScreenCompleteApplicationPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String CompleteApplicationButton_xpath= "//android.widget.Button[@content-desc=\"Complete Application\"]";
	
	public void CompleteApplication() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	     WebElement completeApplication = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CompleteApplicationButton_xpath)));
	     completeApplication.click();
	}

}
