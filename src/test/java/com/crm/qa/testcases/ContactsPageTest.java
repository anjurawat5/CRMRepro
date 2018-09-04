package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
@Listeners(com.crm.qa.ExtentReportListener.CRMListener.class)				
public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage= new LoginPage();
		testUtil= new TestUtil();
		
		contactsPage= new ContactsPage();
		homePage= loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyUserNameLabelTest(){
		Assert.assertTrue(contactsPage.verifyUserNameLabel(), "Contact label is missing");
	}
	
	@Test(priority=2)
	public void selectContactsTest(){
		contactsPage.selectContacts("Al Ravi");
	}
	
	@Test(priority=3)
	public void multipleContactsTest(){
		contactsPage.selectContacts("Al Ravi");
		contactsPage.selectContacts("Anil Kumar");
		contactsPage.selectContacts("Anil");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() throws IOException{
		Object[][] data = TestUtil.readData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateNewContact(String title, String firstName, String lastName, String company ){
		homePage.clickOnContactsLink();
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}


}
