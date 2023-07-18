package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {
	public static void main(String[] args) throws SQLException {
		
		//queryDepartments();
		sellerInsert();

	}
	
	
	private static void sellerInsert() {
		Connection dbConnection = null;
		PreparedStatement st = null;
		SimpleDateFormat  fmt = new SimpleDateFormat("dd/MM/yyyy");

		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)"
					);
		
			st.setString(1, "Jonh Lopes");
			st.setString(2, "lopes@gmail.com");
			
			long longDate = fmt.parse("15/01/1981").getTime();
			
			st.setDate(3, new java.sql.Date(longDate));
			
			st.setDouble(4, 1255.55);
			st.setInt(5, 3);
			st.executeUpdate();

	//		System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
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
