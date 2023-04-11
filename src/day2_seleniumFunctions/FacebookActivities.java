package day2_seleniumFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookActivities {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		FacebookActivities fb = new FacebookActivities();
		fb.testcase1();
		fb.testcase2();
		fb.getTextPractice();
	}
	
	
	public void testcase1() {
		
	WebDriver driver = new ChromeDriver();
     // go to facebook.com
		driver.get("https://facebook.com");
     // find the Email or phone number field and type Automation
		driver.findElement(By.name("email")).sendKeys("automation");
     // find the Password field and type Automation
		driver.findElement(By.name("pass")).sendKeys("automation");
     // find the Login button and click on it.
		driver.findElement(By.name("login")).click();
		
		driver.close();
	}
	
	public void testcase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
	 //  go to facebook.com
		driver.get("https://facebook.com");
	 // find the Create New Account button and click on it
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(1000);
	 // find the FirstName,  LastName, Email and Password fields and type Automation
		driver.findElement(By.name("firstname")).sendKeys("automation");
		driver.findElement(By.name("lastname")).sendKeys("automation");
		driver.findElement(By.name("reg_email__")).sendKeys("automation");
		driver.findElement(By.name("reg_passwd__")).sendKeys("automation");
	 // find the Sign Up button and click on it.
		driver.findElement(By.name("websubmit")).click();
	    driver.close();
	    
	}
	
	
	public void getTextPractice() {
		WebDriver driver = new ChromeDriver();
		 //  go to facebook.com
			driver.get("https://facebook.com");
		 // find the Login button and get text of it
			String loginText = driver.findElement(By.name("login")).getText();
			System.out.println("Log in button text is: " + loginText);
		 // verify that it is Log In
			if (loginText.equals("Log In")) {
				System.out.println("Test Pass!");
			} else {
				System.out.println("Test Fail! Text doesn't equal");
			}
			driver.quit();
	}
	
}
