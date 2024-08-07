package student;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FamilyOverallView {

	@Test(priority = 0)
	public void addMember() throws InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(Signin.driver, Duration.ofSeconds(20));
		WebElement addMemberBtn = Signin.driver
				.findElement(By.cssSelector("div[class='d-flex justify-content-between align-items-center mt-2 mb-1']>button"));
		wait.until(ExpectedConditions.elementToBeClickable(addMemberBtn)).click();
		Thread.sleep(2000);
		

		WebElement memberName = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/input)[1]"));
		memberName.sendKeys("Arun");
		Thread.sleep(2000);

		WebElement memberAge = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/input)[2]"));
		memberAge.sendKeys("25");
		Thread.sleep(2000);

		WebElement gender = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/select)[1]"));
		Select selectgender = new Select(gender);
		selectgender.selectByVisibleText("Male");
		Thread.sleep(2000);

		WebElement maritalStatus = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/select)[2]"));
		Select selectMaritalStatus = new Select(maritalStatus);
		selectMaritalStatus.selectByVisibleText("Single");
		Thread.sleep(2000);

		WebElement relationship = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/select)[3]"));
		Select selectRelationship = new Select(relationship);
		selectRelationship.selectByVisibleText("Brother");
		Thread.sleep(2000);

		WebElement memberQualification = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/input)[3]"));
		memberQualification.sendKeys("SoftwareTester");
		Thread.sleep(2000);

		WebElement bloodGroup = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/select)[4]"));
		Select selectBloodGroup = new Select(bloodGroup);
		selectBloodGroup.selectByVisibleText("O+");
		Thread.sleep(2000);

		WebElement status = Signin.driver.findElement(By.xpath("(//div[@class='val-select']/select)[5]"));
		Select selectStatus = new Select(status);
		selectStatus.selectByVisibleText("Temporarily inactive");
		Thread.sleep(2000);

	}

	@Test(priority = 1)
	public void submitProfile() {

		// Submit
		Signin.driver
				.findElement(
						By.xpath("//div[@class='row m-0 bottom_button']/button[contains(@class,'add_familymember')]"))
				.click();
		// Yes
		Signin.driver.findElement(By.xpath("//button[contains(@class,'small el-button--primary')]")).click();
		// No
	//	Signin.driver
		//		.findElement(
		//				By.xpath("//button[contains(@class,'small el-button--primary')]/preceding-sibling::button"))
			//	.click();

	}

	@Test(enabled = false)
	public void addMemberCancellation() {

		// Cancel
		Signin.driver
				.findElement(By.xpath(
						"//div[@class='row m-0 bottom_button']/button[contains(@class,'cancel_familymember_button')]"))
				.click();
		// Yes
		Signin.driver.findElement(By.xpath("//button[contains(@class,'small el-button--primary')]")).click();
		// No
		Signin.driver
				.findElement(
						By.xpath("//button[contains(@class,'small el-button--primary')]/preceding-sibling::button"))
				.click();

	}
	
	@Test(priority = 2)
	public void verifyFamilyMembers(){
		List<WebElement> totalFamilyMemberNames=Signin.driver.findElements(By.xpath
				("//div[@class='d-flex  align-items-center']/h6[@class='mb-0 content-text']"));
		
		List<String> ele=totalFamilyMemberNames.stream().map(s->s.getText()).collect(Collectors.toList());
		ele.forEach(r->System.out.println("Family Member Details: "+r));
		
	}

	@Test(priority = 3)
	public void addTreatment() throws InterruptedException, AWTException {

		WebElement addTreatmentBtn = Signin.driver
				.findElement(By.xpath("(//div[@class='right-long-section']//button)[1]"));
		WebDriverWait wait = new WebDriverWait(Signin.driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(addTreatmentBtn)).click();

		WebElement selectName = Signin.driver.findElement(By.cssSelector(".custom-select"));
		selectName.click();
		List<WebElement> getFamilMemberNames = Signin.driver.findElements(By.cssSelector(".custom-select>option"));
		String selectedName = getFamilMemberNames.get(3).getText();
		System.out.println("dropdown name is :" + selectedName);

		Select name = new Select(selectName);
		name.selectByVisibleText(selectedName);

		Signin.driver.findElement(By.xpath("//label[text()='OP/IP Number ']/following-sibling::input"))
				.sendKeys("12321");
		Signin.driver.findElement(By.xpath("//label[text()='Complaints ']/following-sibling::textarea "))
				.sendKeys("fever");
		Signin.driver.findElement(By.xpath("//label[text()='Diagnosis']/following-sibling::textarea "))
				.sendKeys("fever");
		Signin.driver.findElement(By.xpath("//label[text()='Treatment ']/following-sibling::textarea "))
				.sendKeys("follow the medicine");
		Signin.driver.findElement(By.xpath("//label[text()='Remarks']/following-sibling::textarea ")).sendKeys("nil");
		Signin.driver.findElement(By.xpath("//label[text()='Govt Schemes']/following-sibling::input "))
				.sendKeys("scheme");
		Thread.sleep(2000);

		Signin.driver.findElement(By.cssSelector(".add-image-placeholder")).click();
		Thread.sleep(3000);
		WebElement ele = Signin.driver.findElement(By.cssSelector(".dropzone-custom-content"));
		ele.click();

		Robot robot = new Robot();

		StringSelection file = new StringSelection(
				"C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_P_Profile_11.png");
		Thread.sleep(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

	@Test(priority = 4) 
	public void submitTreatment() {
		  // Submit
		  Signin.driver.findElement(By.xpath("//button[contains(@class,'btn submit')]")).click();
		  // Pop-up 
		  String ele = Signin.driver.findElement(By.xpath("//p[text()='Medical data is created successfully']")).getText();
		  System.out.println(ele); 
		  }

	@Test(enabled = false) 
	public void  addTreatmentCancellation() {
		 
		// Cancel
		Signin.driver.findElement(By.xpath("//button[contains(@class,'btn back')]")).click();
		// Yes
		Signin.driver.findElement(By.xpath("//button[contains(@class,'small el-button--primary')]")).click();
		// No
		Signin.driver
				.findElement(
						By.xpath("//button[contains(@class,'small el-button--primary')]/preceding-sibling::button"))
				.click();

	}
	
	
	@Test(priority = 5)
	public void treatmentDetails(){
		List<WebElement> OverallTreatmentDetails=Signin.driver.findElements(By.xpath
				("//h6[@class='desc-text']"));
		
		List<String> ele=OverallTreatmentDetails.stream().map(s->s.getText()).collect(Collectors.toList());
		ele.forEach(r->System.out.println("Treatment Details: "+r));
		
	}
	
	

	@Test(priority = 6)
	public void Visits() throws InterruptedException{
		JavascriptExecutor js=(JavascriptExecutor) Signin.driver;
		Thread.sleep(2000);
		WebElement scrollVisit= Signin.driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-primary']"));
		js.executeScript("arguments[0].scrollIntoView();", scrollVisit);
		scrollVisit.click();
		Signin.driver.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-primary']/following-sibling::ul")).click();
		List<WebElement> visitCount= Signin.driver.findElements(By.xpath("//li[@role='presentation']/a[contains(text(),'Visit')]"));
		System.out.println(visitCount.size());
		
		for(int i=0; i<visitCount.size();i++)
		{
			visitCount.get(i).click();
			Thread.sleep(3000);
			System.out.println( Signin.driver.findElement(By.cssSelector("#comment__BV_tab_container_")).getText());
			Thread.sleep(3000);
           
		}
		Actions action=new Actions(Signin.driver);
		WebElement dashboardIcon=Signin.driver.findElement(By.xpath("//div[@class='custom v-list-item v-list-item--link theme--light'][1]"));
		action.moveToElement(dashboardIcon).click().build().perform();
	
		
		String name="Ribha"; //-----------------Manual

		WebElement ele= Signin.driver.findElement(By.xpath("//div[@id='student-family-card']//div[@class='card-content-container']/h6[contains(text(),'"+name+"')]/following-sibling::h6/span"));
		Thread.sleep(3000);
		WebElement move=Signin.driver.findElement(By.cssSelector("#student-chart-dashboard"));
		Thread.sleep(2000);
		action.moveToElement(move).click().build().perform();
		
		
	     if(ele.getText().contains("Ready for new log"))
	     {
	    	 Thread.sleep(2000);
	    	 Signin.driver.findElement(By.xpath("//div[@class='card-content-container']/h6[contains(text(),'"+name+"')]/following-sibling::button")).click();
	     }
	     else {
	    	 System.out.println("status is pending for approval or Re-Submission is Needed");
	     }
	
	}
	@Test(dependsOnMethods = "Visits")
	public void createNewVist() throws InterruptedException, AWTException {
		
		Signin.driver.findElement(By.cssSelector(".button-container>button")).click();
		
		List<WebElement> selectMember=Signin.driver.findElements(By.xpath("//ul[@class='nav nav-tabs']/li//p"));
		String name="Arun";
		for(int i=0; i<selectMember.size();i++)
		{
		if(selectMember.get(i).getText().contains(name)){
			Signin.driver.findElement(By.xpath("//ul[@class='nav nav-tabs']/li//p[contains(text(),'"+name+"')]")).click();
		
	}
	}
		WebElement availability= Signin.driver.findElement(By.xpath("//label[contains(text(),'Availability')]/following-sibling::div/select"));
		Select d1=new Select(availability);
		d1.selectByVisibleText("Available");
		
		Signin.driver.findElement(By.cssSelector("#date-picker")).click();
		Thread.sleep(2000);
		Signin.driver.findElement(By.xpath("//span[@class='el-date-picker__header-label']")).click();
		Thread.sleep(2000);

		String date="2";
		String year="2024";
		String month="Jun";
		Actions action=new Actions(Signin.driver);
		WebElement selectYear=Signin.driver.findElement(By.xpath("//td/a[text()='"+year+"']"));
		action.moveToElement(selectYear).click().build().perform();
		Thread.sleep(2000);
		WebElement selectMonth=Signin.driver.findElement(By.xpath("//td/div/a[text()='"+month+"']"));
		action.moveToElement(selectMonth).click().build().perform();
		Thread.sleep(2000);
		WebElement selectdate=Signin.driver.findElement(By.xpath("//td/div/span[text()[normalize-space()='"+date+"']]"));
		action.moveToElement(selectdate).click().build().perform();
		Thread.sleep(2000);

	/*	
		WebElement previousYear=Signin.driver.findElement(By.xpath("//div[@class='el-date-picker__header']/button[@aria-label='Previous Year']"));
		WebElement nextYear=Signin.driver.findElement(By.xpath("//div[@class='el-date-picker__header']/button[@aria-label='Previous Year']"));
		WebElement previousMonth=Signin.driver.findElement(By.xpath("//div[@class='el-date-picker__header']/button[@aria-label='Previous Month']"));
		WebElement nextMonth=Signin.driver.findElement(By.xpath("//div[@class='el-date-picker__header']/button[@aria-label='Next Month']"));
*/
				
		Signin.driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[1]")).click();
		Thread.sleep(2000);
		
		String dietaryHabits="Vegetarian";
		Signin.driver.findElement(By.xpath("//li[@class='multiselect__element']/span/span[text()='"+dietaryHabits+"']")).click();
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Occupation");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]")).click();
		Thread.sleep(2000);
		
		String personalHistory="Tobacco smoking";
		Signin.driver.findElement(By.xpath("//li[@class='multiselect__element']/span/span[text()='"+personalHistory+"']")).click();
		Thread.sleep(2000);
	
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("180");
		Thread.sleep(2000);

		Signin.driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("80");
		Thread.sleep(2000);

		Signin.driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("60");
		Thread.sleep(2000);

		Signin.driver.findElement(By.xpath("(//input[@type='text'])[8]")).sendKeys("65");
		Thread.sleep(2000);

		Signin.driver.findElement(By.xpath("(//input[@type='text'])[9]")).sendKeys("5");
		Thread.sleep(2000);

		Signin.driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("6");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[11]")).sendKeys("7");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys("chief complaints");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("8");
		Thread.sleep(2000);
		

		WebElement urineProtein= Signin.driver.findElement(By.cssSelector("#infourine_protein>div>select"));
		Select d2=new Select(urineProtein);
		d2.selectByVisibleText("1+");
		Thread.sleep(2000);

		WebElement urineSugar= Signin.driver.findElement(By.cssSelector("#infourine_sugar>div>select"));
		Select d3=new Select(urineSugar);
		d3.selectByVisibleText("Trace");
		Thread.sleep(2000);
		
		WebElement scroll= Signin.driver.findElement(By.xpath("//label[contains(text(),' GPE:Conscious & Oriented, Afebri')]"));
		action.scrollToElement(scroll).build().perform();
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[14]")).sendKeys("90");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys("General Hygine");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[16]")).sendKeys("oral Hygine");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//input[@type='text'])[17]")).sendKeys("Immunization Status");
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]")).click();
		Thread.sleep(2000);
		
		Signin.driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[3]")).click();
		Thread.sleep(2000);
		
		String Morbidity="Acute pancreatitis";
		Signin.driver.findElement(By.xpath("//li[@class='multiselect__element']/span/span[text()='"+Morbidity+"']")).click();
		Thread.sleep(2000);
		
		WebElement Contracepation= Signin.driver.findElement(By.cssSelector("#infocontracepation>div>select"));
		Select d4=new Select(Contracepation);
		d4.selectByVisibleText("CombinedPill");
		
		Signin.driver.findElement(By.xpath("//textarea[@wrap='soft']")).sendKeys("Testing on Notes field");
		
		action.moveToElement(Signin.driver.findElement(By.cssSelector(".add-image-placeholder"))).click().build().perform();
		
		Signin.driver.findElement(By.cssSelector("#multipleFileDropbox")).click();
		
		Robot robot=new Robot();
		
		StringSelection file = new StringSelection(
				"C:\\Users\\ArunkumarRagavan\\Pictures\\Screenshots\\Def_P_Profile_11.png");
		Thread.sleep(3000);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(file, null);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(3000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		
		
		//Save
		Signin.driver.findElement(By.xpath("(//div[@class='mobileview col-12 text-center']/button)[8]")).click();
		Thread.sleep(2000);
		//Cancel
//		Signin.driver.findElement(By.xpath("(//div[@class='mobileview col-12 text-center']/button)[4]")).click();
		Thread.sleep(2000);
		//Save&submit
		Signin.driver.findElement(By.xpath("(//div[@class='mobileview col-12 text-center']/button)[9]")).click();
		



	}

}
