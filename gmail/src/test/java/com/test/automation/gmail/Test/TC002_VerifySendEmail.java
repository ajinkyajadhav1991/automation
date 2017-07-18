/**
 * 
 */
package com.test.automation.gmail.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.automation.gmail.Pages.InboxPage;
import com.test.automation.gmail.Pages.LoginPage;
import com.test.automation.gmail.TestBase.TestBase;

/**
 * @author Ajinkya
 *
 */
public class TC002_VerifySendEmail extends TestBase{
	
	LoginPage loginpage;
	InboxPage inboxPage;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	
	@Test
	public void verifySendEmail() throws InterruptedException{
		
		loginpage = new LoginPage(driver);
		loginpage.login(OR.getProperty("username"), OR.getProperty("password"));
		
		inboxPage = new InboxPage(driver);
		inboxPage.click_Composebutton();
		inboxPage.enter_To("maxpane.b.567@gmail.com");
		inboxPage.enter_Subject("This is subject");
		inboxPage.enter_Body("This is body");
		inboxPage.click_Send();
		
		Assert.assertEquals(inboxPage.verify_Message_Is_Recieved_using_Inbox(), true);
		
		}
	
	@AfterClass
	public void tearDown(){
		
		closeBrowser();
	}
	

}
