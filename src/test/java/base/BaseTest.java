package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;
	protected LoginPage loginPage;
	protected DashboardPage dashboardPage;
	
	
	protected static ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("TestResult.html");
	
	
	@BeforeTest
	public void setUp() throws IOException {
		
		// Set up WebDriver (Assuming you have the ChromeDriver executable in your system path)
//	    try {
//	        System.setProperty("webdriver.chrome.driver", "path/t/chromedriver");
//	        driver = new ChromeDriver();
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
		
		System.out.println("aaaaaaaAAAAAAAAAAAAA 1");
		
		if(driver==null) {
			FileReader fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}
		
		System.out.println("aaaaaaaAAAAAAAAAAAAA 2");
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("testurl"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(prop.getProperty("testurl"));
		}
		System.out.println("aaaaaaaAAAAAAAAAAAAA 3");
		
		
		loginPage = new LoginPage(driver);
		System.out.println("aaaaaaaAAAAAAAAAAAAA 4");
		dashboardPage = new DashboardPage(driver);
		System.out.println("aaaaaaaAAAAAAAAAAAAA 5");
		extent.attachReporter(spark);

	}
	
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		//driver.close();
		driver.quit();
		System.out.println("Teardown successful");
	}
	
	


}
