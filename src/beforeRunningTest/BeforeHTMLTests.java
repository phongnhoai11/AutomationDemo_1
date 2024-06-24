package beforeRunningTest;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.BeforeClass;

import PageObject.HomePage;
import core.BaseTest;

public class BeforeHTMLTests extends BaseTest {

	protected HomePage homePage;

	// Chay chi 1 lan truoc khi chay cac test
	@BeforeClass
	public void SetUp(ITestContext context) {
		System.out.print("Before Class");
		ITestNGMethod[] tMethod = context.getAllTestMethods();
		for(ITestNGMethod tMethod_1 : tMethod) {
			if(tMethod_1.getRealClass() == this.getClass()) {
				System.out.print(tMethod_1.getConstructorOrMethod().getName());
			}
		}
	}

	// Chay truoc khi chay Test, co the chay nhieu lan
	// So lan chay se ti le thuan vs so luong TC
	@org.testng.annotations.BeforeMethod
	public void BeforeMethod() {
		System.out.print("Before Method");
		homePage = new HomePage(driver);
		homePage.OpenPage();
	}

	// Chay sau khi chay Test, co the chay nhieu lan
	// So lan chay se ti le thuan vs so luong TC
	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		System.out.print("After Method");
		// driver.close();
	}

	// Chay chi 1 lan sau khi chay tat ca cac test
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.print("After Class");
	}
}
