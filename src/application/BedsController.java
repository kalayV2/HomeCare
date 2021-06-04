package application;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class BedsController {



	    @FXML
	    private Button b2_1a;

	    @FXML
	    private Button b2_2a;

	    @FXML
	    private Button b3_1a;

	    @FXML
	    private Button b3_2a;

	    @FXML
	    private Button b3_3a;

	    @FXML
	    private Button b3_4a;

	    @FXML
	    private Button b5_1a;

	    @FXML
	    private Button b5_4a;

	    @FXML
	    private Button b6_1a;

	    @FXML
	    private Button b6_2a;

	    @FXML
	    private Button b6_3a;

	    @FXML
	    private Button b6_4a;

	    @FXML
	    private Button b4_1a;

	    @FXML
	    private Button b4_3a;

	    @FXML
	    private Button b4_2a;

	    @FXML
	    private Button b4_4a;

	    @FXML
	    private Button b1a;

	    @FXML
	    private Button b2_1b;

	    @FXML
	    private Button b2_2b;

	    @FXML
	    private Button b3_1b;

	    @FXML
	    private Button b3_2b;

	    @FXML
	    private Button b3_3b;

	    @FXML
	    private Button b3_4b;

	    @FXML
	    private Button b5_1b;

	    @FXML
	    private Button b5_2b;

	    @FXML
	    private Button b5_3b;

	    @FXML
	    private Button b5_4b;

	    @FXML
	    private Button b6_1b;

	    @FXML
	    private Button b6_2b;

	    @FXML
	    private Button b6_3b;

	    @FXML
	    private Button b6_4b;

	    @FXML
	    private Button b4_1b;

	    @FXML
	    private Button b4_3b;

	    @FXML
	    private Button b4_2b;

	    @FXML
	    private Button b4_4b;

	    @FXML
	    private Button b1b;

	    @FXML
	    private Button btnStaffMana;
	    
	    
	    @FXML
	    private TextField txtPatID;

	    @FXML
	    private TextField txtPatName;

	    @FXML
	    private ChoiceBox<?> choGender;

	    @FXML
	    private TextArea txtPre;

	    @FXML
	    private Button btnAddPat;

	    @FXML
	    void AddPatient(ActionEvent event) {

	    }

	    @FXML
	    void OnAddPatient(ActionEvent event) {

	    }
	    
	    Stage secondStage = new Stage();

	    @FXML
	    void OnStaffsMana(ActionEvent event) throws IOException  {
	    	Main m = new Main();
        	int h =600;
        	int w= 600;
            m.changeScene(h,w,"HomeCare.fxml");
	    }
	    
	    @FXML
	    void OnButtonA1(ActionEvent event)  throws IOException {
	    	b1a.setStyle("-fx-color: red");
	            
	            Parent root1 = FXMLLoader.load(getClass().getResource("PatientController.fxml"));
				Scene scene = new Scene(root1,600,500);
				secondStage.setResizable(false);
				secondStage.setScene(scene); 
	            secondStage.setTitle("Patients");
	            secondStage.show();
	    	
	    }
	    
	}


