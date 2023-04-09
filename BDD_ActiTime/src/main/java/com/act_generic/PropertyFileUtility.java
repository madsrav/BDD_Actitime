package com.act_generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class PropertyFileUtility {
	Properties properties;
	public void loadProperty() throws IOException
	{

	FileInputStream fis = new FileInputStream(IAutoConstants.PROPERTY_FILE);
	properties= new Properties();
	properties.load(fis);
	}
	public String getBrowser() 
	{
	return 	properties.getProperty("browser");
	}
	
	public String getURL()
	{
		return properties.getProperty("url");
	}
	
	public String getusername()
	{
		return properties.getProperty("username");
	}
	
	public String getpassword()
	{
		return properties.getProperty("password");
	}
	
	public int getImplicitWait()
	{
		return Integer.parseInt(properties.getProperty("implicitwait"));
	}
	public String getRemote()
	{
		return properties.getProperty("remote");
	}
}
