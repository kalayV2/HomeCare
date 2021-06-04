package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.SQLException;

public class MysqlConnection {
	
	public MysqlConnection() {
			    }
	
	public Connection connect() throws Exception{
	    Connection con = null;
		String url = "jdbc:mysql://localhost:3306/dbHomeCare";
	    String username = "root";
	    String password = "kalay";
	    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      con = DriverManager.getConnection(url, username, password);		    
		    } catch (SQLException ex) {
		        throw new Error("Error ", ex);
		    }
	    return con;
	}
	
}