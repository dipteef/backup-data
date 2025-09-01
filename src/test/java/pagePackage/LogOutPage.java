package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class LogOutPage extends BaseTest{

	public LogOutPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String LogOut_xpath = "//android.widget.ImageView[@content-desc=\"Sign Out\"]";
	String YesButton_xpath = "//android.widget.Button[@content-desc=\"YES\"]";
	
	public void LogOut() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); 
		driver.findElement(MobileBy.AndroidUIAutomator(
			    "new UiScrollable(new UiSelector().scrollable(true))" +
			    ".scrollForward()"));
		WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(LogOut_xpath)));
		logOut.click();
		
		Thread.sleep(2000);
		WebElement yesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(YesButton_xpath)));
		yesButton.click();
		
		
	}
	
}
