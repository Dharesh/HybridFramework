package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genric.Base_Page;

public class Enter_Time_Track extends Base_Page {
@FindBy(xpath = "//a[@class='logout']")
private WebElement lgout;
@FindBy(xpath = "//span[contains(text(),'Help & Support')]")
private WebElement help;
@FindBy(xpath = "//div[contains(text(),'About actiTIME')]")
private WebElement aboutacti;
@FindBy(xpath = "//td[contains(text(),'3.1 (build 15563), Auto-installation package')]")
private WebElement aboutVersion;
@FindBy(xpath = "//img[@class='close']")
private WebElement close;
@FindBy(xpath = "//div[contains(text(),'Report a Bug to Vendor')]")
private WebElement reportBug;
//@FindBy(xpath = "//img[@class='close']")
//private WebElement reportBug;

public Enter_Time_Track(WebDriver driver) {
	super(driver);
}
public void clickonLgout (){
lgout.click();	
}
public void clickOnHelp () {
	help.click();
}
public void clickOnAboutActiTime (){
	aboutacti.click();
}
public String verifyVersion() {
	
	WebElement aversion = null;
	verifyElement(aversion, 10);
return aboutVersion.getText();
}
public void closeVersionWindow() {
close.click();
}
public void clickOnReportBug() {
	reportBug.click();
}
}
