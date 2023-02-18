package executeClass;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;

public class LoginPageTestClass extends BaseClass {
	//WebDriver driver;
	LoginPage lp;
  @Test(priority=1,groups = {"group-1"})
  public void verifyTheLoginPageIsLoadedWhileHittingTheUrl() throws InterruptedException {
	  
	  lp=new LoginPage(driver);
	 
	  Boolean actual=lp.isLoginTextDisplayed();
	  Assert.assertTrue(actual);  
  }
  @Test(priority=2,groups = {"group-1"})
  public void verifyTheRestaurantLogoIsDispalyed() {
	  
	  lp=new LoginPage(driver);
	  
	  Boolean actual=lp.isLogoDisplayed();
	  Assert.assertTrue(actual);
  }
  @Test(priority=3,dataProvider="successfullLogin",dataProviderClass=DataProviderClass.class,groups = {"login-1"})
  public void verifySuccessFullLogin(String usName,String pwd) {
	  
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(usName);
	  lp.enterPassword(pwd);
	  lp.clickOnLoginButton();
	  
	  String expected="  admin Doe";
	  String actual=lp.getTextOfAdminName();
	  Assert.assertEquals(actual,expected);
  }
  @Test(priority=4,dataProvider="UnSuccessfullLogin",dataProviderClass=DataProviderClass.class,groups = {"login-2"})
  public void verifyUnSuccessFullLogin(String usName,String pwd) {
	  
	  lp=new LoginPage(driver);
	  
	  lp.enterUserName(usName);
	  lp.enterPassword(pwd);
	  lp.clickOnLoginButton();
	  
	  //String expected="  admin Doe";
	  //String actual=lp.getTextOfAdminName();
	  //Assert.assertEquals(actual,expected);
	 /* Boolean actual=lp.isLoginTextDisplayed();
	  Assert.assertTrue(actual); */
	 /* Boolean actual=lp.isLogoDisplayed();
	  Assert.assertTrue(actual);*/
	  String expected="https://qalegend.com/restaurant/login";
	  String actual1=lp.getCurrentUrlOfThePage();
	  Assert.assertEquals(actual1, expected);
  }
}
