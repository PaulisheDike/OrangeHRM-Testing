package pages;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import testcases.LoginFunctionality;

public class LoginPage {
	
	private WebDriver driver;
	public static Properties loc = new Properties();
	public static FileReader fr;
	

	
	public LoginPage(WebDriver driver) throws IOException {
		
		this.driver = driver;
		//this.fetchLocators();
	}
	
	public void fetchLocators() throws IOException {
		if (driver==null) {
			
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			loc.load(fr);
		}
	}
	
	
	
	public void enterValidUsername(String username) {
		System.out.println("Something 2");
		driver.findElement(By.xpath(loc.getProperty("valid_username"))).sendKeys(username);
	}
	
	public void enterValidPassword(String password) {
		driver.findElement(By.xpath(loc.getProperty("valid_password"))).sendKeys(password);
	}
	
	public void enterInvalidUsername(String username) {
		driver.findElement(By.xpath(loc.getProperty("invalid_username"))).sendKeys(username);
	}
	
	public void enterInvalidPassword(String password) {
		driver.findElement(By.xpath(loc.getProperty("invalid_password"))).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(By.xpath(loc.getProperty("login_button"))).click();
	}
	
	public boolean isErrorMessageDisplayed() {
		return driver.findElement(By.xpath(loc.getProperty("login_error_message"))).isDisplayed();
	}

}
