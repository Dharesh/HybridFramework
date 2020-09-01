package regressionScripts;
import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import genric.Excel;
import genric.Genric_Test;
import pom.Enter_Time_Track;
import pom.Login_page;
import pom.Report_Bug_Vendor;


public class Regression extends Genric_Test {

@Test 
public void validLoginLogout() {
	
	String username = Excel.readData("regression", 1, 0);
	String password = Excel.readData("regression", 1, 1 );
	String hp_Title = Excel.readData("regression", 1, 3);
	
	Login_page lp=new Login_page(driver); 
	lp.enterUn(username);
	lp.enterPs(password);
	lp.clickLogin();
	Enter_Time_Track hp=new Enter_Time_Track(driver) ;
	hp.verifyTitle(hp_Title, 10);
	hp.clickonLgout();
}

@Test
public void invalidLogin() {
	String username = Excel.readData("regression", 2, 0);
	String password = Excel.readData("regression", 2, 1);
	String lp_title = Excel.readData("regression", 2, 2);
	Login_page lp=new Login_page(driver); 
	lp.enterUn(username);
	lp.enterPs(password);
	lp.clickLogin();
	lp.verifyErrorMsg();
	lp.verifyTitle(lp_title, 10);
}
@Test
public void verifyActiTimeVersion() {
	String username = Excel.readData("regression", 3, 0);
	String password = Excel.readData("regression", 3, 1);
	String eVersion = Excel.readData("regression", 3, 4);

	Login_page lp=new Login_page(driver); 
	lp.enterUn(username);
	lp.enterPs(password );
	lp.clickLogin();
	Enter_Time_Track hp=new Enter_Time_Track(driver) ;
	hp.clickOnHelp();
	hp.clickOnAboutActiTime();
	String aversion = hp.verifyVersion();
	Assert.assertEquals(aversion, eVersion);
	hp.closeVersionWindow();
	
}
@Test
public void sendBugReport() {
	String username = Excel.readData("regression", 4, 0);
	String password = Excel.readData("regression", 4, 1);
	String bugSummary = Excel.readData("regression", 4, 5);
	String fn = Excel.readData("regression", 4, 6);
	String ln = Excel.readData("regression", 4, 7);
	String email = Excel.readData("regression", 4, 8);
	String company = Excel.readData("regression", 4, 9);
	Login_page lp=new Login_page(driver); 
	lp.enterUn(username);
	lp.enterPs(password);
	lp.clickLogin();
	Enter_Time_Track hp=new Enter_Time_Track(driver) ;
	hp.clickOnHelp();
	hp.clickOnReportBug();
    hp.verifyChildtab(2, 5);
	Set<String> ch = driver.getWindowHandles();
	for (String tab : ch) {
		driver.switchTo().window(tab);// write genric method for this in base page
	}
	Report_Bug_Vendor rp=new Report_Bug_Vendor (driver);
	rp.enterBugDescription(bugSummary);
	rp.enterFirstName(fn);
	rp.enterLasttName(ln);
	rp.enterEmail(email );
	rp.enterCompanyName(company);
	rp.clickOnSendBugReport();
	
}

}