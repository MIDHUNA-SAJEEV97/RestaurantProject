package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class WaitersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public WaitersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='People']")
	WebElement peopleTab;
	
	@FindBy(xpath="//span[text()='Waiters']")
	WebElement WaitersTab;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBoxInWaitersTab;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement addWaiter;
	
	@FindBy(xpath="//input[@id='WaiterName']")
	WebElement waiterName;
	
	@FindBy(xpath="//input[@id='WaiterPhone']")
	WebElement waiterPhone;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement email;
	
	@FindBy(xpath="//select[@id='WaiterStore']")
	WebElement storeDropDown;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement searchedStoreName;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[2]")
	WebElement searchedMobileNumber;
	
	public void clickOnPeopleTab() {
		gu.clickElement(peopleTab);
	}
	public void clickOnWaitersTabInPeopleTab() {
		gu.clickElement(WaitersTab);
	}
	public boolean isWaitersPagevisibleByClickingOnWaiterOnPeopleTab() {
		return gu.isDisplayedMethod(searchBoxInWaitersTab);
	}
	public boolean isAddWaiterButtonDisplayedOrNot() {
		return gu.isDisplayedMethod(addWaiter);
	}
	public void clickOnAddWaiter() {
		gu.clickElement(addWaiter);
	}
	public void addWaiterName(String data) {
		gu.typeIntoAnElement(waiterName, data);
	}
	public void addWaiterPhone(String data) {
		gu.typeIntoAnElement(waiterPhone, data);
	}
	public void addEmail(String data) {
		gu.typeIntoAnElement(email, data);
	}
	public void ClickStoreDropDownClick() {
		gu.clickElement(storeDropDown);
	}
	public void selectStoreD4FromDropDown() {
		gu.selectByIndexFromDropDown(storeDropDown, 176);
	}
	public void clickSubmitButton() {
		gu.clickElement(submitButton);
	}
	public void searchNameInSearchButton(String data) {
		gu.typeIntoAnElement(searchBoxInWaitersTab, data);
	}
	public boolean isStoreNameDisplayedBySearch() {
	   return gu.isDisplayedMethod(searchedStoreName);
	}
	public void searchAWaiterByMobileNUmber(String data) {
		gu.typeIntoAnElement(searchBoxInWaitersTab, data);
	}
	public boolean isMobileNumberDisplayedBySearch() {
		return gu.isDisplayedMethod(searchedMobileNumber);
	}
}
