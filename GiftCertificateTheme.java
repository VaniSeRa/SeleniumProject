package Project1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GiftCertificateTheme extends NavigateClass {
	
	@Test
	public void ValidateGiftCertificate() throws InterruptedException {
		
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
		
		String voucher=driver.findElement(By.xpath("(//label[@class='col-sm-2 col-form-label'])[5]")).getText();
		System.out.println(voucher);
		

//		List RadioButton = driver.findElements(By.name("voucher_theme_id"));
//        // selecting the Radio buttons by Name
//
//        int Size = RadioButton.size();  
//        for(int i=0;i<Size;i++) {
//        	String val=RadioButton.findElement(By.)
//        }
		
		
		List<WebElement> voucherList = driver.findElements(By.xpath("//div[@class='form-check']"));
		
		if(voucherList.size()==3) {
			System.out.println("Test case passed");
		}
		else {
			System.out.println("Test case failed");
		}
		
		String[] Greetings= { "Birthday","Christmas","General"};
		for(int i=0;i<voucherList.size();i++) {
        	
			if(voucherList.get(i).getText().equals(Greetings[i])) {
				System.out.println(voucherList.get(i).getText());
				System.out.println("Test case passed");
			}
			else {
				System.out.println("Test case failed");
			}
			
        }
		
		browserClose();
		
//		for (WebElement i : voucherList) {
//			System.out.println(i.getText());
//		}
		
		
		
		
		}

}
