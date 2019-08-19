package Scripts;

import static org.testng.Assert.assertEquals;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class EditUserUseCase extends BaseTest{

	String name= "Howard Stevens";
	String expected = "Read-only session, data not updated";
	
	
	@Test
	public void editUser() throws InterruptedException
	{

		home.clicktoggle();
		home.clickHomeButton();
		home.findaUserandClick(name);
		home.clickEditButton();
		home.editFirstName("abc");
		home.clickSaveButton();
		String read=home.getReadOnlyText();
		
		assertEquals(read, expected);
		
		Reporter.log("Assertion Passed, After Edit User and click on Save--> "+read, true);
		
		home.clicktoggleOnexit();
		
//		home.moveTotoggleandClick();
		
		home.clicklogOut();
		
	}
	
	
	
	
}
