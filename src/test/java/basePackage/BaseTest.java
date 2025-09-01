package basePackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;

public class BaseTest {
	
	public AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		
		 // Selenium 4 style - Using UiAutomator2Options instead of DesiredCapabilities
        UiAutomator2Options options = new UiAutomator2Options()
            .setDeviceName("motorola moto g45 5G")
            .setPlatformName("Android")
            .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
            .setPlatformVersion("15")
            .setAppPackage("com.kgil.swipeloan.stg")
   //         .setAppPackage("com.kgil.swipeloan.dev")
            .setAppActivity("com.kgil.swipeloan.MainActivity")
            .setAutoGrantPermissions(true)
            .setIgnoreHiddenApiPolicyError(true)
            .setNewCommandTimeout(Duration.ofSeconds(10))
            
  //      .setNoReset(true)
  //      .setFullReset(false)
        .setAdbExecTimeout(Duration.ofSeconds(120))
        .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(120));
        // For Selenium 4 + Appium 8.x
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		
// motorola moto g45 5G, 15		
		
/*		
		DesiredCapabilities capabilities= new DesiredCapabilities();
		capabilities.setCapability("appium:deviceName","motorola moto g45 5G");  //Xiaomi M2010J19SI
		capabilities.setCapability("appium:platformName", "Android");
		capabilities.setCapability("appium:automationName", "UiAutomator2");
		capabilities.setCapability("appium:platformVersion", "15");  //12
		capabilities.setCapability("appium:appPackage", "com.kgil.swipeloan");   //com.swipeloan.swipe_loan_app
		capabilities.setCapability("appium:appActivity", "com.kgil.swipeloan.MainActivity");  //com.swipeloan.swipe_loan_app.MainActivity
		capabilities.setCapability("appium:autoGrantPermissions", true);
//		capabilities.setCapability("orientation", "PORTRAIT"); // or "LANDSCAPE"
//		capabilities.setCapability("appium:noReset", true);
		capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
		capabilities.setCapability("appium:enforceXPath1", true);
		capabilities.setCapability("appium:newCommandTimeout", 10000);
//		capabilities.setCapability("appWaitActivity", "*");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
*/
		
		
/*        URL url= URI.create("http://127.0.0.1:4723/").toURL();
		driver= new AndroidDriver(url, capabilities);
	*/	
	}
	
	

}
