package pagePackage;

import org.openqa.selenium.By;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class SelfieVerificationPage extends BaseTest {
	
	public SelfieVerificationPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String ClickSelfieButton_xpath="//android.widget.ImageView[@content-desc='Click Selfie']";
	String SelfieCapture_xpath="android.view.View";
	String SubmitSelfieButton_xpath="//android.widget.Button[@content-desc='Submit Selfie']";
	
	public void SelfieFeature() throws InterruptedException {
		Thread.sleep(5000);
   	    driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Click Selfie']")).click();
   	    Thread.sleep(2000);
   	    driver.findElement(By.className("android.view.View")).click();
   	    Thread.sleep(2000);
        driver.findElement(By.xpath("//android.widget.Button[@content-desc='Submit Selfie']")).click();
	}

}
