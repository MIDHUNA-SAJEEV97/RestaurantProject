package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.ExpensePage;
import elementRepository.LoginPage;
import elementRepository.SalesPage;

public class ExpensePageTestClass extends BaseClass {
	LoginPage lp;
	ExpensePage ep;
 
  @Test(priority = 1)
	public void verifyExpensePageIsVisibleByClickingnExpenseTab() throws IOException {
		lp = new LoginPage(driver);
		ep = new ExpensePage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

	    ep.expensePageVisibleByClickingExpenseTab();
		
		Boolean actual =ep.isAddExpenseButtonVisibleOrNot();
		Assert.assertTrue(actual);
}
  @Test(priority = 2)
	public void verifyAddExpenseButtonIsVisibleOrNot() throws IOException {
		lp = new LoginPage(driver);
		ep = new ExpensePage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

	    ep.expensePageVisibleByClickingExpenseTab();
		
		Boolean actual =ep.isAddExpenseButtonVisibleOrNot();
		Assert.assertTrue(actual);
}
}
