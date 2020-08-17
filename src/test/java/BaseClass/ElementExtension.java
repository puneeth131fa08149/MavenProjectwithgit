package BaseClass;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ElementExtension {
	//  ".get()" extension method
	public static void getDriver(WebDriver driver, String url) {
		driver.get(url);
	}


	//  ".quit" extenison method
	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}


	//  ".clear" extension method
	public static void clearAll(WebElement element)
	{
		try
		{
			element.clear();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("clould not clear.got an exception");
			throw e;
		}
	}

	//  ".sendkeys()" extension method
	public static void EnterText(WebElement element, String text) {

		try{
			if (text == "enter")
				element.sendKeys(Keys.ENTER);
			else
				element.sendKeys(text);
		}
		catch(ElementNotVisibleException e)
		{
			System.out.println("Got an element not visible exception");
			throw e;
		}

	}

	// ".click" extension method
	public static void ClickOnIt(WebElement element){
		try
		{ 
			element.click();
		}
		catch(ElementClickInterceptedException e)
		{
			System.out.println("coud not click on the elemet.Got an click intercept exception");
			throw e;
		}
	}


	// ".findElement()" extension method
	public static WebElement detectElement(WebDriver driver, By xpath) {

		try {
			WebElement element = driver.findElement(xpath);
			return element;

		} catch (ElementNotVisibleException e) {
			System.out.println("coudnot find the element.Element Not visible exception");
			throw e;
		}


	}
	 public static void ImplicitlyWait(WebDriver driver, int seconds)
     {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
     }
	 public static void pageLoadTimeout(WebDriver driver, int seconds)
     {
        driver.manage().timeouts().pageLoadTimeout(seconds, TimeUnit.SECONDS);
     }
       
     

}
