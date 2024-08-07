package student;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FamilyMember {
	
	
	@Test(priority = 0)
	public void familyMember() throws InterruptedException {

		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement familyMemberBtn = Signin.driver
				.findElement(By.xpath("(//div[@class='custom v-list-item v-list-item--link theme--light'])[2]"));
		action.moveToElement(familyMemberBtn).click().build().perform();
		Thread.sleep(2000);
		WebElement familyDashboardBtn = Signin.driver.findElement(By.cssSelector("#hodmemberquickFilter"));
		action.moveToElement(familyDashboardBtn).build().perform();
		Thread.sleep(5000);

	}

	@Test(dependsOnMethods = "familyMember")
	public void search() throws InterruptedException {
		String name = "Ribha";
		WebElement familyDashboardBtn = Signin.driver.findElement(By.cssSelector("#hodmemberquickFilter"));
		familyDashboardBtn.sendKeys(name);

		List<WebElement> printMembersName = Signin.driver
				.findElements(By.xpath("//div[@class='ag-pinned-left-cols-container']/div//div/p"));
		System.out.println(printMembersName.size());
		Thread.sleep(2000);

	}

	@Test(enabled = false)
	public void download() throws InterruptedException {

		WebElement download = Signin.driver.findElement(By.xpath("//button[@data-test='download-button']"));
		download.click();

	}

	@Test
	public void viewProfile() throws InterruptedException {

		Signin.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		Signin.driver.findElement(By.xpath("(//button[@class='btn common-view-edit-btn-css btn-secondary'])[1]"))
				.click();

		// Edit
		Signin.driver.findElement(By.xpath("//button[@class='btn editmemberbtn pl-2 btn-secondary']")).click();

		WebElement memName = Signin.driver.findElement(By.cssSelector("#infomembername>div>div>input"));
		memName.clear();
		Thread.sleep(2000);
		memName.sendKeys("Ar");

		WebElement age = Signin.driver.findElement(By.cssSelector("#infoage>div>div>input"));
		age.clear();
		Thread.sleep(2000);
		age.sendKeys("24");

		WebElement gender = Signin.driver
				.findElement(By.xpath("//div[@id='infosex']//Select[@class='custom-select profile-input']"));
		Select genderDropdown = new Select(gender);
		genderDropdown.selectByVisibleText("Female");

		WebElement maritalStatus = Signin.driver
				.findElement(By.xpath("//div[@id='infomaritalstatus']//Select[@class='custom-select profile-input']"));
		Select maritalStatusDropdown = new Select(maritalStatus);
		maritalStatusDropdown.selectByVisibleText("Single");

		WebElement relationshipToHOF = Signin.driver.findElement(
				By.xpath("//div[@id='inforelationship_to_hof']//Select[@class='custom-select profile-input']"));
		Select relationshipToHOFDropdown = new Select(relationshipToHOF);
		relationshipToHOFDropdown.selectByVisibleText("Mother");

		WebElement educationalQualification = Signin.driver
				.findElement(By.cssSelector("#infoeducationalqualification>div>div>input"));
		educationalQualification.clear();
		Thread.sleep(2000);
		educationalQualification.sendKeys("Testings");

		WebElement bloodGroup = Signin.driver
				.findElement(By.xpath("//div[@id='infobloodgroup']//Select[@class='custom-select profile-input']"));
		Select bloodGroupDropdown = new Select(bloodGroup);
		bloodGroupDropdown.selectByVisibleText("A+");

		WebElement status = Signin.driver
				.findElement(By.xpath("//div[@id='infostatus']//Select[@class='custom-select profile-input']"));
		Select statusDropdown = new Select(status);
		statusDropdown.selectByVisibleText("Active");
		/*
		 * Signin.driver.findElement(By.
		 * xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"
		 * )) .click(); Thread.sleep(2000);
		 */
		// save
		Signin.driver.findElement(By.xpath("//button[@class='btn add_familymember_button  ml-4 btn-secondary']")).click();
		Thread.sleep(2000);
		// yes
		Signin.driver.findElement(By.cssSelector(".el-message-box__btns>button~button")).click();
		Thread.sleep(2000);
		// no
		// Signin.driver.findElement(By.cssSelector(".el-message-box__btns>button")).click();

		List<WebElement> printMentorDetails = Signin.driver.findElements(By.xpath("//h4/following-sibling::table/tr"));
		List<String> ele1=printMentorDetails.stream().map(s->s.getText()).collect(Collectors.toList());
		ele1.forEach(a->System.out.println("Mentor details :"+a));

		List<WebElement> printVisitDetails = Signin.driver.findElements(By.cssSelector(".visit-details~table>tr"));
		List<String> ele2=printVisitDetails.stream().map(s->s.getText()).collect(Collectors.toList());
		ele2.forEach(a->System.out.println("Visit details :"+a));
		
		
		WebElement ele=Signin.driver.findElement(By.cssSelector("#sidebar-profile-edit button[class='close text-dark']"));
	    WebDriverWait wait=new WebDriverWait(Signin.driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(ele)).click();

	
	}
	

	@Test(dependsOnMethods = "viewProfile")
	public void areaFiltering() throws InterruptedException {
		WebElement area = Signin.driver.findElement(By.xpath("//button[text()='Area']/.."));
		Thread.sleep(2000);
	    area.click();
		List<String> ele = new ArrayList<String>();
		ele.add(0, "tambaram");
		ele.add(1, "Kolathur");
		List<WebElement> ele1 = Signin.driver
				.findElements(By.xpath("//div[@class='custom-control custom-checkbox']/label"));
		for (int j = 0; j < ele.size(); j++) {
			for (int k = 0; k < ele1.size(); k++) {
				String comp1 = ele.get(j);
				String comp2 = ele1.get(k).getText();
				if (comp1.equalsIgnoreCase(comp2)) {
					String val = ele1.get(k).getText();
					Thread.sleep(2000);
					Signin.driver.findElement(By.cssSelector("input[value='" + val + "']~label")).click();
				}
			}
		}

	}

}
