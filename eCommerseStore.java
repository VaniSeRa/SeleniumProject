package Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class eCommerseStore {
	
	@Test
	public void addFunctionality() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=common/home");
//		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
		
		WebElement option = driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/account'])[2]/div/span"));
		Actions actionObj = new Actions(driver);
		actionObj.moveToElement(option).perform();
		
		WebElement SelOption=driver.findElement(By.xpath("(//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register'])/div/span"));
		actionObj.moveToElement(SelOption).click().build().perform();
		
		driver.findElement(By.id("input-firstname")).sendKeys("Kaviya");
		driver.findElement(By.id("input-lastname")).sendKeys("Sekar");
		driver.findElement(By.id("input-email")).sendKeys("VaniSekar@gmail.com");
		driver.findElement(By.id("input-telephone")).sendKeys("8903768901");
		driver.findElement(By.id("input-password")).sendKeys("VaniK@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("VaniK@12345");
		driver.findElement(By.xpath("//label[@for='input-newsletter-no']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='input-agree']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
}
