package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	private static Connection dbConnection = null;

	public static Connection getDbConnection() {
		if (dbConnection == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				dbConnection = DriverManager.getConnection(url, props);
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}

		return dbConnection;
	}

	public static void closeConnection() {
		if (dbConnection != null) {
			try {
				dbConnection.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}

	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}

	}
}
