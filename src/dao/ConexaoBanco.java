package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {
	private final String url = "jdbc:mysql://localhost:3306/Comercio";
	private final String user = "root";
	private final String password = "241607";

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e: ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}