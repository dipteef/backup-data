package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PaymentPayPage extends BaseTest {
	
	public PaymentPayPage(AndroidDriver driver) {
		this.driver= driver;
	}

	String UpiAppClick_xpath="//android.webkit.WebView[@content-desc='primary_webview']";
	String EUpiApp_xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View/android.view.View[2]/android.view.View[5]/android.view.View[1]/android.widget.Image";
//			"//android.webkit.WebView[@resource-id=\"com.kgil.swipeloan:id/webview_pwe_payment\"]";
	String EupiId_xpath = "//android.view.View[@resource-id=\"root\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View[5]";
	String EQr_xpath= "//android.view.View[@resource-id=\"root\"]/android.view.View[2]/android.view.View/android.view.View/android.view.View[6]";
	String EnterUpiId_xpath = "android.widget.EditText";
	String PayButton_xpath= "//android.widget.Button[@text=\"Pay ₹ 1.00\"]";
	String ProceedToPayButton_xpath="//android.widget.TextView[@text='PROCEED TO PAY']";
	
	public void Pay() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
/*	     WebElement paymentApp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(UpiAppClick_xpath)));
	     paymentApp.click();
	     
*/
		 
		 WebElement payApp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EUpiApp_xpath)));
		 payApp.click();
/*		 
		 Thread.sleep(2000);
		 WebElement payUpiId = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EupiId_xpath)));
		 payUpiId.click();
*/		 
		 Thread.sleep(2000);
		 WebElement qrcode= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EQr_xpath)));
		 qrcode.click();
/*		 
		 Thread.sleep(2000);
		 WebElement enterUpiId = wait.until(ExpectedConditions.elementToBeClickable(By.className(EnterUpiId_xpath)));
		 enterUpiId.click();
		 enterUpiId.sendKeys("9975561091-2@ybl");
		 driver.hideKeyboard();
*/		 
		 Thread.sleep(2000);
		 WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PayButton_xpath)));
		 payButton.click();
		 
		
//		 Thread.sleep(4000);
//	     driver.findElement(AppiumBy.xpath(ProceedToPayButton_xpath)).click();

	}
}
