package Utlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import BaseClass.Base;

public class BrowserActions extends Base{
	public static void lanchBrowser() {
		try {
			logger=Logger.getLogger("testBase");
			PropertyConfigurator.configure("log.properties");
			prop=new Properties();
			fls = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\PropertiesFile\\config.properties");
			prop.load(fls);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		String brsr = prop.getProperty("browser");

		try {
			if(brsr.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_path"));
				driver = new ChromeDriver();
				logger.info("************ Lanchink on chrome browser **********");
			}
			else if (brsr.equalsIgnoreCase("firefox")) {
				logger.info("************ Launching Firefox Browser  ************");
				driver = new FirefoxDriver();
			}
			else if (brsr.equalsIgnoreCase("IE")) {
				logger.info("************ Launching IE Browser************");
				driver = new InternetExplorerDriver();	
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		pageLoadTimeout(driver, 30);
		ImplicitlyWait(driver, 30);
		getDriver(driver, prop.getProperty("URL"));

	}

}
