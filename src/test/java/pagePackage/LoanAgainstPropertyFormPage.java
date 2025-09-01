package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class LoanAgainstPropertyFormPage extends BaseTest{

	
	public LoanAgainstPropertyFormPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String LoanAmount_xpath = "//android.widget.ScrollView/android.widget.EditText[1]";
	String PropertyType_xpath = "//android.widget.Button[@content-desc=\"Select Property Type\"]";
	String CommercialType_xpath = "//android.view.View[@content-desc=\"Commercial\"]";
	String City_xpath = "//android.widget.ScrollView/android.widget.EditText[2]";
	String Pincode_xpath = "//android.widget.ScrollView/android.widget.EditText[3]";
	String OwnershipType_xpath = "//android.widget.Button[@content-desc=\"Select Ownership Type\"]";
	String Single_xpath = "//android.view.View[@content-desc=\"Single\"]";
	String PropertyValue_xpath = "//android.widget.ScrollView/android.widget.EditText[4]";
	String ContinueButton_xpath = "//android.widget.Button[@content-desc=\"Continue\"]";
	
	public void LAPForm() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		WebElement loanAmount= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LoanAmount_xpath)));
		loanAmount.click();
		loanAmount.sendKeys("8000000");
		driver.hideKeyboard();
		
		WebElement propertyType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyType_xpath)));
		propertyType.click();
		WebElement commercialType= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CommercialType_xpath)));
		commercialType.click();
		driver.hideKeyboard();
		
		WebElement city= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(City_xpath)));
		city.click();
		city.sendKeys("Pune");
		driver.hideKeyboard();
		
		WebElement pincode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Pincode_xpath)));
		pincode.click();
		pincode.sendKeys("411057");
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward();"
			));

		WebElement ownershipType= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OwnershipType_xpath)));
		ownershipType.click();
		WebElement singleType = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Single_xpath)));
		singleType.click();
		driver.hideKeyboard();
		
		WebElement propertyValue = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyValue_xpath)));
		propertyValue.click();
		propertyValue.sendKeys("9000000");
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement ContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
		ContinueButton.click();
		
	}
}
