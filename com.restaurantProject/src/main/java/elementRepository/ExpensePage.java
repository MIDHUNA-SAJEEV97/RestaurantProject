package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ExpensePage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	
	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//span[text()='Expense'])[1]")
	WebElement expenseTab;
	
	@FindBy(xpath="//button[@class='btn btn-add btn-lg']")
	WebElement addExpenseTab;
	
	public void expensePageVisibleByClickingExpenseTab() {
		gu.clickElement(expenseTab);
	}
	public boolean isAddExpenseButtonVisibleOrNot() {
		return gu.isDisplayedMethod(addExpenseTab);
	}
	
	
}
