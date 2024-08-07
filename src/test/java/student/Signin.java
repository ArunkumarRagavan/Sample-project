package student;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signin {

	public static WebDriver driver;
	
	
	@BeforeTest
	public void LaunchBrowser() {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://community.medyaan.com/");
		
	}
	

	@Test
	public void Sign() throws InterruptedException {
		WebElement userId = driver.findElement(By.name("phone"));
		userId.sendKeys("7094755145");
		WebElement userPassword = driver.findElement(By.name("password"));
		userPassword.sendKeys("Medyaan@123");
		driver.findElement(By.xpath("//div[@class='login-button-box']/button")).click();
	}


}
