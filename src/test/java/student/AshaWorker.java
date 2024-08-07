package student;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AshaWorker {
	
	@Test
	public void ashaWorker() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement clickAshaWorkerbtn = Signin.driver.findElement(
				By.xpath("((//div[@class='v-list v-sheet theme--light v-list--dense v-list--nav'])[2]/div)[5]"));
		Thread.sleep(2000);
		action.moveToElement(clickAshaWorkerbtn).click().build().perform();
	}
	
	@Test(enabled = true)
	public void search() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement searchText = Signin.driver.findElement(By.cssSelector("#quickFilter"));
		Thread.sleep(2000);
		action.moveToElement(searchText).click().sendKeys("tambaram").build().perform();
	}
	
	@Test
	public void getAshawokerNames() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> printAshaWorkerNames= Signin.driver.findElements(By.xpath("//div[@class='ag-pinned-left-cols-container']/div"));
		Thread.sleep(2000);
		
		List<String> name=printAshaWorkerNames.stream().map(n->n.getText()).collect(Collectors.toList());
		name.forEach(r->System.out.println(r));
			
		
		
	}


	
}
