package models;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//Creating a singleton class for database connection instance.
public final class DBconnection {
private static Connection conn=null;
private DBconnection()
{
//do nothing
}

public static final Connection getConnection(Datasource ds)
{
if(conn==null)
{
String dbURL = ds.getUrl();
String username = ds.getUser();
String password = ds.getPassword();
String driver = ds.getDriver();

try 
{
Class.forName(driver);
Properties props = new Properties();
props.setProperty("unicode","useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8");
props.setProperty("user", username);
props.setProperty("password", password);
conn=DriverManager.getConnection(dbURL, props);
} 
catch(ClassNotFoundException ex)
{
ex.printStackTrace();
System.out.println("Class not found");
}
catch (SQLException ex) {
   
   System.out.println("SQLException: " + ex.getMessage());
   System.out.println("SQLState: " + ex.getSQLState());
   System.out.println("VendorError: " + ex.getErrorCode());
}
catch(Exception e)
{
e.printStackTrace();
System.out.println("Exception");
}
return conn;
}
return conn;
}
}
