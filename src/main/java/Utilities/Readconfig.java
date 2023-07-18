package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class Readconfig {
	
	Properties pro;
	
public Readconfig()
{

	File src=new File("./Configuration/config.properties");
	
	try {
		FileInputStream file=new FileInputStream(src);
		pro=new Properties();
		pro.load(file);
		
	} catch (Exception e) {
	
	System.out.println( " Exception is"+ e.getMessage());
	}
}
public String getAppURL()
{
	String  url=pro.getProperty("baseURL");
return url;

}
public String getusername()
{
	String  username=pro.getProperty("username");
return username;

}
public String getpassword()
{
	String  password=pro.getProperty("password");
return password;

}
public String getchromepath()
{
	String  chromepath=pro.getProperty("chromepath");
return chromepath;

}
public String getfirefox()
{
	String  firefoxpath=pro.getProperty("firefox");
return firefoxpath;

}



}
