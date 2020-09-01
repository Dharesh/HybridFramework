package genric;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base_Page  {
	WebDriver driver; //default value is null
	public  Base_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);  //this is super class
		
	}
	public void verifyTitle(String title,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.titleContains(title));
		System.out.println("valid Title");		
		} catch (Exception e) {
		System.out.println("invalid title");
		Assert.fail();
		} }

public void verifyElement(WebElement element, int time) {
	
	WebDriverWait wait = new WebDriverWait(driver, time);
	try {
		wait.until(ExpectedConditions.visibilityOf(element));
	System.out.println("Element is visible");		
	} catch (Exception e) {
	System.out.println("Element is not visible");
	}
	 }
	
	public void verifyChildtab(int noofwindow,int time) {
		
		WebDriverWait wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.numberOfWindowsToBe(noofwindow));
		System.out.println("child tab present");		
		} catch (Exception e) {
		System.out.println("child tab is not present");
		} }
public void mousehoverAction(WebElement element) {
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();	
}
public void rightClick(WebElement element) {
	Actions r = new Actions(driver);
	r.contextClick(element).perform();
}
public void selectByName(WebElement element,String value,int index,String val,int dindex,String dval) {
	Select s = new Select(element) ;
	s.selectByVisibleText(value);
	s.selectByIndex(index);
	s.selectByValue(val);
 s.deselectByIndex(dindex);
	s.deselectByValue(dval);
}
public List<String> getAllOptionfromDropdown(WebElement element) { //example for RTP
	//RTP
	List<String> l=new ArrayList<String>();
Select s = new Select(element) ;
List<WebElement> options = s.getOptions();
for (WebElement opt : options) {
	l.add(opt.getText());
}
return l;
}

public void scrollToSpecificLoction(WebElement element) {
	int x = element.getLocation().getX();
	int y = element.getLocation().getY();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	//js.executeScript("window.scrollBy("+x+""+y+")");
	js.executeScript("arguement[0].scrollIntoview()",element);
}
//public void handleAlertPopUps() {
//	Object pp = driver.switchTo().alert();
//pp.
//}

}