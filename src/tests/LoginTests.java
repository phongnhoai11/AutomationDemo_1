package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.MyLearningPage;
import PageObject.VideosPage;
import beforeRunningTest.BeforeLoginTests;
import core.BaseTest;
import dataProviders.LoginDataProvider;

public class LoginTests extends BeforeLoginTests {


	private VideosPage videosPage;
	private LoginPage loginPage;
	private MyLearningPage myLearningPage;
	
	@Test(description = "Verify error message when login unsuccessfully", groups = { "suiteone"}, priority = 3)
	public void VerifyErrorMessageIfLoginWithInvalidCreds() {
		String introduceTextExpected = "Learn the basics of HTML in this fun and engaging video tutorial.";
		String errorMessageExpected = "A user with this email does not exist";
		
		//Action
		 videosPage = homePage.ClickOnVideoTutorial();
		 String introduceText = videosPage.GetIntroduceText();
		 
		 Assert.assertEquals(introduceText, introduceTextExpected);
		
		 loginPage = videosPage.ClickOnGetPro();
		 loginPage.FillInLoginForm("abc", "abcd");
		 loginPage.ClickOnLogin();
		 
		 String errorMessageActual = loginPage.GetErrorMessage();
		 
		 //Assert
		 Assert.assertEquals(errorMessageActual, errorMessageExpected);
	}
	
	@Test(description = "Verify login function", dataProvider = "login_data_1", dataProviderClass = LoginDataProvider.class)
	public void VerifyLoginFunction(String email, String password, boolean isEmailValid, boolean isPswValid) {
		//Declare
		String contentTitlePage ="My learning";
		String invalidEmailErrorMessage = "Make sure you type your email and password correctly. Both your password and email are case-sensitive.";
		String invalidBothEmailAndPsw = "A user with this email does not exist";
		String actualErrorMessage = null;
		
		//Action
		loginPage = homePage.ClickOnLoginButton();
		loginPage.FillInLoginForm(email, password);
		myLearningPage = loginPage.ClickOnLogin();
		
		//Assert
		//if email + psw dung => assert: navigate to My learning | W3Schools
		if(isEmailValid && isPswValid) {
			String actualContentTitle = myLearningPage.GetContentTitlePage();
			assertEquals(actualContentTitle, contentTitlePage);
		}
		
		//if email dung/ psw sai => Make sure you type your email and password correctly. Both your password and email are case-sensitive.
		if(isEmailValid && isPswValid == false) {
			actualErrorMessage = loginPage.GetErrorMessage();
			assertEquals(actualErrorMessage, invalidEmailErrorMessage);
		}
		
		//if email sai/ psw dung => A user with this email does not exist
		//if email sai/ psw sai => A user with this email does not exist
		if(isEmailValid == false && isPswValid == false) {
			actualErrorMessage = loginPage.GetErrorMessage();
			assertEquals(actualErrorMessage, invalidBothEmailAndPsw);
		}
	}
	
	@DataProvider(name = "login_data")
	public Object[][] LoginData() {
		// 							email, 						psw, 			isEmailValid, 	isPswValid
		return new Object[][] { { "phong.nhoai@gmail.com", 		"Password12!", 	true, 			false },
								{ "phong.nhoai11@gmail.com", 	"Password1!", 	false, 			true },
								{ "phong.nhoai11@gmail.com", 	"Password12!", 	false, 			false },
								{ "phong.nhoai@gmail.com", 		"Password1!", 	true, 			true }};
	}
}
