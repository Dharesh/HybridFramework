package genric;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.management.RuntimeErrorException;

public class File_Manager {
	Properties pro;
	
public File_Manager( ) {
	try { // advantage of declaring object in the constructor is we can use same object in all method
		FileInputStream	 fis=new FileInputStream("E:\\Eclipse\\Testq\\env.properties");
	 pro=new Properties();
	 pro.load(fis);// Load the property
	} catch (Exception e) {
	System.out.println("property File not found");
	}
} 
	public String getQatUrl() {
		String url = pro.getProperty("qat");
		{
			if (url!=null) {
				return url;
			}
			else {  //throw and throws concept from java
				throw new RuntimeException("qat not found in Property file");
			}
		}
		
			}
	public String getPreProdQatUrl() {
		String url = pro.getProperty("prepod");
		return url;
}
	
	public String getProdQatUrl() {
		String url = pro.getProperty("pod");
		return url;
}
	public Long getimplicetlyWait() {
		String url = pro.getProperty("ImplecitlyWait");
		long val = Long.parseLong(url);
		return val;
	}
	
}