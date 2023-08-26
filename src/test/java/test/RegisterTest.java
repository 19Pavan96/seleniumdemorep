package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.RegisterPage;
import resources.Base;

public class RegisterTest extends Base {
	public WebDriver driver;
	 Logger log;
   @Test
	public void Register() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.registerOption().click();

		RegisterPage registerPage = new RegisterPage(driver);
		String actRes = null;
		try {
			registerPage.registerText().isDisplayed();
			actRes = "Pass";
		} catch (Exception e) {
			actRes = "Fail";
		}
		registerPage.firstName().sendKeys(prop.getProperty("first"));
		registerPage.lastName().sendKeys(prop.getProperty("last"));
		registerPage.inputEmail().sendKeys(prop.getProperty("mail"));
		registerPage.number().sendKeys(prop.getProperty("mobile"));
		registerPage.inputPassword().sendKeys(prop.getProperty("pass"));
		registerPage.confirmPassword().sendKeys(prop.getProperty("pass"));
		registerPage.checkbox().click();
		registerPage.continueButton().click();

		Assert.assertTrue(registerPage.success().isDisplayed());
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
		
	}

}
