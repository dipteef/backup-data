package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ProductInterestPage extends BaseTest{
	
	public ProductInterestPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String medicalLoan_xpath= "//android.widget.ImageView[contains(@content-desc, 'Medical Loan')]";
//	String medicalLoan_xpath= "Medical Loan\\n50k - 25 Lakhs";
	String continueButton_xpath = "//android.widget.Button[@content-desc=\"Continue\"]";
	
	public void ProductInterest() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		 WebElement medicalLoan= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(medicalLoan_xpath)));
//		 WebElement medicalLoan = wait.until(ExpectedConditions.elementToBeClickable(new AppiumBy.ByAccessibilityId(medicalLoan_xpath)));
		 medicalLoan.click();
		 
		 WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(continueButton_xpath)));
		 continueButton.click();
		 
	}

}
