package Scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.TestUtilities;
import pomPages.HomePage;

public class UseCase1Login extends BaseTest{

	@Test
	public void checkLoginHome() throws InterruptedException {
		
		String expected=expectedWishText("Norma");  //Method in TestUtilities class
		
		String wishtext=home.getwishText();   //
		
		String usertext=home.getloginUser();
		
		String welcometext = wishtext +" "+usertext;
		
		assertEquals(welcometext, expected);
		
		Reporter.log("Assertion Passed", true);
		Reporter.log("Welcome text from HomePage --> "+welcometext, true);
		
		home.clicktoggle();
		
		home.clicklogOut();
		
	}
	
}
