package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
	
	private WebDriver driver;
	public static Properties loc = new Properties();
	public static FileReader fr;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void fetchLocators() throws IOException {
		if (driver==null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(fr);
		}
	}
	
	public boolean IsUserLoggedIn() {
		return driver.findElement(By.xpath(loc.getProperty("user_profile"))).isDisplayed();
	}

}
