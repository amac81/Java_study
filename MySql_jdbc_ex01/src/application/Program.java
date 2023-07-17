package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import db.DB;

public class Program {
	public static void main(String[] args) throws SQLException {
		Locale.setDefault(Locale.US); 
		
		Connection dbConnection = DB.getDbConnection();
		
		System.out.println(dbConnection.getCatalog().toString());
		
		DB.closeConnection();
	}
}
