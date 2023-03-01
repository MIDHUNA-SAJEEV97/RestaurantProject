package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ProductPage;
import elementRepository.StoresPage;

public class StoresPageTestClass extends BaseClass{
	LoginPage lp;
	StoresPage sp;

	@Test(priority = 1)
	public void verifyStoresPageIsVisibleByClickingStoresTab() throws IOException {
		lp = new LoginPage(driver);
		sp = new StoresPage(driver);

		lp.login();

		sp.clickStoresTab();
		Boolean actual = sp.isStorePageDisplayedByClickingStoreTab();
		Assert.assertTrue(actual);
	}
	@Test(priority = 2)
	public void verifyToCreateANewStore() throws IOException {
		lp = new LoginPage(driver);
		sp = new StoresPage(driver);

		lp.login();
		
		sp.clickStoresTab();
		sp.clickOnAddStore();
		sp.enterStoreName("midhuStores");
		sp.enterEMail("midhustores@gmail.com");
		sp.enterStorePhone("789654123");
		sp.enterCountry("India");
		sp.enterCity("TVM");
		sp.clickSubmitButton();
		
		Boolean actual=sp.isAddedStoreInSearchBoxDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 3)
	public void verifyStoreNameSearchByUsingStoreName() throws IOException {
		lp = new LoginPage(driver);
		sp = new StoresPage(driver);

		lp.login();
		
		sp.clickStoresTab();
		sp.StoreNameSearchByUsingStoreName("midhuStores");
		
		Boolean actual=sp.isStoreNameSearchByUsingStoreNameDisplayed();
		Assert.assertTrue(actual);
	}
	@Test(priority = 4)
	public void verifyAddStoreButtonisVisibleOrNot() throws IOException {
		lp = new LoginPage(driver);
		sp = new StoresPage(driver);

		lp.login();
		
		sp.clickStoresTab();
		Boolean actual=sp.isAddStoreButtonDisplayedOrNot();
		Assert.assertTrue(actual);
	}	
}