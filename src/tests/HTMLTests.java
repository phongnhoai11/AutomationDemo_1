package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HTMLPage;
import PageObject.HomePage;
import beforeRunningTest.BeforeHTMLTests;
import core.BaseTest;

public class HTMLTests extends BeforeHTMLTests {

	@Test(description = "Test 01", groups = {"suiteone"}, priority = 1)
	public void VerifyThatCanClickOnHomeButton() throws InterruptedException {
		//Declare
		//neu case 1 da pass roi, thi chi vao TCID lay result 
		String homeText = "HTML Tutorial"; //expected
		String homePageTitle = "Learn to Code";
		
		Thread.sleep(4000);
		HTMLPage htmlPage = new HTMLPage(driver);
		htmlPage.OpenPage();
		Thread.sleep(4000);
		
		//Action
		//done expected case1
		String textABC = htmlPage.GetTextFromHTMLTitle();
		
		HomePage homepage = htmlPage.ClickOnHomeButton();
		Thread.sleep(4000);
		String text1 = homepage.GetTextFromTitle();
		
		//Assert -> pass/ fail
		Assert.assertEquals(textABC, homeText);
		Assert.assertEquals(text1, homePageTitle);
	}
	
	@Test(description = "Test 02", groups = {"suiteone"}, priority = 2)
	public void VerifyThatCanClickOnHomeButton_2() throws InterruptedException {
		
		//Declare
		String homeText = "HTML Tutorial"; //expected
		String homePageTitle = "Learn to Code";
				
		Thread.sleep(4000);
		HTMLPage htmlPage = new HTMLPage(driver);
		htmlPage.OpenPage();
		Thread.sleep(4000);
				
		//Action
		String text = htmlPage.GetTextFromHTMLTitle();
		HomePage homepage = htmlPage.ClickOnHomeButton();
		Thread.sleep(4000);
		String text1 = homepage.GetTextFromTitle();
				
		//Assert -> pass/ fail
		Assert.assertEquals(text, homeText);
		Assert.assertEquals(text1, homePageTitle);
	}
	
	
}
