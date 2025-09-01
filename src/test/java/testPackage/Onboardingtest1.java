package testPackage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;

public class Onboardingtest1 extends BaseTest{
	
	@Test
	public void test1() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		
		
	}

}
