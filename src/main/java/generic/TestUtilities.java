package generic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestUtilities {
	WebDriver driver;
	Date morning, afternoon, evening;
	
	public String expectedWishText(String name) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		LocalDate local = LocalDate.now();
		DayOfWeek day=local.getDayOfWeek();
		Date currenttime=new Date();
		
		try {
			morning=sdf.parse(local+" "+"00:00:00");
			afternoon=sdf.parse(local+" "+"11:59:59");
			evening=sdf.parse(local+" "+"15:00:00");
		} catch (ParseException e) {
			System.out.println(e);
		}
		
		if(day==day.SATURDAY || day==day.SUNDAY) {
			return "Enjoy your weekend "+ name;
		}
		if(currenttime.compareTo(morning)>=0 && currenttime.compareTo(afternoon)<0) {
			return "Good morning "+name;
			
		}else if(currenttime.compareTo(afternoon)>0 && currenttime.compareTo(evening)<0) {
			return "Good afternoon "+name; 
			
		}else{
			return "Good evening "+name;
		}
		
		
	}
	
	
	public WebDriver getBrowserDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			return driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			return driver = new FirefoxDriver();
		}else {
			return driver = new InternetExplorerDriver();
		}
		
	}
	
	
	
}
