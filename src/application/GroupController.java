package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GroupController {
    @FXML
    private Button createButton;

    @FXML
    private TextField groupTextField;
    
    @FXML
	public void initialize() {
    	System.out.println("Inside");
    }
}
