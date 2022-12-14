package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
 private static Properties prop= new Properties();
 private static String FILE_NAME = "Test.properties";
 
 
 public Config() throws IOException {
	 InputStream input = Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
	 
	 prop.load(input);
 }
 
 public static void setProperties() {
	 InputStream input = Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
	 
	 try {
		prop.load(input);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
 public static String getProperties(String spropertyName) {
	 String spropertyValue = null;
	 spropertyValue=prop.getProperty(spropertyName);
	 return spropertyValue;
 }
	
	
}
