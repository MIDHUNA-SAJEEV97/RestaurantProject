package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.WaitersPage;

public class WaitersPageTestClass extends BaseClass {
	LoginPage lp;
	WaitersPage wp;

	@Test(priority = 1)
	public void verifyWaitersPageIsVisibleByClickingOnWaiterOnPeopleTab() throws IOException {
		lp = new LoginPage(driver);
		wp = new WaitersPage(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaitersTabInPeopleTab();
		Boolean actual = wp.isWaitersPagevisibleByClickingOnWaiterOnPeopleTab();
		Assert.assertTrue(actual);
	}
	@Test(priority = 2)
	public void verifyAddWaiterButtonIsVisibleOrNot() throws IOException {
		lp = new LoginPage(driver);
		wp = new WaitersPage(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaitersTabInPeopleTab();
		Boolean actual = wp.isAddWaiterButtonDisplayedOrNot();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3)
	public void verifyToAddaNewWaiter() throws IOException {
		lp = new LoginPage(driver);
		wp = new WaitersPage(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaitersTabInPeopleTab();
		wp.clickOnAddWaiter();
		
		wp.addWaiterName("midhuna");
		wp.addWaiterPhone("789654123");
		wp.addEmail("midhu@gmail.com");
		wp.ClickStoreDropDownClick();
		wp.selectStoreD4FromDropDown();
		wp.clickSubmitButton();
		
		wp.searchNameInSearchButton("midhuna");
		
		Boolean actual = wp.isStoreNameDisplayedBySearch();
		Assert.assertTrue(actual);
	}
	@Test(priority = 4)
	public void verifyToSearchAWaiterByUsingNAme() throws IOException {
		lp = new LoginPage(driver);
		wp = new WaitersPage(driver);

		lp.login();

		wp.clickOnPeopleTab();
		wp.clickOnWaitersTabInPeopleTab();
		wp.searchNameInSearchButton("midhuna");
		
		Boolean actual = wp.isStoreNameDisplayedBySearch();
		Assert.assertTrue(actual);
	}
	@Test(priority = 5)
	public void verifyToSearchAWaiterByUsingMobileNumber() throws IOException {
		lp = new LoginPage(driver);
		wp = new WaitersPage(driver);

		lp.login();
		
		wp.clickOnPeopleTab();
		wp.clickOnWaitersTabInPeopleTab();
		wp.searchAWaiterByMobileNUmber("789654123");
		
		Boolean actual = wp.isMobileNumberDisplayedBySearch();
		Assert.assertTrue(actual);
	}
}
