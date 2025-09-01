package testPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.HomeScreenCompleteApplicationPage;
import pagePackage.IncomeAmountPage;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.PermissionAgreePage;
import pagePackage.PromoPopUpPage;
import pagePackage.VerifiedOTPPage;
import pagePackage.VerifyOTPPage;

public class IncomeAmountTest extends BaseTest{

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
/*
	        VerifiedOTPPage verified= new VerifiedOTPPage(driver);
	        verified.verify();
*/
	/*		
	        PermissionAgreePage IAgree= new PermissionAgreePage(driver);
	        IAgree.PermissionAgree();
	*/
/*
	        PromoPopUpPage popUp= new PromoPopUpPage(driver);
	        popUp.closePopUp();
*/
	        HomeScreenCompleteApplicationPage completeApplicationButton= new HomeScreenCompleteApplicationPage(driver);
	        completeApplicationButton.CompleteApplication();
		
	    	IncomeAmountPage income= new IncomeAmountPage(driver);
	    	income.IncomeAmount();
		
	}
	
}
