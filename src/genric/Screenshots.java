package genric;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots implements Auto_const{

		public void capture(WebDriver driver,String testName) {
			String date = new Date().toString().replace(":", "-");
			TakesScreenshot ts=(TakesScreenshot) driver ;
			File srs = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(photo_path + testName+date+".png" );
			try {
				FileHandler.copy(srs,dest);
			} catch (IOException e) {
				System.out.println("Fail to Take Screenshot");
			}
			
					
	}

}
