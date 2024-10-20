package pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

//import testcases.BaseClass;

public class LoginPage {

	WebDriver driver;
	// WebDriver driver = BaseClass.driver;
	/*
	 * below codes will be changed to page factory
	 * 
	 * public void LoginFunction(String UserNameVal, String PwdVal) {
	 * 
	 * WebElement LoginLink = driver.findElement(By.linkText("Log in"));
	 * LoginLink.click();
	 * 
	 * WebElement UserName= driver.findElement(By.name("user_login"));
	 * UserName.sendKeys(UserNameVal);
	 * 
	 * WebElement Password= driver.findElement(By.id("password"));
	 * Password.sendKeys(PwdVal);
	 * 
	 * WebElement Remember= driver.findElement(By.id("remember-me"));
	 * Remember.click();
	 * 
	 * WebElement Loginbtn = driver.findElement(By.name("btn_login"));
	 * Loginbtn.click();
	 */

	// ==================== Locators ======================

	@FindBy(linkText = "Log in")
	WebElement LoginLink;

	@FindBy(name = "user_login")
	WebElement UserName;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(id = "remember-me")
	WebElement RememberMe;

	@FindBy(name = "btn_login")
	WebElement LoginBtn;

	@FindBy(className = "error_msg")
	WebElement Error;

	// ====================== Functions =====================

	public LoginPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	public void LoginFunction(String UserNameVal, String PwdVal) {

		LoginLink.click();
		UserName.sendKeys(UserNameVal);
		Password.sendKeys(PwdVal);
		RememberMe.click();
		LoginBtn.click();
	}

	public void ValidateErrorMsg(String ExpMsg) {

		String ActMsg = Error.getText();
		Assert.assertEquals(ExpMsg, ActMsg);
	}

}
