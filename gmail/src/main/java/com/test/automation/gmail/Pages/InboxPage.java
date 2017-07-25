/**
 * 
 */
package com.test.automation.gmail.Pages;

import java.util.List;

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
public class InboxPage extends TestBase {
	
	public static final Logger Log = Logger.getLogger(InboxPage.class.getName());
	
	WebDriver driver;
	
	@FindBy(xpath="//div[contains(text(), 'COMPOSE')]")
	WebElement btn_Compose;
	
	@FindBy(xpath="//textarea[@aria-label='To']")
	WebElement txt_To;
	
	@FindBy(name="subjectbox")
	WebElement txt_Subject;
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	WebElement txt_Body;
	
	@FindBy(xpath="//div[contains(text(), 'Send')]")
	WebElement btn_Send;
	
	@FindBy(xpath="//a[contains(text(),'Inbox (1)')]")
	WebElement link_Inbox;
	
	@FindBy(xpath="//div[@class='y6']")
	List<WebElement> list_of_mails;
	
	
	
	public InboxPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyIfContainbuttonIsDisplayed() throws InterruptedException{
		
		waitforElement(driver, btn_Compose, 10);
		
		if(btn_Compose.isDisplayed()){
			return true;
			
		}
		else{
			return false;
		}
	}
	
	public void click_Composebutton() throws InterruptedException{
		
		waitforElement(driver, btn_Compose, 10);
		btn_Compose.click();
	}
	
	public void enter_To(String to) throws InterruptedException{
		
		waitforElement(driver, txt_To, 10);
		txt_To.sendKeys(to);
		
	}
	
	public void enter_Subject(String subject) throws InterruptedException{
		
		waitforElement(driver, txt_Subject, 10);
		txt_Subject.sendKeys(subject);
	}
	
	public void enter_Body(String body) throws InterruptedException{
		
		waitforElement(driver, txt_Body, 10);
		txt_Body.sendKeys(body);
		
	}
	
	public void click_Send(){
		
		btn_Send.click();
	}
	
	
	public boolean verify_Message_Is_Recieved_using_Inbox() throws InterruptedException{
		
		waitforElement(driver, link_Inbox, 30);
		
		if(link_Inbox.isDisplayed()){
			return true;
			
		}
		else{
			return false;
		}
		
		
	}
	
	
	
	public void click_inboxlink() throws InterruptedException{
		
		waitforElement(driver, link_Inbox, 30);
		link_Inbox.click();
	}
	
	public void select_email(){
		
		list_of_mails.get(0).click();
		
	}
	
	

}
