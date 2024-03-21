package testcases;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class LoginFunctionality extends BaseTest {
	
	public static Properties tdata = new Properties();
	public static FileReader fr;
	private ExtentTest test;
	
	@BeforeMethod
	public void setUp() {
		test = extent.createTest("User Login Test");
	}
	
	
	public void fetchTestData() throws IOException {
		if (driver==null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\testdata.properties");
			loc.load(fr);
		}
	}
	
	
	@Test
	public void validUsernameAndValidPassword() {
		
		//Perform login with valid username and valid password
		String username = loc.getProperty("valid_username");
		String password = loc.getProperty("valid_password");
		
		loginPage.enterValidUsername(username);
		loginPage.enterValidPassword(password);
		loginPage.clickLoginButton();
		
		Assert.assertTrue(dashboardPage.IsUserLoggedIn());
		//Assert.assertTrue(loginPage.isErrorMessageDisplayed());
		
		if(test.getStatus() == Status.PASS) {
			test.pass("Login successful for user: "+username);
			
		}else if(test.getStatus() == Status.FAIL) {
			test.fail("Login failed for user: "+username);
		}
		
		
	}
	
	@Test
	public void invalidUsernameAndValidPassword() {
		//Perform login with valid username and valid password
		String username = loc.getProperty("invalid_username");
		String password = loc.getProperty("valid_password");

		loginPage.enterValidUsername(username);
		loginPage.enterValidPassword(password);
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());

		if (test.getStatus() == Status.PASS) {
			test.pass("Login successful for user: " + username);

		} else if (test.getStatus() == Status.FAIL) {
			test.fail("Login failed for user: " + username);
		}
	}
	
	@Test
	public void validUsernameAndInvalidPassword() {
		//Perform login with valid username and valid password
		String username = loc.getProperty("valid_username");
		String password = loc.getProperty("invalid_password");

		loginPage.enterValidUsername(username);
		loginPage.enterValidPassword(password);
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());

		if (test.getStatus() == Status.PASS) {
			test.pass("Login successful for user: " + username);

		} else if (test.getStatus() == Status.FAIL) {
			test.fail("Login failed for user: " + username);
		}
	}
	
	@Test
	public void invalidUsernameAndInvalidPassword() {
		//Perform login with valid username and valid password
		String username = loc.getProperty("invalid_username");
		String password = loc.getProperty("invalid_password");

		loginPage.enterValidUsername(username);
		loginPage.enterValidPassword(password);
		loginPage.clickLoginButton();

		Assert.assertTrue(loginPage.isErrorMessageDisplayed());

		if (test.getStatus() == Status.PASS) {
			test.pass("Login successful for user: " + username);

		} else if (test.getStatus() == Status.FAIL) {
			test.fail("Login failed for user: " + username);
		}
	}
	
	
//    private void waitForWebsite() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Initial wait time
//
//        long startTime = System.currentTimeMillis();
//        while (System.currentTimeMillis() - startTime < 30000) { // Max wait time
//            try {
//                // Check if the user is logged in (replace with the actual condition)
//                WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcomeMessage")));
//                if (welcomeMessage.isDisplayed()) {
//                    return; // User is logged in, exit the loop
//                }
//            } catch (Exception e) {
//                // Ignore exceptions, continue waiting
//            }
//
//            // Adjust the wait time based on the elapsed time
//            long elapsedTime = System.currentTimeMillis() - startTime;
//            int dynamicWaitTime = (int) Math.min(500, Math.max(200, elapsedTime / 10));
//            
//            Wait wait1 = new FluentWait(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(30))
//                    .ignoring(NoSuchElementException.class);
//            
//            //wait.withTimeout(dynamicWaitTime, java.util.concurrent.TimeUnit.MILLISECONDS);
//
//            // Sleep for a short duration to avoid high CPU usage during the loop
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        throw new RuntimeException("Timed out waiting for user login");
//    }

}
