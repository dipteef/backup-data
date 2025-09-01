package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class UpdateIncomePage extends BaseTest{

	public UpdateIncomePage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String UpdateIncome_xpath = "Update Income";
	String Income_xpath = "//android.widget.EditText[@text=\"25000\"]";
	String Checkbox_xoath = "android.widget.CheckBox";
	String ConfirmIncome_xpath = "//android.widget.Button[@content-desc=\"Confirm Income\"]";
	String Submit_xpath = "//android.widget.Button[@content-desc=\"Submit\"]";
	
	
	public void UpdateIncome() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		Thread.sleep(2000);
		WebElement updateincome = wait.until(ExpectedConditions.elementToBeClickable(
		        new AppiumBy.ByAccessibilityId(UpdateIncome_xpath)));
		updateincome.click();
		
		WebElement income = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Income_xpath)));
		income.click();
		income.clear();
		income.sendKeys("60000");
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.className(Checkbox_xoath)));
		checkbox.click();
		
		Thread.sleep(5000);
		WebElement confirmIncome = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ConfirmIncome_xpath)));
		confirmIncome.click();
		
		Thread.sleep(8000);
		WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Submit_xpath)));
		submit.click();
		
	}
	
}
