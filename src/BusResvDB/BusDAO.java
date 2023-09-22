package BusResvDB;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {
       
	public void displayBusinfo() throws SQLException {
		String query="select *from bus";
		Connection con=Dbconnection.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			   System.out.println("Bus No is "+rs.getInt(1));
			   if(rs.getInt(2)==0) {
				   System.out.println("AC: no ");
			   }
			   else {
				   System.out.println("AC: yes ");
			   }
			   System.out.println("Capacity "+rs.getInt(3));
			   System.out.println("------------------------------------------");
		}
	}
	public int getcapacity(int id) throws SQLException{
		String query="select capacity from bus where id=" +id;
		Connection con=Dbconnection.getconnection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next(); //because eduthona cursor header la thaan irukum
		return rs.getInt(1);
	}
}
