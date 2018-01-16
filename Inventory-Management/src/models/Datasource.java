package models;
//Establishing the properties required to connect to Database
public class Datasource {
	//Use properties and credentials based on the database being used.
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/shoppingcart";
	private String user = "yash";
	private String password = "mysql";
	//
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

		

}
