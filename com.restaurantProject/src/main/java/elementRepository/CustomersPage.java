package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class CustomersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public CustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='menu-text'])[3]")
	WebElement storesTab;
	
	@FindBy(xpath="//span[text()='People']")
	WebElement peopleTab;
	
	@FindBy(xpath="//span[text()='Customers']")
	WebElement CustomersTab;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBoxInCustomersPage;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement addCustomer;
	
	@FindBy(xpath="//input[@id='CustomerName']")
	WebElement customerName;
	
	@FindBy(xpath="//input[@id='CustomerPhone']")
	WebElement customerPhone;
	
	@FindBy(xpath="//input[@id='CustomerEmail']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='CustomerDiscount']")
	WebElement discount;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchedCustomerName;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[2]")
	WebElement searchedMobileNumber;
	
	public void clickOnPeopleTab() {
		gu.clickElement(peopleTab);
	}
	public void clickOnCustomersTabInPeopleTab() {
		gu.clickElement(CustomersTab);
	}
	public boolean isCustomersPagevisibleByClickingOnCustomersOnPeopleTab() {
		return gu.isDisplayedMethod(searchBoxInCustomersPage);
	}
	public boolean isAddCustomerButtonDisplayedOrNot() {
		return gu.isDisplayedMethod(addCustomer);
	}
	public void clickOnAddCustomer() {
		gu.clickElement(addCustomer);
	}
	public void addCustomerName(String data) {
		gu.typeIntoAnElement(customerName, data);
	}
	public void addCustomerPhone(String data) {
		gu.typeIntoAnElement(customerPhone, data);
	}
	public void addCustomerEmail(String data) {
		gu.typeIntoAnElement(email, data);
	}
	public void addDiscount(String data) {
		gu.typeIntoAnElement(discount, data);
	}
	public void clickSubmitButton() {
		gu.clickElement(submitButton);
	}
	public void searchNameInSearchButton(String data) {
		gu.typeIntoAnElement(searchBoxInCustomersPage, data);
	}
	public boolean isCustomerNameDisplayedBySearch() {
	   return gu.isDisplayedMethod(searchedCustomerName);
	}
	public void searchACustomerByMobileNUmber(String data) {
		gu.typeIntoAnElement(searchBoxInCustomersPage, data);
	}
	public boolean isMobileNumberDisplayedBySearch() {
		return gu.isDisplayedMethod(searchedMobileNumber);
	}
}
