package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class ProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass exp=new ExplicitWaitClass();
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[text()='Product'])[1]")
	WebElement productTab;
	
	@FindBy(xpath="//label[@for='Producttype']")
	WebElement productTypeText;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement AddProduct;
	
	@FindBy(id="ProductCode")
	WebElement productCode;
	
	@FindBy(id="ProductName")
	WebElement productName;
	
	@FindBy(xpath="//input[@id='Tax']")
	WebElement tax;
	
	@FindBy(xpath="//input[@id='Price']")
	WebElement price;
	
	@FindBy(xpath="(//input[@id='ImageInput'])[1]")
	WebElement chooseFile;
	
	@FindBy(xpath="(//button[text()='Submit'])[1]")
	WebElement firstSubmitButton;
	
	@FindBy(xpath="(//button[text()='submit'])[2]")
	WebElement secondSubmitButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr[1]//td[2]")
	WebElement productNameChocobarBySearch;
	
	@FindBy(xpath="//table[@id='Table']//tbody//tr//td[1]")
	WebElement productCodeBySearch;
	
	@FindBy(xpath="//a[@data-placement='top']")
	WebElement editButton;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submitAfterEdit;
	
	@FindBy(xpath="//a[@data-toggle='popover']//i[@class='fa fa-times']")
	WebElement deleteButton;
	
	@FindBy(xpath="//a[@class='btn btn-danger']")
	WebElement deleteConfirmMsg;
	
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement noMatchMessage;
	
	
	public void clickProductTab() {
		gu.clickElement(productTab);
	}
	public boolean isProductTypeTextDisplayedInProductTab() {
		return gu.isDisplayedMethod(productTypeText);
	}
	public void clickAddProductTab() {
		gu.scrollToViewAnElement(AddProduct, driver);
		gu.clickElement(AddProduct);
	}
	public void enterProductCode(String data) {
		gu.typeIntoAnElement(productCode, data);
	}
	public void enterProductName(String data) {
		gu.typeIntoAnElement(productName, data);
	}
	public void enterTax(String data) {
		gu.scrollToViewAnElement(tax, driver);
		gu.typeIntoAnElement(tax, data);
	}
	public void enterPrice(String data) {
		gu.scrollToViewAnElement(price, driver);
		gu.typeIntoAnElement(price, data);
	}
	
	public String readProductCode(int row,int col) throws IOException {           
		return ExcelReadClass.readIntegerData(row, col);
	}
	public String readProductName(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}
	public String readTax(int row,int col) throws IOException {
		return ExcelReadClass.readIntegerData(row, col);
	}
	public String readPrice(int row,int col) throws IOException {
		return ExcelReadClass.readIntegerData(row, col);
	}
	public void insertImageToChooseFile(String data) {
		gu.scrollToViewAnElement(chooseFile, driver);
		gu.typeIntoAnElement(chooseFile, data);
	}
	public void clickFirstSubmitButton() {
		gu.scrollToViewAnElement(firstSubmitButton, driver);
		gu.clickElement(firstSubmitButton);
	}
	public void clickSecondSubmitButton() {
		gu.clickElement(secondSubmitButton);
	}
	public void refreshProductPage() {
		gu.refreshAPage(driver);
	}
	
	public void searchTheData(String data) {
		gu.scrollToViewAnElement(searchBox, driver);
		exp.presenceOfElementLocatedWaitByXpath(driver,"//input[@type='search']");
		gu.typeIntoAnElement(searchBox, data);
	}
	public boolean isProductNameChocobarDisplayedBySearch() {
		return gu.isDisplayedMethod(productNameChocobarBySearch);
	}
	public boolean isProductCodeDisplayedBySearch() {
		return gu.isDisplayedMethod(productCodeBySearch);
	}
	public String getTextOfChocobar() {
		return gu.getTextOfAnElement(productNameChocobarBySearch);
	}
	public String getTextOfProductCodeBySearch() {
		return gu.getTextOfAnElement(productCodeBySearch);
	}
	public void clickOnEditButton() {
		exp.elementToBeClickableWait(editButton, driver);
		gu.clickElement(editButton);
	}
	public void clearTaxColumn() {
		gu.scrollToViewAnElement(tax, driver);
		exp.elementToBeClickableWait(tax, driver);
		gu.clearElement(tax);
	}
	public void enterNewTax(String data) {
		gu.scrollToViewAnElement(tax, driver);
		//exp.presenceOfElementLocatedWaitByXpath(driver, data);
		gu.typeIntoAnElement(tax, data);
	}
	/*public String readNewTax(int row,int col) throws IOException {           
		return ExcelReadClass.readIntegerData(row, col);
	}*/
	public void clickSubmitButtonAfterEdit() {
		gu.scrollToViewAnElement(submitAfterEdit, driver);
		gu.clickElement(submitAfterEdit);
	}
	public void clickOnDeleteButton() {
		gu.clickElement(deleteButton);
	}
	public void clickOnDeleteConfirmMessage() {
		gu.clickElement(deleteConfirmMsg);
	}
	public String getTextOfNoMatchMessage() {
		return gu.getTextOfAnElement(noMatchMessage);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}