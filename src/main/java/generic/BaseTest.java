package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pomPages.HomePage;
import pomPages.LoginPage;


public class BaseTest extends TestUtilities implements IAutoConstants{

	public static WebDriver driver;
	public static WebDriverWait wait;
	public LoginPage login;
	public HomePage home;
	
	static {
		System.setProperty(CHROMDRIVER,CHROMEPATH);
		System.setProperty(GECKODRIVER,GECKOPATH);
	}
	
	@BeforeMethod
	public void openBrowser() {
		driver = getBrowserDriver("chrome");					//Method in TestUtilities Class
		login = new LoginPage(driver);
		driver.manage().window().maximize();
		wait= new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.get("https://examples.sencha.com/coworkee/#login");
		home=login.clickLoginButton();
	}
	
	@AfterMethod(enabled=true)
	public void closeBrowser() {
		
		driver.close();
		
	}
}
