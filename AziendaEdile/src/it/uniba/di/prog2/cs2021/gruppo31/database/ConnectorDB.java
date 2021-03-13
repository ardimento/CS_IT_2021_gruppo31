package it.uniba.di.prog2.cs2021.gruppo31.database;
import java.sql.*;

public class ConnectorDB {
	
	private static String url = "jdbc:sqlite:sqlite3/schema.db";

	public static Connection connect() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url);
		return conn;
	}
	
	public static void close(Connection conn) throws SQLException {
		if(conn != null)	conn.close();
	}
}