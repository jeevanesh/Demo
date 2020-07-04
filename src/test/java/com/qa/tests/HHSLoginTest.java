package com.qa.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HHSLoginTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://shipcom-iot-ui-dev.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

//		Thread.sleep(30000);
		
		System.out.println("Title is:  "+driver.getTitle());

		driver.findElement(By.id("email")).sendKeys("Shahrzad@shipcomwireless.com");
		driver.findElement(By.id("password")).sendKeys("Shipcom12345");
		driver.findElement(By.id("btn-login")).click();

		System.out.println("Login success");
		
		Thread.sleep(50000);
		driver.switchTo().activeElement();
					
		Boolean Display = driver.findElement(By.xpath("//div[@class='popover-body-message']")).isDisplayed();
		System.out.println("Element displayed is :"+Display);
		
		//System.out.println(driver.findElement(By.xpath("//div[@class='popover-body-message']")).getText());
		
		driver.findElement(By.xpath("//button[@id='onesignal-popover-cancel-button']")).click();  // click on Cancel of popup box
		System.out.println("Popup get cancelled");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//li//a//img[@src='assets/img/route-list-icon.svg']")).click();  // click on Route List menu
		
		driver.findElement(By.xpath("//button[@class='btn-filter']")).click();  // click on Add button
		
		System.out.println(driver.findElement(By.xpath("//h4[@class='modal-heading mb-0']")).getText());  //get popup header
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Route Name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Enter Route Name']")).sendKeys("TestRoute01");

		driver.findElement(By.xpath("//input[@placeholder='Origin']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Origin']")).sendKeys("Mumbai (Mumbai, Maharashtra, India)");

		driver.findElement(By.xpath("//input[@placeholder='Destination']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Destination']")).sendKeys("Pune (Pune, Maharashtra, India)");
		
		driver.findElement(By.xpath("//input[@placeholder='Add Stop']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Add Stop']")).sendKeys("Lonavla (Lonavla, Maharashtra, India)");
		
				
		driver.findElement(By.xpath("//button[@class='btn-submit px-4']")).click();   // click on Add button		
//		driver.switchTo().activeElement();
//		System.out.println(driver.findElement(By.xpath("//div[@aria-label='Please enter route id']")).getText());


	}

}
