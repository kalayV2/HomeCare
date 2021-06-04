package application;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.Statement;  

public class ClassInsertQuery {
	 public static void main(String[] args) { 
	      Connection con = null; 
	      Statement stmt = null; 
	      int result = 0; 
	      try { 
	         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
	         con = DriverManager.getConnection("jdbc:hsqldb:file:database/dbHomeCare", "SA", ""); 
	   		 System.out.println("Connection to database created successfully");
	         stmt = con.createStatement(); 
	         result = stmt.executeUpdate("INSERT INTO tbStaff VALUES (003,'sear123', 'Male', 'Doctor','')"); 
	         con.commit(); 
	      }catch (Exception e) { 
	         e.printStackTrace(System.out); 
	      } 
	      System.out.println(result+" rows effected"); 
	      System.out.println("Rows inserted successfully"); 
	   } 
	} 

