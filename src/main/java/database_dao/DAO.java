package database_dao;

import java.sql.SQLException;

import database_exceptions.IdNotFoundException;

public interface DAO {
	public void databaseConnection() throws SQLException;

	public void closeConnection() throws SQLException;

	public void getEmployeeById(int id) throws Exception;

	public void findAll() throws SQLException;

	public void updateEmployeeNameById(int id, String name) throws SQLException, IdNotFoundException;

	public void deleteEmployeeById(int id) throws SQLException, IdNotFoundException;

	public void addEmployee(int id, String name, long salary) throws SQLException;
}
