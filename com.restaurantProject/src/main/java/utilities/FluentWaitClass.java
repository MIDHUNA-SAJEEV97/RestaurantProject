package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FluentWaitClass {
	WebDriverWait wait;

	public void elementToBeClickableFluentWait(String locator, WebDriver driver) {

	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(1))
			.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	
	}
}
