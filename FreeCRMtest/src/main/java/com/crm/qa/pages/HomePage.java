package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(css="td[class='headertable'] table tbody tr td")
	WebElement userNameLabel;
	@FindBy(css="a[title='Contacts']")
	WebElement contactsLink;
	@FindBy(css="a[title='Deals']")
	WebElement dealsLink;
	@FindBy(css="a[title='Tasks']")
	WebElement tasksLink;
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	public ContactsPage clickonContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickondealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickonTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	public void clickOnNewContactsLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactsLink.click();
	}
	
	
	
	
	
	
	
	
	
	

}
