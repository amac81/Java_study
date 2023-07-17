package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import db.DB;

public class Program {
	public static void main(String[] args) throws SQLException {
		Locale.setDefault(Locale.US);

		Connection dbConnection = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			dbConnection = DB.getDbConnection();
			st = dbConnection.createStatement();
			rs = st.executeQuery("SELECT * FROM department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			st.close();
			DB.closeConnection();
		}

	}
}
