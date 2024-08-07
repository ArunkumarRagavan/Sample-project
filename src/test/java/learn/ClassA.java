package learn;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClassA {

	public static WebDriver driver;


	 public void ak() throws InterruptedException {
		
		// TODO Auto-generated method stub
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		Thread.sleep(2000);
		driver.get("https://letcode.in/");
		
		


	}

}
