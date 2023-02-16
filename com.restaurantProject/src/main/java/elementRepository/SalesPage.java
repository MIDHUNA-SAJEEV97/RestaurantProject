package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SalesPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public SalesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class='menu-text'])[8]")
	WebElement salesTab;
	
	@FindBy(xpath="//h3[text()='Sales']")
	WebElement salesTextHeading;
	
	public void clickOnSalestab() {
		gu.clickElement(salesTab);
	}
	public boolean isSalesPageDisplayedOnClickingSalesTab() {
		return gu.isDisplayedMethod(salesTextHeading);
	}
	
}
