package pagePackage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.netty.handler.timeout.TimeoutException;

public class HomesScreenExploreOffersPage extends BaseTest{
	
	public HomesScreenExploreOffersPage(AndroidDriver driver) {
		this.driver= driver;
	}
	
	String promopopup_xpath = "//android.widget.ImageView[@clickable='true']";
	String exploreOffers_xpath = "//android.widget.Button[@content-desc=\"Explore Offers\"]";
	String alternativeClose_xpath = "//*[contains(@content-desc, 'Close') or contains(@text, 'X')]";

	public void ExploreOffers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
	    
		WebElement offer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath(exploreOffers_xpath)));
		offer.click();
		
		
	    // 1. First ensure popup is dismissed
/*	    dismissPopup(wait);
	    
	    // 2. Alternative wait - check if popup is either not present OR not displayed
	    try {
	        wait.until(d -> {
	            List<WebElement> popups = driver.findElements(By.xpath(promopopup_xpath));
	            return popups.isEmpty() || !popups.get(0).isDisplayed();
	        });
	    } catch (TimeoutException e) {
	        System.out.println("Popup might still be present but proceeding anyway");
	    }
	    

	    
	 
	}

	private void dismissPopup(WebDriverWait wait) {
		try {
	        // Try all possible ways to dismiss popup
	        List<By> closeOptions = Arrays.asList(
	            By.xpath(promopopup_xpath),
	            By.xpath(alternativeClose_xpath),
	            By.id("com.kgil.swipeloan:id/btnClose")
	        );
	        
	        for (By locator : closeOptions) {
	            try {
	                List<WebElement> closeButtons = driver.findElements(locator);
	                if (!closeButtons.isEmpty() && closeButtons.get(0).isDisplayed()) {
	                    closeButtons.get(0).click();
	                    wait.until(ExpectedConditions.invisibilityOf(closeButtons.get(0)));
	                    return;
	                }
	            } catch (Exception e) {
	                continue;
	            }
	        }
	        
	        // Fallback to back button
	        driver.pressKey(new KeyEvent(AndroidKey.BACK));
	    } catch (Exception e) {
	        System.out.println("Popup might not have been present");
	    }
	    */
	}

	
	}	

	
	
/*	
    String Promopopup_xpath= "//android.widget.ImageView[@clickable='true']";
    String ExploreOffers_xpath= "//android.widget.Button[@content-desc=\"Explore Offers\"]";
    
    public void ExploreOffers() {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	 
    	 driver.pressKey(new KeyEvent(AndroidKey.BACK));
   // 	 WebElement deletePromo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Promopopup_xpath)));
	//     deletePromo.click();
    	 
	     WebElement exploreOffers = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ExploreOffers_xpath)));
	     exploreOffers.click();
	*/     
	     



