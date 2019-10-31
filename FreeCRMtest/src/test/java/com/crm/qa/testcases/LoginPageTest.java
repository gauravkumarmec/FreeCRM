package com.crm.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	//now we have to create the constructor for LoginPageTest class
	//and then we have to call the super keyword because it will call super class constructor ie TestBase constructor
	public LoginPageTest() {
		super();
		System.out.println("Test succesful!!");
		
	}
	//we have to call the Initilization Method from Parents Class
	@BeforeMethod
	public void setUp(){
		System.out.println("Third 3!!");
		initialization();
		System.out.println("Third 4!!");
	//now we have to create the object of login page class
		//now login page variable is define as class level so we can use in all programme
		 
		System.out.println("Third 5!!");
		loginpage=new LoginPage();
		System.out.println("Third 6!!");
		
	}
	//now we have to right the test case over there
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title=loginpage.validateLoginpageTittle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));//This method returning home page class object as HomePage is the landing page of login page
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}

}
