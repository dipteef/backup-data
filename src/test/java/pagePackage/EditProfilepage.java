package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class EditProfilepage extends BaseTest{

	public EditProfilepage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String EditProfile_xpath = "My Profile";
	String SaveButton_xpath = "//android.widget.Button[@content-desc=\"Save\"]";
	String Address_xpath = "//android.widget.EditText[@text=\"Hinjewadi, Pune\"]";
	
	public void editProfile() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		WebElement editProfile = wait.until(ExpectedConditions.elementToBeClickable(
		        new AppiumBy.ByAccessibilityId(EditProfile_xpath)));
		editProfile.click();
		
		WebElement companyDetailsElement = wait.until(ExpectedConditions.elementToBeClickable(
			    MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"COMPANY DETAILS\"))")));
	/*	
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollForward()"));
		*/
		WebElement address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Address_xpath)));
		address.click();
		address.clear();
		address.sendKeys("Hinjewadi Phase - 2, Pune");
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveButton_xpath)));
		saveButton.click();
		
	}
}
