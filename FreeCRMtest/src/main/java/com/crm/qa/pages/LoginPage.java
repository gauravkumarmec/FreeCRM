package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	//we have to define the page factory or object reprositery of login page
	@FindBy(name="username")
	 WebElement username;
	@FindBy(name="password")
	 WebElement password;
	@FindBy(css="input[value='Login']")
	 WebElement Loginbtn;
	@FindBy(xpath="//font[contains(text(),'Sign Up')]")
	 WebElement SignUp;
	@FindBy(css="img[class='img-responsive']")
	 WebElement CRMlogo;
	//Now we have to Initilized the above Element with the Page Pagefactoy method
	//Now we have to Create the constructor
	//Initilizating the page object
	public LoginPage() {
	PageFactory.initElements(driver, this);
	}
	//Action means different Features
	public String validateLoginpageTittle() {
		return driver.getTitle();
	}
	//verify the crmlogo
	public boolean validateCRMImage(){
		return CRMlogo.isDisplayed();
	}
	public HomePage login(String un,String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//Loginbtn.click();
		 js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",Loginbtn );
		//return of login page is home page so
		return new HomePage();	
	}

}
