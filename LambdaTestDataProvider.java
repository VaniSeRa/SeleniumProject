package Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LambdaTestDataProvider extends GenericClass {

	@DataProvider(name = "TestData")
	public Object[][] getTestdata(){
		String[][] member = new String[3][6];
		member[0][0] = "Firstname";
		member[1][0] = "Kavi";
		member[2][0] = "Vani";
		
		member[0][1] = "Lastname";
		member[1][1] = "Karthi";
		member[2][1] = "Sera";
		
		member[0][2] = "Email";
		member[1][2] = "Abc@gmail.com";
		member[2][2] = "Cde@gmail.com";
		
		member[0][3] = "Phone";
		member[1][3] = "7890654323";
		member[2][3] = "6543789020";
								
		member[0][4] = "Password";
		member[1][4] = "Asdfg#12345";
		member[2][4] = "Bnmjklo@09876";
		
		member[0][5] = "ConfPassword";
		member[1][5] = "Asdfg#12345";
		member[2][5] = "Bnmjklo@09876";
		
		return member;
	}	
	
	@Test(dataProvider = "TestData")
	public void addFunctionality(String Fname, String Lname, String Email, String Phone, String Pass, String PassConf) throws InterruptedException {
		
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
//		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		
		WebElement option = driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[2]/div/span"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(option).perform();
		
		WebElement SelOption=driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register'])/div/span"));
		actionObj.moveToElement(SelOption).click().build().perform();
		
		driver.findElement(By.id("input-firstname")).sendKeys(Fname);
		driver.findElement(By.id("input-lastname")).sendKeys(Lname);
		driver.findElement(By.id("input-email")).sendKeys(Email);
		driver.findElement(By.id("input-telephone")).sendKeys(Phone);
		driver.findElement(By.id("input-password")).sendKeys(Pass);
		driver.findElement(By.id("input-confirm")).sendKeys(PassConf);
		driver.findElement(By.xpath("//label[@for='input-newsletter-no']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
}

