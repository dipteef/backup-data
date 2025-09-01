package pagePackage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class UploadBankDetailsPage extends BaseTest{
	
	public UploadBankDetailsPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String EditTextField_xpath= "android.widget.EditText";
	String BankName_xpath= "//android.widget.Button[@content-desc=\"Select Bank Name\"]";
	String BankNameSearch_xpath ="//android.widget.EditText";
	String BankNameListScroll_xpath= "//android.widget.ScrollView/android.widget.EditText[1]";	
	String BankNameSelect_xpath= "//android.view.View[@content-desc=\"Bank of Maharashtra\"]";
	String AccountNumberField_xpath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText[1]";
	String ConfirmAccountNumberField_xpath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText[2]";
	String IfscCodeField_xpath= "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.widget.EditText[3]";
	String SubmitButton_xpath="//android.widget.Button[@content-desc=\"Submit\"]";
	
	public void BankDetails() throws InterruptedException {
		 
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	     List<WebElement> editTextFields = driver.findElements(By.className(EditTextField_xpath));
	        System.out.println("Number of EditText fields found: " + editTextFields.size());
	        if (editTextFields.size() >= 3) {
	        	 WebElement banknameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BankName_xpath)));
		            banknameField.click();
		            Thread.sleep(8000);
		            driver.findElement(By.xpath(BankNameSearch_xpath)).click();
		            Thread.sleep(2000);
		            driver.findElement(By.xpath(BankNameSearch_xpath)).sendKeys("bank of maharashtra");
		            
	        
	  // Wait for the dropdown to show results and select the item
/*	    
	     WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(BankNameSelect_xpath)));
	     option.click();   
	     driver.hideKeyboard();
	 */    
	     WebElement accountNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(AccountNumberField_xpath)));
         accountNumberField.click();
         accountNumberField.sendKeys("12345678901");
         driver.hideKeyboard();
         
	     Thread.sleep(2000);
         WebElement confirmaccountNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ConfirmAccountNumberField_xpath)));
         confirmaccountNumberField.click();
         confirmaccountNumberField.sendKeys("12345678901");
         driver.hideKeyboard();
         
         Thread.sleep(2000);
         WebElement ifscCodeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IfscCodeField_xpath)));
         ifscCodeField.click();
         ifscCodeField.sendKeys("AAAA0001122");
         driver.hideKeyboard();
         
        } 
	        
         Thread.sleep(1000);
         driver.findElement(By.xpath(SubmitButton_xpath)).click();
	}


	

}
