package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PanNumberKycPage extends BaseTest {
	
	public PanNumberKycPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String PanNumberConfirmButton_xpath="//android.view.View[@content-desc='Confirm']";
	
	public void PanNumberConfirm() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PanNumberConfirmButton_xpath))).click();
	}

}
