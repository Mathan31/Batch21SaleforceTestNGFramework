package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC002_CreateLeads extends BaseClass{
	
	@BeforeTest
	public void testCaseSetUp() {
		excelFileName = "TC02";
		authors = "Tharshini";
		category = "Sanity";
		testName = "Create Leads Scenario";
		testDesc = "Create Leads Field  Validation and Creating the Lead";
		moduleName = "Create Lead";
	}
	
	@Test(priority = 1,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String userName,String password) {
		boolean result = new LoginPage(driver,node)
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		Assert.assertTrue(result);
	}

}
