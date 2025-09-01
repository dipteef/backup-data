package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PermissionAgreePage extends BaseTest {
	
	public PermissionAgreePage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String IAgrreButton_xpath="//android.widget.Button[@content-desc=\"I Agree\"]";
	String Permission_xpath= "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]";
	
	public void PermissionAgree() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement IAgreeButton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(IAgrreButton_xpath)));
		IAgreeButton.click();
		
		try {
            // Wait for a shorter time, as it's an optional element
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement permissionButton = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Permission_xpath)));
            permissionButton.click();
            System.out.println("Clicked on the 'Permission Agree' button.");
        } catch (TimeoutException e) {
            System.out.println("Permission button not found. Proceeding without clicking.");
            // The test will continue from here
        }
		
	}
	

}
