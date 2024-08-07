package student;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Morbidity {
	
	@Test
	public void morbidity() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement morbidity = Signin.driver.findElement(
				By.xpath("((//div[@class='v-list v-sheet theme--light v-list--dense v-list--nav'])[2]/div)[7]"));
		Thread.sleep(2000);
		action.moveToElement(morbidity).click().build().perform();
	}
	
	
	@Test(dependsOnMethods = "morbidity")
	public void search() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement search = Signin.driver.findElement(
				By.cssSelector("#hodfamilyquickFilter"));
		Thread.sleep(2000);
		action.moveToElement(search).click().sendKeys("kanagha").build().perform();
	}
	

	
	@Test(dependsOnMethods = "search")
	public void memberNames() throws InterruptedException {
		List<WebElement> getMemberNames = Signin.driver.findElements(
				By.xpath("((//div[@class='ag-body-viewport ag-layout-normal ag-row-no-animation']/div))[1]/div"));
		List<String> names=getMemberNames.stream().map(s->s.getText()).collect(Collectors.toList());
		names.forEach(a->System.out.println(a));

	}
	
	
	@Test(dependsOnMethods = "memberNames")
	public void area() throws InterruptedException  {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement area = Signin.driver.findElement(By.xpath("//div[@id='filter-dropdown']/div/button[text()='Area']"));
		Thread.sleep(2000);
		action.moveToElement(area).click().build().perform();
		String value = "Tambaram";
		Thread.sleep(2000);
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}
	
	@Test(dependsOnMethods = "area")
	public void proficiency() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement proficiency = Signin.driver.findElement(By.xpath("//div[@id='filter-dropdown']/div/button[text()='Proficiency']"));
		Thread.sleep(2000);
		action.moveToElement(proficiency).click().build().perform();
		Thread.sleep(2000);
		String value = "1";
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}
	
	@Test(dependsOnMethods = "proficiency")
	public void morbidityView() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement morbidity = Signin.driver.findElement(By.xpath("//div[@id='filter-dropdown']/div/button[text()='Morbidity']"));
		Thread.sleep(2000);
		action.moveToElement(morbidity).click().build().perform();
		String value = "Anxiety";
		Thread.sleep(3000);
		Signin.driver.findElement(By.xpath("//div[@class='dropdown b-dropdown dropdown-check show btn-group']/ul/div/label[text()='"+value+"']")).click();
	
	}
	
	@Test(dependsOnMethods = "morbidityView")
	public void visitNo() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement visitNo = Signin.driver.findElement(By.xpath("//div[@id='filter-dropdown']/div/button[text()='Visit No']"));
		Thread.sleep(2000);
		action.moveToElement(visitNo).click().build().perform();
		Thread.sleep(2000);
		String value = "1";
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}
	
	@Test(dependsOnMethods = "visitNo")
	public void download() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement download = Signin.driver.findElement(By.xpath("//button[@data-test='download-button']"));
		Thread.sleep(2000);
		action.moveToElement(download).click().build().perform();
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = "download")
	public void viewMorbidityDetails() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement viewBtn = Signin.driver.findElement(By.xpath("(//button[contains(text(),'View')])[1]"));
		Thread.sleep(2000);
		action.moveToElement(viewBtn).click().build().perform();
		Thread.sleep(2000);
		
	}

}
