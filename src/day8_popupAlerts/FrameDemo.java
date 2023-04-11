package day8_popupAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		frameDemo();
	}
	
	public static void frameDemo() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.get("http://practice.primetech-apps.com/practice/frames");
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframe1']")));
		driver.switchTo().frame(0);
		driver.findElement(By.id("firstName")).sendKeys("Hello");
		
		driver.switchTo().parentFrame(); // goes back to one step out of the iframe. 
		//driver.switchTo().defaultContent(); // goes back to original page.
		
		System.out.println(driver.findElement(By.xpath("//h3[text()='Frames']")).getText());
		
	}

}
