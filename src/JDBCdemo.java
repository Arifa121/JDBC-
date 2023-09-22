import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class JDBCdemo {
	public static void main(String[] args) throws SQLException {
		commit();
	}
     
	//Read
	 public static void readRecords()throws SQLException {
		String url="jdbc:mysql://localhost:3306/jdbcdemo";
		String uname="root";
		String pw="Arifa@12";
		String query="select *from student";		
		Connection con=DriverManager.getConnection(url, uname, pw);
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(query);
        
		while(rs.next()) {
		   System.out.println("Id is "+rs.getInt(1));
		   System.out.println("Name is "+rs.getString(2));
		   System.out.println("gpa is "+rs.getFloat(3));
		   System.out.println();
		}
		
		con.close();
	}
	 
	 //insert hardly 
	 public static void insertRecords()throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
			String query="insert into student (name,gpa) values(\"Anupriya\",8)";		
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			Statement st=con.createStatement();
			
			int rows=st.executeUpdate(query);
	        
			
			System.out.println("number of rows affected are "+rows);
			
			
			con.close();
		}
	 //insert using PreparedStatement 
	 public static void insertUsingPSt() throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
			
			String NAME="Varun";
			float GPA=(float) 7.0;
			String query="insert into student (name,gpa) values (?,?);";
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1,NAME);
			pst.setFloat(2, GPA);
			
			int rows=pst.executeUpdate();
	        
			
			System.out.println("number of rows affected are "+rows);
			
			
			con.close();
		}
	 //delete 
	 
	 public static void delete() throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
			
			int id=6;
			String query="delete from student where ID = " +id;		
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			Statement st=con.createStatement();
			
			int rows=st.executeUpdate(query);
	        
			
			System.out.println("number of rows affected are "+rows);
			
			
			con.close();
		}
	 
     //update
	 public static void update() throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
			
			
			String query="update student set gpa=7.3 where ID = 7;";		
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			Statement st=con.createStatement();
			
			int rows=st.executeUpdate(query);
	        
			
			System.out.println("number of rows affected are "+rows);
			
			
			con.close();
		}
	 
	//callable statement
	 public static void sp()throws SQLException {
	 			String url="jdbc:mysql://localhost:3306/jdbcdemo";
	 			String uname="root";
	 			String pw="Arifa@12";
	 				
	 			Connection con=DriverManager.getConnection(url, uname, pw);
	 			
	 			CallableStatement cst=con.prepareCall("{call GetStud()}");
	 			
	 			ResultSet rs=cst.executeQuery();
	 	        
	 			while(rs.next()) {
	 			   System.out.println("Id is "+rs.getInt(1));
	 			   System.out.println("Name is "+rs.getString(2));
	 			   System.out.println("gpa is "+rs.getFloat(3));
	 			   System.out.println();
	 			}
	 			
	 			con.close();
	 		}
	   //calling stored procedure with parameter
	 public static void sp1()throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa";
		    int id=2;		
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			CallableStatement cst=con.prepareCall("{call GetStudbyId(?)}");
			cst.setInt(1, id);
			ResultSet rs=cst.executeQuery();
	        
			while(rs.next()) {
			   System.out.println("Id is "+rs.getInt(1));
			   System.out.println("Name is "+rs.getString(2));
			   System.out.println("gpa is "+rs.getFloat(3));
			   System.out.println();
			}
			
			con.close();
		}
	 public static void sp2()throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
		    int id=1;		
			Connection con=DriverManager.getConnection(url, uname, pw);
			
			CallableStatement cst=con.prepareCall("{call GetNamebyId(?,?)}");
			cst.setInt(1, id);
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.executeUpdate();
			System.out.println("Name is "+cst.getString(2));
			
			con.close();
		}
	 //commit vs auto commit
	 public static void commit()throws SQLException {
			String url="jdbc:mysql://localhost:3306/jdbcdemo";
			String uname="root";
			String pw="Arifa@12";
		    
		    String query1="update student set gpa=9.7 where id=1";
		    String query2="update student set gpa=9.0 where id=2";
			Connection con=DriverManager.getConnection(url, uname, pw);
			Statement st=con.createStatement();
			
			int rows1=st.executeUpdate(query1);
			System.out.println("Rows affected "+rows1);
			int rows2=st.executeUpdate(query2);
			System.out.println("Rows affected "+rows2);
			con.close();
		}	
}
