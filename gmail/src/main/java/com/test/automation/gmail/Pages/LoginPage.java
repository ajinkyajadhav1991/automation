/**
 * 
 */
package com.test.automation.gmail.Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.automation.gmail.TestBase.TestBase;

/**
 * @author Ajinkya
 *
 */
public class LoginPage extends TestBase {
	
	public static final Logger Log = Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;
	
	String username = "maxpane.b.567";
	String password = "Ram3Sita#";
	
	@FindBy(id="identifierId")
	WebElement txt_username;
	
	@FindBy(xpath="//*[@id='identifierNext']/div[2]")
	WebElement btn_next;
	
	@FindBy(name="password")
	WebElement txt_password;
	
	@FindBy(xpath="//*[@id='passwordNext']/div[2]")
	WebElement btn_passwd_next;
	
	public LoginPage(WebDriver driver){
		Log.info("Initializing PageFactory for LoginPage");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Log.info("PageFactory for LoginPage is initialized");
	}
	
	public void login(String username, String password) throws InterruptedException{
		
		Log.info("Entering username and password");
		txt_username.sendKeys(username);
		btn_next.click();
		waitforElement(driver, txt_password, 10);
		txt_password.sendKeys(password);
		btn_passwd_next.click();
		
	}
	
	
	
	
	
	
	

}
