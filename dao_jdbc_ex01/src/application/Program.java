package application;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	
	
	public static void main(String[] args) throws SQLException {
		final DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("######## SellerDao.findById TEST ########");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		System.out.println("------------------------------------------------------");
		
		System.out.println("######## SellerDao.findByDepartment TEST ########");
		List <Seller> sellersList = sellerDao.findByDepartment(new Department(1, null));
		System.out.println(sellersList);
		System.out.println("------------------------------------------------------");

		System.out.println("######## SellerDao.findAll TEST ########");
		sellersList = sellerDao.findAll();
		System.out.println(sellersList);
		System.out.println("------------------------------------------------------");
		
		System.out.println("######## SellerDao.insert TEST ########");
		LocalDate birthDate = LocalDate.parse("16/07/1978", dateTimeFmt);
		seller = new Seller(null, "David Miami", "david@gmail.com", birthDate, 8750.00, new Department(3, null));
		sellerDao.insert(seller);
		System.out.println("New seller Inserted, id: " + seller.getId());
		System.out.println("------------------------------------------------------");
		
		
		System.out.println("######## SellerDao.update TEST ########");
		seller = sellerDao.findById(14);
		seller.setName("Marina Brown");
		seller.setBaseSalary(2333.22);
		sellerDao.update(seller);
		System.out.println("Seller update complete!");
		
		System.out.println("------------------------------------------------------");

		
		DB.closeConnection();
	

	}

		

}
