package application;

import java.sql.Connection;
import java.sql.SQLException;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {
	
	
	
	public static void main(String[] args) throws SQLException {
		
		Connection dbConnection = DB.getDbConnection();
		SellerDao sellerDao = DaoFactory.createSellerDao(dbConnection);
		
		Seller seller = sellerDao.findById(1);
		
		System.out.println(seller);
		
		
		
		DB.closeConnection();
	

	}

		

}
