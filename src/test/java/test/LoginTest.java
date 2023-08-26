package test;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.AccountPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	WebDriver driver;
	 Logger log;
	@Test(dataProvider = "getLoginData")
	public void Login(String email, String password, String expectedResult) throws IOException, InterruptedException {
		
        LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on MyAccount option");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");

		Thread.sleep(3000);

		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(email);
		log.debug("Email entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password entered");
		loginPage.loginButton().click();
		log.debug("Clicked on login button");

		AccountPage accountPage = new AccountPage(driver);

		String actualResult;
		try {
			accountPage.editAccount().isDisplayed();
			log.info("Successfully logged in");
			System.out.println("tyr block");
			actualResult = "Pass";
		} catch (Exception e) {
			log.error("Login Failed");
			System.out.println("catch block");
			actualResult = "Fail";
		}
       Assert.assertEquals(actualResult, expectedResult);
       log.info("Test got passed");
	}

	@BeforeMethod
	public void Open() throws IOException {
	    log = LogManager.getLogger(LoginTest.class.getName());
		driver = initializeDriver();
		log.debug("Browser got opened");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to url");
	}
    
	@AfterMethod
	public void Closure() {
		
		driver.quit();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { { "pavankumar47159@gmail.com", "Pavan@1234", "Pass" },
				{ "test@gmail.com", "Test@123", "Fail" } };
		return data;
	}
}