package Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_XYZ_login {
	@Test
	public void selectName() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/customer");
		WebElement Name=driver.findElement(By.id("userSelect"));
		Select nameObj=new Select(Name);
		nameObj.selectByVisibleText("Hermoine Granger");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@Type='submit']")).click();
		
		String welcomeMessage = driver.findElement(By.xpath("//span[@class='fontBig ng-binding']")).getText();
		System.out.println(welcomeMessage);

		if (welcomeMessage.equalsIgnoreCase("Hermoine Granger")) {
			System.out.println("TestCase Passed");
		} else {
			System.out.println("TestCase Failed");
		}
	}

}
