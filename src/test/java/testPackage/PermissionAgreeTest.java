package testPackage;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.PermissionAgreePage;
import pagePackage.VerifyOTPPage;

public class PermissionAgreeTest extends BaseTest{
	
	@Test
	public void Test1() throws InterruptedException {

//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		onboarding.nextButtonClick();
		LoginPage mobileNumber= new LoginPage(driver);
		mobileNumber.enterMobileNumber("7757933391");
		driver.hideKeyboard();
		
		VerifyOTPPage otpField= new VerifyOTPPage(driver);
		otpField.enterOTPAndContinue();
		
		PermissionAgreePage IAgree= new PermissionAgreePage(driver);
		IAgree.PermissionAgree();
		
		
		
	}

}
