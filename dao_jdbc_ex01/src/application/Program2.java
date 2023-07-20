package application;

import java.sql.SQLException;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

//Program to test DepartmentDaoImpl
public class Program2 {

	public static void main(String[] args) throws SQLException {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		  System.out.println("######## DepartmentDao.findById TEST ########"); 
		  Department department = departmentDao.findById(1); 
		  System.out.println(department);
		  System.out.println("------------------------------------------------------");
		 
		 /* 
		 * System.out.println("######## SellerDao.findByDepartment TEST ########"); List
		 * <Seller> sellersList = sellerDao.findByDepartment(new Department(1, null));
		 * System.out.println(sellersList);
		 * System.out.println("------------------------------------------------------");
		 * 
		 * System.out.println("######## SellerDao.findAll TEST ########"); sellersList =
		 * sellerDao.findAll(); System.out.println(sellersList);
		 * System.out.println("------------------------------------------------------");
		 * 
		 * System.out.println("######## SellerDao.insert TEST ########"); LocalDate
		 * birthDate = LocalDate.parse("16/07/1978", dateTimeFmt); seller = new
		 * Seller(null, "David Miami", "david@gmail.com", birthDate, 8750.00, new
		 * Department(3, null)); sellerDao.insert(seller);
		 * System.out.println("New seller Inserted, id: " + seller.getId());
		 * System.out.println("------------------------------------------------------");
		 * 
		 * 
		 * System.out.println("######## SellerDao.update TEST ########"); seller =
		 * sellerDao.findById(14); seller.setName("Marina Brown");
		 * seller.setBaseSalary(2333.22); sellerDao.update(seller);
		 * System.out.println("Seller update complete!");
		 * System.out.println("------------------------------------------------------");
		
		System.out.println("######## DepartmentDao.deleteById TEST ########");
		departmentDao.deleteById(19);
		System.out.println("Delete completeted !");
		System.out.println("------------------------------------------------------");
 */

		DB.closeConnection();

	}

}
