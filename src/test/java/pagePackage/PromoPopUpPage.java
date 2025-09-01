package pagePackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class PromoPopUpPage extends BaseTest{
	
	public PromoPopUpPage(AndroidDriver driver) {
		this.driver= driver;
	}

	String close_xpath="//android.widget.ImageButton[@content-desc='Close']";
	
	public void closePopUp() throws InterruptedException {
		
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
       try {
           // Wait for and click a potential close button. 
           // The XPath/selector will vary based on the app.
           // You may need to inspect the app source again to find the correct selector for the close button.
           WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ImageButton[@content-desc='Close']")));
           closeButton.click();
           System.out.println("Pop-up closed successfully by clicking the close button.");
       } catch (Exception e) {
           System.out.println("No pop-up or close button found, continuing with execution.");
           // The pop-up might not be present, so we catch the exception and proceed.
       }
       
       driver.navigate().back(); 
       
     
       
        
    }
	
}
