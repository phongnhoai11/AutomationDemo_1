package core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	 String baseUrl = "https://www.w3schools.com";
	 
	 protected WebDriver driver;
	 protected WebDriverWait wait;
	 
	 public BasePage(WebDriver driver) {
		 this.driver = driver;
		 wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	 }
	 
	 protected void OpenPage(String path, String domain) {
		 if(domain != null) {
			 baseUrl = baseUrl.replace("www", domain);
		 }
		 else {
			 driver.get(baseUrl + path);
		}
	 }
}
