package pagePackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class EmailPage extends BaseTest {
	
	public EmailPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	
	
	String SelectEmail1_xpath="//android.view.View[@hint='demo@gmail.com']";
	String SelectEmail_xpath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.widget.ImageView";		
	String EmailList_xpath= "//android.widget.LinearLayout[@resource-id=\"com.google.android.gms:id/account_picker_container\"]";
	String VerifyButton_xpath= "//android.widget.Button[@content-desc=\"Verify\"]";
	
			public void Email() throws InterruptedException {
				
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				
				 WebElement emailField = (WebElement) driver.findElement(By.xpath(SelectEmail_xpath));

		            if (emailField.isDisplayed() || emailField.isEnabled()) {
		                emailField.click();
		            } else {
		                System.out.println("Element is not clickable!");
		            }


		            // Find all Google accounts listed
		            List<WebElement> accounts = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(EmailList_xpath)));
		           
		            System.out.println("Number of accounts:"+ accounts.size());
		          
		            if (accounts.size() >= 1) {
		                accounts.get(0).click(); 
		                System.out.println("✅ Selected the third Google account.");
		            } 
		            
		            Thread.sleep(5000);
		            WebElement verifyButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(VerifyButton_xpath)));
		            verifyButton.click();
				
			}
	
}
