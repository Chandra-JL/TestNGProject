package testcases;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

//import java.time.Duration;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.Assert;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.LoginPage;

@Listeners(Listener.class)

public class LoginTest extends BaseClass {

	@Test

	public void TC01_LoginFailure() {

		// below commented codes moved to base class and LoginPage.
		/*
		 * WebDriver driver = new FirefoxDriver();
		 * driver.get("https://www.simplilearn.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 * 
		 * WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		 * LoginLink.click();
		 * 
		 * WebElement UserName= driver.findElement(By.name("user_login"));
		 * UserName.sendKeys("abc@xyz.com");
		 * 
		 * WebElement Password= driver.findElement(By.id("password"));
		 * Password.sendKeys("Abc@1234");
		 * 
		 * WebElement Remember= driver.findElement(By.id("remember-me"));
		 * Remember.click();
		 * 
		 * WebElement Loginbtn = driver.findElement(By.name("btn_login"));
		 * Loginbtn.click();
		 */
		LoginPage lp = new LoginPage(); // creating object for LoginPage
		lp.LoginFunction("abc@xyz.com", "Abcd@1234");
		lp.ValidateErrorMsg("The email or password you have entered is invalid.");
		/*
		 * if the text inside double quotes differed with the actual error msg, then
		 * this TC will fail while running Listener class and ss will be captured or
		 * else listener class will be passed and no error ss will be captured,
		 */

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		// WebElement Error = driver.findElement(By.className("error_msg"));
		// String ActMsg = Error.getText();
		// String ExpMsg = "The email or password you have entered is invalid.";
		// Assert.assertEquals(ExpMsg, ActMsg);

		/*
		 * driver.close();
		 */

	}

	@Test
	public void TC02_LoginSuccessTest() {
		LoginPage lp = new LoginPage(); // creating object for LoginPage
		lp.LoginFunction("chandra.jl92@gmail.com", "Pratheesha123*");

	}

//	@Test
	//@Parameters({ "param1", "param2" })
	//public void TC03_LoginSuccessTest(String Uname, String Pwd) {

		//LoginPage lp = new LoginPage();
		//lp.LoginFunction(Uname, Pwd);

	//}

	Map<String, String> testdata = new HashMap<String, String>();

	@Test(dataProvider = "dp")
	public void TC04_LoginSuccessTest(String key) {

		LoginPage lp = new LoginPage();
		lp.LoginFunction(key, testdata.get(key));

	}

	@DataProvider(name = "dp")
	public Iterator<String> method1() {

		testdata.put("aaa@xyz.com", "Abc@1234");
		testdata.put("bbb@xyz.com", "Abc@1234");
		testdata.put("ccc@xyz.com", "Abc@1234");

		return testdata.keySet().iterator();

	}
public void TC05_LoginFailureTest() {
		
		LoginPage lp = new LoginPage();
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		lp.LoginFunction(UserNameVal, PasswordVal);
		lp.ValidateErrorMsg("The email or password you have entered is invalid.");
			
		
	}


}
