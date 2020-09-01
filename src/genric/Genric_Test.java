package genric;

import java.util.concurrent.TimeUnit;

import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Genric_Test implements Auto_const {
	File_Manager fm=new File_Manager();
	public WebDriver driver ;	
	@Parameters({"browser"})
     @BeforeMethod
     public void openApp(@Optional("chrome") String browser)//precondition
     {
		if(browser.equals("chrome"))
		{
	  System.setProperty(chrome_key, chrome_value);
	  driver = new ChromeDriver();
	  driver.get(fm.getQatUrl());
		}else if(browser.equals("firefox")){
			System.setProperty(gecko_key, gecko_Value);
			  driver = new FirefoxDriver();
			  driver.get(fm.getQatUrl());
		}
		driver.manage().window().maximize(); //max the browser
		  driver.manage().timeouts().implicitlyWait(fm.getimplicetlyWait(), TimeUnit.SECONDS);
	  }
     @AfterMethod
     public void closeApp(ITestResult res){ //
    	 System.out.println(res.getStatus());
    	 String testName = res.getName();
    	 if (ITestResult.FAILURE==res.getStatus())
    	 {
    		 new Screenshots().capture(driver,testName);//
    	 }
    	 
     driver.quit();
}



}

