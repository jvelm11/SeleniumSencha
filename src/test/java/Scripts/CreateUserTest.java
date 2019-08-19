package Scripts;

import static org.testng.Assert.assertTrue;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.BaseTest;
import pomPages.CreateUserPOM;
import pomPages.SearchUser;

public class CreateUserTest extends BaseTest{
	
	String read = "Read-only session, data not updated";
	
	@Test(dataProvider="usercreation")
	public void createUser(String fname, String lname, String uname, String pwd, String cpwd, String bdate, String email, String phone,
			String Job, String entrydt, String office, String org) {
		
		SearchUser srch = new SearchUser(driver);				//Object for SearchUserPOM Pages
		CreateUserPOM create = new CreateUserPOM(driver);		//Object for CreateUserPOM Pages
	
		srch.clickEmployee();
		create.clickCreateUser();
		create.clickGeneralTAB();
		create.enterFirstName(fname);
		create.enterlastName(lname);
		create.enteruserName(uname);
		create.enterPassword(pwd);
		create.enterConfirmPwd(cpwd);
		create.clickPersonal();
		create.enterBirthDate(bdate);
		create.enterEmail(email);
		create.enterPhone(phone);
		create.clickworkTAB();
		create.enterJobtitle(Job);
		create.enterentryDateTB(entrydt);
		create.clickdropListOfC();
		create.selectOffice(office);
		create.clickdropListORG();
		create.selectOrganization(org);
		
		create.clickFinalCreate();
		
		String readonly=create.getreadOnlyText();		//get the text after Click on Create button of CreateUser Page
		
		assertTrue(readonly.equals(read));
		
		Reporter.log("Assertion Passed, After User Data Entry and Click Create --> "+readonly, true);
		
		home.moveTotoggleandClick();
		home.clicklogOut();
	}
	
	
	@DataProvider(name = "usercreation")
	public Object[][] userData(){
		
		Object [][] obj=new Object [1][12];
		
		obj [0][0]="Rajashekar";
		obj [0][1]="MR";
		obj [0][2]="rajashekartr";
		obj [0][3]="rajashekartr@123";
		obj [0][4]="rajashekartr@123";
		obj [0][5]="12/12/1980";
		obj [0][6]="rajshekartr123@gmail.com";
		obj [0][7]="9923909239";
		obj [0][8]="Test Engineer";
		obj [0][9]="01/01/2018";
		obj [0][10]="Dottie";
		obj [0][11]="Engineering";
		
		return obj;
	}
	
	
	
}
