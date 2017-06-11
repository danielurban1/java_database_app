package screensframework;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Screen1Controller implements Initializable, ControlledScreen {

		ScreensController myController;
	
	    @FXML
	    private AnchorPane loginPane;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private Button loginButton;

	    @FXML
	    private Label password;

	    @FXML
	    private Label login;

	    @FXML
	    private Label error;

	    @FXML
	    private TextField log;

	    @FXML
	    void log(ActionEvent event) {
	    	if (passwordField.getText().equals("123") && log.getText().equals("admin")){
	    		myController.setScreen(ScreensFramework.screen2ID);
	    	}
	    	else{
	    		error.setText("Incorrect login or password");
	    	}
	    }

		@Override
		public void setScreenParent(ScreensController screenParent) {
			 myController = screenParent;
			
		}

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

	}