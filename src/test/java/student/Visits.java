package student;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v118.css.model.Value;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Visits {

	@Test
	public void visits() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement clickVisitbtn = Signin.driver.findElement(
				By.xpath("((//div[@class='v-list v-sheet theme--light v-list--dense v-list--nav'])[2]/div)[4]"));
		Thread.sleep(2000);
		action.moveToElement(clickVisitbtn).click().build().perform();
	}

	@Test(dependsOnMethods = "visits")
	public void vistsStatus() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement visitStatus = Signin.driver.findElement(By.xpath("(//div[@id='filter-dropdown']/div)[3]"));
		Thread.sleep(2000);
		action.moveToElement(visitStatus).click().build().perform();
		Thread.sleep(2000);
		String value = "submitted"; //-------------->Manual
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}

	@Test(dependsOnMethods = "vistsStatus")
	public void visitNo() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement vistsNo = Signin.driver.findElement(By.xpath("(//div[@id='filter-dropdown']/div)[2]"));
		Thread.sleep(2000);
		action.moveToElement(vistsNo).click().build().perform();
		Thread.sleep(2000);
		String value = "1"; //-------------->Manual
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}

	@Test(dependsOnMethods = "visitNo")
	public void visitProficiency() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement visitProficiency = Signin.driver.findElement(By.xpath("(//div[@id='filter-dropdown']/div)[1]"));
		Thread.sleep(2000);
		action.moveToElement(visitProficiency).click().build().perform();
		Thread.sleep(2000);
		String value = "3";  //-------------->Manual
		Signin.driver.findElement(By.xpath("//ul[@class='dropdown-menu show']//label[text()='" + value + "']")).click();

	}

	@Test(dependsOnMethods = "visitProficiency")
	public void downloadVisits() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		WebElement downloadBtn = Signin.driver
				.findElement(By.cssSelector("div[class='search-grid gridstyle col-md-12 col-lg-6 col-12'] button"));
		Thread.sleep(2000);
		action.moveToElement(downloadBtn).click().build().perform();
	}

	@Test(enabled = false)
	public void search() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		WebElement searchText = Signin.driver.findElement(By.cssSelector("#hodvisitquickFilter"));
		Thread.sleep(2000);
		action.moveToElement(searchText).click().sendKeys("tambaram").build().perform();
	}

	@Test(dependsOnMethods = "downloadVisits")
	public void getFamilyHeads() {
		List<WebElement> printFamilyHeadNames = Signin.driver
				.findElements(By.cssSelector(".ag-center-cols-container div[class='custom-cell-icon-container']"));
		
		List<String> ele=printFamilyHeadNames.stream().map(s->s.getText()).collect(Collectors.toList());
		ele.forEach(r->System.out.println("Family names are :"+r));
		
	}
	
    @Test(dependsOnMethods = "getFamilyHeads")
	public void viewVist() {
    	String name="Ribha";  //-------------->Manual
    	Signin.driver.findElement(By.xpath("(//p[text()='"+name+" ']/../../following-sibling::div)[6]/div/button")).click();
    	
			
    	
		}

	

}
