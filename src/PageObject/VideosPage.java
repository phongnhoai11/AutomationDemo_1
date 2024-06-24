package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;

public class VideosPage extends BasePage {

	String videoURLPath = "/videos/index.php";
	String videoWebTitle = "Video Tutorials - W3Schools";
	//Locator
	By videoTitleLocator = By.xpath("//script[@type='text/javascript']/parent::head/title");
	By subHeadingLocator = By.xpath("//h3[@class='subheading']");
	By getProLocator = By.xpath("(//a[@id='plans_pro_btn'])[1]");
	
	public VideosPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void OpenPage() {
		OpenPage(videoURLPath, null);
	}

	//Get introduce text from Videos page
	public String GetIntroduceText() {
		wait.until(ExpectedConditions.titleIs(videoWebTitle));
		
		return driver.findElement(subHeadingLocator).getText();
	}
	
	//Click on Get Pro button
	public LoginPage ClickOnGetPro() {
		WebElement getPro = wait.until(ExpectedConditions.elementToBeClickable(getProLocator));
		getPro.click();
		
		return new LoginPage(driver);
	}
}
