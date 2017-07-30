/**
 * 
 */
package com.test.automation.gmail.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.automation.gmail.customListener.Listener;

/**
 * @author Ajinkya
 *
 */
public class TestBase {
	
	public static WebDriver driver;
	public Properties OR = new Properties();
	

	public void init() throws IOException{
		loadData();
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		selectBrowser(OR.getProperty("browser"));
		
		enterURL(OR.getProperty("url"));
		
		}
	
	public void loadData() throws IOException{
		
		File file = new File(System.getProperty("user.dir")+"/src/main/java/com/test/automation/gmail/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
		}


	public void enterURL(String url) {
		// TODO Auto-generated method stub
		driver.get(url);
		}


	public void selectBrowser(String browser) {
		// TODO Auto-generated method stub
		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else {
			System.out.println("Please enter proper browser");
			
		}
		
	}
	
	public void waitforElement(WebDriver driver,WebElement element, int time) throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		//Thread.sleep(5000);
	}
	
	public void closeBrowser(){
		
		driver.quit();
	}
	
	public File getScreenShot(){
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		return scrFile;
		
	}
	
	
	
	

}
