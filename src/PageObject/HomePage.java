package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.internal.invokers.Invoker;

import core.BasePage;

public class HomePage extends BasePage {

	private String HOMEUrl = "/default.asp";

	//Locator
	By titleLocator = By.xpath("//h1[@class='learntocodeh1']");
	By videoTutorialLocator = By.xpath("//a[@title='HTML video tutorial']");
	By loginButtonLocator = By.cssSelector("#w3loginbtn");

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void OpenPage() {
		OpenPage(HOMEUrl, null);
	}
	
	//Get text
	public String GetTextFromTitle() {
		return driver.findElement(titleLocator).getText();
	}
	
	//Click on Video tutorial in HTML component
	public VideosPage ClickOnVideoTutorial() {
		driver.findElement(videoTutorialLocator).click();
		
		return new VideosPage(driver);
	}
	
	//Click on Login button
	public LoginPage ClickOnLoginButton() {
		driver.findElement(loginButtonLocator).click();
		
		return new LoginPage(driver);
	}
}
