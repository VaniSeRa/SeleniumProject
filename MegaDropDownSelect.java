package Project1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MegaDropDownSelect extends NavigateClass {

	@Test
	public void DropDown() {
		Navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
//		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		
		
		driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[2]/div/span")).click();
		
		driver.findElement(By.id("input-email")).sendKeys("VaniSekar@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("VaniK@12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement options = driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[2]/div/span"));
		Actions optionsObj = new Actions(driver);
		optionsObj.moveToElement(options).perform();
		
		WebElement choose = driver.findElement(By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/voucher']/div/span"));
		Actions chooseObj = new Actions(driver);
		chooseObj.moveToElement(choose).click().build().perform();
		
		WebElement dropdown=driver.findElement(By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=information/information&information_id=4']/div/span"));
		Actions dropdownobj=new Actions(driver);
		dropdownobj.moveToElement(dropdown).perform();
		
		driver.findElement(By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=product/manufacturer/info&manufacturer_id=8']")).click();
		
		driver.findElement(By.xpath("//select[@id='input-limit-212433']/option[text()='100']")).click();
		
		System.out.println("Printing list of items");
		List<WebElement> productsList = driver.findElements(By.xpath("//h4[@class='title']"));
		for (WebElement i : productsList) {
			System.out.println(i.getText());
		}
		
		System.out.println("------------------------------------");
		
		
//		for(int i=0;i<priceList.size();i++) {
//			String list=priceList.get(i).getText();
//			if(list)
//		}
//		
		driver.findElement(By.xpath("//select[@id='input-sort-212434']/option[text()='Price (Low > High)']")).click();
		
		System.out.println("Printing items price list");
		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='price']"));
		
			String LP=priceList.get(1).getText();
			System.out.println(LP);
			
			String HP=priceList.get(priceList.size()-1).getText();
			System.out.println(HP);
		
//		System.out.println("Printing items price list");
//		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='price']"));
//		for(WebElement i : priceList) {
////			List list=driver.findElements(By.xpath("//div[@class='price']")).getText();
//			System.out.println(i.getText());
//		}
		
		
//		driver.findElement(By.xpath("//h4[@class='title']"));
//		browserClose();
	}
}
