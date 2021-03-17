package com.jobT.web.connection;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//connection 관리
public class ConnectionProvider {
    public static Connection getConnection() throws ClassNotFoundException {
	Connection conn = null;
		
	try { 
		 String url = "jdbc:mysql://3.35.244.119:3306/jobt";
		 String id = "kimdo";
		 String pw = "1234";
		 String driver = "com.mysql.jdbc.Driver";
		 Class.forName(driver);
		 conn = DriverManager.getConnection(url, id, pw);    
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return conn;
    }
}