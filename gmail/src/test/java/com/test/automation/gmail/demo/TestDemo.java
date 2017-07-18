package com.test.automation.gmail.demo;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestDemo {
	
	public static final Logger Log = Logger.getLogger(TestDemo.class.getName());
	
	WebDriver driver;
	
	@Test
	public void login() throws InterruptedException{
		
		
		Log.info("This is Logger");
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		Log.info("Navigating to gmail");
		driver.get("http://gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("maxpane.b.567");
		driver.findElement(By.xpath(".//*[@id='identifierNext']/div[2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("password")).sendKeys("Ram3Sita#");
		driver.findElement(By.xpath(".//*[@id='passwordNext']/div[2]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[contains(text(), 'COMPOSE')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//textarea[@aria-label='To']")).sendKeys("maxspane.b.567@gmail.com");
		
		Thread.sleep(5000);
		driver.findElement(By.name("subjectbox")).sendKeys("This is subject");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys("This is body");
		
		
	}

}
