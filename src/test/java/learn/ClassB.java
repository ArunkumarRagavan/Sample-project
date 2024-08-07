package learn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ClassB extends ClassA {

	public void val() throws InterruptedException {

		// TODO Auto-generated method stub
		WebDriver driver =ClassA.driver;
		driver.findElement(By.cssSelector("a[class='button is-link']")).click();
		Thread.sleep(2000);
		
	}

	public static void main(String[] args) throws InterruptedException {
		ClassB obj = new ClassB();
		obj.ak();
		obj.val();
	}

}
