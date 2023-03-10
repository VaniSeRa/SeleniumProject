package Project1;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NavigateToWindow extends NavigateClass{
	
	@Test
	public void Naukri() throws InterruptedException {
		Navigate("https://www.naukri.com/");
		String baseWindow=driver.getWindowHandle();
		System.out.println(baseWindow);
		
		driver.findElement(By.xpath("//span[@title='Remote']")).click();
		Set<String> windowNameList=driver.getWindowHandles();
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
}
