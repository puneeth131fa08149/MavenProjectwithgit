package Utlities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import BaseClass.Base;
import PageObjectModel.HomePageDetails;

public class CustomerPageDetails extends Base {
	String emailtext="";
	
	
	
	public void CustomerHomePage() {
	
		hp=new HomePageDetails(driver);
		
		logger.info("************ Customer click on CustomerMenu **********");
		hp.clickCustomersMenu();
		logger.info("************ Customer click on CustomerMenu Item**********");
		hp.clickCustomerMenuItem();
		logger.info("************ Customer clic on Add Button **********");
		hp.clickOnAddbutton();
		logger.info("************ Enter Email Id **********");
		String emailtext=randomstring()+"@gmail.com";
		hp.Enter_email(emailtext);
		System.out.println(emailtext);
		hp.Enter_password(randomint());
		logger.info("************ Enter firstName **********");
		hp.Enter_Frist_Name(randomstring());
		logger.info("************ Enter LastName **********");
		hp.Enter_Last_Name(randomstring());
		logger.info("************ Select Gender **********");
		hp.select_gender("Male");
		logger.info("************ Enter DOB **********");
		hp.Enter_DOB("01/02/2020");
		logger.info("************ Enter Company name **********");
		hp.Enter_company_name("ABCDEF");
		logger.info("************ Select the Vendor **********");
		hp.select_vendor("Vendor 1");
		logger.info("************ Click on Save Button **********");
		hp.click_save();
		hp.Email_search(emailtext);
		System.out.println(emailtext);
		hp.search();
		logger.info("************ Click on check box **********");
		hp.FcheckBox();
		logger.info("************ Click on edit Button **********");
		hp.EditButton();
		logger.info("************ Click on delete Customer Details **********");
		hp.deleteCustomer();
		logger.info("************ Click on delete Button **********");
		hp.deleteButtom();
		
	
		
	}
}
