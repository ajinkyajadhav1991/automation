/**
 * 
 */
package com.test.automation.gmail.Test;

import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
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
public class TC001_VerifyLogin extends TestBase {
	
	LoginPage loginpage;
	InboxPage inboxPage;
	
	
	@BeforeClass
	public void setUp() throws IOException{
		
		init();
	}
	
	@Test
	public  void verifyLogin() throws InterruptedException{
		
		loginpage = new LoginPage(driver);
		loginpage.login(OR.getProperty("username"), OR.getProperty("password"));
		
		inboxPage = new InboxPage(driver);
		Assert.assertEquals(inboxPage.verifyIfContainbuttonIsDisplayed(), true);
		
	}
	
	@AfterClass
	public void tearDown(){
		
		closeBrowser();
	}

}
