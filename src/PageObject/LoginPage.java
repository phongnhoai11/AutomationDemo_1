package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;

public class LoginPage extends BasePage{

	String LoginURL = "/login";
	String webTitle = "Log in - W3Schools";
	//Locator
	//email
	By emailLocator = By.cssSelector("#modalusername");
	
	//pass
	By pwdLocator = By.cssSelector("#current-password");
	
	//login btn
	By loginButtonLocator = By.xpath("//span[contains(text(),'Log in')]/parent::button");
	
	//error message
	By errorMessageLocator = By.cssSelector(".Alert_iwrp__5q1xH.Alert_danger__Wsdhv");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void OpenPage() {
		OpenPage(LoginURL, null);
	}
	
	//Input value to form
	public void FillInLoginForm(String email, String password) {
		wait.until(ExpectedConditions.titleIs(webTitle));
		
		driver.findElement(emailLocator).sendKeys(email);
		driver.findElement(pwdLocator).sendKeys(password);
	}
	
	//Click on login btn
	public MyLearningPage ClickOnLogin() {
		driver.findElement(loginButtonLocator).click();
		
		return new MyLearningPage(driver);
	}
	
	//Get error message
	public String GetErrorMessage() {
		WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(errorMessageLocator));
		
		return errorMessage.getText();
	}
}
