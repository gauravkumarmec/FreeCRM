package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.Webeventlistener;



public class TestBase {
	public static WebDriver driver;
	public static Properties prop;//prop and driver are golobaly declare value so we can use these values from child class and testbase class
	public static JavascriptExecutor js;
	public static EventFiringWebDriver e_driver;
	public static Webeventlistener eventListener;
	
	public TestBase(){
		
		try {
			System.out.println("Inside try");
			prop=new Properties();
			System.out.println("after prop");
			FileInputStream ip=new FileInputStream("D:\\work\\FreeCRMtest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			System.out.println("after fileInput TestBase");
			prop.load(ip);
			System.out.println("a TestBase");
			}catch(FileNotFoundException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void initialization() {
		
		
		String browserName=prop.getProperty("browser");
		
		if(browserName != null) {
			if(!browserName.equals("")) {
		if(browserName.equals("chrome")) {
			System.out.println("123");
			System.setProperty("webdriver.chrome.driver","D:\\FF driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		}
			else {
				System.out.println("empty");
			}
		}
			e_driver=new EventFiringWebDriver(driver);
			eventListener=new Webeventlistener();
			e_driver.register(eventListener);
			driver=e_driver;
			
		System.out.println("31");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("64");
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		System.out.println("end");
	}

}
