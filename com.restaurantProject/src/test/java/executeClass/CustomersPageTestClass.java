package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.CustomersPage;
import elementRepository.ExpensePage;
import elementRepository.LoginPage;
import elementRepository.WaitersPage;

public class CustomersPageTestClass extends BaseClass {
	LoginPage lp;
	CustomersPage cp;

	@Test(priority = 1)
	public void verifyCustomersPageIsVisibleByClickingOnCutomerOnPeopleTab() throws IOException {
		lp = new LoginPage(driver);
		cp = new CustomersPage(driver);

		/*lp.enterUserName(lp.readUserName(0, 1));
		  lp.enterPassword(lp.readPassword(1, 1));
		  lp.clickOnLoginButton();*/
		  lp.login();

		cp.clickOnPeopleTab();
		cp.clickOnCustomersTabInPeopleTab();

		Boolean actual = cp.isCustomersPagevisibleByClickingOnCustomersOnPeopleTab();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void verifyAddCustomerButtonIsVisibleOrNot() throws IOException {
		lp = new LoginPage(driver);
		cp = new CustomersPage(driver);

		lp.login();

		cp.clickOnPeopleTab();
		cp.clickOnCustomersTabInPeopleTab();
		Boolean actual = cp.isAddCustomerButtonDisplayedOrNot();
		Assert.assertTrue(actual);
	}

	@Test(priority = 3)
	public void verifyToAddaNewCustomer() throws IOException {
		lp = new LoginPage(driver);
		cp = new CustomersPage(driver);

		lp.login();

		cp.clickOnPeopleTab();
		cp.clickOnCustomersTabInPeopleTab();
		cp.clickOnAddCustomer();

		cp.addCustomerName("saanvi");
		cp.addCustomerPhone("887654321");
		cp.addCustomerEmail("saanvi@gmail.com");
		cp.addDiscount("15%");
		cp.clickSubmitButton();

		cp.searchNameInSearchButton("saanvi");

		Boolean actual = cp.isCustomerNameDisplayedBySearch();
		Assert.assertTrue(actual);
	}

	@Test(priority = 4)
	public void verifyToSearchACustomerByUsingNAme() throws IOException {
		lp = new LoginPage(driver);
		cp = new CustomersPage(driver);

		lp.login();

		cp.clickOnPeopleTab();
		cp.clickOnCustomersTabInPeopleTab();
		cp.searchNameInSearchButton("saanvi");

		Boolean actual = cp.isCustomerNameDisplayedBySearch();
		Assert.assertTrue(actual);
	}

	@Test(priority = 5)
	public void verifyToSearchACustomerByUsingMobileNumber() throws IOException {
		lp = new LoginPage(driver);
		cp = new CustomersPage(driver);

		lp.login();

		cp.clickOnPeopleTab();
		cp.clickOnCustomersTabInPeopleTab();
		cp.searchACustomerByMobileNUmber("887654321");

		Boolean actual = cp.isMobileNumberDisplayedBySearch();
		Assert.assertTrue(actual);
	}
}
