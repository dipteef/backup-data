package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PanNumberVerifyPage extends BaseTest {
	
	public PanNumberVerifyPage(AndroidDriver driver) {
		this.driver= driver;
	}

	String PanVerifyButton_xpath="//android.widget.Button[@content-desc=\"Proceed\"]";
	
	public void Pannumber() throws InterruptedException {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        WebElement verify = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PanVerifyButton_xpath)));
	        verify.click();
		
		  
	}
}
