package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjectModel.HomePageDetails;
import PageObjectModel.LoginPageDetails;
import Utlities.CustomerPageDetails;
import Utlities.loginDetails;

public class Base extends ElementExtension {
	public static WebDriver driver;
	public static Logger logger;
	public static  Properties prop;
	public static  LoginPageDetails lp;
	private loginDetails ld;
	private FileInputStream fls;
	public HomePageDetails hp;
	private CustomerPageDetails cp;

	@BeforeMethod
	public void initialization() {
		try {
			//object creation for logger
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
		ChromeOptions options =new ChromeOptions();
		options.addArguments("headless");
		try {
			if(brsr.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", prop.getProperty("chrome_path"));
				driver = new ChromeDriver(options);
				logger.info("************ Lanchink on chrome browser **********");
			}
			else if (brsr.equalsIgnoreCase("firefox")) {
				logger.info("************ Launching Firefox Browser  ************");
				driver = new FirefoxDriver();
			}
			else if (brsr.equalsIgnoreCase("IE")) {
				logger.info("************ Launching IE Browser  ************");
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

	@Test(priority=1)
	public void testMethod() {
		ld = new loginDetails();
		ld.LoginPage();
		cp = new CustomerPageDetails();
		cp.CustomerHomePage();
	}
	@Test(priority=2)
	public void test() {
		System.out.println("Sample test");
	}

	@AfterMethod
	public void tearDown() {
		lp.closeBrowser(driver);
	}
}
