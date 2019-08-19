package pomPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchUser{

	WebDriver driver;
	
	@FindBy(xpath="//span[@class='icon x-fa fa-users']") //Employees Button
	private WebElement employeeButton;
	
	
	@FindBy(css=".x-searchfield")   //Employee search field
	private WebElement searchField;
	
	
	@FindAll(@FindBy(css=".x-listitem-listing")) //gets all the List of Employees rows
	private List<WebElement> empLists;
		
	
	public SearchUser(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
		
	}
	
	public void searchUser(String user) {
		Actions action = new Actions(driver);
		action.moveToElement(searchField).click().sendKeys(user).pause(1000).perform(); //enter the employee in search field
		
	}
	
	public List<WebElement> getEmpList() {
		return empLists;   //returns the list of Employees rows.
	}
		
	public void clickEmployee() {
		employeeButton.click();
	}
	
	public String getEmpNameElement(String role,String empname) {			// find xpath using dynamic role and 
		String empxpath = "//div[contains(text(),'"+role+"')]/preceding-sibling::a[contains(text(),'"+empname+"')]";
		By employeeName = By.xpath(empxpath);
		WebElement wb=waitforvisibility(employeeName);
		return wb.getText();
	}
	
	
	
	private WebElement waitforvisibility(By element) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(element));
		
		WebElement element1 = driver.findElement(element);
		return element1;
	}
	
	
}
