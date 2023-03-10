package Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate {
	@Test
	public void selectValue() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://testsheepnz.github.io/panther.html");
		Thread.sleep(3000);
		WebElement missileCount = driver.findElement(By.id("numMissiles"));
		Thread.sleep(3000);
		Select missileSelObj = new Select(missileCount);
		missileSelObj.selectByVisibleText("1");
		Thread.sleep(3000);
		WebElement bombCount = driver.findElement(By.id("numDumbBomb"));
		Select bombSelObj = new Select(bombCount);
		bombSelObj.selectByValue("4");
		driver.findElement(By.id("setEquipmentButton")).click();

		String errorMessage = driver.findElement(By.id("initErrorMsg")).getText();
		System.out.println(errorMessage);

		if (errorMessage.equalsIgnoreCase("Max fuel level of 3000kg")) {
			System.out.println("TestCase Passed");
		} else {
			System.out.println("TestCase Failed");
		}
	}
}
