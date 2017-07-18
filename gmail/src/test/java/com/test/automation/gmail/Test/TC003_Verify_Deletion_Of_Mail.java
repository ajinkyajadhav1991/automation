/**
 * 
 */
package com.test.automation.gmail.Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.gmail.Pages.InboxPage;
import com.test.automation.gmail.Pages.LoginPage;
import com.test.automation.gmail.TestBase.TestBase;

/**
 * @author Ajinkya
 *
 */
public class TC003_Verify_Deletion_Of_Mail extends TestBase {
	
	LoginPage loginpage;
	InboxPage inboxPage;
	
	@BeforeClass
	public void setUP() throws IOException{
		
		init();
		
	}
	
	
	
	@Test
	public void verify_Deletion_Of_Mail() throws InterruptedException{
	
		loginpage = new LoginPage(driver);
		loginpage.login(OR.getProperty("username"), OR.getProperty("password"));
		
		
		inboxPage = new InboxPage(driver);
		inboxPage.click_Composebutton();
		inboxPage.enter_To("maxpane.b.567@gmail.com");
		inboxPage.enter_Subject("This is subject");
		inboxPage.enter_Body("This is body");
		inboxPage.click_Send();
		
		inboxPage.click_Composebutton();
		inboxPage.select_mail();
		
		
	}
	
	
	@AfterClass
public void tearDown(){
		
		closeBrowser();
	}

}
