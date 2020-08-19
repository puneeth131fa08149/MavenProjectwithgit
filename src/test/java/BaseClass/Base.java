package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Utilities;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import DisplayAllLinks.Links;
import PageObjectModel.HomePageDetails;
import PageObjectModel.LogOutDetails;
import PageObjectModel.LoginPageDetails;
import PageObjectModel.Promotions_Menu;
import ScreenShot_Pag.ScreenShot;
import Utlities.BrowserActions;
import Utlities.CustomerPageDetails;
import Utlities.PromotionDetails;
import Utlities.loginDetails;

public class Base extends ElementExtension {
	public static WebDriver driver;
	public static Logger logger;
	public static  Properties prop;
	public static  LoginPageDetails lp;
	public loginDetails ld;
	public static FileInputStream fls;
	public HomePageDetails hp;
	private CustomerPageDetails cp;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extend;
	public ExtentTest test;
	public static Promotions_Menu pm;
	public static String generateint;
	public static String generateString2;
	public PromotionDetails pd;
	public BrowserActions ba;
	private Links l;

	public static String randomstring() {
		generateString2 = RandomStringUtils.randomAlphabetic(4);
		return (generateString2);
	}
	public static String randomint() {
		generateint = RandomStringUtils.randomNumeric(10);
		return (generateint);
	}

	@BeforeTest
	public void setReports() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/testout/myreport.html");
		htmlReporter.config().setDocumentTitle("Automation report");//Title of the report
		htmlReporter.config().setReportName("Functional Report");//Name of the report
		htmlReporter.config().setTheme(Theme.STANDARD);
		extend=new ExtentReports();
		extend.attachReporter(htmlReporter);
		extend.setSystemInfo("Hostname", "LocalHost");
		extend.setSystemInfo("OS", "windows");
		extend.setSystemInfo("TesterName", "Puneeth");
		extend.setSystemInfo("BrowserName", "chrome");
	}
	@AfterTest
	public void EndReport() {
		extend.flush();
	}

	@BeforeClass
	public void initialization() {
		ba = new BrowserActions();
		ba.lanchBrowser();
	}
	@Test(priority=1)
	public void testMethod() {
		test=extend.createTest("nopcommercetitleTest");
		ld = new loginDetails();
		ld.LoginPage();
		cp = new CustomerPageDetails();
		cp.CustomerHomePage();
		l = new Links();
		l.AllLinks();
	}
	@Test(priority=2)
	public void google() throws InterruptedException {
		test=extend.createTest("PromotionDetails");
		pd = new PromotionDetails();
		pd.promotion();
	}
	@Test(priority=3)
	public void test() throws InterruptedException {
		test=extend.createTest("LogOutDetails");
		LogOutDetails lg=new LogOutDetails();
		Thread.sleep(3000);
		lg.Logout();
		Assert.assertEquals(driver.getTitle(), "Your store. Login");
		System.out.println("title of the page : "+driver.getTitle());
	}
	@Test(priority=4)
	public void title() {
		test=extend.createTest("ScreenShot");
		Assert.assertEquals(driver.getTitle(), "google");
	}
	@AfterMethod
	public void screenShotPage(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			ScreenShot screenshot=new ScreenShot();
			String temp=screenshot.getScreenShot(driver);
			test.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
	}
	@AfterClass
	public void tearDown() {
		lp.closeBrowser(driver);
	}
}
