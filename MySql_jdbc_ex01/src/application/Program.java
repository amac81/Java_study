package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import db.DB;

public class Program {
	public static void main(String[] args) throws SQLException {

		queryExample();

	}

	private static void queryExample() {
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
