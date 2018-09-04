package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
@Listeners(com.crm.qa.ExtentReportListener.CRMListener.class)				
public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		testUtil= new TestUtil();
		contactsPage= new ContactsPage();
		homePage= loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String title= homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO11");
	}

	@Test(priority=2)
	public void verifyCorrectUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority=3)
	public void clickOnContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage= homePage.clickOnContactsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
