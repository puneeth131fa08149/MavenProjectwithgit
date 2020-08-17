package Utlities;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.Assert;

import BaseClass.Base;
import PageObjectModel.LoginPageDetails;

public class loginDetails extends Base{
	public static void LoginPage() {
		lp = new LoginPageDetails();
		logger.info("************ Customer Should be login  ************");
		lp.login(prop.getProperty("userName"), prop.getProperty("Password"));
		lp.setlogin();
		logger.info("************validateTitle  ************");
		System.out.println(lp.validateTitle());
		Assert.assertEquals(lp.validateTitle(), "Dashboard / nopCommerce administration");
	}
	
}