package maven_jdbc;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import database_dao.DAO;
import database_dao.DAOImpl;
import database_exceptions.IdNotFoundException;

public class JDBCWithMaven {
	static Connection con;
	static Statement stmt;

	public static void main(String[] args) {
		try {
			DAO d = new DAOImpl();
			System.out.println("1 for getElementById" + "\n" + "2 for fetching all records" + "\n" + "3 for update"
					+ "\n" + "4 for delete" + "\n" + "5 for adding an empployee");
			System.out.println("Enter the operation you want to perform:");
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();

			switch (n) {
			case 1:
				System.out.println("Enter the id of the employee:");
				int id9 = sc.nextInt();
				d.getEmployeeById(id9);
				break;
			case 2:
				d.findAll();
				break;
			case 3:
				System.out.println("Enter the id of the employee:");
				int id1 = sc.nextInt();
				System.out.println("Enter the name of the employee to update");
				String name = sc.next();
				d.updateEmployeeNameById(id1, name);
				break;
			case 4:
				System.out.println("Enter the id of the employee:");
				int id2 = sc.nextInt();
				d.deleteEmployeeById(id2);
				break;
			case 5:
				System.out.println("Enter the employee details to add");
				int id3 = sc.nextInt();
				String name1 = sc.next();
				long salary1 = sc.nextLong();
				d.addEmployee(id3, name1, salary1);
				break;
			default:
				System.out.println("No matching operation is found!");
			}
		} catch (IdNotFoundException e) {
			System.out.print(e);
		} catch (Exception e) {
			System.out.println("Hello");
			System.out.println(e);
		}

	}
}
