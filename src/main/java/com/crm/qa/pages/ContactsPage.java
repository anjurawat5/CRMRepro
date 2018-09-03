package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Contacts Label
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement userNameLabel;
	
	//name
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(id="client_lookup")
	WebElement companyName;
	
	
	//Save button
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	//@FindBy(xpath="//a[text()='Al Ravi']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	//WebElement userNameLabelFromTable;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyUserNameLabel(){
		return userNameLabel.isDisplayed();
	}
	
	public void selectContacts(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	
	public void createNewContact(String title, String fName, String lName, String company){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fName);
		surname.sendKeys(lName);
		companyName.sendKeys(company);
	}
}
