package dataProviders;

import org.testng.annotations.DataProvider;

public class LoginDataProvider {
	
	@DataProvider(name = "login_data_1")
	public Object[][] LoginData() {
		// 							email, 						psw, 			isEmailValid, 	isPswValid
		return new Object[][] { { "phong.nhoai@gmail.com", 		"Password12!", 	true, 			false },
								{ "phong.nhoai11@gmail.com", 	"Password1!", 	false, 			true },
								{ "phong.nhoai11@gmail.com", 	"Password12!", 	false, 			false },
								{ "phong.nhoai@gmail.com", 		"Password1!", 	true, 			true }};
	}
}
