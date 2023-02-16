package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class StoresPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public StoresPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='menu-text'])[3]")
	WebElement storesTab;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBoxInStorePage;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement addStore;
	
	@FindBy(xpath="//input[@id='StoreName']")
	WebElement storeName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='StorePhone']")
	WebElement storePhone;
	
	@FindBy(xpath="//input[@id='Country']")
	WebElement country;
	
	@FindBy(xpath="//input[@id='City']")
	WebElement city;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchedStoreName;

	
	public void clickStoresTab() {
		gu.clickElement(storesTab);
	}
	public boolean isStorePageDisplayedByClickingStoreTab() {
		return gu.isDisplayedMethod(searchBoxInStorePage);
	}
	public void clickOnAddStore() {
		gu.clickElement(addStore);
	}
	public void enterStoreName(String data) {
		gu.typeIntoAnElement(storeName, data);
	}
	public void enterEMail(String data) {
		gu.typeIntoAnElement(email, data);
	}
	public void enterStorePhone(String data) {
		gu.typeIntoAnElement(storePhone, data);
	}
	public void enterCountry(String data) {
		gu.typeIntoAnElement(country, data);
	}
	public void enterCity(String data) {
		gu.typeIntoAnElement(city, data);
	}
	public void clickSubmitButton() {
		gu.clickElement(submitButton);
	}
	public void searchAddedStoreInSearchBox(String data) {
		gu.typeIntoAnElement(searchBoxInStorePage, data);
	}
	public boolean isAddedStoreInSearchBoxDisplayed() {
		return gu.isDisplayedMethod(searchedStoreName);
	}
	public void StoreNameSearchByUsingStoreName(String data) {
		gu.typeIntoAnElement(searchBoxInStorePage, data);
	}
	public boolean isStoreNameSearchByUsingStoreNameDisplayed() {
		return gu.isDisplayedMethod(searchedStoreName);
	}
	public boolean isAddStoreButtonDisplayedOrNot() {
		return gu.isDisplayedMethod(addStore);
	}
	
	
}
