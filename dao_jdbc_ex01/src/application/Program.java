package application;

import java.sql.SQLException;
import java.util.List;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
	
	
	
	public static void main(String[] args) throws SQLException {
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("######## SellerDao.findById TEST ########");
		Seller seller = sellerDao.findById(1);
		System.out.println(seller);
		System.out.println("------------------------------------------------------");
		
		System.out.println("######## SellerDao.findByDepartment TEST ########");
		List <Seller> sellersByDepartment = sellerDao.findByDepartment(new Department(1, null));
		System.out.println(sellersByDepartment);
		System.out.println("------------------------------------------------------");

		
		
		DB.closeConnection();
	

	}

		

}
