package pomPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateUserPOM {

	WebDriver driver;
	
	@FindBy(xpath="//div[text()='Create']/../../following-sibling::button")
	private WebElement createUserButton;

	@FindBy(xpath="//div[text()='General']/../../following-sibling::button")
	private WebElement generalTab;
	
	@FindBy(xpath="//span[text()='First Name']/../following-sibling::div//input")
	private WebElement firstNameTB;
	
	@FindBy(xpath="//span[text()='Last Name']/../following-sibling::div//input")
	private WebElement lastNameTB;
	
	@FindBy(xpath="//span[text()='Username']/../following-sibling::div//input")
	private WebElement userNameTB;
	
	@FindBy(xpath="//span[text()='Password']/../following-sibling::div//input")
	private WebElement passWordTB;
	
	@FindBy(xpath="//span[text()='Confirm Password']/../following-sibling::div//input")
	private WebElement confirmPWDTB;
	
	@FindBy(xpath="//div[text()='Personal']/../../following-sibling::button")
	private WebElement personalTAB;
	
	@FindBy(xpath="//span[text()='Birthday']/../following-sibling::div//div[contains(@class,'x-datetrigger')]")
	private WebElement birthDateICON;
	
	@FindBy(xpath="//span[text()='Birthday']/../following-sibling::div//input")
	private WebElement birthDateTB;
	
	@FindBy(xpath="//span[text()='Email']/../following-sibling::div//input")
	private WebElement emailTB;
	
	@FindBy(xpath="//span[text()='Phone']/../following-sibling::div//input")
	private WebElement phoneTB;
	
	@FindBy(xpath="//div[text()='Work']/../../following-sibling::button")
	private WebElement workTAB;
	
	@FindBy(xpath="//span[text()='Job Title']/../following-sibling::div//input")
	private WebElement jobTitleTB;
	
	@FindBy(xpath="//span[text()='Entry date']/../following-sibling::div//input")
	private WebElement entryDateTB;
	
	@FindBy(xpath="//span[text()='Office']/../following-sibling::div//div[@class='x-after-input-el']")
	private WebElement dropListOfcBTN;
	
	@FindAll(@FindBy(xpath="//span[text()='Dottie']/ancestor::div[@class='x-list-outer-ct x-scroller']//span"))
	private List<WebElement> listofOffice;
	
	@FindBy(xpath="//span[text()='Organization']/../following-sibling::div//div[@class='x-after-input-el']")
	private WebElement dropListOrgBTN;
	
	@FindAll(@FindBy(xpath="//span[text()='Customer Service']/ancestor::div[@class='x-list-outer-ct x-scroller']//span"))
	private List<WebElement> listofOrgDept;
	
	@FindBy(xpath="//div[text()='Cancel']/ancestor::div[contains(@class,'x-horizontal')]//div[text()='Create']/../../following-sibling::button")
	private WebElement createBTN;
	
	@FindBy(xpath="//div[text()='Read-only session, data not updated']")
	private WebElement readOnlyText;
	
	@FindBy(xpath="//div[@data-title='Add Employee']")
	private WebElement addEmplTitle;
	
	public CreateUserPOM(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
	}
	
	
	public void clickCreateUser() {
			createUserButton.click();
	}
	
	public String getTitleForAddEmp() {
		return addEmplTitle.getText();
	}
	
	public void clickGeneralTAB() {
			generalTab.click();
	}
	
	public void enterFirstName(String fname) {
			firstNameTB.sendKeys(fname);
	}
	
	public void enterlastName(String lname) {
			lastNameTB.sendKeys(lname);
	}
	
	public void enteruserName(String uname) {
			userNameTB.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
			passWordTB.sendKeys(pwd);
	}

	
	public void enterConfirmPwd(String cpwd) {
			confirmPWDTB.sendKeys(cpwd);
	}

	
	public void clickPersonal() {
			personalTAB.click();
	}

	
	public void enterBirthDate(String bday) {
			birthDateTB.sendKeys(bday);
	}

	
	public void enterEmail(String email) {
			emailTB.sendKeys(email);
	}

	
	public void enterPhone(String phone) {
			phoneTB.sendKeys(phone);
	}

	public void clickworkTAB() {
			workTAB.click();
	}


	public void enterJobtitle(String jobtitle) {
			jobTitleTB.sendKeys(jobtitle);
	}


	public void enterentryDateTB(String entrydt) {
			entryDateTB.sendKeys(entrydt);
	}


	public void clickdropListOfC() {
			dropListOfcBTN.click();
	}

	public List<WebElement> getlistofOffice() {
			return listofOffice;
	}
	

	public void clickdropListORG() {
			dropListOrgBTN.click();
	}
	

	public List<WebElement> getlistofORG() {
			return listofOrgDept;
	}
		
	public void clickFinalCreate() {
			createBTN.click();
	}
	
	public String getreadOnlyText() {
			waitToVisible();
		return readOnlyText.getText();
	}
	

	public void waitToVisible() {
			new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(readOnlyText));
		
	}
	
	
	public void selectOffice(String office) {
		List<WebElement> officeList=getlistofOffice();
		
		for(WebElement ofc:officeList) {
			if(ofc.getText().equals(office)) {
				ofc.click();
			}
		}
	}
	
	public void selectOrganization(String org) {
		List<WebElement> orglist=getlistofORG();
		
		for(WebElement ofc:orglist) {
			if(ofc.getText().equals(org)) {
				ofc.click();
			}
		}
	}
	
	
}
