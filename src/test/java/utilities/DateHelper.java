package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import basePackage.BaseTest;
import io.appium.java_client.android.AndroidDriver;

public class DateHelper extends BaseTest {
	
	public DateHelper(AndroidDriver driver) {
		this.driver=driver;
	}
	
	public String getCurrentDay() {
		 LocalDate currentDate = LocalDate.now();

	        // Format the date (optional)
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String[] formattedDate = currentDate.format(formatter).split("-");
            
	        // Print the current date
	        System.out.println("Current Date: " + formattedDate[0]);
	        return formattedDate[0];
	        
	}

}
