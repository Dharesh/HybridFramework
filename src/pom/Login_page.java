package pom;

import static org.testng.Assert.assertTrue;

import org.apache.commons.codec.binary.Base32;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import genric.Base_Page;

public class Login_page extends Base_Page {     //declaration
	
@FindBy(xpath="//input[@name='username']")
private WebElement username;
@FindBy(xpath="//input[@name='pwd']")
private WebElement password;
@FindBy(xpath="//a[@id='loginButton']")
private WebElement lgn_button;
@FindBy(xpath="//span[contains(text(),'Username or Password is invalid. Please try again.')]")
private WebElement errmsg;

// declare or initialization constructor once and reuse it is called constructor chaining
// subclass construtor calling super class constructor is known as constructor chaining
public Login_page(WebDriver driver) {
	super(driver);
}


public void enterUn(String un) {
	username.sendKeys(un);
}
public void enterPs(String ps) {
	password.sendKeys(ps);
}
public void clickLogin() {
	lgn_button.click();
	}

	public void verifyErrorMsg() {
		verifyElement(errmsg, 10);
	}

}