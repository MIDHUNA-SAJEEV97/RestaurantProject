package executeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.HomePage;
import elementRepository.LoginPage;

public class HomePageTestClass extends BaseClass{
	LoginPage lp;
	HomePage hp;
	
  @Test(priority=1)
  public void verifyProductTabIsDisplayedorNot() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  Boolean actual=hp.isProductTabDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=2)
  public void verifyD4StoreIsDisplayedorNot() throws IOException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  Boolean actual=hp.isD4StoreDisplayed();
	  Assert.assertTrue(actual);
	  
  }
  @Test(priority=3)
  public void verifyLogOutButtonIsClickableOrNot() throws IOException, InterruptedException {
	  lp=new LoginPage(driver);
	  hp=new HomePage(driver);
	  
	  lp.enterUserName(lp.readUserName(0, 1));
	  lp.enterPassword(lp.readPassword(1, 1));
	  lp.clickOnLoginButton();
	  
	  hp.logoutButtonClickableOrNot();
	  
	  Boolean actual=hp.isProductTabDisplayed();
	  Assert.assertTrue(actual);
	    
  }
}
