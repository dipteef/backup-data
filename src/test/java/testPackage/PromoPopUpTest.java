package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.PromoPopUpPage;
import pagePackage.VerifiedOTPPage;
import pagePackage.VerifyOTPPage;

public class PromoPopUpTest extends BaseTest{

	
	@Test
	public void Test1() throws InterruptedException {
		
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
		
		PromoPopUpPage popUp= new PromoPopUpPage(driver);
		popUp.closePopUp();
		
    	}
}