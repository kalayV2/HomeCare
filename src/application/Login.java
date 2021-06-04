package application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Login {
	 public Login() {

	    }

	    @FXML
	    private Button btnLogin;

	    @FXML
	    private TextField txtUserName;

	    @FXML
	    private TextField txtPassword;

	    @FXML
	    private Label lbLogin;



	    public void OnUserLogin(ActionEvent event) throws IOException {
	        checkLogin();

	    }

	    private void checkLogin() throws IOException {
	        Main m = new Main();
	        if(txtUserName.getText().toString().equals("admin") && txtPassword.getText().toString().equals("123")) {
	        	lbLogin.setText("Success!");
	        	int h =600;
	        	int w= 900;
	            m.changeScene(h,w,"Bed.fxml");

	        }

	        else if(txtUserName.getText().isEmpty() && txtPassword.getText().isEmpty()) {
	        	lbLogin.setText("Please enter your data.");
	        }


	        else {
	        	lbLogin.setText("Wrong username or password!");
	        }
	    }


	}

