package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;


public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFileName = "TC01";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
			boolean result = new LoginPage()
			.verifyLoginElements();
			Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String userName,String password) {
		boolean result = new LoginPage()
		    .enterUserName(userName)
		    .enterPassword(password)
		    .clickOnLogin()
		    .verifyHomeElement()
		    .clickUserImg()
		    .clickLogout()
		    .verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("mathan@credosystemz.sanbox")
	    .enterPassword("Mylearning$2")
	    .clickOnLoginWithInvalidCredential()
	    .validateErrorMsg();
		Assert.assertTrue(result);
	}

}
