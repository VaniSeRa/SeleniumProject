package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Scroll extends NavigateClass{

	@Test
	public void scrollToSpecficElement() throws InterruptedException {
		Navigate("https://www.amazon.in/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement sectionToview = driver.findElement(By.xpath("//a[text()='See all deals']"));
		// for page scrolldown to specific element
		jse.executeScript("arguments[0]. scrollIntoView(false);", sectionToview);

		WebElement clickAllDetails = driver.findElement(By.linkText("See all deals"));
		// for click
		jse.executeScript("arguments[0].click();", clickAllDetails);
	}	
	
}
