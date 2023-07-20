package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

//Program to test DepartmentDaoImpl
public class Program2 {

	public static void main(String[] args) throws SQLException {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

	/*	System.out.println("######## DepartmentDao.findById TEST ########");
		Department department = departmentDao.findById(1);
		System.out.println(department);
		System.out.println("------------------------------------------------------");

		System.out.println("######## DepartmentDao.findAll TEST ########");
		List<Department> departmentsList = new ArrayList<>();
		departmentsList = departmentDao.findAll();
		System.out.println(departmentsList);
		System.out.println("------------------------------------------------------");

		System.out.println("######## DepartmentDao.insert TEST ########");
		department = new Department(null, "Garden");
		departmentDao.insert(department);
		System.out.println("New department Inserted, id: " + department.getId());
		System.out.println("------------------------------------------------------");

		System.out.println("######## DepartmentDao.update TEST ########");
		department = departmentDao.findById(5);
		department.setName("House and Garden");
		departmentDao.update(department);		
		System.out.println("Department update complete!");
		System.out.println("------------------------------------------------------");
*/

		System.out.println("######## DepartmentDao.deleteById TEST ########");
		departmentDao.deleteById(6); 
		System.out.println("Delete completeted !");
		System.out.println("------------------------------------------------------");
		

		DB.closeConnection();

	}

}
