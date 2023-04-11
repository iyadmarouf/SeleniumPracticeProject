package day5_homeworkReview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day4_homeworkReview {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/primetech/Documents/SeleniumTools/chromeDriver/chromedriver_mac_arm64/chromedriver");
		
		//textBox();
		webTabel();
	}
	
	
	public static void textBox() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		//Homework: Please use Xpath or Css selector only:
			//Testcase 1: 
			//Go to http://practice.primetech-apps.com/practice/text-box
		driver.get("http://practice.primetech-apps.com/practice/text-box");
			//Find first name, last name, email, password, address fields, and type relevant information. 
			//(Create variables for those information and pass the variable to the sendkey() method).
		String firstname = "Hello";
		String lastname = "dow";
		String email = "john.dow@gmail.com";
		String password = "12345hello";
		String address = "123 main st, fairfax, VA, 22030";
		driver.findElement(By.cssSelector("#firstName")).sendKeys(firstname);
		driver.findElement(By.cssSelector("#lastName")).sendKeys(lastname);
		driver.findElement(By.cssSelector("#email")).sendKeys(email);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(password);
		driver.findElement(By.xpath("//button[text()='Enable']")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("textarea[id=address]")).sendKeys(address);
			//Then click on submit button. (your inputs displays under user info section).
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(1000);
			//Find your inputs and get text of each and store them into variables.
		String firstNameActual = driver.findElement(By.xpath("//div[text()='"+firstname+"']")).getText();
		System.out.println("Actual first name is: " + firstNameActual);
		
		String lastNameActual = driver.findElement(By.xpath("//div[text()='"+lastname+"']")).getText();
		System.out.println("Actual last name is: " + lastNameActual);
		
		String emailActual = driver.findElement(By.xpath("//div[text()='"+email+"']")).getText();
		System.out.println("Actual email is: " + emailActual);
		
		String passwordActual = driver.findElement(By.xpath("//div[text()='"+password+"']")).getText();
		System.out.println("Actual password is: " + passwordActual);
		
		String addressActual = driver.findElement(By.xpath("//div[text()='"+address+"']")).getText();
		System.out.println("Actual address is: " + addressActual);
			//Then compare your input with the displayed user information if they match.
		
		if (firstNameActual.equals(firstname)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (lastNameActual.equals(lastname)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (emailActual.equals(email)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (passwordActual.equals(password)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		if (addressActual.equals(address)) {
			System.out.println("Test Pass!");
		} else {
			System.out.println("Test Fail!");
		}
		
	}
	
	public static void webTabel() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//Homework: Please practice your element locating skills,id, name, xpath and css selector

		//Testcase 2: 

		//1. Go to http://practice.primetech-apps.com/practice/web-tables
		driver.get("http://practice.primetech-apps.com/practice/web-tables");
		//2. Verify that you see Web Table's text
		String webtabelHeaderText = driver.findElement(By.xpath("//h3[text()='Web Tables']")).getText();
		if (webtabelHeaderText.equals("Web Tables")) {
			System.out.println(" We are on the Web Table Page.");
		}else {
			System.out.println("We are not on the Web table Page.");
		}
		//3. Find id, firstname, lastname, salary fields and give a relevant input. (store the information into variables, then pass the variable to sendKeys() method) 
		int id = 123;
		String firstname = "John";
		String lastname = "Smith";
	    int salary = 120000;
	    double salary2 = 13000.00;
		
	    driver.findElement(By.cssSelector("input[id=Id]")).sendKeys(String.valueOf(id));
	    driver.findElement(By.cssSelector("input[id='First Name']")).sendKeys(firstname);
	    driver.findElement(By.cssSelector("input[id='Last Name']")).sendKeys(lastname);
	    driver.findElement(By.cssSelector("input[id='Salary']")).sendKeys(String.valueOf(salary));
	  //4. Click on Add button
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	    
	    
		//5. Then your inputs will display under the table. (use xpath text() contains() functions to locate those elements. get text and store them into variables)
		String actualId = driver.findElement(By.xpath("//td[text()='" + id + "']")).getText();
		System.out.println(actualId);
		String actualFirstname = driver.findElement(By.xpath("//td[text()='" + firstname + "']")).getText();
		System.out.println(actualFirstname);
		String actualLastname = driver.findElement(By.xpath("//td[text()='" + lastname + "']")).getText();
		System.out.println(actualLastname);
		String actualSalary = driver.findElement(By.xpath("//td[text()='" + salary + "']")).getText();
		System.out.println(actualSalary);
	    //6. Verify your input under the table match the input you added. 
		
		
		if (Integer.parseInt(actualId) == id) {
			System.out.println("ID is good, Test Pass!");
		} else {
			System.out.println("ID is not good.");
		}
		if (actualFirstname.equals(firstname)) {
			System.out.println("Firstname is good, Test Pass!");
		} else {
			System.out.println("Firstname is not good.");
		}
		if (actualLastname.equals(lastname)) {
			System.out.println("Lastname is good, Test Pass!");
		} else {
			System.out.println("Lastname is not good.");
		}
		if (Integer.parseInt(actualSalary) == salary) {
			System.out.println("Salary is good, Test Pass!");
		} else {
			System.out.println("Salary is not good.");
		}
	}
}
