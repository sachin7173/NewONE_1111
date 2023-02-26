package Test_Classes;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POM_Classes.BaseClass;
import POM_Classes.HomePage;
import POM_Classes.LoginPage;
import POM_Classes.LogoutPage;
import POM_Classes.SigninPage;
import POM_Classes.UtilityClass;

public class Test_1 extends BaseClass {
SigninPage signin;
LoginPage login;
HomePage home;
LogoutPage logout;
@BeforeClass
public void openBrowser12() throws IOException, InterruptedException {
	openBrowser();
	signin =new SigninPage(driver);
	login=new LoginPage(driver);
	home=new HomePage(driver);
	logout=new LogoutPage(driver);
	
}
@BeforeMethod
public void login12() throws IOException, InterruptedException {
	signin.signinbtn12();
	login.Username12(UtilityClass.getPropertyFileData("username"));
	login.password12(UtilityClass.getPropertyFileData("password"));
	login.loginbtn12();
	Thread.sleep(2000);
	home.accountbtn12();
}
@Test
public void verifyusername123() throws IOException {
	String expResult = UtilityClass.getPropertyFileData("username1");
	String actResult = home.verifyusername12();
	SoftAssert soft=new SoftAssert();
	soft.assertEquals(actResult, actResult,"act and exp result is different");
	soft.assertAll();
}
@AfterMethod
public void logout12(ITestResult result) throws IOException, InterruptedException {
	if(result.getStatus()==ITestResult.FAILURE) {
		int TCID=2324;
		UtilityClass.CaptureScreenshot(driver, TCID);
		Thread.sleep(2000);
	}logout.logoutbtn12();
}
@AfterClass
public void closeBrowser() {
	driver.quit();
}


}
