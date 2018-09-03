package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public TestBase(){
		try{
			properties = new Properties();
			FileInputStream fis = new FileInputStream("D:\\Workspace-eclipse\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			//FileInputStream fis = new FileInputStream("/Users/anjur/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			properties.load(fis);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization(){
		String browserName = properties.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("ff")){
			//System.setProperty("webdriver.chrome.driver", "/Users/anjur/Desktop/Anju/chromedriver");
			driver = new FirefoxDriver ();
		}
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("url"));
	}

}
