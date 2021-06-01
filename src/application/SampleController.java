package application;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController {

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
    private ChoiceBox<?> ChoGender;

    @FXML
    private ChoiceBox<?> ChoPosition;

    @FXML
    private ListView<?> listStaff;
}
