package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class IncomeRelationshipStatusPage extends BaseTest{
	
	public IncomeRelationshipStatusPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String SingleRelationshipStatus_xpath= "//android.widget.Button[@content-desc=\"Single\"]";
	String SubmitButton_xpath= "//android.widget.Button[@content-desc=\"Submit\"]";
	
	public void RelationshipStatus() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement singleStatus= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SingleRelationshipStatus_xpath)));
		singleStatus.click();
        
        Thread.sleep(2000);
        WebElement submitButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SubmitButton_xpath)));
        submitButton.click();
        
	}

}
