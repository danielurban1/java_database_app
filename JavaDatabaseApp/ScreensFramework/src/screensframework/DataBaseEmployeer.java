package screensframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

public class DataBaseEmployeer {
	private SimpleStringProperty login;
	private SimpleStringProperty password;
	private SimpleStringProperty name;
	private SimpleStringProperty last_name;
	private SimpleStringProperty task1;
	private SimpleStringProperty task2;
	private SimpleStringProperty task3;
	private SimpleStringProperty task4;
	private SimpleStringProperty task5;
	private SimpleStringProperty task6;
	
	DataBaseEmployeer(String login, String password, String name, String last_name, String task1, String task2, String task3, String task4, String task5, String task6){
		setLogin(new SimpleStringProperty(login));
		setPassword(new SimpleStringProperty(password));
		setName(new SimpleStringProperty(name));
		setLast_name(new SimpleStringProperty(last_name));
		setTask1(new SimpleStringProperty(task1));
		setTask2( new SimpleStringProperty(task2));
		setTask3(new SimpleStringProperty(task3));
		setTask4(new SimpleStringProperty(task4));
		setTask5(new SimpleStringProperty(task5));
		setTask6(new SimpleStringProperty(task6));
	}
	

	public String getLogin() {
		return login.get();
	}
	public void setLogin(SimpleStringProperty login) {
		this.login = login;
	}
	public String getPassword() {
		return password.get();
	}
	public void setPassword(SimpleStringProperty simpleStringProperty) {
		this.password = simpleStringProperty;
	}
	public String getName() {
		return name.get();
	}
	public void setName(SimpleStringProperty name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name.get();
	}
	public void setLast_name(SimpleStringProperty last_name) {
		this.last_name = last_name;
	}
	public String getTask1() {
		return task1.get();
	}
	public void setTask1(SimpleStringProperty task1) {
		this.task1 = task1;
	}
	public String getTask2() {
		return task2.get();
	}
	public void setTask2(SimpleStringProperty task2) {
		this.task2 = task2;
	}
	public String getTask3() {
		return task3.get();
	}
	public void setTask3(SimpleStringProperty simpleStringProperty) {
		this.task3 = simpleStringProperty;
	}
	public String getTask4() {
		return task4.get();
	}
	public void setTask4(SimpleStringProperty simpleStringProperty) {
		this.task4 = simpleStringProperty;
	}
	public String getTask5() {
		return task5.get();
	}
	public void setTask5(SimpleStringProperty simpleStringProperty) {
		this.task5 = simpleStringProperty;
	}
	public String getTask6() {
		return task6.get();
	}
	public void setTask6(SimpleStringProperty simpleStringProperty) {
		this.task6 = simpleStringProperty;
	}
	
	public static Connection connect() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","123Fokus456p");
		
		return con;}
	
	public static void insert(String login, String password, String name, String last_name, int task1, int task2, int task3, int task4, int task5, int task6){
		try{
			Connection con = connect();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
			stmt.executeUpdate("insert into employee_table (login, password, name, last_name, task1, task2, task3, task4, task5, task6) values('" + login + "', '" + password + "', '" + name + "', '" + last_name + "', '" + task1 +"', '" + task2 +"', '" + task3 +"', '" + task4 +"', '" + task5 +"', '" + task6 +"');");
			con.close();
			} 
		catch(Exception e){
			System.out.println(e);
			}
	}
	public static void delete(String login){
		try{
			Connection con = connect();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
			stmt.executeUpdate("delete from employee_table where login = '" + login + "';");
			con.close();
			} 
		catch(Exception e){
			System.out.println(e);
			}
	}
	
	public static void update(String login){
		try{
			Connection con = connect();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0");
			stmt.executeUpdate("delete from employee_table where login = '" + login + "';");
			con.close();
			} 
		catch(Exception e){
			System.out.println(e);
			}
	}
	
	public static ArrayList<Object> select(){
		ArrayList<Object> employees = new ArrayList<Object>();
		try{
			Connection con = connect();
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("SELECT * FROM employee_table");
			while (result.next()) {
				ArrayList<Object> employee = new ArrayList<Object>();
				employee.add(result.getString(2));
		        employee.add(result.getString(3));
		        employee.add(result.getString(4));
		        employee.add(result.getString(5));
		        employee.add(result.getString(6));
		        employee.add(result.getString(7));
		        employee.add(result.getString(8));
		        employee.add(result.getString(9));
		        employee.add(result.getString(10));
		        employee.add(result.getString(11));
		        employees.add(employee);
		        }
			con.close();
			} 
		catch(Exception e){
			System.out.println(e);
			}
		return employees;
	}
}
