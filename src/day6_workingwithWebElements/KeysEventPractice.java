package day6_workingwithWebElements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysEventPractice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // waits for the page to be loaded.
		driver.manage().window().maximize();
		//driver.get("");
		driver.navigate().to("https://google.com");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Coffee Mug" + Keys.ENTER); // this opens a new page
		Thread.sleep(1000);
		//driver.findElement(By.name("q"));
		WebElement newSearchBox = driver.findElement(By.name("q"));
		newSearchBox.clear();
		Thread.sleep(1000);
		newSearchBox.sendKeys("Seleneium Webdriver" + Keys.ENTER); // 
		driver.navigate().back();
		driver.findElement(By.name("q")).clear(); 
		Thread.sleep(1000);
		driver.navigate().forward();
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		driver.close();
		
	}
	
	

}
