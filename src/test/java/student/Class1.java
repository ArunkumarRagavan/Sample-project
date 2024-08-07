package student;

import org.testng.annotations.Test;

public class Class1 {
	@Test
	public void dashboard() throws InterruptedException {

		String url = "https://community.medyaan.com/dashboard";
		Thread.sleep(2000);
		String cp = Signin.driver.getCurrentUrl();
		if (url.equals(cp)) {
			System.out.println("URL is Matched");
		}

	}}
