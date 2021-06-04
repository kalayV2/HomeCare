package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;




public class AddStaffController {
    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnAdd;

    @FXML
    private Button bntUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private ChoiceBox ChoGender;

    @FXML
    private ChoiceBox ChoPosition;

    @FXML
    private TextField txtStaffpwd;

    
    
    @FXML
    private TableView<stRecord> table;

    @FXML
    private TableColumn<stRecord,String> CoID;

    @FXML
    private TableColumn<stRecord,String> CoName;

    @FXML
    private TableColumn<stRecord,String> CoGender;

    @FXML
    private TableColumn<stRecord,String> CoPosition;

    @FXML
    private TableColumn<stRecord,String> CoShift;
    
    Connection con = null;
    String url = "jdbc:mysql://localhost:3306/dbHomeCare";
    String username = "root";
    String password = "kalay";
    Statement stmt = null;
    PreparedStatement pst;
    
    
    public void conncet() {
    	try {
    		Class.forName("com.mysql.cj.jdbc.Driver");
		     con = DriverManager.getConnection(url, username, password);

    	} catch (ClassNotFoundException ex) {
    		ex.printStackTrace();
    	} catch (SQLException ex) {
    		ex.printStackTrace();
    	}
}


    public void table()
    {
        ObservableList<stRecord> records = FXCollections.observableArrayList();
     try 
     {
    	 //ResultSet result = null;
	       //String query = "select staffId,sName,sGender,sPosition,shift  from staff";
	
    	 pst = con.prepareStatement("select staffId,sName,sGender,sPosition,shift  from staff");  
         ResultSet rs = pst.executeQuery();
    
      while (rs.next())
      {
          stRecord record = new stRecord();
          record.setID(rs.getString("staffId"));
          record.setName(rs.getString("sName"));
          record.setGedner(rs.getString("sGender"));
          record.setPos(rs.getString("sPosition"));
          record.setShift(rs.getString("shift"));
          records.add(record);
     }
   
              table.setItems(records);
              CoID.setCellValueFactory(f -> f.getValue().IDpro());
              CoName.setCellValueFactory(f -> f.getValue().Namepro());
              CoGender.setCellValueFactory(f -> f.getValue().Genpro());
              CoPosition.setCellValueFactory(f -> f.getValue().Pospro());
              CoShift.setCellValueFactory(f -> f.getValue().Shipro());
     }
     
     catch (SQLException ex) 
     {
         Logger.getLogger(AddStaffController.class.getName()).log(Level.SEVERE, null, ex);
     }
}

    
    ObservableList<String> GenderList = FXCollections.observableArrayList("Male","Female");
    ObservableList<String> PositonList = FXCollections.observableArrayList("Nurse","Doctor");
    
    
    public void initialize() {
    	conncet();
    	table();
    	ChoGender.setValue("Male");
    	ChoGender.setItems(GenderList);
    	ChoPosition.setValue("Nurse");
    	ChoPosition.setItems(PositonList);
    	bntUpdate.setDisable(true);
    	
    	
    }
    
    @FXML
    void AddStaff(ActionEvent event) throws Exception {
    	//int id = Integer.parseInt(txtID.getText());
    	String sid = txtID.getText();
    	String name = txtName.getText();
    	String gender = (String)ChoGender.getSelectionModel().getSelectedItem();
    	String position = (String)ChoPosition.getSelectionModel().getSelectedItem();
    	String psw = txtStaffpwd.getText();
    	String shift ="";
   	    try {
		      stmt = con.createStatement();
		      String queryInsert = "INSERT INTO staff (staffId,sName,sGender,sPosition,sPassword,shift) VALUES ('" + sid + "','" + name + "','" + gender + "','" + position + "','" + psw + "','" + shift +"')";	      
		      int status = stmt.executeUpdate(queryInsert);
		      
	             if(status==1)
	             { 
	                Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText("Staff");
	                alert.setContentText("Record Added Successfully");
	                alert.showAndWait();
	                table();
	                txtID.setText("");
	                txtName.setText("");
	                txtStaffpwd.setText("");
	                ChoGender.setValue("");
	                ChoPosition.setValue("");
	                txtID.requestFocus();
	                
	             }
	             else
	             {
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Fail");
	                alert.setHeaderText("Staff");
	                alert.setContentText("Record Added Failded");
	                alert.showAndWait();
	             }
	    
		     
		    
		    } catch (SQLException ex) {
		        
		        ex.printStackTrace();
		    } 
    }
	        
    @FXML
    void OnTable(MouseEvent event) {
    	//ObservableList<stRecord> staffRecord = FXCollections.observableArrayList();
        stRecord staffR;
    	
        staffR = table.getSelectionModel().getSelectedItem();	
        txtID.setText(staffR.getID());
        txtName.setText(staffR.getName());
        ChoGender.setValue(staffR.getGender());
        ChoPosition.setValue(staffR.getPos());
        bntUpdate.setDisable(false);
    }    
	   

    @FXML
    void RemoveStaff(ActionEvent event) {

    }

    @FXML
    void UpdateStaff(ActionEvent event) {
    	
       	String sid = txtID.getText();
    	String name = txtName.getText();
    	String gender = (String)ChoGender.getSelectionModel().getSelectedItem();
    	String position = (String)ChoPosition.getSelectionModel().getSelectedItem();
    	String psw = txtStaffpwd.getText();
    	String shift ="";

	    try {
		      stmt = con.createStatement();
		      String queryUpdate = "UPDATE staff SET " + 
		    		  "staffId='" + sid + "'," +
		    		  "sName="	+ "'" + name + "'," +
		    		  "sGender="	+ "'" + gender + "'," +
		    		  "sPosition="	+ "'" + position + "'," +
		    		  "sPassword="	+ "'" + psw + "'," +
		    		  "shift="	+ "'" + shift +"'" +
		    		  "WHERE staffId='" + sid + "'";
		   
		      
		      int status = stmt.executeUpdate(queryUpdate);

	             if(status==1)
	             { 
	                Alert alert = new Alert(Alert.AlertType.INFORMATION);
	                alert.setTitle("Success");
	                alert.setHeaderText("Staff");
	                alert.setContentText("Record Updated Successfully");
	                alert.showAndWait();
	                table();
	                txtID.setText("");
	                txtName.setText("");
	                txtStaffpwd.setText("");
	                ChoGender.setValue("");
	                ChoPosition.setValue("");
	                txtID.requestFocus();
	                bntUpdate.setDisable(true);
	                
	             }
	             else
	             {
	                Alert alert = new Alert(Alert.AlertType.ERROR);
	                alert.setTitle("Fail");
	                alert.setHeaderText("Staff");
	                alert.setContentText("Record Updated Failded");
	                alert.showAndWait();
	             }

		    
		    } catch (SQLException ex) {
		        
		        ex.printStackTrace();
		    } 
    
    }
    

}
