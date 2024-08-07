package student;

import java.time.Duration;
import java.util.List;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Dashboard {
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
	}



	@Test
	public void dashboard() throws InterruptedException {

		String url = "https://community.medyaan.com/dashboard";
		Thread.sleep(2000);
		String cp = Signin.driver.getCurrentUrl();
		if (url.equals(cp)) {
			System.out.println("URL is Matched");
		}

	}

	@Test(dependsOnMethods = { "dashboard" })
	public void dashboardContent() throws InterruptedException {

		Signin.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));

		WebElement totalFamilyMemberCount = Signin.driver
				.findElement(By.xpath("//div[@id='family_members_count']//p/span"));
		Thread.sleep(3000);
		System.out.println("Total No. of Family Members " + totalFamilyMemberCount.getText());
		Thread.sleep(2000);

		WebElement averageMemberPerFamily = Signin.driver
				.findElement(By.xpath("//div[@id='per_members_count']//p/span"));
		System.out.println("Average Members per Family " + averageMemberPerFamily.getText());
		Thread.sleep(2000);

		WebElement totalVisits = Signin.driver.findElement(By.xpath("//div[@id='members_visits_count']//p/span"));
		System.out.println("Total No. of Visits " + totalVisits.getText());
		Thread.sleep(2000);

		WebElement totalMorbidities = Signin.driver
				.findElement(By.xpath("//div[@id='members_morbidities_count']//p/span"));
		System.out.println("Total No. of Persons with Morbidities " + totalMorbidities.getText());
		Thread.sleep(2000);

		WebElement underTreatmentCount = Signin.driver
				.findElement(By.xpath("//div[@id='members_treatment_count']//p/span"));
		System.out.println("Total No. of Members under Treatment " + underTreatmentCount.getText());
		Thread.sleep(2000);
		
	}

	@Test(dependsOnMethods = { "dashboardContent" })
	public void familyManage() throws InterruptedException {

		List<WebElement> families = Signin.driver
				.findElements(By.xpath("(//div[@id='student-family-card']//div[@class='card-content-container']/h6)"));

		String name="Tamil"; //-------------->Manual
		
		List<String> ele=families.stream().map(s->s.getText()).collect(Collectors.toList());
		if(ele.stream().filter(a->a.equals(name)) != null) {
			
			WebElement manageBtn = Signin.driver
					.findElement(By.xpath("//div[@class='card-content-container']/h6[contains(text(),'" + name
							+ "')]/following-sibling::button"));
			Thread.sleep(2000);
			manageBtn.click();
		}
			
		
	/*	for (int i = 0; i < 15; i++) {
			String val = families.get(i).getText();
			System.out.println(val);
			i = i + 2;

			String name = "Arun"; // ------>Manually should enter the name
			if (val.contains(name)) {
				WebElement manageBtn = Signin.driver
						.findElement(By.xpath("//div[@class='card-content-container']/h6[contains(text(),'" + name
								+ "')]/following-sibling::button"));
				Thread.sleep(2000);
				manageBtn.click();
			}
		}*/
	}

}
