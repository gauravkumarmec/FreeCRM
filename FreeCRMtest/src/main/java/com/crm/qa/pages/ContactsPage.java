package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabels;
	@FindBy(id="first_name")
	WebElement firstname;
	@FindBy(css="input[name='surname']")
	WebElement lastname;
	@FindBy(name="client_lookup")
	WebElement company;
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	//for contacts checkbox
	/*@FindBy(xpath="//a[text()='Bandana Kumari']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input")
	WebElement radiobutton;*/
	//this is not a ideal way to do this
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		}
	public boolean verifyContactsLabels() {
		return contactslabels.isDisplayed();
	}
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input")).click();
	}
	public void createNewContacts(String title,String ftname,String ltname,String comp) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	//a[text()='Bandana Kumari']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input
}
