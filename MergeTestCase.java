package Project1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeTestCase extends NavigateClass{
	@Test(priority = 0)
	public void addFunctionality() throws InterruptedException {
		
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
		driver.findElement(By.id("number1Field")).sendKeys("5.48");
		driver.findElement(By.id("number2Field")).sendKeys("2.35");
		driver.findElement(By.id("calculateButton")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("integerSelect")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("clearButton")).click();
		System.out.println("Test case 1");
		
	}
	@Test(priority = 1)
	public void Naukri() throws InterruptedException {
		Navigate("https://www.naukri.com/");
		String baseWindow=driver.getWindowHandle();
		System.out.println(baseWindow);
		
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String> windowNameList=driver.getWindowHandles();
		System.out.println("Test case 2");
		for(String winName: windowNameList) {
			Thread.sleep(3000);
			if(!winName.equalsIgnoreCase(baseWindow)) {
				System.out.println(winName);
				driver.switchTo().window(winName);
			}
		}
		String value=driver.findElement(By.xpath("//div[@class='sortAndH1Cont']/div[1]/span")).getText();
		System.out.println(value);
		
		String subvalue=driver.findElement(By.xpath("//div[3]/label/p/span[2]")).getText();
		System.out.println(subvalue);
		
		String[] s1= value.split("\\s");
		String s2=s1[4];
		System.out.println(s2);
		
		String s3=subvalue.substring(1, 5);
		System.out.println(s3);
		
		if(s2.equals(s3)) {
			System.out.println("Test case Passed");
		}
		else {
			System.out.println("Test case Failed");
		}	
	}
	
	@Test(priority = 3)
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
		System.out.println("Test case 3");
	}
}
