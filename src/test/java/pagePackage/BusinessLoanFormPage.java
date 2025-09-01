package pagePackage;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class BusinessLoanFormPage extends BaseTest {
	
	public BusinessLoanFormPage(AndroidDriver driver) {
		this.driver= driver;
	}


	String BusinessType_xpath="//android.widget.Button[@content-desc=\"Select Business Type\"]";
	String ProprietorshipBusinessType_xpath= "//android.view.View[@content-desc=\"Proprietorship\"]";
	String IncorporationDate_xpath="//android.widget.ScrollView/android.view.View[6]";
	String DateEditField_xpath="android.widget.Button";
	String DateEnterField_xpath= "android.widget.EditText";
	String DateOk_xpath="//android.widget.Button[@content-desc=\"OK\"]";
	String BusinessTurnover_xpath = "//android.widget.Button[@content-desc=\"Select Business Turnover\"]";
	String Turnover_xpath = "//android.view.View[@content-desc=\"₹10 Lakhs to ₹50 Lakhs\"]";
	String PropertyOwnership_xpath="//android.widget.Button[@content-desc=\"Select Property Ownership\"]";
	String ResidenceOwnership_xpath="//android.view.View[@content-desc=\"Residence\"]";
	String BankAccountType_xpath="//android.widget.Button[@content-desc=\"Select Type of Bank Account\"]";
	String CurrentBankAccountType_xpath= "//android.view.View[@content-desc=\"Current\"]";
	String BusinessNature_xpath = "//android.widget.Button[@content-desc=\"Select Nature Of Business\"]";
	String Retail_xpath= "//android.view.View[@content-desc=\"Retail\"]";
	String ContinueButton_xpath= "//android.widget.Button[@content-desc=\"Continue\"]";
	
	
	public void BusinessForm() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		
		WebElement businessType= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BusinessType_xpath)));
		businessType.click();
		
		WebElement proprietorship= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ProprietorshipBusinessType_xpath)));
		proprietorship.click();
		driver.hideKeyboard();
	
		Thread.sleep(2000);
		WebElement date= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(IncorporationDate_xpath)));
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
		WebElement turnover= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BusinessTurnover_xpath)));
		turnover.click();
		
		WebElement turnover10lakhs= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Turnover_xpath)));
		turnover10lakhs.click();
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollForward()"));
		
		Thread.sleep(2000);
		WebElement ownership= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PropertyOwnership_xpath)));
		ownership.click();
		
		WebElement residence= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ResidenceOwnership_xpath)));
		residence.click();
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement bankAccount= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BankAccountType_xpath)));
		bankAccount.click();
		
		WebElement currentBankAccount= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(CurrentBankAccountType_xpath)));
		currentBankAccount.click();
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement businessNature= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(BusinessNature_xpath)));
		businessNature.click();
		
		WebElement retailBusiness= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Retail_xpath)));
		retailBusiness.click();
		driver.hideKeyboard();
		
		Thread.sleep(2000);
		WebElement continueButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
		continueButton.click();
		
		/*
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	   	Sequence scroll = new Sequence(finger, 0);

	   	// Start at (500, 1500), move to (500, 500)
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 500, 1500));
	   	scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	   	scroll.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), 500, 500));
	   	scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	   	driver.perform(Collections.singletonList(scroll));

	   	*/
		
		
	}
}
