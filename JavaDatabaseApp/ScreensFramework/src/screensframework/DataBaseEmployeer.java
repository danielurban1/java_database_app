package screensframework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBaseEmployeer {
	private String login;
	private String password;
	private String name;
	private String last_name;
	private int task1;
	private int task2;
	private int task3;
	private int task4;
	private int task5;
	private int task6;
	
	DataBaseEmployeer(String login, String password, String name, String last_name, int task1, int task2, int task3, int task4, int task5, int task6){
		setLogin(login);
		setPassword(password);
		setName(name);
		setLast_name(last_name);
		setTask1(task1);
		setTask2(task2);
		setTask3(task3);
		setTask4(task4);
		setTask5(task5);
		setTask6(task6);
	}
	

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getTask1() {
		return task1;
	}
	public void setTask1(int task1) {
		this.task1 = task1;
	}
	public int getTask2() {
		return task2;
	}
	public void setTask2(int task2) {
		this.task2 = task2;
	}
	public int getTask3() {
		return task3;
	}
	public void setTask3(int task3) {
		this.task3 = task3;
	}
	public int getTask4() {
		return task4;
	}
	public void setTask4(int task4) {
		this.task4 = task4;
	}
	public int getTask5() {
		return task5;
	}
	public void setTask5(int task5) {
		this.task5 = task5;
	}
	public int getTask6() {
		return task6;
	}
	public void setTask6(int task6) {
		this.task6 = task6;
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
			stmt.executeUpdate("delete from employee_table where login = '" + login + "');");
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
			stmt.executeUpdate("delete from employee_table where login = '" + login + "');");
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
