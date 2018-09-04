package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//public ContactsPage contactPage;
	
	//Page Factory
	
	@FindBy(xpath="//td[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	//ContactLink
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	//DealLink
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	//Task link
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//New Contact Link
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement newContactLink;
	
	//Initializing the page object via constructor
	 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click(); 
	}
}
