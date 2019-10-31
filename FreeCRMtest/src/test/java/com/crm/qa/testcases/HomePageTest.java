package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
    TestUtil testUtil;
    ContactsPage contactspage;
    TasksPage taskspage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil=new TestUtil();
		loginpage = new LoginPage();
	    contactspage=new ContactsPage();
	    taskspage=new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		testUtil.switchToFrame();
		boolean flag=homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void verifyContactsLinksTest() {
		testUtil.switchToFrame();
		contactspage=homepage.clickonContactsLink();
	}
	@Test(priority=4)
	public void verifyTasksLinksTest() {
		testUtil.switchToFrame();
		taskspage=homepage.clickonTasksLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
