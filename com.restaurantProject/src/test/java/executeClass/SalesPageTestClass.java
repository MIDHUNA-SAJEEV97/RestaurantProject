package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.SalesPage;
import elementRepository.WaitersPage;

public class SalesPageTestClass extends BaseClass {
	LoginPage lp;
	SalesPage slp;
 
  @Test(priority = 1)
	public void verifyWaitersPageIsVisibleByClickingOnWaiterOnPeopleTab() throws IOException {
		lp = new LoginPage(driver);
		slp = new SalesPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		slp.clickOnSalestab();
		
		Boolean actual = slp.isSalesPageDisplayedOnClickingSalesTab();
		Assert.assertTrue(actual);
}
}