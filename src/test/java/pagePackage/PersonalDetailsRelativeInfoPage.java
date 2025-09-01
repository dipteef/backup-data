package pagePackage;

import java.time.Duration;
import java.util.Collections;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import basePackage.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PersonalDetailsRelativeInfoPage extends BaseTest{
	
	public PersonalDetailsRelativeInfoPage(AndroidDriver driver) {
		this.driver=driver;
	}

	String EditField_xpath= "android.widget.EditText";
	String Relative1name_xpath= "//android.widget.ScrollView/android.widget.EditText[1]";
	String Relative1no_xpath="//android.widget.ScrollView/android.widget.EditText[2]";
	String Relative2name_xpath="//android.widget.ScrollView/android.widget.EditText[3]";
	String Relative2no_xpath="//android.widget.ScrollView/android.widget.EditText[4]";
	String Relative1type_xpath = "(//android.view.View[@content-desc=\"Select Relationship Type\"])[1]";
	String Relative2type_xpath= "(//android.view.View[@content-desc=\"Select Relationship Type\"])[2]";
//	String Relative2type_xpath= "//android.widget.ScrollView/android.view.View[5]";
	String Friend_xpath= "//android.view.View[@content-desc=\"Friend\"]";
	String ContinueButton_xpath="//android.widget.Button[@content-desc=\"Continue\"]";

	
	public void RelativeInfo() throws InterruptedException {
	    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));


	    	
		    // Find and fill Relative Info 1 fields
	    	 List<WebElement> editTextFields1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(EditField_xpath)));
	    	    
		    System.out.println("Number of EditText fields found initially: " + editTextFields1.size());

		    if (editTextFields1.size() >= 2) {
		        // Relative 1 Name
		        WebElement relative1nameField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields1.get(0)));
		        relative1nameField.click();
		        relative1nameField.sendKeys("Rahul");
		        driver.hideKeyboard();

		        // Relative 1 Relationship Type
		        WebElement relative1typeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative1type_xpath)));
		        relative1typeField.click();
		        // Scroll and click "Friend"
		        WebElement friendOption1 = driver.findElement(AppiumBy.androidUIAutomator(
		                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Friend\"))"));
		            friendOption1.click();
         
		        driver.hideKeyboard();
		            
		        Thread.sleep(5000);    
		        // Relative 1 Mobile Number
		        WebElement relative1numberField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields1.get(1)));
		        relative1numberField.click();
		        relative1numberField.sendKeys("8888888801");
		        driver.hideKeyboard();
		    }

		    // Scroll down to find the next set of fields
		    // This is the key step to make the "Relative Info 2" fields visible
		    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"));

		    // Now, find and fill Relative Info 2 fields
		    // It's important to find the elements again after scrolling
		    List<WebElement> editTextFields2 = driver.findElements(By.className(EditField_xpath));
		    System.out.println("Number of EditText fields found after scrolling: " + editTextFields2.size());

		    // The index of the new fields will depend on what's visible, but with a clean scroll,
		    // they should be at the end of the list.
		    if (editTextFields2.size() >= 3) {
		        // Relative 2 Name
		        WebElement relative2nameField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields1.get(1)));
		        relative2nameField.click();
		        relative2nameField.sendKeys("Yash");
		        driver.hideKeyboard();

		        // Relative 2 Relationship Type
		        WebElement relative2typeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative2type_xpath)));
		        relative2typeField.click();
		        // The scrollIntoView method is robust; it finds the element and scrolls to it if needed.
		        WebElement friendOption2 = driver.findElement(AppiumBy.androidUIAutomator(
		                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Friend\"))"));
		            friendOption2.click();

		        driver.hideKeyboard();    
		            
		        Thread.sleep(5000);    
		        // Relative 2 Mobile Number
		        WebElement relative2numberField = wait.until(ExpectedConditions.elementToBeClickable(editTextFields1.get(2)));
		        relative2numberField.click();
		        relative2numberField.sendKeys("8888888802");
		        driver.hideKeyboard();
		    }
	    	
		    // Click the Continue button
		    WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
		    continueButton.click();
		}
	
/*

       WebElement relative1nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative1name_xpath)));
       relative1nameField.click();
       relative1nameField.sendKeys("Rahul");
       driver.hideKeyboard();

      
       WebElement relative1typeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative1type_xpath)));
       relative1typeField.click();
      
       WebElement friendOption1 = driver.findElement(AppiumBy.androidUIAutomator(
               "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Friend\"))"));
           friendOption1.click();

       driver.hideKeyboard();
              
  
       WebElement relative1numberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative1no_xpath)));
       relative1numberField.click();
       relative1numberField.sendKeys("8888888801");
       driver.hideKeyboard();
   

    // ---------- Scroll to Relative 2 name ----------
       driver.findElement(AppiumBy.androidUIAutomator(
    		    "new UiScrollable(new UiSelector().scrollable(true))" +
    		    ".scrollIntoView(new UiSelector().description(\"Select Relationship Type\").instance(1))"
    		));

       
//   driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(1)"));

      // *** FIX: Scroll to the Continue button as a reliable anchor ***
 //   driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Continue\"))"));


       WebElement relative2nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative2name_xpath)));
       relative2nameField.click();
       relative2nameField.sendKeys("Yash");
       driver.hideKeyboard();
       
       // ---------- Scroll step-by-step until relationship type is visible ----------
       WebElement relative2typeField = null;
       for (int i = 0; i < 5; i++) {
           try {
               relative2typeField = driver.findElement(By.xpath(Relative2type_xpath));
               if (relative2typeField.isDisplayed()) break;
           } catch (Exception e) {
               driver.findElement(AppiumBy.androidUIAutomator(
                   "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
               Thread.sleep(500);
           }
       }

       if (relative2typeField == null) {
           throw new RuntimeException("Second relationship type field not found");
       }
       
//       WebElement relative2typeField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative2type_xpath)));
       relative2typeField.click();
      
       WebElement friendOption2 = driver.findElement(AppiumBy.androidUIAutomator(
               "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Friend\"))"));
           friendOption2.click();
       driver.hideKeyboard();    
           
         
      
       WebElement relative2numberField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Relative2no_xpath)));
       relative2numberField.click();
       relative2numberField.sendKeys("8888888802");
       driver.hideKeyboard();
   
    // ---------- Continue ----------
       driver.findElement(AppiumBy.androidUIAutomator(
               "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Continue\"))"));
       Thread.sleep(500);

       
   WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ContinueButton_xpath)));
   continueButton.click();
   
   }
	    	 
	*/    	 
	    	 

	    	 	     	 
	    	 
	    	 
	
}
