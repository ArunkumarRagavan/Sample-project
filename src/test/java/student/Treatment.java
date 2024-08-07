package student;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Treatment {

	@Test(priority = 0)
	public void treatment() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement treatment = Signin.driver.findElement(
				By.xpath("((//div[@class='v-list v-sheet theme--light v-list--dense v-list--nav'])[2]/div)[6]"));
		Thread.sleep(2000);
		action.moveToElement(treatment).click().build().perform();
	}

	@Test(priority = 1)
	public void search() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement searchText = Signin.driver.findElement(By.cssSelector("#treatmentDetailfilter"));
		Thread.sleep(2000);
		action.moveToElement(searchText).click().sendKeys("AK").build().perform();
	}

	@Test(priority = 2)
	public void viewTreatmentDetails() throws InterruptedException {
		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement viewTreatmentDetails = Signin.driver.findElement(By.cssSelector(
				".ag-center-cols-container div[class='ag-cell-value ag-cell ag-cell-not-inline-editing ag-cell-normal-height action-user'] button"));
		Thread.sleep(3000);
		action.moveToElement(viewTreatmentDetails).click().build().perform();
		List<WebElement> printtreatmentDetails = Signin.driver
				.findElements(By.xpath("//div[@class='d-flex justify-content-between py-1']/following-sibling::tr/td"));
		
		List<String> treatmentDetails=printtreatmentDetails.stream().map(td->td.getText()).collect(Collectors.toList());
		treatmentDetails.forEach(r->System.out.println(r));
		
		Signin.driver.findElement(By.cssSelector("div[class='d-flex justify-content-between py-1'] button")).click();
	}

	
	@Test(priority = 3)
	public void addTreatment() throws InterruptedException, AWTException {

		Actions action = new Actions(Signin.driver);
		Thread.sleep(2000);
		WebElement clickAddTreatmentBtn = Signin.driver
				.findElement(By.cssSelector("button[class='btn add-btn btn-primary collapsed']"));
		Thread.sleep(2000);
		action.moveToElement(clickAddTreatmentBtn).click().build().perform();
		Thread.sleep(2000);
		
		WebElement selectFamilyName = Signin.driver.findElement(By.xpath("(//select[@class='custom-select'])[1]"));
		selectFamilyName.click();
		Thread.sleep(2000);
		List<WebElement> getFamilyMemberNames = Signin.driver.findElements(By.xpath("(//select[@class='custom-select'])[1]/option"));
		String selectedName1 = getFamilyMemberNames.get(2).getText();
		System.out.println("dropdown name is :" + selectedName1);
		Select familyNameDropdown = new Select(selectFamilyName);
		familyNameDropdown.selectByVisibleText(selectedName1);
		Thread.sleep(2000);
		
		WebElement selectMemberName = Signin.driver.findElement(By.xpath("(//select[@class='custom-select'])[2]"));
		selectMemberName.click();
		Thread.sleep(2000);
		List<WebElement> getMemberNames = Signin.driver.findElements(By.xpath("(//select[@class='custom-select'])[2]/option"));
		String selectedName2 = getMemberNames.get(1).getText();
		System.out.println("dropdown name is :" + selectedName2);
		Thread.sleep(2000);
		Select memberNameDropdown = new Select(selectMemberName);
		memberNameDropdown.selectByVisibleText(selectedName2);
		Thread.sleep(2000);

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

	@Test(dependsOnMethods = { "addTreatment" })
	public void submitTreatment() {
		// Submit
		Signin.driver.findElement(By.xpath("//button[contains(@class,'btn submit')]")).click();
		// Pop-up
		String ele = Signin.driver.findElement(By.xpath("//p[text()='Medical data is created successfully']"))
				.getText();
		System.out.println(ele);
	}

	@Test(dependsOnMethods = { "addTreatment" })
	public void addTreatmentCancellation() {

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

}