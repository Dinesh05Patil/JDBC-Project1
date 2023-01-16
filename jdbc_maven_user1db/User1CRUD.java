package jdbc_maven_user1db;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;

import jdbc_maven_user1db.User1;


public class User1CRUD {
	
	public Connection getConnection() throws Exception {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
	
		FileInputStream fileInputStream = new FileInputStream("dbconfig.properties");
		Properties properties=new Properties();
		properties.load(fileInputStream);
		
		Connection connection=DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),properties.getProperty("password"));
		
		return connection;
	}
	public void signupUser(User1 user1) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into user1 values(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, user1.getId());
		preparedStatement.setString(2, user1.getName());
		preparedStatement.setString(3, user1.getEmail());
		preparedStatement.setString(4, user1.getPassword());
		preparedStatement.setString(5, user1.getAddress());
		preparedStatement.setString(6, user1.getFacebookpwd());
		preparedStatement.setString(7, user1.getInstapwd());
		preparedStatement.setString(8, user1.getSnapchatpwd());
		preparedStatement.setString(9, user1.getWhatsapppwd());
		preparedStatement.setString(10, user1.getTwiiterpwd());
		
		preparedStatement.execute();
		connection.close();
		System.out.println("  SIGNED UP ");
	}
	
	
	public boolean loginUser(User1 user1)throws Exception{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from user1 where name=?");
		preparedStatement.setString(1, user1.getName());
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		while(resultSet.next()) {
			password=resultSet.getString("password");
		}
		if(password.equals(user1.getPassword())) {
			return true;
		}
		
		return false;
		
		
	}
	
	

}
