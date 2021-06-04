package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;



public class ConnectionMysql {
	
	 public static void main(String[] args) {
		 System.setProperty("hsqldb.reconfig_logging", "false");
	      //Connection con = null;

		 
	   	 
	   	 final String DB_NAME = "dbHomeCare";
	   	 
	   	 //use try-with-resources Statement
	   	 try (Connection con = getConnection(DB_NAME)) {
	   		 
	   		 System.out.println("Connection to database " 
	+ DB_NAME + " created successfully");
	   		 
	   	 } catch (Exception e) {
	   		 System.out.println(e.getMessage());
	   	 }
	    }
	    
	    public static Connection getConnection(String dbName)
	   				 throws SQLException, ClassNotFoundException {
	   	 //Registering the HSQLDB JDBC driver
	   	 Class.forName("org.hsqldb.jdbc.JDBCDriver");
	   		 
	      Statement stmt = null;
	      int result = 0;
	   	 /* Database files will be created in the "database"
	   	  * folder in the project. If no username or password is
	   	  * specified, the default SA user and an empty password are used */
	   	 Connection con = DriverManager.getConnection
	   			 ("jdbc:hsqldb:file:database/" + dbName, "SA", "");
	   	 
         stmt = con.createStatement();
         
         result = stmt.executeUpdate("CREATE TABLE tbStaff ( " +
           " id INT NOT NULL, name VARCHAR(50) NOT NULL, " +
           " gender VARCHAR(20) NOT NULL, position VARCHAR(20) NOT NULL," +
           " shift VARCHAR(20), " +
           " PRIMARY KEY (id)); ");
         
	   	 return con;
	    }
	}

