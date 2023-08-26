package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id=\"content\"]/h1")
	WebElement registerText;
	@FindBy(id = "input-firstname")
	WebElement firstName;
	@FindBy(id = "input-lastname")
	WebElement lastName;
	@FindBy(id = "input-email")
	WebElement inputEmail;
	@FindBy(id = "input-telephone")
	WebElement number;
	@FindBy(id = "input-password")
	WebElement inputPassword;
	@FindBy(id = "input-confirm")
	WebElement confirmPassword;
	@FindBy(css = "input[name=\"agree\"]")
	WebElement checkbox;
	@FindBy(css = "input[value=\"Continue\"]")
	WebElement continueButton;
	@FindBy(linkText="Success")
	WebElement success;

	public WebElement registerText() {
		return registerText;
	}

	public WebElement firstName() {
		return firstName;
	}

	public WebElement lastName() {
		return lastName;
	}

	public WebElement inputEmail() {
		return inputEmail;
	}

	public WebElement number() {
		return number;
	}

	public WebElement inputPassword() {
		return inputPassword;
	}

	public WebElement confirmPassword() {
		return confirmPassword;
	}

	public WebElement checkbox() {
		return checkbox;
	}

	public WebElement continueButton() {
		return continueButton;
	}
	
	public WebElement success() {
		return success;
	}
}
