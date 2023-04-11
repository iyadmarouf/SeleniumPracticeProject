package day3_advancedLocators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathDeno {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		//amazonSearch();
		indeedTest();
	}
	
	
	public static void amazonSearch() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.findElement(By.xpath("//input[@placeholder='Search Amazon']")).sendKeys("Coffee mug");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	}
	
	public static void indeedTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://indeed.com");
		WebElement whereField = driver.findElement(
				By.xpath("//input[@id='text-input-where']"));
		
		whereField.sendKeys(Keys.CONTROL + "a");
		whereField.sendKeys(Keys.DELETE);
	}

}
