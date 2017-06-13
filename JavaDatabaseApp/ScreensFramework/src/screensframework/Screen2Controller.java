package screensframework;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import screensframework.DataBaseEmployeer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Screen2Controller implements Initializable , ControlledScreen {
	
    ScreensController myController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	l1.setText("You are logged as admin");
    	try {
			refrest();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
        private TableColumn<DataBaseEmployeer, String> lastName;

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
        private Button connect;
        
        private ObservableList<DataBaseEmployeer>data;
        
        @FXML
        void add(ActionEvent event){
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
	    
	    @FXML
	    void connectDB(ActionEvent event) throws ClassNotFoundException, SQLException{
	    	refrest();
	    }
	    private void refrest() throws ClassNotFoundException, SQLException{
	    	connect.setText("Refresh");
	    	data = FXCollections.observableArrayList();
	    	Connection con = DataBaseEmployeer.connect();
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM employee_table");
			while (result.next()) {
				data.add(new DataBaseEmployeer( result.getString(2), 
						result.getString(3), 
						result.getString(4), 
						result.getString(5), 
						result.getString(6), 
						result.getString(7), 
						result.getString(8), 
						result.getString(9), 
						result.getString(10), 
						result.getString(11)));}
	        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
	        lastName.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
	        login.setCellValueFactory(new PropertyValueFactory<>("Login"));
	        password.setCellValueFactory(new PropertyValueFactory<>("Password"));
	        task1.setCellValueFactory(new PropertyValueFactory<>("Task1"));
	        task2.setCellValueFactory(new PropertyValueFactory<>("Task2"));
	        task3.setCellValueFactory(new PropertyValueFactory<>("Task3"));
	        task4.setCellValueFactory(new PropertyValueFactory<>("Task4"));
	        task5.setCellValueFactory(new PropertyValueFactory<>("Task5"));
	        task6.setCellValueFactory(new PropertyValueFactory<>("Task6"));

	        table1.setItems(null);
	        table1.setItems(data);
	    }
    }

