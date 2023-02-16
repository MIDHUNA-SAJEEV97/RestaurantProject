package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class GeneralUtilities {

	public void clickElement(WebElement element) {
		element.click();
	}
	public void typeIntoAnElement(WebElement element,String data) {
		element.sendKeys(data);
	}
	public String getTextOfAnElement(WebElement element) {
		return element.getText();
	}
	public boolean isDisplayedMethod(WebElement element) {
		return element.isDisplayed();
	}
	public boolean isEnabledMethod(WebElement element) {
		return element.isEnabled();
	}
	public boolean isSelectedMethod(WebElement element) {
		return element.isSelected();
	}
	public void addThreadSleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	public void scrollToViewAnElement(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}
	public void clickAnElementByJavaScript(WebElement element,WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismisstAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getTextOfAlertMessage(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void sendDataTofAlertBox(WebDriver driver,String data) {
		 driver.switchTo().alert().sendKeys(data);
	}
	
	public void selectByIndexFromDropDown(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);	
	}
	public void selectByVisibleTextFromDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByVisibleText(value);	
	}
	public void selectByValueFromDropDown(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);	
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public void refreshAPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public void clearElement(WebElement element) {
		element.clear();
	}
	
	
}


