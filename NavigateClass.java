package Project1;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateClass {
	public RemoteWebDriver driver;
	
	public void Navigate(String link) {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.manage().window().maximize();
	driver.get(link);
	}
	
	public void browserClose() {
		driver.quit();
	}
	
//	@AfterMethod
//	public void browserClose() {
//		driver.quit();
//	}
//	@BeforeMethod
//	public void Navigate() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//		driver.manage().window().maximize();
//	}
}
