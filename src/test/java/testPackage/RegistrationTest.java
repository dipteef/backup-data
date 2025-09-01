package testPackage;

import org.testng.annotations.Test;

import basePackage.BaseTest;
import pagePackage.AadhaarNumberVerifyPage;
import pagePackage.CreditScorePlanPage;
import pagePackage.HomeScreenCompleteApplicationPage;
import pagePackage.IncomeAmountPage;
import pagePackage.IncomeCompanyDetailsPage;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.PanNumberEnterPage;
import pagePackage.PanNumberVerifyPage;
import pagePackage.PaymentPayPage;
import pagePackage.PaymentSuccessPage;
import pagePackage.PermissionAgreePage;
import pagePackage.PersonalDetailsAddressPage;
import pagePackage.PersonalDetailsNamePage;
import pagePackage.UploadBankDetailsPage;
import pagePackage.VerifyOTPPage;

public class RegistrationTest extends BaseTest{

	
		
		@Test
		public void Test1() throws InterruptedException {
			
			OnboardingScreen1Page onboarding= new OnboardingScreen1Page(driver);
			onboarding.nextButtonClick();
			onboarding.nextButtonClick();
			onboarding.nextButtonClick();
			LoginPage mobileNumber= new LoginPage(driver);
			mobileNumber.enterMobileNumber("7757933391");
			driver.hideKeyboard();
			
			VerifyOTPPage otpField= new VerifyOTPPage(driver);
			otpField.enterOTPAndContinue();
	/*		
			VerifiedOTPPage verified= new VerifiedOTPPage(driver);
			verified.verify();
			
			EmailPage emailField= new EmailPage(driver);
			emailField.Email();
		*/	
			PanNumberEnterPage panNumberField= new PanNumberEnterPage(driver);
			panNumberField.PanNumber();
			
			PanNumberVerifyPage panNumberVerify= new PanNumberVerifyPage(driver);
			panNumberVerify.Pannumber();
			
			PermissionAgreePage IAgree= new PermissionAgreePage(driver);
			IAgree.PermissionAgree();
			
			HomeScreenCompleteApplicationPage completeApplicationButton= new HomeScreenCompleteApplicationPage(driver);
	        completeApplicationButton.CompleteApplication();
	        
	        PersonalDetailsNamePage EmailGenderSelection= new PersonalDetailsNamePage(driver);
		    EmailGenderSelection.Name();
			
		    PersonalDetailsAddressPage address= new PersonalDetailsAddressPage(driver);
		    address.AddressDetails();
		  	
	    	AadhaarNumberVerifyPage aadhaarVerify= new AadhaarNumberVerifyPage(driver);
	    	aadhaarVerify.AadhaarNumberVerify();
	    	
	    	UploadBankDetailsPage BankInfo= new UploadBankDetailsPage(driver);
			BankInfo.BankDetails();
			
			IncomeAmountPage income= new IncomeAmountPage(driver);
		    income.IncomeAmount();
		
		    IncomeCompanyDetailsPage companyInfo= new IncomeCompanyDetailsPage(driver);
		    companyInfo.CompanyDetails();
		
		    CreditScorePlanPage subscribeButton= new CreditScorePlanPage(driver);
			subscribeButton.Subscribe();
			
			PaymentPayPage payButton= new PaymentPayPage(driver);
			payButton.Pay();
			
			PaymentSuccessPage success = new PaymentSuccessPage(driver);
			success.PaymentSuccess();
			
	}
	
}
