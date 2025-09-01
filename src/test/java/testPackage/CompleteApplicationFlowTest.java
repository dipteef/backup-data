package testPackage;

import org.junit.Test;

import basePackage.BaseTest;
import pagePackage.AadhaarNumberVerifyPage;
import pagePackage.HomeScreenCompleteApplicationPage;
import pagePackage.IncomeAmountPage;
import pagePackage.IncomeCompanyDetailsPage;
import pagePackage.LoginPage;
import pagePackage.OnboardingScreen1Page;
import pagePackage.PersonalDetailsAddressPage;
import pagePackage.PersonalDetailsDobPage;
import pagePackage.PersonalDetailsEmploymentTypePage;
import pagePackage.PersonalDetailsNamePage;
import pagePackage.PersonalDetailsRelativeInfoPage;
import pagePackage.UploadBankDetailsPage;
import pagePackage.VerifyOTPPage;

public class CompleteApplicationFlowTest extends BaseTest{

	@Test
	public void test1() throws InterruptedException {
		
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
		
	}
	
}
