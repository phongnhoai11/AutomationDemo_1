package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.BasePage;

public class HTMLPage extends BasePage {

	//Khai bao locator
	String HTMLUrl = "/html/default.asp";
	
	By htmlTitleLocator = By.cssSelector("#main > h1");
	By homeButtonLocator = By.xpath("(//a[contains(text(),'Home')])[1]");
	
	
	public HTMLPage(WebDriver driver) {
		super(driver);
	}
	
	//Action
	
	public void OpenPage() {
		OpenPage(HTMLUrl, null);
	}
	
	//Get text from element HTML title
	public String GetTextFromHTMLTitle() {
		WebElement htmlTitle = driver.findElement(htmlTitleLocator);
		return htmlTitle.getText();
	}
	
	//Click on Home button, then it will be navigate to Home page
	public HomePage ClickOnHomeButton() {
		driver.findElement(homeButtonLocator).click();
		return new HomePage(driver);
	}
	
}
