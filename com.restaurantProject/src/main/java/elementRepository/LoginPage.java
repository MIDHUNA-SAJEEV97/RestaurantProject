package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass exp=new ExplicitWaitClass();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Login']")
	WebElement loginText;
	
	@FindBy(name = "username")
	WebElement userName;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "submit")
	WebElement loginButton;
	
	@FindBy(xpath="//span[contains(text(),'admin Doe')]")
	WebElement adminDoeName;
	
	@FindBy(xpath="//img[@alt='logo']")
	WebElement logo;

	public boolean isLoginTextDisplayed() throws InterruptedException {
		//exp.presenceOfElementLocatedWaitByXpath(driver, "//h1[text()='Login']" );
		//gu.addThreadSleep();
		return gu.isDisplayedMethod(loginText);
	}
	public void enterUserName(String data) {
		gu.typeIntoAnElement(userName, data);
	}
	public void enterPassword(String data) {
		gu.typeIntoAnElement(password, data);
	}
	public void clickOnLoginButton() {
		exp.elementToBeClickableWait(loginButton, driver);
		gu.clickElement(loginButton);
	}
	public String getTextOfAdminName() {
		return gu.getTextOfAnElement(adminDoeName);
	}
	
	public boolean isLogoDisplayed() {
		return gu.isDisplayedMethod(logo);
	}
	public String getCurrentUrlOfThePage() {
		return gu.getCurrentUrl(driver);
	}
	public String readUserName(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}
	public String readPassword(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}
	
}
