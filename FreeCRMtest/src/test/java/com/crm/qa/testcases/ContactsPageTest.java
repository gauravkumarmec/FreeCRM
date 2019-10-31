package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
    TestUtil testUtil;
    ContactsPage contactspage;
    TasksPage taskspage;
    
   static String sheetName="TestData";
    public ContactsPageTest() {
    	super();
    }
    @BeforeMethod
    public void setUp() {
    	initialization();
    	loginpage=new LoginPage();
    	homepage=new HomePage();
    	testUtil=new TestUtil();
    	contactspage=new ContactsPage();
    	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
    	testUtil.switchToFrame();
    	contactspage = homepage.clickonContactsLink();
    	
    }
    @Test
    public void verifyContactsPageLabelsTest() {
    Assert.assertTrue(contactspage.verifyContactsLabels(),"contacts lebel is missing");
    	
    }
    @Test
    public void selectsContactsTest() {
    	contactspage.selectContactsByName("Bandana Kumari");
    	contactspage.selectContactsByName("uwq qwq");
    }
   /* @Test
    public void validateCreateNewContact() {
    	homepage.clickOnNewContactsLink();
    	contactspage.createNewContacts("Mr.","Ram","shyam","Hanuman");
    	
    }*/
    @DataProvider
    public Object[][] getCRMTestData() throws IOException{
    	Object data[][]=TestUtil.getTestData(sheetName);
    	return data;
    	}
    @Test(dataProvider="getCRMTestData")
    public void validateCreateNewContact(String title,String firstname,String lastname,String company) {
    	homepage.clickOnNewContactsLink();
    	contactspage.createNewContacts(title, firstname, lastname, company);
    }
    

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}


}
