package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class IncomeCompanyDetailsPage extends BaseTest {

	public IncomeCompanyDetailsPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String CompanyNameField_xpath= "//android.widget.ScrollView/android.widget.EditText[1]";
	String JoiningDate_xpath="//android.widget.ScrollView/android.view.View[3]";
	String DateEditField_xpath="android.widget.Button";
	String DateEnterField_xpath= "android.widget.EditText";
	String DateOk_xpath="//android.widget.Button[@content-desc=\"OK\"]";
	String CompanyDescriptionField_xpath="//android.widget.ScrollView/android.widget.EditText[2]";
	String PincodeField_xpath="//android.widget.ScrollView/android.widget.EditText[3]";
	String CityField_xpath="//android.widget.ScrollView/android.widget.EditText[4]";
	String SaveemployerDetailsButton_xpath="//android.widget.Button[@content-desc=\"Save employer details\"]";
	
	public void CompanyDetails() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	
		WebElement companyName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CompanyNameField_xpath)));
        companyName.click();
        companyName.sendKeys("Bpointer Technologies");
        driver.hideKeyboard();
        
        Thread.sleep(2000);
		WebElement date= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(JoiningDate_xpath)));
		date.click();
		
		WebElement editDate= wait.until(ExpectedConditions.elementToBeClickable(By.className(DateEditField_xpath)));
		editDate.click();
		
		WebElement enterDate= wait.until(ExpectedConditions.elementToBeClickable(By.className(DateEnterField_xpath)));
		enterDate.click();
		enterDate.clear();
		enterDate.sendKeys("04/10/2022");
		
		WebElement okButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DateOk_xpath)));
		okButton.click();
        
        Thread.sleep(2000);
        WebElement companyDescription= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CompanyDescriptionField_xpath)));
        companyDescription.click();
        companyDescription.sendKeys("1215, Gera's Imperium Rise, Hinjewadi, Pune");
        driver.hideKeyboard();
        
        driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollForward()"));
        
        Thread.sleep(2000);
        WebElement pincode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PincodeField_xpath)));
        pincode.click();
        pincode.sendKeys("411057");
        driver.hideKeyboard();
        
        
        WebElement city= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CityField_xpath)));
        city.click();
        city.sendKeys("Pune");
        driver.hideKeyboard();
        
        Thread.sleep(2000);
        WebElement saveButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SaveemployerDetailsButton_xpath)));
        saveButton.click();
        
	}
}
