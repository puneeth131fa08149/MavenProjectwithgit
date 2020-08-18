package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class LogOutDetails extends Base{
	public LogOutDetails() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]")
	WebElement logout;
	public void Logout() {
		ClickOnIt(logout);
	}
}
