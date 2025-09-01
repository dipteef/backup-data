package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.VerifiedOTPPage;
import pagePackage.VerifyOTPPage;

public class VerifiedOTPTest extends BaseTest{

	
//	String otp="121512";
	@Test
	public void VerifiedTest() throws InterruptedException {
		
		OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
		LoginPage mobileNumber= new LoginPage(driver);
		VerifyOTPPage otpField= new VerifyOTPPage(driver);
		VerifiedOTPPage verified= new VerifiedOTPPage(driver);
		
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		
		mobileNumber.enterMobileNumber("9689698026");
		driver.hideKeyboard();
		
		otpField.enterOTPAndContinue();
		
		verified.verify();
		
		
	}
}
