package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genric.Base_Page;

public class Report_Bug_Vendor extends Base_Page{
@FindBy(xpath = "//textarea[@id='bug']")
private WebElement description;

@FindBy(xpath = "//input[@id='firstName']")
private WebElement fname;
@FindBy(xpath = "//input[@id='lastName']")
private WebElement lname;
@FindBy(xpath = "//input[@id='emailAddress']")
private WebElement email;
@FindBy(xpath = "//input[@id='companyName']")
private WebElement cname;
@FindBy(xpath = "//input[@id='submitButton']")
private WebElement send;


public Report_Bug_Vendor (WebDriver driver) {
	super(driver);
}



public void enterBugDescription (String desc){
	description.sendKeys(desc);
	}
public void enterFirstName (String firstname){
	fname.sendKeys(firstname);
	}
public void enterLasttName (String lastname){
	lname.sendKeys(lastname);
	}
public void enterEmail (String email1){
	email.sendKeys(email1);
	}
public void enterCompanyName (String company){
	cname.sendKeys(company);
	}
public void clickOnSendBugReport(){
	send.click(); 
	}
}
