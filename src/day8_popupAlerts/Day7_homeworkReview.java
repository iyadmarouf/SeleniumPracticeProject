package day8_popupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day7_homeworkReview {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		//amazonSelect();
		alertTestcase3();
	}
	
	public static void alertTestcase3() {
		//Test case 3
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//go to http://practice.primetech-apps.com/practice/alerts 
		driver.get("http://practice.primetech-apps.com/practice/alerts");
		//Click on the 'Prompt Alert' button and type PrimeTech
		String text = "PrimeTech";
		driver.findElement(By.id("prompt")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert handle = driver.switchTo().alert();
		handle.sendKeys(text);
		//Then accept the Alert. 
		handle.accept();
		//Verify that a greeting message displays as
		//"Hello <your input>! How are you today?".
		WebElement greetingTextElement = driver.findElement(By.id("demo"));
		wait.until(ExpectedConditions.visibilityOf(greetingTextElement));
		String greetingText = greetingTextElement.getText();
		if (greetingText.equals("Hello " + text + "! How are you today?")) {
			System.out.println("Test Pass!");
		}else {
			System.out.println("Test Fail!");
		}
	}
	
	public static void amazonSelect() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 //Test case 2
	     //go to amazon.com
		 driver.get("https://amazon.com");
	     //verify that you are on the amazon home page. (verify with title). 
		 String expectedTitle = "Amazon.com. Spend less. Smile more.";
		 if (driver.getTitle().equals(expectedTitle)) {
			System.out.println("We are on the Home page!");
		}else {
			System.out.println("We are Not on the Home page!");
		}
	     //verify dropdown value is by default "All Departments"
		 String defaultDropdownValue = "All Departments";
		 WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		 
		 Select letSelect = new Select(dropdown);
		 String actualSelectedOption = letSelect.getFirstSelectedOption().getText();
		 if (actualSelectedOption.equals(defaultDropdownValue)) {
			System.out.println("Default dropdown value matches.");
		}else {
			System.out.println("Default dropdown value does not match.");
		}
	     //select department Home & Kitchen, and search coffee mug.
		 String searchItem = "Coffee Mug";
		 letSelect.selectByVisibleText("Home & Kitchen");
		 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);
		 driver.findElement(By.id("nav-search-submit-button")).click();
	     //verify you are on coffee mug search results page (use title).
		 String itemPageTitle = driver.getTitle(); 
		 // Amazon.com : Coffee Mug 23 - 10 = 13
		 int beginningIndex = itemPageTitle.length() - searchItem.length();
		 
		 if (itemPageTitle.substring(beginningIndex).equals(searchItem)) {
			System.out.println("Search item title match");
		}else {
			System.out.println("Search item title Does not match");
		}
	     //verify you are in Home & Kitchen department.
		 WebElement dropdown2 = driver.findElement(By.id("searchDropdownBox"));
		 Select letSelect2 = new Select(dropdown2);
		 String selectedOption = letSelect2.getFirstSelectedOption().getText();
		 if (selectedOption.equals("Home & Kitchen")) {
			System.out.println("Test pass.");
		}else {
			System.out.println("Test fail.");
		}
	}

}
