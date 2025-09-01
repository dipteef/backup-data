package pagePackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PersonalDetailsEmploymentTypePage extends BaseTest{
	

	public PersonalDetailsEmploymentTypePage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String Salaried_xpath= "//android.widget.Button[@content-desc=\"Salaried\"]";
	String ContinueButton_xpath= "//android.widget.Button[@content-desc=\"Continue\"]";
	
	public void Employment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement EmploymentType= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Salaried_xpath)));
		EmploymentType.click();
		
		WebElement ContinueButton= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
		ContinueButton.click();
		
	}
}








