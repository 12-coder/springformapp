package database_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database_entity.Employee;
import database_exceptions.IdNotFoundException;

public class DAOImpl implements DAO{
	static Connection con;
	static Statement stmt;

	public void databaseConnection() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_1?autoReconnect=true&useSSL=false",
				 "root", "ssrpknt");
	}

	public void closeConnection() throws SQLException {
		if (con != null || stmt != null) {
			con.close();
			stmt.close();
		}
	}

	@Override
	public void getEmployeeById(int id) throws Exception {
		databaseConnection();
		stmt = con.createStatement();
		ResultSet result = stmt.executeQuery("select * from employee1 where id='" + id + "'");
		boolean flag = false;
		while (result.next()) {
			flag = true;
			System.out.print(result.getInt(1) + " " + result.getString(2) + " " + result.getLong(3) + "\n");

		}

		if (flag == false) {
			throw new IdNotFoundException("No such Id present in the database!");
		}
		closeConnection();

	}

	@Override
	public void findAll() throws SQLException {
		databaseConnection();
		stmt = con.createStatement();
		List<Employee> al=new ArrayList<Employee>();
		ResultSet result = stmt.executeQuery("select * from employee1");
		while (result.next()) {
			al.add(new Employee(result.getInt(1),result.getString(2),result.getLong(3)));

		}
		for(Employee e:al) {
			System.out.println(e.getId()+" "+e.getName()+" "+e.getSalary());
		}
		closeConnection();

	}

	@Override
	public void updateEmployeeNameById(int id, String name) throws SQLException, IdNotFoundException {
		databaseConnection();
		stmt = con.createStatement();
		try {
			stmt.executeUpdate("update employee set name='" + name + "' where id='" + id + "'");
		} catch (Exception e) {
			throw new IdNotFoundException("No such Id present in the database!");
		} finally {
			closeConnection();
		}

	}

	@Override
	public void deleteEmployeeById(int id) throws SQLException, IdNotFoundException {
		databaseConnection();
		stmt = con.createStatement();
		try {
			stmt.executeUpdate("delete from employee where id='" + id + "'");
		} catch (Exception e) {
			throw new IdNotFoundException("No such Id present in the database!");

		} finally {
			closeConnection();
		}

	}

	@Override
	public void addEmployee(int id, String name, long salary) throws SQLException {
		databaseConnection();
		stmt = con.createStatement();
		stmt.executeUpdate("insert into employee values('" + id + "','" + name + "','" + salary + "')");
		closeConnection();

	}

}
