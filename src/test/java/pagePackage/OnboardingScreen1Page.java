package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class OnboardingScreen1Page extends BaseTest{
	
	public OnboardingScreen1Page(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String NextButton_xpath= "android.widget.Button";
	
	public void nextButtonClick() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement nextButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(NextButton_xpath)));
		nextButton.click();
	}

}
