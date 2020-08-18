package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import BaseClass.Base;

public class Promotions_Menu extends Base{
	public Promotions_Menu() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Promotions')]")
	WebElement promotions;

	public void promotion() {
		ClickOnIt(promotions);
	}

	@FindBy(how=How.XPATH,using="//span[contains(text(),'Affiliates')]")
	WebElement Affiliates;

	public void Affiliates() {
		ClickOnIt(Affiliates);
	}
	@FindBy(how = How.XPATH,using ="//i[@class='fa fa-plus-square']")
	WebElement addButton;

	public void addButton() {
		ClickOnIt(addButton);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Active']")
	WebElement ActiveCheckBox;

	public void ActiveCheckBox() {
		ClickOnIt(ActiveCheckBox);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_FirstName']")
	WebElement Address_FirstName;

	public void Address_FirstName(String name) {
		EnterText(Address_FirstName, name);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_LastName']")
	WebElement Address_LastName;

	public void Address_LastName(String Lastname) {
		EnterText(Address_LastName, Lastname);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_Email']")
	WebElement Address_Email;

	public void Address_Email(String Lastname) {
		EnterText(Address_Email, Lastname);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_Company']")
	WebElement Address_Company;

	public void Address_Company(String Company) {
		EnterText(Address_Company, Company);
	}
	@FindBy(how = How.XPATH,using ="//select[@id='Address_CountryId']")
	WebElement Address_CountryId;
	public void Address_CountryId(String dropdown) {
		SelectElementByVisibletext(Address_CountryId, dropdown);
	}
	
	@FindBy(how = How.XPATH,using ="//input[@id='Address_County']")
	WebElement Address_County;

	public void Address_County(String country) {
		EnterText(Address_County, country);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_City']")
	WebElement Address_City;

	public void Address_City(String City) {
		EnterText(Address_City, City);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_Address1']")
	WebElement Address_Address1;

	public void Address_Address1(String Address1) {
		EnterText(Address_Address1, Address1);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_ZipPostalCode']")
	WebElement Address_ZipPostalCode;

	public void Address_ZipPostalCode(String ZipPostalCode) {
		EnterText(Address_ZipPostalCode, ZipPostalCode);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='Address_PhoneNumber']")
	WebElement Address_PhoneNumber;

	public void Address_PhoneNumber(String PhoneNumber) {
		EnterText(Address_PhoneNumber, PhoneNumber);
	}
	@FindBy(how=How.XPATH,using="//button[@name='save']")
	WebElement saveButton;

	public void saveButton() {
		ClickOnIt(saveButton);
	}
	@FindBy(how = How.XPATH,using ="//input[@id='SearchFirstName']")
	WebElement SearchFirstName;

	public void SearchFirstName(String SearchFirst) {
		EnterText(SearchFirstName, SearchFirst);
	}
	@FindBy(how=How.XPATH,using="//button[@id='search-affiliates']")
	WebElement search;

	public void search() {
		ClickOnIt(search);
	}
	@FindBy(how=How.XPATH,using="//a[@class='btn btn-default']")
	WebElement editButton;

	public void editButton() {
		ClickOnIt(editButton);
	}
	@FindBy(how=How.XPATH,using="//span[@id='affiliate-delete']")
	WebElement delete;

	public void delete() {
		ClickOnIt(delete);
	}
	@FindBy(how=How.XPATH,using="//button[@class='btn bg-red pull-right']")
	WebElement deleteaffiliate ;

	public void deleteaffiliate() {
		ClickOnIt(deleteaffiliate);
	}
	
}
