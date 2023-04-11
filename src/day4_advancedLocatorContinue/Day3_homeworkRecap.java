package day4_advancedLocatorContinue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day3_homeworkRecap {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		faceBookTestCase1();
		faceBookTestCase2();
		indeedTestCase3();
	}
	
	
	public static void faceBookTestCase1() {
		WebDriver driver = new ChromeDriver();
		 //Test case 1 - (Use only Xpath)
	     //go to facebook.com
		driver.get("https://facebook.com");
	     //find the Email or phone number field and type Automation
		driver.findElement(By.xpath("//input[@data-testid='royal_email']")).sendKeys("automation");
	     //find the Password field and type Automation
		driver.findElement(By.xpath("//input[@data-testid='royal_pass']")).sendKeys("automation");
	     //find the Login button and click on it.
		driver.findElement(By.xpath("//button[@data-testid='royal_login_button']")).click();
		
	}
	
	
	public static void faceBookTestCase2() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		 // Test case 2 - (Use only Xpath)
	     // go to facebook.com
		driver.get("https://facebook.com");
	     // find the Create New Account button and click on it
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(1000);
	     // find the FirstName,  LastName, Email and Password fields and type Automation
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("automation");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("automation");
	     // find the Sign Up button and click on it.
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		
	}
	
	
	public static void indeedTestCase3() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//Test case 3 - (Use only Xpath) 
		//1. go to indeed.com
		driver.get("https://indeed.com");
		//2. get the current URL and store it in a variable called homeURL.
		String homeURL = driver.getCurrentUrl();
		//3. get the website title and store it in a variable homeTitle.
		String homeTitle = driver.getTitle();
		//4. find the input field for WHAT and type SDET
		String jobSearchName = "SDET";
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(jobSearchName);
		//5. find the input field for where, clear the field first and type washington DC
		WebElement whereField = driver.findElement(By.xpath("//input[@name='l']"));
//		whereField.sendKeys(Keys.COMMAND + "a");  // selects all the text in the box
//		whereField.sendKeys(Keys.DELETE);  // deletes all selected text.
//		whereField.sendKeys("Washington, DC");
		
		// another way of deleting the text in a box by looping
		// getting the pre existing text in the box using getAttribute method
		String locationText = whereField.getAttribute("value");
		for (int i = 0; i < locationText.length(); i++) {
			whereField.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(500);
		}
		whereField.sendKeys("Washington, DC");
		//6. find the Search button and click on it.
		driver.findElement(By.xpath("//button[@class='yosegi-InlineWhatWhere-primaryButton']")).click();
		Thread.sleep(1000);
		//get the current URL and store it as a variable searchURL.
		String searchURL = driver.getCurrentUrl();
		System.out.println(searchURL);
		//7. get the website title and store it in a variable searchTitle.
		String searchTitle = driver.getTitle();
		System.out.println(searchTitle);
		//8. verify that searchURL does not equal to homeURL and contains the search criteria.
		//9. verify that searchTitle does not equal to homeTitle and has the search criteria.
		//10. Get Text of the JobsInLocation field, store it in a variable, 
		//11. then verify if it's equal to your search criteria.
	}

}
