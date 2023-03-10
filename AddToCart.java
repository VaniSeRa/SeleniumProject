package Project1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddToCart extends NavigateClass {
	int IPrice,FPrice;
	@Test
	public void Cart() throws InterruptedException {
	Navigate("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
//	driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

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
//	driver.findElement(By.xpath("//select[@id='input-sort-212434']/option[text()='Price (Low > High)']")).click();
	
	driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=product/product&manufacturer_id=8&product_id=34&limit=100'])[1]")).click();
	driver.findElement(By.xpath("(//button[@title='Add to Cart'])[2]")).click();
	
	
	driver.findElement(By.xpath("(//div[@class='icon svg-icon'])[17]")).click();
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=checkout/cart']")).click();
	
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).clear();
	driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("4");
	driver.findElement(By.xpath("//i[@class='fas fa-sync-alt']")).click();
	
	String unitPrice=driver.findElement(By.xpath("(//td[@class='text-right'])[6]")).getText();
	System.out.println(unitPrice);
	String[] s= unitPrice.split("\\.");
	String s1=s[0];
//	System.out.println(s1);
	String s2=s1.substring(1,4);
//	System.out.println(s2);
	
	IPrice=Integer.parseInt(s2);
	System.out.println("Price of 1 prod: "+IPrice);
	
	String finalPrice=driver.findElement(By.xpath("(//td[@class='text-right'])[7]")).getText();
//	System.out.println(finalPrice);
	String[] ss= finalPrice.split("\\.");
	String s3=ss[0];
	String s4=s3.substring(1,4);
//	System.out.println(s4);
	
	FPrice=Integer.parseInt(s4);
	System.out.println("Price of 4 prods: "+FPrice);
	
	if((IPrice*4)==FPrice) {
		System.out.println("Test case passed");
		
	}else {
		System.out.println("Test case failed");
	}
	
	driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=checkout/checkout'])[2]")).click();
	
	driver.findElement(By.id("input-telephone")).sendKeys("7890654324");
	driver.findElement(By.id("input-payment-firstname")).sendKeys("Vani");
	driver.findElement(By.id("input-payment-lastname")).sendKeys("Sekar");
	driver.findElement(By.id("input-payment-company")).sendKeys("SSG");
	driver.findElement(By.id("input-payment-address-1")).sendKeys("57, AAA st, KK Nagar, Chennai");
	driver.findElement(By.id("input-payment-city")).sendKeys("Chennai");
	driver.findElement(By.id("input-payment-postcode")).sendKeys("600009");
	driver.findElement(By.xpath("//select[@id='input-payment-country']/option[text()='India']")).click();
	
	driver.findElement(By.xpath("//select[@id='input-payment-zone']/option[text()='Tamil Nadu']")).click();
	
	driver.findElement(By.xpath("//label[@for='input-shipping-address-same']")).click();
	driver.findElement(By.xpath("//label[@for='input-payment-method-cod']")).click();
	
	driver.findElement(By.xpath("//label[@for='input-agree']")).click();
	
	driver.findElement(By.xpath("//button[@id='button-save']")).click();
}
}
