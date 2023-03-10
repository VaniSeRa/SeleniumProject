package Project1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Alert extends NavigateClass{
	
	@Test
	public void Alertmethod() throws InterruptedException {
		Navigate("https://letcode.in/alert");
//		driver.findElement(By.id("accept")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();
//		
//		driver.findElement(By.id("confirm")).click();
//		Thread.sleep(1000);
//		driver.switchTo().alert().accept();
//		
		driver.findElement(By.id("prompt")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().sendKeys("Prompt alert");
		driver.switchTo().alert().accept();
		String text = driver.findElement(By.id("myName")).getText();
		System.out.println(text);
		
		driver.findElement(By.id("modern")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("// button[@aria-label='close']")).click();
	}

}
