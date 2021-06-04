package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ClassSelectQuery {
	   public static void main(String[] args) {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
    	System.setProperty("hsqldb.reconfig_logging", "false"); 
       Class.forName("org.hsqldb.jdbc.JDBCDriver");
       con = DriverManager.getConnection("jdbc:hsqldb:file:database/dbHomeCare", "SA", "");
       System.out.println("Connection to database created successfully");
       stmt = con.createStatement();
       String query = "SELECT * FROM tbStaff ";
       rs = stmt.executeQuery(query);
       System.out.println(query);
  /*     while(result.next()){
          System.out.println(result.getInt("id")+" | "+
             result.getString("name")+" | "+
             result.getString("gender")+" | "+
             result.getString("position")+" | "+
             result.getString("shift"));
       }
   */    
       while(rs.next()){
       int empNo= rs.getInt("id");
       String eName= rs.getString("name");
       String gender = rs.getString("gender");
       String position = rs.getString("shift");
       String shift = rs.getString("shift");
       System.out.println(empNo+ ", " + eName+ ", " + gender + ", " + position + ", " + shift );
       }

    } catch (Exception e) {
       e.printStackTrace(System.out);
    }
 }
}
