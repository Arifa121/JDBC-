package BusResvDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	private static final String url="jdbc:mysql://localhost:3306/busResv";
	private static final String uname="root";
	private static final String pw="Arifa@12";
	
	public static Connection getconnection() throws SQLException{
	   return DriverManager.getConnection(url, uname, pw);
	}
}
