package beforeRunningTest;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.VideosPage;
import core.BaseTest;

public class BeforeLoginTests extends BaseTest {

	protected HomePage homePage;

	// Chay chi 1 lan truoc khi chay cac test
	@BeforeClass
	public void SetUp(ITestContext context) {
		System.out.print("Before Class");
		ITestNGMethod[] tMethod = context.getAllTestMethods();
		for (ITestNGMethod tMethod_1 : tMethod) {
			if (tMethod_1.getRealClass() == this.getClass()) {
				System.out.print(tMethod_1.getConstructorOrMethod().getName());
			}
		}
	}

	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.println("Before method");
		homePage = new HomePage(driver);
		homePage.OpenPage();
	}

	@AfterMethod
	public void AfterMethod() {
		System.out.println("After method");
	}
}
