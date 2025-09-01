package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.EmailPage;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.VerifiedOTPPage;
import pagePackage.VerifyOTPPage;

public class EmailScreen extends BaseTest{
	
//	String otp="121512";
	@Test
	public void EmailTest() throws InterruptedException {

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		LoginPage mobileNumber= new LoginPage(driver);
		mobileNumber.enterMobileNumber("9689698026");
		driver.hideKeyboard();
		
		VerifyOTPPage otpField= new VerifyOTPPage(driver);
		otpField.enterOTPAndContinue();
		
		VerifiedOTPPage verified= new VerifiedOTPPage(driver);
		verified.verify();
		
		EmailPage emailField= new EmailPage(driver);
		emailField.Email();
		
	}

}
