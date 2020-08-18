package Utlities;

import BaseClass.Base;
import PageObjectModel.Promotions_Menu;

public class PromotionDetails extends Base{
	String firstname="";
	public static void promotion() throws InterruptedException {
		logger.info("************ click into Promotions **********");
		pm=new Promotions_Menu();
		logger.info("************ click into Promotions_Menu **********");
		pm.promotion();
		Thread.sleep(3000);
		logger.info("************ click in Affiliates **********");
		pm.Affiliates();
		logger.info("************ click in addButton **********");
		pm.addButton();
		logger.info("************ click in Active Check Box **********");
		pm.ActiveCheckBox();
		logger.info("************ Enter the first name **********");
		String firstname=randomstring();
		pm.Address_FirstName(firstname);
		System.out.println(firstname);
		logger.info("************ Enter the lastName **********");
		pm.Address_LastName(randomstring());
		logger.info("************ Enter the Email id **********");
		String AddressEmail=randomstring()+"@gmail.com";
		pm.Address_Email(AddressEmail);
		System.out.println(AddressEmail);
		logger.info("************ Enter the company name **********");
		pm.Address_Company(randomstring());
		logger.info("************ Enter the Country name **********");
		pm.Address_CountryId("India");
		logger.info("************ Enter the country/Region **********");
		pm.Address_County("Andhra");
		logger.info("************ Enter the City name **********");
		pm.Address_City(randomstring());
		logger.info("************ Enter the Address **********");
		pm.Address_Address1(randomstring());
		logger.info("************ Enter the phone number **********");
		pm.Address_PhoneNumber(randomint());
		logger.info("************ Enter the pincode **********");
		pm.Address_ZipPostalCode("516360");
		logger.info("************ Click on save button **********");
		pm.saveButton();
		Thread.sleep(3000);
		logger.info("************ Search the first Name **********");
		pm.SearchFirstName(firstname);
		System.out.println(firstname);
		logger.info("************ Click on search **********");
		pm.search();
		logger.info("************ Click on edit button **********");
		pm.editButton();
		logger.info("************ Click on delete button **********");
		pm.delete();
		logger.info("************ Click on delete details **********");
		pm.deleteaffiliate();
	}
}
