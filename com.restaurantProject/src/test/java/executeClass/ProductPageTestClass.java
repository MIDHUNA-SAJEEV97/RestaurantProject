package executeClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;

public class ProductPageTestClass extends BaseClass {
	LoginPage lp;
	ProductPage pp;

	@Test(priority = 1)
	public void verifyProductPageIsOpenedWhileClickingProductTab() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
		Boolean actual = pp.isProductTypeTextDisplayedInProductTab();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2)
	public void verifyAddNewProduct() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
		pp.clickAddProductTab();

		pp.enterProductCode(pp.readProductCode(2, 1));
		pp.enterProductName(pp.readProductName(3, 1));
		pp.enterTax(pp.readTax(4, 1));
		pp.enterPrice(pp.readPrice(5, 1));
		pp.insertImageToChooseFile(System.getProperty("user.dir") + "\\src\\main\\resources\\AMUL-ICE-CREAM-CHOCOBAR-FORSTIK-70-ML.jpg");

		pp.clickFirstSubmitButton();
		pp.clickSecondSubmitButton();
		pp.refreshProductPage();

		// pp.searchTheData("chocobar");
		// System.out.println(pp.getTextOfChocobar());
		// Boolean actual=pp.isProductNameChocobarDisplayedBySearch();
		// Assert.assertTrue(actual);
		
		pp.searchTheData("786");
		
		String expected = "786";
		String actual = pp.getTextOfProductCodeBySearch();
		Assert.assertEquals(actual, expected);

	}
	@Test(priority = 3)
	public void verifySearchFunctionalityUsingProductName() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
		pp.searchTheData("chocobar");
		String expected = "chocobar";
		String actual = pp.getTextOfChocobar();
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 4)
	public void verifySearchFunctionalityUsingProductCode() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
        pp.searchTheData("786");
		
		String expected = "786";
		String actual = pp.getTextOfProductCodeBySearch();
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 5)
	public void verifyEditFunctionalityOfProduct() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
		pp.searchTheData("chocobar");
		pp.clickOnEditButton();
		pp.clearTaxColumn();
		
		//pp.enterNewTax(pp.readNewTax(6, 1));
		pp.enterNewTax("15");
		pp.clickSubmitButtonAfterEdit();
		
		pp.searchTheData("chocobar");
		Boolean actual=pp.isProductNameChocobarDisplayedBySearch();
		Assert.assertTrue(actual);
		
	}
	@Test(priority = 6)
	public void verifyDeleteFunctionalityOfProduct() throws IOException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.enterUserName(lp.readUserName(0, 1));
		lp.enterPassword(lp.readPassword(1, 1));
		lp.clickOnLoginButton();

		pp.clickProductTab();
		pp.searchTheData("chocobar");
		
		pp.clickOnDeleteButton();
		pp.clickOnDeleteConfirmMessage();
		
		pp.searchTheData("chocobar");
		
		String expected = "No matching records found";
		String actual = pp.getTextOfNoMatchMessage();
		Assert.assertEquals(actual, expected);
	}
	
}