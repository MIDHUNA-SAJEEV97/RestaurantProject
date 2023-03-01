package executeClass;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;
import elementRepository.ProductPage;
//@Listeners(TestListener.class)
public class ProductPageTestClass extends BaseClass {
	LoginPage lp;
	ProductPage pp;
	String code;

	@Test(priority = 1,groups = {"group-1"}) 
	public void verifyProductPageIsOpenedWhileClickingProductTab() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();

		pp.clickProductTab();
		Boolean actual = pp.isProductTypeTextDisplayedInProductTab();
		Assert.assertTrue(actual);
	}

	@Test(priority = 2,groups = {"add"})
	public void verifyAddNewProduct() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();

		pp.clickProductTab();
		code=pp.addProduct();

	/*	pp.enterProductCode(pp.readProductCode(2, 1));
		pp.enterProductName(pp.readProductName(3, 1));
		pp.enterTax(pp.readTax(4, 1));
		pp.enterPrice(pp.readPrice(5, 1));
		pp.insertImageToChooseFile(System.getProperty("user.dir") + "\\src\\main\\resources\\AMUL-ICE-CREAM-CHOCOBAR-FORSTIK-70-ML.jpg");

		pp.clickFirstSubmitButton();
		pp.clickSecondSubmitButton();
		pp.refreshProductPage();*/

		// pp.searchTheData("chocobar");
		// System.out.println(pp.getTextOfChocobar());
		// Boolean actual=pp.isProductNameChocobarDisplayedBySearch();
		// Assert.assertTrue(actual);
		
		//pp.searchTheData("786");
		//String expected = "786";
		
		/*String expected = code;
		String actual = pp.getTextOfProductCodeBySearch();
		Assert.assertEquals(actual, expected);*/
		pp.searchTheData(code);
		Boolean actual=pp.isProductCodeDisplayedBySearch();
		Assert.assertTrue(actual);
  
	}
	@Test(priority = 3,groups = {"search"})
	public void verifySearchFunctionalityUsingProductName() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();

		pp.clickProductTab();
		pp.searchTheData("chocobar");
		String expected = "chocobar";
		String actual = pp.getTextOfChocobar();
		Assert.assertEquals(actual, expected);
		
	}
	@Test(priority = 4,groups = {"search"})
	public void verifySearchFunctionalityUsingProductCode() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();

		pp.clickProductTab();
		
        /*pp.searchTheData("786");
		
		String expected = "786";
		String actual = pp.getTextOfProductCodeBySearch();
		Assert.assertEquals(actual, expected);*/
		
		code=pp.addProduct();
		pp.searchTheData(code);
		Boolean actual=pp.isProductCodeDisplayedBySearch();
		Assert.assertTrue(actual);
	}
	@Test(priority = 5,groups = {"edit"})
	public void verifyEditFunctionalityOfProduct() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();
		
		pp.clickProductTab();
		code=pp.addProduct();
		pp.searchTheData("chocobar");
		pp.clickOnEditButton();
		pp.clearTaxColumn();
		
		//pp.enterNewTax(pp.readNewTax(6, 1));
		pp.enterNewTax("15");
		pp.clickSubmitButtonAfterEdit();
		
		pp.searchTheData(code);
		Boolean actual=pp.isProductCodeDisplayedBySearch();
		Assert.assertTrue(actual);
		
	}
	@Test(priority = 6,groups = {"delete"})
	public void verifyDeleteFunctionalityOfProduct() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		pp = new ProductPage(driver);

		lp.login();

		pp.clickProductTab();
		code=pp.addProduct();
		pp.searchTheData("chocobar");
		
		pp.clickOnDeleteButton();
		pp.clickOnDeleteConfirmMessage();
		
		pp.searchTheData(code);
		
		String expected = "No matching records found";
		String actual = pp.getTextOfNoMatchMessage();
		Assert.assertEquals(actual, expected);
	}
	
}