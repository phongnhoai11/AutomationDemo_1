package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	protected WebDriver driver;
	
	//Khởi tạo driver
	@BeforeSuite
	public WebDriver getDriver() {
		System.out.print("Before Suite");
		String browserType = "CHROME";
		switch (browserType) {
			case "CHROME": 
				driver = setUpChromeDriver();
				break;
			case "FIREFOX": 
				driver = setUpFireFoxDriver();
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + browserType);
		}
		return driver;
	}
	
	private static WebDriver setUpChromeDriver() {
		System.setProperty(
				"webdriver.chrome.driver", 
				"drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;
	}
	
	private WebDriver setUpFireFoxDriver() {
		System.setProperty(
				"webdriver.gecko.driver", 
				"drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	@AfterSuite
	public void TearDown(){
		System.out.print("After Suite");
		driver.quit();
	}
}
