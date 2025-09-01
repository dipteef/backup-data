package testPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.VerifyOTPPage;

public class VerifyOTPTest extends BaseTest {
	
//	String otp="121512";
	@Test
	public void VerifyTest() throws InterruptedException {


		OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		LoginPage mobileNumber= new LoginPage(driver);
		mobileNumber.enterMobileNumber("7757933391");
		
		VerifyOTPPage otpField= new VerifyOTPPage(driver);
		otpField.enterOTPAndContinue();
		
		
		
	}

}
