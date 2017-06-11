package screensframework;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Screen2Controller implements Initializable , ControlledScreen {
	
    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	l1.setText("You are logged as admin");
    	/*table1.setItems(selectAll());
    	table1.getColumns().addAll(name, login, password, task1, task2, task3, task4, task5, task6);*/
    }
    
    /*public ObservableList<DataBaseEmployeer> selectAll(){
    	ObservableList<DataBaseEmployeer> employees = FXCollections.observableArrayList();
    	employees.addAll(DataBaseEmployeer.select());
		return employees;}*/
    
        @FXML
        private TableView<DataBaseEmployeer> table1;

        @FXML
        private TableColumn<DataBaseEmployeer, String> name;

        @FXML
        private TableColumn<DataBaseEmployeer, String> login;

        @FXML
        private TableColumn<DataBaseEmployeer, String> password;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task1;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task2;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task3;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task4;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task5;

        @FXML
        private TableColumn<DataBaseEmployeer, String> task6;

        @FXML
        private Button add;

        @FXML
        private Button edit;

        @FXML
        private Button remove;

        @FXML
        private Label l1;

        @FXML
        private Button logOut;

        @FXML
        void add(ActionEvent event) {
        	add.setText("aaa");
        }

		@Override
		public void setScreenParent(ScreensController screenParent) {
			myController = screenParent;
			
		}
	    @FXML
	    void log(ActionEvent event) {
	    	myController.setScreen(ScreensFramework.screen1ID);
	    }
    }

