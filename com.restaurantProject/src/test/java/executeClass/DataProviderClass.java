package executeClass;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  
	  @DataProvider(name="successfullLogin")
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] {  "admin","password" },    
	    };
	  }
	  
	  @DataProvider(name="UnSuccessfullLogin")
	  public Object[][] dp1() {
	    return new Object[][] {
	      new Object[] {  "admin21","password" },
	      new Object[] {  "admin21","admin12" },
	      new Object[] {  "admin","passwrd" }
	    };
	  }
	}