package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import core.BasePage;

public class MyLearningPage extends BasePage {

	//domain
	String MyLearningPageURL = "my-learning";
	String MyLearningPage_Title = "My learning | W3Schools";
	
	By contentTitlePageLocator = By.cssSelector(".MainHeader_mainHeaderTitle__14sVT.MainHeader_mainHeaderTitle__14sVT");
	
	public MyLearningPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Get content title page
	public String GetContentTitlePage() {
		wait.until(ExpectedConditions.titleIs(MyLearningPage_Title));
		
		return driver.findElement(contentTitlePageLocator).getText();
	}

}
