package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	
	public static SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) throws SQLException {

		// queryDepartments();
		//sellerInsert();
		//departmentsInsert();
		updateSeller();

	}

	private static void updateSeller() {
		Connection dbConnection = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.prepareStatement("UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			
			st.setDouble(1, 200.00); //increase salary by 200.00
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
		
			System.out.println("Done! Rows Affected: " + rowsAffected);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	private static void sellerInsert() {
		Connection dbConnection = null;
		PreparedStatement st = null;
		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.prepareStatement("INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) " 
					+ "VALUES " 
					+ "(?, ?, ?, ?, ?)");
						st.setString(1, "Jonh Lopes");
						
			st.setString(2, "lopes@gmail.com");

			long longDate = fmt.parse("15/01/1981").getTime();

			st.setDate(3, new java.sql.Date(longDate));
			st.setDouble(4, 1255.55);
			st.setInt(5, 3);
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done! Rows Affected: " + rowsAffected);	

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

	//insertion with id retrieval
	private static void departmentsInsert() {
		Connection dbConnection = null;
		PreparedStatement st = null;

		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.prepareStatement("INSERT INTO department "
					+ "(Name) " 
					+ "VALUES " 
					+ "('Garden'),('Eletronics'),('DIY')", Statement.RETURN_GENERATED_KEYS);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					System.out.println("Done! id: " + rs.getInt(1));
				}
			}
			else {
				System.out.println("No Rows affected");	
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
	
	private static void queryDepartments() {
		Connection dbConnection = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.createStatement();
			rs = st.executeQuery("SELECT * FROM department");

			while (rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
