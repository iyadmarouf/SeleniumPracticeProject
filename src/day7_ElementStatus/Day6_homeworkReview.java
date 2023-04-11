package day7_ElementStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day6_homeworkReview {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		//radioButtonHomework();
		//checkboxHomework();
		amazonHomework();
	}
	
	public static void radioButtonHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//go to http://practice.primetech-apps.com/practice/radio-button
		driver.get("http://practice.primetech-apps.com/practice/radio-button");
        //Find those available radio buttons.
		List<WebElement> radioButtons = driver.findElements(By.cssSelector(".form-check-input"));
        //Check if it’s displayed and enabled,
		for (WebElement singleRadio : radioButtons) {
			//if true, check if it’s selected,
			if (singleRadio.isDisplayed() && singleRadio.isEnabled()) {
				//if false select the button
                if (singleRadio.isSelected()) {
                	System.out.println("Radio button is selected!");
				}else {
					System.out.println("Radio button is not selected!");
					Thread.sleep(1000);
					singleRadio.click();
				}
			}else {
				System.out.println("Something is not right. Either not displayed or enabled.");
			}
			Thread.sleep(1000);
			//check if it’s selected.
			System.out.println("Is radio Button selected? " + singleRadio.isSelected());
		}
	}
	
	
	public static void checkboxHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//go to http://practice.primetech-apps.com/practice/check-box
		driver.get("http://practice.primetech-apps.com/practice/check-box");
        //find the checkboxes and verify if it’s displayed, 
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[class=form-check-input]"));
		for (WebElement singleCheckbox : checkboxes) {
			Thread.sleep(1000);
			if (singleCheckbox.isDisplayed()) {  // if this is false, it's not displayed message will be printed.
				System.out.println("It's displayed.");
				//if true, then verify if it’s enabled,
				if (singleCheckbox.isEnabled()) { // is this is false, it's not enabled message will be printed.
					System.out.println("It's enabled.");
					//if true, verify if it’s selected,
					if (singleCheckbox.isSelected()) {
						System.out.println("It's selected.");
					}else {
						System.out.println("It's not selected so I am selecting it. Clicking");
						//if false, then check the boxes.
						singleCheckbox.click();
					}
				}else {
					System.out.println("It's not enabled.");
				}
			}else {
				System.out.println("It's not displayed.");
			}
			//Then verify if it’s checked.
			System.out.println("Is checkbox now selected?  " + singleCheckbox.isSelected());
		}
	}
	
	public static void amazonHomework() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 //go to amazon.com    
		driver.get("https://amazon.com");
		 //click on signin 
		driver.findElement(By.xpath("//span[text()=\"Hello, sign in\"]")).click();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page.");
		}else {
			System.out.println("I am not on the sign in page.");
		}
	     //navigate back, and navigate forward
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
	     //verify that you are on sign in page (either by sign-in text or email field).
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the second time.");
		}else {
			System.out.println("I am not on the sign in page on the second time.");
		}
	     //click on create new account, verify you are on new account create page.
		driver.findElement(By.id("createAccountSubmit")).click();
		WebElement createAccountText = 
				driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]"));
		if (createAccountText.isDisplayed()) {
			System.out.println("I am on the account creation page.");
		}else {
			System.out.println("I am not on the account creation page.");
		}
	     //navigate back, verify you are on the sign-in page.
		driver.navigate().back();
		Thread.sleep(1000);
		if (driver.findElement(By.id("ap_email")).isDisplayed()) {
			System.out.println("I am on the sign in page on the third time.");
		}else {
			System.out.println("I am not on the sign in page on the third time.");
		}
	     //navigate forward, verify you are on the create account page.
		driver.navigate().forward();
		Thread.sleep(1000);
		if (driver.findElement(By.xpath("//h1[contains(text(), \"Create account\")]")).isDisplayed()) {
			System.out.println("I am on the account creation page second time.");
		}else {
			System.out.println("I am not on the account creation page second time.");
		}
	     //click on the Continue button without filling the form
		driver.findElement(By.id("continue")).click();
		Thread.sleep(1000);
	     //verify error messages displayed and get text to verify:
	      //Enter your name
		WebElement nameErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your name')]"));
		if (nameErrorMessage.isDisplayed()) {
			if (nameErrorMessage.getText().equals("Enter your name")) {
				System.out.println("Name error message displays and it matches.");
			}else {
				System.out.println("Name error message does not display or it doesn't match.");
			}
		}
	      //Enter your email or mobile phone number
		WebElement emailErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Enter your email')]"));
		if (emailErrorMessage.isDisplayed()) {
			if (emailErrorMessage.getText().equals("Enter your email or mobile phone number")) {
				System.out.println("Email error message displays and it matches.");
			}else {
				System.out.println("Email error message does not display or it doesn't match.");
			}
		}
	     //Minimum 6 characters required
		WebElement passwordErrorMessage = driver.findElement(By.xpath("//div[contains(text(), 'Minimum 6 characters required')]"));
		if (passwordErrorMessage.isDisplayed()) {
			if (passwordErrorMessage.getText().equals("Minimum 6 characters required")) {
				System.out.println("Password error message displays and it matches.");
			}else {
				System.out.println("Password error message does not display or it doesn't match.");
			}
		}

	}

}
